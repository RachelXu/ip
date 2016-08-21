package dao;

/**
 * Card entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String pwd;
	private Integer state;
	private Integer day;
	private String enddate;
	private String chargedate;
	private Integer batchNo;
	private Batch batch;
	private ServiecType serviecType;

	// Constructors

	/** default constructor */
	public Card() {
	}

	/** minimal constructor */
	public Card(Integer id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	/** full constructor */
	public Card(Integer id, User user, Batch batch, ServiecType serviecType,
			String pwd, Integer state, Integer day, String enddate,
			String chargedate, Integer batchNo) {
		this.id = id;
		this.user = user;
		this.batch = batch;
		this.serviecType = serviecType;
		this.pwd = pwd;
		this.state = state;
		this.day = day;
		this.enddate = enddate;
		this.chargedate = chargedate;
		this.batchNo = batchNo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getChargedate() {
		return this.chargedate;
	}

	public void setChargedate(String chargedate) {
		this.chargedate = chargedate;
	}

	/**
	 * @return the batch
	 */
	public Batch getBatch() {
		return batch;
	}

	/**
	 * @param batch
	 *            the batch to set
	 */
	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	/**
	 * @return the serviecType
	 */
	public ServiecType getServiecType() {
		return serviecType;
	}

	/**
	 * @param serviecType
	 *            the serviecType to set
	 */
	public void setServiecType(ServiecType serviecType) {
		this.serviecType = serviecType;
	}

	/**
	 * @return the batchNo
	 */
	public Integer getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo
	 *            the batchNo to set
	 */
	public void setBatchNo(Integer batchNo) {
		this.batchNo = batchNo;
	}

}