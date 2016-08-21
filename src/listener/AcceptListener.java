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
 * 报文系统服务器端
 * 
 * @author 郑悦
 */
public class AcceptListener extends Thread {

	/** 用于检测所有Channel状态的Selector */
	private Selector acceptSelector = null;

	private Selector ioChangeSelector = null;

	private ServerSocketChannel server = null;

	private List<ServerSocket> ssList = new ArrayList<ServerSocket>();

	/**
	 * 构造方法
	 * 
	 * @throws IOException
	 */
	public AcceptListener(int port1, Selector acceptSelector,
			Selector ioChangeSelector) throws IOException {

		// 创建一个Selector
		this.acceptSelector = acceptSelector;

		this.ioChangeSelector = ioChangeSelector;

		// 通过open方法来打开一个未绑定的ServerSocketChannel实例
		server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress(port1);

		// 将该ServerSocketChannel绑定到指定IP地址和端口
		ServerSocket sServerSocket = server.socket();
		sServerSocket.bind(isa);
		ssList.add(sServerSocket);

		// 设置ServerSocket以非阻塞方式工作
		server.configureBlocking(false);

		// 将server注册到指定Selector对象
		server.register(this.acceptSelector, SelectionKey.OP_ACCEPT);
	}

	/**
	 * 构造方法
	 * 
	 * @throws IOException
	 */
	public AcceptListener(int[] port1, Selector acceptSelector,
			Selector ioChangeSelector) throws IOException {

		// 创建一个Selector
		this.acceptSelector = acceptSelector;

		this.ioChangeSelector = ioChangeSelector;

		for (int port : port1) {

			// 通过open方法来打开一个未绑定的ServerSocketChannel实例
			server = ServerSocketChannel.open();
			InetSocketAddress isa = new InetSocketAddress(port);

			// 将该ServerSocketChannel绑定到指定IP地址和端口
			ServerSocket sServerSocket = server.socket();
			sServerSocket.bind(isa);
			ssList.add(sServerSocket);

			// 设置ServerSocket以非阻塞方式工作
			server.configureBlocking(false);

			// 将server注册到指定Selector对象
			server.register(this.acceptSelector, SelectionKey.OP_ACCEPT);
		}
	}

	/**
	 * 主处理
	 */
	public void run() {
		int keyCount = 0;
		try {
			while (this.acceptSelector.isOpen()) {
				keyCount = this.acceptSelector.select();
				if (keyCount > 0) {
					Iterator<SelectionKey> iterator = acceptSelector
							.selectedKeys().iterator();
					// 依次处理selector上的每个已选择的SelectionKey
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						// 从selector上的已选择Key集中删除正在处理的SelectionKey
						iterator.remove();
						if (key.isAcceptable()) {
							// 如果key对应的通道包含客户端的连接请求
							// System.out.println(Thread.currentThread().getName()
							// + "正在监听连接");
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
	 * 接受客户端连接
	 * 
	 * @param sk
	 *            SelectionKey
	 */
	private void doAccept(SelectionKey sk) throws IOException,
			ClosedChannelException {

		// 调用accept方法接受连接，产生服务器端对应的SocketChannel
		ServerSocketChannel server1 = (ServerSocketChannel) sk.channel();
		SocketChannel sc = server1.accept();

		// 设置采用非阻塞模式
		sc.configureBlocking(false);

		// 将该SocketChannel也注册到selector
		sc.register(this.ioChangeSelector, SelectionKey.OP_READ);

		// 将sk对应的Channel设置成准备接受其他请求
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
