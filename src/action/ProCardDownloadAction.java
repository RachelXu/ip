package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import logic.LogicDTO;
import logic.ProCardDownloadLogic;
import util.CommonUtil;
import util.Contants;
import dao.Card;
import form.CardForm;

public class ProCardDownloadAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -592930974756071310L;
	private ProCardDownloadLogic logic;
	private String downId;
	private String downloadFileName;
	private InputStream downloadFile;
	private Integer batchNum;

	/**
	 * @return the downloadFile
	 */
	public InputStream getDownloadFile() throws Exception {
		CardForm card = new CardForm();
		logic.doLogic(batchNum, card);
		downloadFileName = "Card"
				+ CommonUtil.formatDateToCharYYYYMMDD(new Date()) + ".csv";
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("充值卡ID");
		sBuilder.append(Contants.DELIM_COMMA);
		sBuilder.append("充值卡密码");
		sBuilder.append(Contants.DELIM_COMMA);
		sBuilder.append("充值天数");
		sBuilder.append(Contants.DELIM_COMMA);
		sBuilder.append("有效时间");
		sBuilder.append(Contants.DELIM_COMMA);
		sBuilder.append("批次");
		sBuilder.append("\n");
		for (Card entity : card.getDownloadList()) {
			sBuilder.append(entity.getId());
			sBuilder.append(Contants.DELIM_COMMA);
			sBuilder.append(entity.getPwd());
			sBuilder.append(Contants.DELIM_COMMA);
			sBuilder.append(entity.getDay());
			sBuilder.append(Contants.DELIM_COMMA);
			sBuilder.append(entity.getEnddate());
			sBuilder.append(Contants.DELIM_COMMA);
			sBuilder.append(entity.getBatchNo());
			sBuilder.append("\n");
		}
		downloadFile = new ByteArrayInputStream(sBuilder.toString().getBytes());
		return downloadFile;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public void validate() {
		super.validate();
		if (CommonUtil.isEmpty(batchNum)) {
			this.addFieldError("field", getText(Contants.E050));
			return;
		}
		LogicDTO dto;
		try {
			dto = logic.doLogic(batchNum, null);
			if (!dto.isResult()) {
				this.addFieldError("field", getText(dto.getErrorCode()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the logic
	 */
	public ProCardDownloadLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardDownloadLogic logic) {
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

	/**
	 * @return the batchNum
	 */
	public Integer getBatchNum() {
		return batchNum;
	}

	/**
	 * @param batchNum
	 *            the batchNum to set
	 */
	public void setBatchNum(Integer batchNum) {
		this.batchNum = batchNum;
	}

}
