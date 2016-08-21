package main;

import java.net.ServerSocket;
import java.nio.channels.Selector;
import java.sql.Connection;

import listener.AcceptListener;
import listener.IoChangeListener;
import pool.ThreadLogicPool;
import pool.ThreadReadPool;
import pool.ThreadWritePool;
import util.C3P0Utils;
import util.Contents;

/**
 * 启动服务器线程
 * 
 * @author 郑悦
 */
public class ServerMain {

	public static ThreadReadPool readPool;
	public static ThreadLogicPool logicPool;
	public static ThreadWritePool writePool;
	private static Selector acceptSelector;
	private static Selector ioChangeSelector;
	private static AcceptListener acceptListener;
	private static IoChangeListener ioChangeListener;
	private static boolean flag;

	public static boolean startup() {

		try {
			ServerMain.main("");
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			return false;
		}
	}

	public static boolean stop() {

		try {
			acceptSelector.close();
			ioChangeSelector.close();
			acceptSelector = null;
			ioChangeSelector = null;
			acceptListener.getServer().close();
			for (ServerSocket ss : acceptListener.getSsList()) {
				ss.close();
			}
			acceptListener.setServer(null);
			acceptListener.stop();
			ioChangeListener.stop();
			acceptListener = null;
			ioChangeListener = null;
			readPool.waitFinish(); // 等待所有任务执行完毕
			readPool.closePool();
			writePool.waitFinish(); // 等待所有任务执行完毕
			writePool.closePool();
			logicPool.waitFinish(); // 等待所有任务执行完毕
			logicPool.closePool();
			flag = false;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String... args) throws Exception {
		long begin = System.currentTimeMillis();
		C3P0Utils.getInstance();
		readPool = new ThreadReadPool(Contents.READ_POOL_SIZE);
		logicPool = new ThreadLogicPool(Contents.LOGIC_POOL_SIZE);
		writePool = new ThreadWritePool(Contents.WRITE_POOL_SIZE);
		acceptSelector = Selector.open();
		ioChangeSelector = Selector.open();
		int size = Contents.MAX_PORT - Contents.MIN_PORT + 1;
		int[] ports = new int[size];
		int port = Contents.MIN_PORT;
		for (int i = 0; i < size; i++, port++) {
			ports[i] = port;
		}
		Connection con = null;
		for (int i = 0; i < 10; i++) {
			con = C3P0Utils.getInstance().getConnection();
			con.close();
		}
		acceptListener = new AcceptListener(ports, acceptSelector,
				ioChangeSelector);
		acceptListener.start();
		ioChangeListener = new IoChangeListener(ioChangeSelector);
		ioChangeListener.start();
		long end = System.currentTimeMillis();
		System.out.println("系统启动耗时为:" + (end - begin) + "ms");
		System.out.println("===================================");
		flag = true;
	}

	/**
	 * @return the flag
	 */
	public static boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public static void setFlag(boolean flag) {
		ServerMain.flag = flag;
	}

}
