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
 * 报文系统服务器端
 * 
 * @author 郑悦
 */
public class Server {

	/** 用于检测所有Channel状态的Selector */
	private Selector selector = null;

	/** 服务器端Socket通道 */
	private ServerSocketChannel server = null;

	/** 端口号 */
	private int port1 = 30000;

	/** IP地址 */
	private String ip = "192.168.0.101";

	/** 处理请求的线程池 */
	ExecutorService pool = null;

	/**
	 * 构造方法
	 * 
	 * @throws IOException
	 */
	public Server() throws IOException {

		// 创建一个Selector
		this.selector = Selector.open();

		// 通过open方法来打开一个未绑定的ServerSocketChannel实例
		this.server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress(ip, port1);

		// 将该ServerSocketChannel绑定到指定IP地址和端口
		this.server.socket().bind(isa);

		// 设置ServerSocket以非阻塞方式工作
		this.server.configureBlocking(false);

		// 将server注册到指定Selector对象
		this.server.register(selector, SelectionKey.OP_ACCEPT);

		// 创建一个可重用固定线程数的线程池
		this.pool = Executors.newFixedThreadPool(3);
	}

	/**
	 * 处理客户端请求
	 */
	public void process() throws Exception {
		int keyCount = 0;
		while (this.selector.isOpen()) {
			keyCount = this.selector.select();
			if (keyCount > 0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys()
						.iterator();
				// 依次处理selector上的每个已选择的SelectionKey
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					// 从selector上的已选择Key集中删除正在处理的SelectionKey
					iterator.remove();
					if (key.isAcceptable()) {
						// 如果key对应的通道包含客户端的连接请求
						this.doAccept(key);
					} else if (key.isReadable()) {
						// 如果key对应的通道有数据需要读取
						this.doRequest(key);
					}
				}
			}
		}
	}

	/**
	 * 处理客户端请求
	 * 
	 * @param sk
	 *            SelectionKey
	 */
	private void doRequest(SelectionKey sk) throws Exception {

		// 获取该SelectionKey对应的Channel，该Channel中有可读的数据
		SocketChannel sc = (SocketChannel) sk.channel();

		// 定义准备执行读取数据的ByteBuffer
		ByteBuffer buff = ByteBuffer.allocate(4096);
		buff.clear();
		// 开始读取数据
		try {
			int i = sc.read(buff);
			if (i == -1) {
				cancel(sk);
				return;
			}
			buff.flip();
			// 处理客户请求
			Callable<byte[]> excutor = new CallExecutor(buff.array());

			// 将excutor交给线程池处理
			Future<byte[]> task = pool.submit(excutor);
			buff.clear();

			// 将excutor中的返回值写入buffer中
			buff.put(task.get());
			buff.flip();
			sc.write(buff);

			// 将sk对应的Channel设置成准备下一次读取
			sk.interestOps(SelectionKey.OP_READ);

		} catch (Exception e) {
			// 如果捕捉到该sk对应的Channel出现了异常
			e.printStackTrace();
			cancel(sk);
		}
	}

	/**
	 * 接受客户端连接
	 * 
	 * @param sk
	 *            SelectionKey
	 */
	private void doAccept(SelectionKey sk) throws IOException,
			ClosedChannelException {
		// 调用accept方法接受连接，产生服务器端对应的SocketChannel
		SocketChannel sc = server.accept();
		// 设置采用非阻塞模式
		sc.configureBlocking(false);
		// 将该SocketChannel也注册到selector
		sc.register(selector, SelectionKey.OP_READ);
		// 将sk对应的Channel设置成准备接受其他请求
		sk.interestOps(SelectionKey.OP_ACCEPT);
	}

	/**
	 * 取消客户端的注册
	 * 
	 * @param sk
	 *            SelectionKey
	 */
	private void cancel(SelectionKey sk) throws IOException {
		// 对应的Client出现了问题，所以从Selector中取消sk的注册
		// 从Selector中删除指定的SelectionKey
		sk.cancel();
		if (sk.channel() != null) {
			sk.channel().close();
		}
	}

	/**
	 * 启动服务器
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new Server().process();

	}

}
