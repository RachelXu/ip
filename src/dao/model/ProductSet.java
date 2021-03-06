package dao.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

public class ProductSet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private Set<AccountProductSet> accountProds = new HashSet<AccountProductSet>();
	private Set<Channel> channels;
	
	/** default constructor */
	public ProductSet() {
	}

	public ProductSet(String productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}

	public Set<AccountProductSet> getAccountProds() {
		return accountProds;
	}

	public void setAccountProds(Set<AccountProductSet> accountProds) {
		this.accountProds = accountProds;
	}


}