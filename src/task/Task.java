package task;

import java.nio.channels.SelectionKey;
import java.util.Date;

/**
 * ��������ӿ� �����������̳з���
 * 
 * @author ֣��
 */
public abstract class Task implements Runnable {

	/* ѡ���Key */
	private SelectionKey key = null;

	/* �û����� */
	private byte[] request = null;

	/* �û�����(String����) */
	private String[] stringRequest = null;

	/* ��Ӧ */
	private byte[] response = null;

	/* ����ʱ�� */
	private Date generateTime = null;

	/* �ύִ��ʱ�� */
	private Date submitTime = null;

	/* ��ʼִ��ʱ�� */
	private Date beginExceuteTime = null;

	/* ִ�����ʱ�� */
	private Date finishTime = null;

	/* ����ID */
	private long taskId;

	public Task() {
		this.generateTime = new Date();
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public abstract void execute();

	/**
	 * �Ƿ��õ����ݿ�
	 * 
	 * @return
	 */
	protected abstract boolean useDb();

	/**
	 * �Ƿ���Ҫ����ִ��
	 * 
	 * @return
	 */
	protected abstract boolean needExecuteImmediate();

	/**
	 * ������Ϣ
	 * 
	 * @return String
	 */
	public abstract String info();

	/**
	 * @return the key
	 */
	public SelectionKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(SelectionKey key) {
		this.key = key;
	}

	/**
	 * @return the request
	 */
	public byte[] getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(byte[] request) {
		this.request = request;
	}

	/**
	 * @return the response
	 */
	public byte[] getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(byte[] response) {
		this.response = response;
	}

	/**
	 * @return the generateTime
	 */
	public Date getGenerateTime() {
		return generateTime;
	}

	/**
	 * @param generateTime
	 *            the generateTime to set
	 */
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

	/**
	 * @return the submitTime
	 */
	public Date getSubmitTime() {
		return submitTime;
	}

	/**
	 * @param submitTime
	 *            the submitTime to set
	 */
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	/**
	 * @return the beginExceuteTime
	 */
	public Date getBeginExceuteTime() {
		return beginExceuteTime;
	}

	/**
	 * @param beginExceuteTime
	 *            the beginExceuteTime to set
	 */
	public void setBeginExceuteTime(Date beginExceuteTime) {
		this.beginExceuteTime = beginExceuteTime;
	}

	/**
	 * @return the finishTime
	 */
	public Date getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime
	 *            the finishTime to set
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * @return the taskId
	 */
	public long getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the stringRequest
	 */
	public String[] getStringRequest() {
		return stringRequest;
	}

	/**
	 * @param stringRequest
	 *            the stringRequest to set
	 */
	public void setStringRequest(String[] stringRequest) {
		this.stringRequest = stringRequest;
	}

	public void run() {
		execute();

	}
}