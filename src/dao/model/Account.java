package dao.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

public class Account implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountId;
	private int state;
	private Set<AccountProductSet> accountProds = new HashSet<AccountProductSet>();

	/** default constructor */
	public Account() {
	}

	public Account(String accountId, int state) {
		this.accountId = accountId;
		this.state = state;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Set<AccountProductSet> getAccountProds() {
		return accountProds;
	}

	public void setAccountProds(Set<AccountProductSet> accountProds) {
		this.accountProds = accountProds;
	}



}