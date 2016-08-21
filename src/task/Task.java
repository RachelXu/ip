package task;

import java.nio.channels.SelectionKey;
import java.util.Date;

/**
 * 所有任务接口 其他任务必须继承访类
 * 
 * @author 郑悦
 */
public abstract class Task implements Runnable {

	/* 选择的Key */
	private SelectionKey key = null;

	/* 用户请求 */
	private byte[] request = null;

	/* 用户请求(String类型) */
	private String[] stringRequest = null;

	/* 响应 */
	private byte[] response = null;

	/* 产生时间 */
	private Date generateTime = null;

	/* 提交执行时间 */
	private Date submitTime = null;

	/* 开始执行时间 */
	private Date beginExceuteTime = null;

	/* 执行完成时间 */
	private Date finishTime = null;

	/* 任务ID */
	private long taskId;

	public Task() {
		this.generateTime = new Date();
	}

	/**
	 * 运行主处理
	 * 
	 * @return
	 */
	public abstract void execute();

	/**
	 * 是否用到数据库
	 * 
	 * @return
	 */
	protected abstract boolean useDb();

	/**
	 * 是否需要立即执行
	 * 
	 * @return
	 */
	protected abstract boolean needExecuteImmediate();

	/**
	 * 任务信息
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