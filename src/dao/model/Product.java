package dao.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;

	/** default constructor */
	public Product() {
	}

	public Product(String productId, String productName) {
		super();
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

}