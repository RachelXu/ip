package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import logic.LogicDTO;
import logic.ProMediaInsertLogic;
import util.CommonUtil;
import util.Contants;
import dao.SubMediaSource;
import dao.SubMediaSourceId;
import form.MediaDetil;
import form.MediaForm;

public class ProMediaInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private MediaForm media;
	private ProMediaInsertLogic logic;
	private String pageString;
	List<MediaDetil> sourceErrorList = new ArrayList<MediaDetil>();
	private boolean showError;

	public String execute() throws Exception {
		MediaForm tempForm = (MediaForm) this.request.getSession()
				.getAttribute("mediaform");
		media.copy(tempForm);
		// 上传单个链接的情况
		LogicDTO dto = null;
		if (media.getRadioCheck() == 1) {
			if (CommonUtil.isEmpty(media.getSourceLink())) {
				this.addFieldError("field", getText(Contants.E026));
				return INPUT;
			}
			dto = logic.doLogic(media);
		} else {
			// 上传多个链接的情况
			if (CommonUtil.isEmpty(uploadFileName)) {
				this.addFieldError("field", getText(Contants.E015));
				return INPUT;
			}
			String extString = CommonUtil.getFileExt(uploadFileName);
			if (!Contants.CSV.equals(extString)) {
				this.addFieldError("field", getText(Contants.E004));
				return INPUT;
			}
			int recordCount = 0;
			FileInputStream fis = new FileInputStream(getUpload());
			BufferedReader inBuffer = new BufferedReader(new InputStreamReader(
					fis));
			String strRecord = null;
			SubMediaSource entitySubMediaSource = null;
			boolean errorFlag = false;
			while ((strRecord = inBuffer.readLine()) != null) {
				errorFlag = false;
				recordCount++;
				if (recordCount == 1) {
					continue;
				}
				String strRecordTmp = strRecord;
				if (strRecord.endsWith(",")) {
					strRecordTmp = strRecordTmp + " ";
				}
				String[] strs = strRecordTmp.split("[,]");
				entitySubMediaSource = new SubMediaSource();
				// 顺序
				if (CommonUtil.isEmpty(strs[0])) {
					errorFlag = true;
					sourceErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E029)));
				} else if (!CommonUtil.isEmpty(strs[0])
						&& !CommonUtil.isNumber(strs[0])) {
					errorFlag = true;
					sourceErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E030)));
				} else {
					entitySubMediaSource.setOrder1(Integer.valueOf(strs[0]));
				}
				// URL
				if (CommonUtil.isEmpty(strs[1])
						|| Contants.BLANK.equals(strs[1])) {
					errorFlag = true;
					sourceErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E031)));
				} else {
					entitySubMediaSource.setId(new SubMediaSourceId(null,
							strs[1]));
				}
				if (errorFlag == false) {
					media.getSubMediaSourceList().add(entitySubMediaSource);
				}
			}
			if (sourceErrorList.size() != 0) {
				showError = true;
			} else {
				dto = logic.doLogic(media);
			}
		}
		if (dto == null) {
			return INPUT;
		} else if (dto.isResult()) {
			this.addFieldError("field", "新增节目信息成功！");
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			return INPUT;
		}
	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(media.getYear())
				&& !CommonUtil.isNumber(media.getYear())) {
			this.addFieldError("field", getText(Contants.E028));
		}
		MediaForm tempForm = (MediaForm) this.request.getSession()
				.getAttribute("mediaform");
		media.copy(tempForm);
	}

	/**
	 * @return the logic
	 */
	public ProMediaInsertLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProMediaInsertLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the pageString
	 */
	public String getPageString() {
		return pageString;
	}

	/**
	 * @param pageString
	 *            the pageString to set
	 */
	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

	/**
	 * @return the media
	 */
	public MediaForm getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(MediaForm media) {
		this.media = media;
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
	 * @return the sourceErrorList
	 */
	public List<MediaDetil> getSourceErrorList() {
		return sourceErrorList;
	}

	/**
	 * @param sourceErrorList
	 *            the sourceErrorList to set
	 */
	public void setSourceErrorList(List<MediaDetil> sourceErrorList) {
		this.sourceErrorList = sourceErrorList;
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

}
