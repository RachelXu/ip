/** 任务接口类 **/

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
 * 逻辑任务
 * 
 * @author 刘亚喆
 */
public class LogicTask extends Task {
	private Message message = new Message();

	public String info() {
		return "进行逻辑任务";
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
		byte[] bytes = getRequest();

		// 反序列化出客户端请求对象
		String[] request = this.getRequest(bytes);
		StringBuffer sb = new StringBuffer();
		byte[] b = null;
		// 具体进行判断，进行业务处理
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

		// 加入响应处理队列
		Dispatcher.notifyWrite(getKey(), b);
	}

	/**
	 * 反序列化出客户端请求对象
	 * 
	 * @param buff
	 *            ByteBuffer
	 */
	private String[] getRequest(byte[] bytes) {

		String[] request = message.readXmlHead(bytes);
		return request;
	}

	/**
	 * 将响应对象序列化
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