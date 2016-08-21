package listener;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

import dispatch.Dispatcher;

/**
 * 报文系统服务器端
 * 
 * @author 郑悦
 */
public class IoChangeListener extends Thread {

	/** 用于检测所有Channel状态的Selector */
	private Selector ioChangeSelector = null;

	/**
	 * 构造方法
	 * 
	 * @throws IOException
	 */
	public IoChangeListener(Selector ioChangeSelector) throws IOException {

		// 创建一个Selector
		this.ioChangeSelector = ioChangeSelector;

	}

	/**
	 * 主处理
	 */
	public void run() {
		int keyCount = 0;
		try {
			while (this.ioChangeSelector.isOpen()) {
				keyCount = this.ioChangeSelector.selectNow();
				if (keyCount > 0) {

					Iterator<SelectionKey> iterator = ioChangeSelector
							.selectedKeys().iterator();
					// 依次处理selector上的每个已选择的SelectionKey
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						// 从selector上的已选择Key集中删除正在处理的SelectionKey
						iterator.remove();
						if (key.isReadable()) {
							// 如果key对应的通道有数据需要读取
							// 分发读请求的任务
							// System.out.println(Thread.currentThread().getName()
							// + "正在监听IO状态改变");
							key.cancel();
							Dispatcher.notifyRead(key);
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
