package dispatch;

import java.nio.channels.SelectionKey;

import main.ServerMain;
import task.LogicTask;
import task.ReadTask;
import task.WriteTask;

/**
 * 任务分发者
 * 
 * @author 郑悦
 */
public class Dispatcher {

	/**
	 * 分发读请求的任务
	 * 
	 * @param key
	 *            SelectionKey
	 */
	public static void notifyRead(SelectionKey key) {
		ReadTask readTask = new ReadTask();
		readTask.setKey(key);
		ServerMain.readPool.execute(readTask);
	}

	/**
	 * 加入逻辑处理队列
	 * 
	 * @param key
	 *            SelectionKey
	 * @param request
	 *            byte数组
	 */
	public static void notifyLogic(SelectionKey key, byte[] request) {
		LogicTask logicTask = new LogicTask();
		logicTask.setRequest(request);
		logicTask.setKey(key);
		ServerMain.logicPool.execute(logicTask);
	}

	/**
	 * 加入响应处理队列
	 * 
	 * @param key
	 *            SelectionKey
	 * @param response
	 *            byte数组
	 */
	public static void notifyWrite(SelectionKey key, byte[] response) {
		WriteTask writeTask = new WriteTask();
		writeTask.setResponse(response);
		writeTask.setKey(key);
		ServerMain.writePool.execute(writeTask);

	}
}
