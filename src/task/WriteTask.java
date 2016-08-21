/** 任务接口类 **/

package task;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 写任务
 * 
 * @author 郑悦
 */
public class WriteTask extends Task {

	public String info() {
		return "进行写响应用户的任务";
	}

	protected boolean needExecuteImmediate() {
		return true;
	}

	protected boolean useDb() {
		return false;
	}

	/**
	 * 任务执行入口
	 */
	public void execute() {

		// 获取该SelectionKey对应的Channel，该Channel中有可写的数据
		SocketChannel sc = (SocketChannel) getKey().channel();
		try {
			sc.open();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ByteBuffer buff = ByteBuffer.allocate(getResponse().length);
		buff.clear();
		buff.put(getResponse());
		buff.flip();
		try {
			sc.write(buff);
		} catch (IOException e) {
			e.printStackTrace();
			getKey().cancel();
			if (sc != null) {
				try {
					sc.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				sc = null;
			}
		}
	}

}