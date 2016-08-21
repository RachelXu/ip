package dao.model;

/**
 * 
 */

public class AccountProductSet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Account account;
	private ProductSet productSet;
	private String endDate;
	
	/** default constructor */
	public AccountProductSet() {
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ProductSet getProductSet() {
		return productSet;
	}

	public void setProductSet(ProductSet productSet) {
		this.productSet = productSet;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}