package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import logic.ProIptvUploadLogic;

import org.apache.struts2.ServletActionContext;

import util.CommonUtil;
import util.Contants;

public class ProIptvUploadAction extends MySuperAction {

	private static final long serialVersionUID = -4954571183292793919L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String version;
	private String update;
	private String content;
	private String usedate;
	private ProIptvUploadLogic logic;

	public String execute() throws Exception {
		String realpath = ServletActionContext.getServletContext().getRealPath(
				Contants.IPTV_SOFTWARE_PATH);
		File dir = new File(realpath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		String outNameString = version + Contants.UNDERLINE + uploadFileName;
		FileInputStream fis = new FileInputStream(upload);
		FileOutputStream fos = new FileOutputStream(
				new File(dir, outNameString));
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		logic.doLogic(version, update, content, usedate, outNameString);
		return SUCCESS;
	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(version) && !CommonUtil.isNumber(version)) {
			this.addFieldError("field", getText(Contants.E051));
		}
		if (!CommonUtil.isEmpty(update) && !CommonUtil.isyyyyMMdd(update)) {
			this.addFieldError("field", getText(Contants.E016));
		}
		if (!CommonUtil.isEmpty(usedate) && !CommonUtil.isyyyyMMdd(usedate)) {
			this.addFieldError("field", getText(Contants.E017));
		}
	}

	/**
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}

	/**
	 * @param upload
	 *            the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName
	 *            the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the uploadContentType
	 */
	public String getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType
	 *            the uploadContentType to set
	 */
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the update
	 */
	public String getUpdate() {
		return update;
	}

	/**
	 * @param update
	 *            the update to set
	 */
	public void setUpdate(String update) {
		this.update = update;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the userdate
	 */
	public String getUsedate() {
		return usedate;
	}

	/**
	 * @param userdate
	 *            the userdate to set
	 */
	public void setUsedate(String usedate) {
		this.usedate = usedate;
	}

	/**
	 * @return the logic
	 */
	public ProIptvUploadLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProIptvUploadLogic logic) {
		this.logic = logic;
	}

}
