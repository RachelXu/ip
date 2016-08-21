package form;

import java.io.Serializable;

public class UserDetil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -905740278451152166L;
	/** �û�id */
	private Integer id;
	/** �û����� */
	private String name;
	/** �û�״̬ */
	private String state;
	/** �û����� */
	private String type;
	/** �û�����ʣ������ */
	private String restday;
	/** �û��������� */
	private Integer group;
	/** �к� */
	private Integer row;
	/** ������Ϣ */
	private String errorMessage;

	private String deleteCkeck;

	public UserDetil(Integer row, String errorMessage) {
		super();
		this.row = row;
		this.errorMessage = errorMessage;
	}

	public UserDetil() {

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the group
	 */
	public Integer getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(Integer group) {
		this.group = group;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

	/**
	 * @return the restday
	 */
	public String getRestday() {
		return restday;
	}

	/**
	 * @param restday
	 *            the restday to set
	 */
	public void setRestday(String restday) {
		this.restday = restday;
	}

}
