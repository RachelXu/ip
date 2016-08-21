package dispatch;

import java.nio.channels.SelectionKey;

import main.ServerMain;
import task.LogicTask;
import task.ReadTask;
import task.WriteTask;

/**
 * ����ַ���
 * 
 * @author ֣��
 */
public class Dispatcher {

	/**
	 * �ַ������������
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
	 * �����߼��������
	 * 
	 * @param key
	 *            SelectionKey
	 * @param request
	 *            byte����
	 */
	public static void notifyLogic(SelectionKey key, byte[] request) {
		LogicTask logicTask = new LogicTask();
		logicTask.setRequest(request);
		logicTask.setKey(key);
		ServerMain.logicPool.execute(logicTask);
	}

	/**
	 * ������Ӧ�������
	 * 
	 * @param key
	 *            SelectionKey
	 * @param response
	 *            byte����
	 */
	public static void notifyWrite(SelectionKey key, byte[] response) {
		WriteTask writeTask = new WriteTask();
		writeTask.setResponse(response);
		writeTask.setKey(key);
		ServerMain.writePool.execute(writeTask);

	}
}
