package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import logic.ProMediaBatchUploadLogic;
import dao.MediaDesc;
import form.MediaDetil;

public class ProMediaBatchUploadConfirmAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1841919829450192876L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	List<MediaDetil> viewMediaList = new ArrayList<MediaDetil>();
	List<MediaDesc> entityList = new ArrayList<MediaDesc>();
	List<MediaDetil> mediaErrorList = new ArrayList<MediaDetil>();
	private boolean showError;
	private boolean showNomal;
	private ProMediaBatchUploadLogic logic;

	public String execute() throws Exception {
		entityList = (List<MediaDesc>) this.request.getSession().getAttribute(
				"entityList");
		logic.doLogic(entityList);
		this.request.getSession().removeAttribute("entityList");
		return SUCCESS;
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
	 * @return the viewMediaList
	 */
	public List<MediaDetil> getViewMediaList() {
		return viewMediaList;
	}

	/**
	 * @param viewMediaList
	 *            the viewMediaList to set
	 */
	public void setViewMediaList(List<MediaDetil> viewMediaList) {
		this.viewMediaList = viewMediaList;
	}

	/**
	 * @return the entityList
	 */
	public List<MediaDesc> getEntityList() {
		return entityList;
	}

	/**
	 * @param entityList
	 *            the entityList to set
	 */
	public void setEntityList(List<MediaDesc> entityList) {
		this.entityList = entityList;
	}

	/**
	 * @return the mediaErrorList
	 */
	public List<MediaDetil> getMediaErrorList() {
		return mediaErrorList;
	}

	/**
	 * @param mediaErrorList
	 *            the mediaErrorList to set
	 */
	public void setMediaErrorList(List<MediaDetil> mediaErrorList) {
		this.mediaErrorList = mediaErrorList;
	}

	/**
	 * @return the showError
	 */
	public boolean isShowError() {
		return showError;
	}

	/**
	 * @param showError
	 *            the showError to set
	 */
	public void setShowError(boolean showError) {
		this.showError = showError;
	}

	/**
	 * @return the showNomal
	 */
	public boolean isShowNomal() {
		return showNomal;
	}

	/**
	 * @param showNomal
	 *            the showNomal to set
	 */
	public void setShowNomal(boolean showNomal) {
		this.showNomal = showNomal;
	}

	/**
	 * @return the logic
	 */
	public ProMediaBatchUploadLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProMediaBatchUploadLogic logic) {
		this.logic = logic;
	}

}
