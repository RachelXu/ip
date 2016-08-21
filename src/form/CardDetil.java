package form;

import java.io.Serializable;

public class CardDetil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -905740278451152166L;
	/** 充值卡id */
	private Integer id;
	/** 充值卡状态 */
	private String state;
	/** 充值截止日期 */
	private String enddate;
	/** 充值时长 */
	private Integer day;
	/** 充值时期 */
	private String chargedate;
	/** 行号 */
	private Integer row;
	/** 错误信息 */
	private String errorMessage;

	private String deleteCkeck;

	public CardDetil(Integer row, String errorMessage) {
		super();
		this.row = row;
		this.errorMessage = errorMessage;
	}

	public CardDetil() {

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the enddate
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * @param enddate
	 *            the enddate to set
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * @return the day
	 */
	public Integer getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(Integer day) {
		this.day = day;
	}

	/**
	 * @return the chargedate
	 */
	public String getChargedate() {
		return chargedate;
	}

	/**
	 * @param chargedate
	 *            the chargedate to set
	 */
	public void setChargedate(String chargedate) {
		this.chargedate = chargedate;
	}

	/**
	 * @return the row
	 */
	public Integer getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(Integer row) {
		this.row = row;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the deleteCkeck
	 */
	public String getDeleteCkeck() {
		return deleteCkeck;
	}

	/**
	 * @param deleteCkeck
	 *            the deleteCkeck to set
	 */
	public void setDeleteCkeck(String deleteCkeck) {
		this.deleteCkeck = deleteCkeck;
	}

}
