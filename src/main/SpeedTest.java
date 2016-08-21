package main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import liuyazhe.Packet;

/**
 * 报文系统客户端
 * 
 * @author 郑悦
 */
public class SpeedTest extends Thread {
	// 定义检测SocketChannel的Selector对象
	private Selector selector = null;
	// 客户端SocketChannel
	private SocketChannel sc = null;

	/** 端口号 */
	private int port1 = 30000;

	/** IP地址 */
	private String ip = "127.0.0.1";

	public SpeedTest() {
		try {
			selector = Selector.open();
			InetSocketAddress isa = new InetSocketAddress(ip, port1);
			// 调用open静态方法创建连接到指定主机的SocketChannel
			sc = SocketChannel.open(isa);
			// 设置该sc以非阻塞方式工作
			sc.configureBlocking(false);
			// 将SocketChannel对象注册到指定Selector
			sc.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		try {
			Packet p = new Packet();
			int packet_id = (int) (Math.random() * 10000000);
			ByteArrayOutputStream baos = p.requestDetailById(packet_id, 301, 1);
			ByteBuffer buff = ByteBuffer.allocate(4096);
			buff.put(baos.toByteArray());
			baos.close();
			buff.flip();
			// System.out.println("客户端发送请求");
			sc.write(buff);
			buff.clear();
			long begin = System.currentTimeMillis();
			while (true) {
				int i = sc.read(buff);
				if (i > 0) {
					long end = System.currentTimeMillis();
					System.out.println((end - begin));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sc != null)
					sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 1000; i++) {
			new SpeedTest().start();
			sleep(10);
		}

	}

}