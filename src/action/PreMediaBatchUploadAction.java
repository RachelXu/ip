package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import form.MediaDetil;

public class PreMediaBatchUploadAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5984094446006508234L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	List<MediaDetil> mediaList = new ArrayList<MediaDetil>();
	List<MediaDetil> mediaErrorList = new ArrayList<MediaDetil>();
	private boolean showError;
	private boolean showNomal;

	public String execute() throws Exception {
		showError = false;
		showNomal = false;
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
	 * @return the mediaList
	 */
	public List<MediaDetil> getMediaList() {
		return mediaList;
	}

	/**
	 * @param mediaList
	 *            the mediaList to set
	 */
	public void setMediaList(List<MediaDetil> mediaList) {
		this.mediaList = mediaList;
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

}
