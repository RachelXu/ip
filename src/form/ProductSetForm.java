package form;

import java.io.Serializable;
import java.util.List;

import dao.model.Account;
import dao.model.ProductSet;
import util.Contants;

public class ProductSetForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	private Account account;
	private List<ProductSet> productSet;
	private List<Account> accountList;
	private Integer currentPage;
	private Integer pageCount;
	private Integer resultCount;

	public void initView(boolean resultFlag) {
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<ProductSet> getProductSet() {
		return productSet;
	}

	public void setProductSet(List<ProductSet> productSet) {
		this.productSet = productSet;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

}
