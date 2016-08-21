package dao.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

public class ProductCard implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cardNumber;
	private int cardValue;
	private String productID;
	private int cardState;
	private String useDate;
	private String accountID;
	

	/** default constructor */
	public ProductCard() {
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public int getCardValue() {
		return cardValue;
	}


	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public int getCardState() {
		return cardState;
	}


	public void setCardState(int cardState) {
		this.cardState = cardState;
	}


	public String getUseDate() {
		return useDate;
	}


	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}


	public String getAccountID() {
		return accountID;
	}


	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

}