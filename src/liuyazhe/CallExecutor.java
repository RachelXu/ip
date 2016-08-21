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
		System.out.println(Thread.currentThread().getName() + "正在处理客户请求");
		// 反序列化出客户端请求对象
		byte[] b = null;
		String[] request = this.getRequest(this.bytes);
		StringBuffer sb = new StringBuffer();
		if (request[1].equalsIgnoreCase("100"))// 操作码100
		{

		} else if (request[1].equalsIgnoreCase("401"))// 操作码401
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
		} else if (request[1].equalsIgnoreCase("404"))// 获取所有节目名称
		{
			List<String[]> list = new ArrayList();
			DaoSupport dao = new DaoSupport();
			list = dao.getChannalAllDao(request[2]);
			b = parseResponse(list);
		} else if (request[1].equalsIgnoreCase("405"))// 获取所有节目名称
		{
			List<String[]> list = new ArrayList();
			DaoSupport dao = new DaoSupport();
			list = dao.getMediaDescDao(request[2]);
			b = parseResponse(list);
		} else {
			System.out.println("没有此操作码");
		}

		// for (int i = 0; i<det.length ;i++){
		// System.out.println(det[i]);
		// }
		// 将响应对象序列化并返回
		return b;
	}

	/**
	 * 反序列化出客户端请求对象
	 * 
	 * @param buff
	 *            ByteBuffer
	 */
	private String[] getRequest(byte[] bytes) throws Exception {

		String[] request = message.readXmlHead(bytes);
		return request;
	}

	/**
	 * 将响应对象序列化
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
