/**
 */
package logic;

import java.util.List;

import dao.AccountDAO;
import dao.model.Account;
import form.AccountForm;
import util.CommonUtil;
import util.Contants;

/**
 * 
 */
public class AccountLogic {

	private AccountDAO accountDao;
	
	/**
	 */
	public LogicDTO search(AccountForm form, String productId){
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = accountDao.getCount(form.getAccount().getAccountId(), form.getAccount().getState(), productId);
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<Account> accountList = accountDao.getAccount(form.getAccount().getAccountId(), form.getAccount().getState(), productId, form.getCurrentPage());
			
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE, resultCount));
			form.setResultCount(resultCount);
			form.setAccountList(accountList);
		}
		return dto;
	}

	public boolean delete(String accId) {
		Object o = accountDao.findById(Account.class, accId);
		try{
		
			if (o != null) {
				accountDao.delete(o);
			}
			

		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

}
