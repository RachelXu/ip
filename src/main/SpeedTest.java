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
 * ����ϵͳ�ͻ���
 * 
 * @author ֣��
 */
public class SpeedTest extends Thread {
	// ������SocketChannel��Selector����
	private Selector selector = null;
	// �ͻ���SocketChannel
	private SocketChannel sc = null;

	/** �˿ں� */
	private int port1 = 30000;

	/** IP��ַ */
	private String ip = "127.0.0.1";

	public SpeedTest() {
		try {
			selector = Selector.open();
			InetSocketAddress isa = new InetSocketAddress(ip, port1);
			// ����open��̬�����������ӵ�ָ��������SocketChannel
			sc = SocketChannel.open(isa);
			// ���ø�sc�Է�������ʽ����
			sc.configureBlocking(false);
			// ��SocketChannel����ע�ᵽָ��Selector
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
			// System.out.println("�ͻ��˷�������");
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