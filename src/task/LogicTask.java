/** ����ӿ��� **/

package task;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import liuyazhe.DaoSupport;
import liuyazhe.Message;
import dispatch.Dispatcher;

/**
 * �߼�����
 * 
 * @author ���ǆ�
 */
public class LogicTask extends Task {
	private Message message = new Message();

	public String info() {
		return "�����߼�����";
	}

	protected boolean needExecuteImmediate() {
		return true;
	}

	protected boolean useDb() {
		return false;
	}

	/**
	 * ����ִ�����
	 */
	public void execute() {
		byte[] bytes = getRequest();

		// �����л����ͻ����������
		String[] request = this.getRequest(bytes);
		StringBuffer sb = new StringBuffer();
		byte[] b = null;
		// ��������жϣ�����ҵ����
		if (request[1].equalsIgnoreCase("100"))// ������100
		{

		} else if (request[1].equalsIgnoreCase("401"))// ������401
		{
			List<String[]> list = new ArrayList();
			DaoSupport dao = new DaoSupport();
			list = dao.getChannalClassifyDao(request[2]);
			b = parseResponse(list);

		} else if (request[1].equalsIgnoreCase("402")) {
			List<String[]> list = new ArrayList();
			DaoSupport dao = new DaoSupport();
			list = dao.getChannalDetialDao(request[2]);
			b = parseResponse(list);
		} else if (request[1].equalsIgnoreCase("403")) {
			List<String[]> list = new ArrayList();
			DaoSupport dao = new DaoSupport();
			list = dao.getChannalResourceDao(request[2]);
			b = parseResponse(list);
		} else if (request[1].equalsIgnoreCase("404"))// ��ȡ���н�Ŀ����
		{
			List<String[]> list = new ArrayList();
			DaoSupport dao = new DaoSupport();
			list = dao.getChannalAllDao(request[2]);
			b = parseResponse(list);
		} else if (request[1].equalsIgnoreCase("405"))// ��ȡ���н�Ŀ����
		{
			List<String[]> list = new ArrayList();
			DaoSupport dao = new DaoSupport();
			list = dao.getMediaDescDao(request[2]);
			b = parseResponse(list);
		} else {
			System.out.println("û�д˲�����");
		}

		// ������Ӧ�������
		Dispatcher.notifyWrite(getKey(), b);
	}

	/**
	 * �����л����ͻ����������
	 * 
	 * @param buff
	 *            ByteBuffer
	 */
	private String[] getRequest(byte[] bytes) {

		String[] request = message.readXmlHead(bytes);
		return request;
	}

	/**
	 * ����Ӧ�������л�
	 * 
	 * @param buff
	 *            ByteBuffer
	 */

	private byte[] parseResponse(List<String[]> response) {

		ByteArrayOutputStream baos = message.createXMLbody(response);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(response);
			oos.close();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return baos.toByteArray();
	}

}