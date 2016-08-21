package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.Area;
import dao.AreaDAO;
import dao.Catalog;
import dao.CatalogDAO;
import dao.Language;
import dao.LanguageDAO;
import dao.MediaCatalog;
import dao.MediaDesc;
import dao.SubMediaSource;
import dao.SubMediaSourceId;
import form.MediaDetil;

public class ProMediaBatchUploadAction extends MySuperAction {
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
	private CatalogDAO dao1;
	private LanguageDAO dao2;
	private AreaDAO dao3;

	public String execute() throws Exception {
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
		BufferedReader inBuffer = new BufferedReader(new InputStreamReader(fis));
		String strRecord = null;
		MediaDesc entityMediaDesc = null;
		MediaDetil viewMediaDetil = null;
		MediaCatalog entityMediaCatalog = null;
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
			viewMediaDetil = new MediaDetil();
			entityMediaDesc = new MediaDesc();
			entityMediaCatalog = new MediaCatalog();
			entitySubMediaSource = new SubMediaSource();
			entityMediaDesc.setMediaCatalog(entityMediaCatalog);
			// 节目中文名称
			if (CommonUtil.isEmpty(strs[0])) {
				errorFlag = true;
				mediaErrorList.add(new MediaDetil(recordCount, this
						.getText(Contants.E032)));
			} else {
				entityMediaDesc.setMediaName(strs[0]);
				entityMediaCatalog.setMediaCatalogName(strs[0]);
				viewMediaDetil.setMediaName(strs[0]);
			}
			// 节目英文名称
			if (CommonUtil.isEmpty(strs[1])) {
				errorFlag = true;
				mediaErrorList.add(new MediaDetil(recordCount, this
						.getText(Contants.E033)));
			} else {
				entityMediaCatalog.setCatalogEnName(strs[1]);
				viewMediaDetil.setMediaNameEn(strs[1]);
			}
			// 年代
			if (!CommonUtil.isEmpty(strs[2])) {
				if (CommonUtil.isyyyyMMdd(strs[2])) {
					entityMediaDesc.setYear(strs[2]);
					viewMediaDetil.setYear(strs[2]);
				} else {
					errorFlag = true;
					mediaErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E028)));
				}
			}
			// 导演
			entityMediaDesc.setDirector(strs[3]);
			viewMediaDetil.setDirector(strs[3]);
			// 演员
			entityMediaDesc.setActor(strs[4]);
			viewMediaDetil.setActor(strs[4]);
			// 评分
			if (!CommonUtil.isEmpty(strs[5])) {
				if (CommonUtil.isNumber(strs[5])) {
					entityMediaDesc.setGrade(Integer.valueOf(strs[5]));
					viewMediaDetil.setGrade(Integer.valueOf(strs[5]));
				} else {
					errorFlag = true;
					mediaErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E034)));
				}
			}
			// 节目目录
			if (CommonUtil.isEmpty(strs[6])) {
				errorFlag = true;
				mediaErrorList.add(new MediaDetil(recordCount, this
						.getText(Contants.E035)));
			} else {
				if (CommonUtil.isNumber(strs[6])) {
					Catalog catalog = dao1.findById(Integer.valueOf(strs[6]));
					if (CommonUtil.isEmpty(catalog)) {
						errorFlag = true;
						mediaErrorList.add(new MediaDetil(recordCount, this
								.getText(Contants.E037)));
					} else {
						entityMediaCatalog.getCatalogs().add(catalog);
						viewMediaDetil.setCatalogId(Integer.valueOf(strs[6]));
					}
				} else {
					errorFlag = true;
					mediaErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E036)));
				}
			}
			// 语言
			if (!CommonUtil.isEmpty(strs[7])) {
				if (CommonUtil.isNumber(strs[7])) {
					Language language = dao2.findById(Integer.valueOf(strs[7]));
					if (CommonUtil.isEmpty(language)) {
						errorFlag = true;
						mediaErrorList.add(new MediaDetil(recordCount, this
								.getText(Contants.E039)));
					} else {
						entityMediaDesc.setLanguage(language);
						viewMediaDetil.setLanguage(language.getLanguageName());
					}
				} else {
					errorFlag = true;
					mediaErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E038)));
				}
			}
			// 地区
			if (!CommonUtil.isEmpty(strs[8])) {
				if (CommonUtil.isNumber(strs[8])) {
					Area area = dao3.findById(Integer.valueOf(strs[8]));
					if (CommonUtil.isEmpty(area)) {
						errorFlag = true;
						mediaErrorList.add(new MediaDetil(recordCount, this
								.getText(Contants.E041)));
					} else {
						entityMediaDesc.setArea(area);
						viewMediaDetil.setArea(area.getAreaName());
					}
				} else {
					errorFlag = true;
					mediaErrorList.add(new MediaDetil(recordCount, this
							.getText(Contants.E040)));
				}
			}
			// 源链接
			if (CommonUtil.isEmpty(strs[9])) {
				errorFlag = true;
				mediaErrorList.add(new MediaDetil(recordCount, this
						.getText(Contants.E031)));
			} else {
				entitySubMediaSource.setOrder1(1);
				entitySubMediaSource.setId(new SubMediaSourceId(
						entityMediaDesc, strs[9]));
				entityMediaDesc.getSubMediaSources().add(entitySubMediaSource);
				viewMediaDetil.setLink(strs[9]);
			}
			// 简介
			entityMediaDesc.setIntroduction(strs[10]);
			viewMediaDetil.setIntroduction(strs[10]);
			if (errorFlag == false) {
				viewMediaList.add(viewMediaDetil);
				entityList.add(entityMediaDesc);
			}
		}
		if (mediaErrorList.size() != 0) {
			showError = true;
			return INPUT;
		} else {
			this.request.getSession().setAttribute("entityList", entityList);
			showNomal = true;
			return SUCCESS;
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
	 * @return the dao1
	 */
	public CatalogDAO getDao1() {
		return dao1;
	}

	/**
	 * @param dao1
	 *            the dao1 to set
	 */
	public void setDao1(CatalogDAO dao1) {
		this.dao1 = dao1;
	}

	/**
	 * @return the dao2
	 */
	public LanguageDAO getDao2() {
		return dao2;
	}

	/**
	 * @param dao2
	 *            the dao2 to set
	 */
	public void setDao2(LanguageDAO dao2) {
		this.dao2 = dao2;
	}

	/**
	 * @return the dao3
	 */
	public AreaDAO getDao3() {
		return dao3;
	}

	/**
	 * @param dao3
	 *            the dao3 to set
	 */
	public void setDao3(AreaDAO dao3) {
		this.dao3 = dao3;
	}

}
