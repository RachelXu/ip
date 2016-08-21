/** 任务接口类 **/

package task;

import java.io.IOException;
import java.nio.channels.SocketChannel;

import buffer.Buffer;
import dispatch.Dispatcher;

/**
 * 读任务
 * 
 * @author 郑悦
 */
public class ReadTask extends Task {

	public String info() {
		return "进行读取用户请求的任务";
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

		// 获取该SelectionKey对应的Channel，该Channel中有可读的数据
		SocketChannel sc = (SocketChannel) getKey().channel();

		// 定义准备执行读取数据的ByteBuffer
		// ByteBuffer buff = ByteBuffer.allocate(10);
		// buff.clear();
		Buffer buff = new Buffer();
		buff.allocate();

		// 开始读取数据
		int i = 0;
		try {
			i = sc.read(buff.buff());
			if (!buff.hasRemaining()) {
				buff.expand();
				sc.read(buff.buff());
			}
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
				return;
			}
		}
		if (i == -1) {
			getKey().cancel();
			if (sc != null) {
				try {
					sc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc = null;
			}
			return;
		}
		buff.flip();
		// 加入业务处理队列
		Dispatcher.notifyLogic(getKey(), buff.array());
	}

}