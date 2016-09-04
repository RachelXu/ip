package form;

import java.io.Serializable;
import java.util.List;

import dao.model.Account;
import dao.model.ProductSet;
import util.Contants;
import util.Contants.AccountStatus;

public class AccountForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	private Account account;
	private List<ProductSet> productSet;
	private List<Account> accountList;
	private boolean resultFlag;
	private Integer currentPage;
	private Integer pageCount;
	private Integer resultCount;
	private AccountStatus[] accountStatus = Contants.AccountStatus.values();
	

	public void initView(boolean resultFlag) {
		this.resultFlag = resultFlag;
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


	public boolean isResultFlag() {
		return resultFlag;
	}


	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
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


	public AccountStatus[] getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(AccountStatus[] accountStatus) {
		this.accountStatus = accountStatus;
	}

}
