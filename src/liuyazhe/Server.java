package liuyazhe;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ����ϵͳ��������
 * 
 * @author ֣��
 */
public class Server {

	/** ���ڼ������Channel״̬��Selector */
	private Selector selector = null;

	/** ��������Socketͨ�� */
	private ServerSocketChannel server = null;

	/** �˿ں� */
	private int port1 = 30000;

	/** IP��ַ */
	private String ip = "192.168.0.101";

	/** ����������̳߳� */
	ExecutorService pool = null;

	/**
	 * ���췽��
	 * 
	 * @throws IOException
	 */
	public Server() throws IOException {

		// ����һ��Selector
		this.selector = Selector.open();

		// ͨ��open��������һ��δ�󶨵�ServerSocketChannelʵ��
		this.server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress(ip, port1);

		// ����ServerSocketChannel�󶨵�ָ��IP��ַ�Ͷ˿�
		this.server.socket().bind(isa);

		// ����ServerSocket�Է�������ʽ����
		this.server.configureBlocking(false);

		// ��serverע�ᵽָ��Selector����
		this.server.register(selector, SelectionKey.OP_ACCEPT);

		// ����һ�������ù̶��߳������̳߳�
		this.pool = Executors.newFixedThreadPool(3);
	}

	/**
	 * ����ͻ�������
	 */
	public void process() throws Exception {
		int keyCount = 0;
		while (this.selector.isOpen()) {
			keyCount = this.selector.select();
			if (keyCount > 0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys()
						.iterator();
				// ���δ���selector�ϵ�ÿ����ѡ���SelectionKey
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					// ��selector�ϵ���ѡ��Key����ɾ�����ڴ����SelectionKey
					iterator.remove();
					if (key.isAcceptable()) {
						// ���key��Ӧ��ͨ�������ͻ��˵���������
						this.doAccept(key);
					} else if (key.isReadable()) {
						// ���key��Ӧ��ͨ����������Ҫ��ȡ
						this.doRequest(key);
					}
				}
			}
		}
	}

	/**
	 * ����ͻ�������
	 * 
	 * @param sk
	 *            SelectionKey
	 */
	private void doRequest(SelectionKey sk) throws Exception {

		// ��ȡ��SelectionKey��Ӧ��Channel����Channel���пɶ�������
		SocketChannel sc = (SocketChannel) sk.channel();

		// ����׼��ִ�ж�ȡ���ݵ�ByteBuffer
		ByteBuffer buff = ByteBuffer.allocate(4096);
		buff.clear();
		// ��ʼ��ȡ����
		try {
			int i = sc.read(buff);
			if (i == -1) {
				cancel(sk);
				return;
			}
			buff.flip();
			// ����ͻ�����
			Callable<byte[]> excutor = new CallExecutor(buff.array());

			// ��excutor�����̳߳ش���
			Future<byte[]> task = pool.submit(excutor);
			buff.clear();

			// ��excutor�еķ���ֵд��buffer��
			buff.put(task.get());
			buff.flip();
			sc.write(buff);

			// ��sk��Ӧ��Channel���ó�׼����һ�ζ�ȡ
			sk.interestOps(SelectionKey.OP_READ);

		} catch (Exception e) {
			// �����׽����sk��Ӧ��Channel�������쳣
			e.printStackTrace();
			cancel(sk);
		}
	}

	/**
	 * ���ܿͻ�������
	 * 
	 * @param sk
	 *            SelectionKey
	 */
	private void doAccept(SelectionKey sk) throws IOException,
			ClosedChannelException {
		// ����accept�����������ӣ������������˶�Ӧ��SocketChannel
		SocketChannel sc = server.accept();
		// ���ò��÷�����ģʽ
		sc.configureBlocking(false);
		// ����SocketChannelҲע�ᵽselector
		sc.register(selector, SelectionKey.OP_READ);
		// ��sk��Ӧ��Channel���ó�׼��������������
		sk.interestOps(SelectionKey.OP_ACCEPT);
	}

	/**
	 * ȡ���ͻ��˵�ע��
	 * 
	 * @param sk
	 *            SelectionKey
	 */
	private void cancel(SelectionKey sk) throws IOException {
		// ��Ӧ��Client���������⣬���Դ�Selector��ȡ��sk��ע��
		// ��Selector��ɾ��ָ����SelectionKey
		sk.cancel();
		if (sk.channel() != null) {
			sk.channel().close();
		}
	}

	/**
	 * ����������
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new Server().process();

	}

}
