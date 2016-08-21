package liuyazhe;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallExecutor implements Callable<byte[]> {

	private byte[] bytes = null;
	private Message message = new Message();

	public CallExecutor(byte[] bytes) {
		this.bytes = bytes;

	}

	public byte[] call() throws Exception {
		System.out.println(Thread.currentThread().getName() + "���ڴ���ͻ�����");
		// �����л����ͻ����������
		byte[] b = null;
		String[] request = this.getRequest(this.bytes);
		StringBuffer sb = new StringBuffer();
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

		// for (int i = 0; i<det.length ;i++){
		// System.out.println(det[i]);
		// }
		// ����Ӧ�������л�������
		return b;
	}

	/**
	 * �����л����ͻ����������
	 * 
	 * @param buff
	 *            ByteBuffer
	 */
	private String[] getRequest(byte[] bytes) throws Exception {

		String[] request = message.readXmlHead(bytes);
		return request;
	}

	/**
	 * ����Ӧ�������л�
	 * 
	 * @param buff
	 *            ByteBuffer
	 */

	private byte[] parseResponse(List<String[]> response) throws Exception {

		ByteArrayOutputStream baos = message.createXMLbody(response);
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(response);
		oos.close();
		baos.close();
		return baos.toByteArray();
	}
}
