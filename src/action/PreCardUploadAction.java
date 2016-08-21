package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.Card;
import form.CardDetil;

public class PreCardUploadAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5984094446006508234L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	List<Card> cardList = new ArrayList<Card>();
	List<CardDetil> cardErrorList = new ArrayList<CardDetil>();
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
	 * @return the cardList
	 */
	public List<Card> getCardList() {
		return cardList;
	}

	/**
	 * @param cardList
	 *            the cardList to set
	 */
	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	/**
	 * @return the cardErrorList
	 */
	public List<CardDetil> getCardErrorList() {
		return cardErrorList;
	}

	/**
	 * @param cardErrorList
	 *            the cardErrorList to set
	 */
	public void setCardErrorList(List<CardDetil> cardErrorList) {
		this.cardErrorList = cardErrorList;
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
