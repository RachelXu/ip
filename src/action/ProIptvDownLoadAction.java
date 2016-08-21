package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import logic.ProIptvDownLoadLogic;

import org.apache.struts2.ServletActionContext;

import util.Contants;
import dao.Iptvsoftware;

public class ProIptvDownLoadAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -592930974756071310L;
	private boolean showResultFlag;
	private List<Iptvsoftware> resultList;
	private ProIptvDownLoadLogic logic;
	private String downId;
	private String downloadFileName;
	private InputStream downloadFile;

	/**
	 * @return the downloadFile
	 */
	public InputStream getDownloadFile() throws Exception {
		Iptvsoftware iptvsoftware = new Iptvsoftware();
		logic.doLogic(downId, iptvsoftware);
		String realpath = ServletActionContext.getServletContext().getRealPath(
				Contants.IPTV_SOFTWARE_PATH);
		downloadFileName = iptvsoftware.getFilename();
		File dir = new File(realpath);
		File file = new File(dir, downloadFileName);
		downloadFile = new FileInputStream(file);
		return downloadFile;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * @return the showResultFlag
	 */
	public boolean isShowResultFlag() {
		return showResultFlag;
	}

	/**
	 * @param showResultFlag
	 *            the showResultFlag to set
	 */
	public void setShowResultFlag(boolean showResultFlag) {
		this.showResultFlag = showResultFlag;
	}

	/**
	 * @return the resultList
	 */
	public List<Iptvsoftware> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<Iptvsoftware> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the logic
	 */
	public ProIptvDownLoadLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProIptvDownLoadLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the downId
	 */
	public String getDownId() {
		return downId;
	}

	/**
	 * @param downId
	 *            the downId to set
	 */
	public void setDownId(String downId) {
		this.downId = downId;
	}

	/**
	 * @return the downloadFileName
	 */
	public String getDownloadFileName() {
		return downloadFileName;
	}

	/**
	 * @param downloadFileName
	 *            the downloadFileName to set
	 */
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	/**
	 * @param downloadFile
	 *            the downloadFile to set
	 */
	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

}
