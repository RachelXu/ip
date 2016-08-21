package listener;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ����ϵͳ��������
 * 
 * @author ֣��
 */
public class AcceptListener extends Thread {

	/** ���ڼ������Channel״̬��Selector */
	private Selector acceptSelector = null;

	private Selector ioChangeSelector = null;

	private ServerSocketChannel server = null;

	private List<ServerSocket> ssList = new ArrayList<ServerSocket>();

	/**
	 * ���췽��
	 * 
	 * @throws IOException
	 */
	public AcceptListener(int port1, Selector acceptSelector,
			Selector ioChangeSelector) throws IOException {

		// ����һ��Selector
		this.acceptSelector = acceptSelector;

		this.ioChangeSelector = ioChangeSelector;

		// ͨ��open��������һ��δ�󶨵�ServerSocketChannelʵ��
		server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress(port1);

		// ����ServerSocketChannel�󶨵�ָ��IP��ַ�Ͷ˿�
		ServerSocket sServerSocket = server.socket();
		sServerSocket.bind(isa);
		ssList.add(sServerSocket);

		// ����ServerSocket�Է�������ʽ����
		server.configureBlocking(false);

		// ��serverע�ᵽָ��Selector����
		server.register(this.acceptSelector, SelectionKey.OP_ACCEPT);
	}

	/**
	 * ���췽��
	 * 
	 * @throws IOException
	 */
	public AcceptListener(int[] port1, Selector acceptSelector,
			Selector ioChangeSelector) throws IOException {

		// ����һ��Selector
		this.acceptSelector = acceptSelector;

		this.ioChangeSelector = ioChangeSelector;

		for (int port : port1) {

			// ͨ��open��������һ��δ�󶨵�ServerSocketChannelʵ��
			server = ServerSocketChannel.open();
			InetSocketAddress isa = new InetSocketAddress(port);

			// ����ServerSocketChannel�󶨵�ָ��IP��ַ�Ͷ˿�
			ServerSocket sServerSocket = server.socket();
			sServerSocket.bind(isa);
			ssList.add(sServerSocket);

			// ����ServerSocket�Է�������ʽ����
			server.configureBlocking(false);

			// ��serverע�ᵽָ��Selector����
			server.register(this.acceptSelector, SelectionKey.OP_ACCEPT);
		}
	}

	/**
	 * ������
	 */
	public void run() {
		int keyCount = 0;
		try {
			while (this.acceptSelector.isOpen()) {
				keyCount = this.acceptSelector.select();
				if (keyCount > 0) {
					Iterator<SelectionKey> iterator = acceptSelector
							.selectedKeys().iterator();
					// ���δ���selector�ϵ�ÿ����ѡ���SelectionKey
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						// ��selector�ϵ���ѡ��Key����ɾ�����ڴ����SelectionKey
						iterator.remove();
						if (key.isAcceptable()) {
							// ���key��Ӧ��ͨ�������ͻ��˵���������
							// System.out.println(Thread.currentThread().getName()
							// + "���ڼ�������");
							this.doAccept(key);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		ServerSocketChannel server1 = (ServerSocketChannel) sk.channel();
		SocketChannel sc = server1.accept();

		// ���ò��÷�����ģʽ
		sc.configureBlocking(false);

		// ����SocketChannelҲע�ᵽselector
		sc.register(this.ioChangeSelector, SelectionKey.OP_READ);

		// ��sk��Ӧ��Channel���ó�׼��������������
		sk.interestOps(SelectionKey.OP_ACCEPT);
	}

	/**
	 * @return the server
	 */
	public ServerSocketChannel getServer() {
		return server;
	}

	/**
	 * @param server
	 *            the server to set
	 */
	public void setServer(ServerSocketChannel server) {
		this.server = server;
	}

	/**
	 * @return the ssList
	 */
	public List<ServerSocket> getSsList() {
		return ssList;
	}

	/**
	 * @param ssList
	 *            the ssList to set
	 */
	public void setSsList(List<ServerSocket> ssList) {
		this.ssList = ssList;
	}

}
