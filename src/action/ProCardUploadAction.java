package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.Card;
import dao.User;
import dao.UserDAOplus;
import form.CardDetil;

public class ProCardUploadAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1841919829450192876L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	List<Card> cardList = new ArrayList<Card>();
	List<CardDetil> cardErrorList = new ArrayList<CardDetil>();
	private boolean showError;
	private boolean showNomal;
	private UserDAOplus dao;

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
		Card card = null;
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
			card = new Card();
			// 用户id
			if (!CommonUtil.isEmpty(strs[0]) && !CommonUtil.isNumber(strs[0])) {
				errorFlag = true;
				cardErrorList.add(new CardDetil(recordCount, this
						.getText(Contants.E023)));
			} else if (!CommonUtil.isEmpty(strs[0])) {
				User user = dao.findById(Integer.valueOf(strs[0]));
				if (user == null) {
					errorFlag = true;
					cardErrorList.add(new CardDetil(recordCount, this
							.getText(Contants.E024)));
				} else {
					card.setUser(user);
				}
			}
			// 密码
			if (CommonUtil.isEmpty(strs[1])) {
				errorFlag = true;
				cardErrorList.add(new CardDetil(recordCount, this
						.getText(Contants.E018)));
			} else {
				card.setPwd(strs[1]);
			}
			// 充值卡状态
			if (!CommonUtil.isEmpty(strs[2]) && !CommonUtil.isNumber(strs[2])) {
				errorFlag = true;
				cardErrorList.add(new CardDetil(recordCount, this
						.getText(Contants.E019)));
			} else if (!Contants.STRING_1.equals(strs[2])
					&& !Contants.STRING_2.equals(strs[2])
					&& !Contants.STRING_3.equals(strs[2])) {
				errorFlag = true;
				cardErrorList.add(new CardDetil(recordCount, this
						.getText(Contants.E019)));
			} else {
				card.setState(Integer.valueOf(strs[2]));
			}
			// 充值时长
			if (!CommonUtil.isEmpty(strs[3]) && !CommonUtil.isNumber(strs[3])) {
				errorFlag = true;
				cardErrorList.add(new CardDetil(recordCount, this
						.getText(Contants.E020)));
			} else {
				card.setDay(Integer.valueOf(strs[3]));
			}
			// 截止时间
			if (!CommonUtil.isEmpty(strs[4]) && !CommonUtil.isyyyyMMdd(strs[4])) {
				errorFlag = true;
				cardErrorList.add(new CardDetil(recordCount, this
						.getText(Contants.E021)));
			} else {
				card.setEnddate(strs[4]);
			}
			// 充值时间
			if (!CommonUtil.isEmpty(strs[5])
					&& !CommonUtil.isyyyyMMdd(strs[5].trim())) {
				errorFlag = true;
				cardErrorList.add(new CardDetil(recordCount, this
						.getText(Contants.E022)));
			} else if (!CommonUtil.isEmpty(strs[5])) {
				card.setChargedate(strs[5].trim());
			}
			if (errorFlag == false) {
				cardList.add(card);
			}
		}
		if (cardErrorList.size() != 0) {
			showError = true;
			return INPUT;
		} else {
			this.request.getSession().setAttribute("cardupload", cardList);
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
	 * @return the dao
	 */
	public UserDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(UserDAOplus dao) {
		this.dao = dao;
	}

}
