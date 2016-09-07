/**
 */
package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.AccountDAO;
import dao.BaseDAO;
import dao.model.Account;
import dao.model.AccountProductSet;
import dao.model.ProductSet;
import form.AccountForm;
import util.CommonUtil;
import util.Contants;

/**
 * 
 */
public class AccountLogic {

	private AccountDAO accountDao;
	private static final Log log = LogFactory.getLog(AccountLogic.class);
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

	public Account loadAccount(String accId) {
		Object o = accountDao.findById(Account.class, accId);
		
		return (Account)o;
	}
	
	public void assignProduct(List<String> accIds, List<String> prodIds, Date validTime) {
		Account acc = null;
		List<String> curProdIds = new ArrayList<String>();
		try{
			for(String accId : accIds) {
				acc = (Account)accountDao.findById(Account.class, accId);
				if (acc != null && acc.getAccountProds().size() > 0) {
					for (AccountProductSet accProd : acc.getAccountProds()) {
						curProdIds.add(accProd.getProductSet().getProductId());					
					}
				}
				List<String> newProdIds = ListUtils.subtract(prodIds, curProdIds);
				
				for(String prodId : newProdIds){
					AccountProductSet accProd = new AccountProductSet();
					accProd.setAccount(acc);
					accProd.setProductSet(new ProductSet(prodId, ""));
					accProd.setEndDate(new Date());
					accountDao.saveOrUpdate(accProd);		
					
				}
			}			
		} catch (Exception e) {
			log.warn("assignProduct failed as " + e.getMessage());
		}
		
	}
	
	public void reduceProduct(List<String> accIds, List<String> prodIds) {
		Account acc = null;
		List<String> curProdIds = new ArrayList<String>();
		try{
			for(String accId : accIds) {
				acc = (Account)accountDao.findById(Account.class, accId);
				if (acc != null && acc.getAccountProds().size() > 0) {
					for (AccountProductSet accProd : acc.getAccountProds()) {
						if (prodIds.contains(accProd.getProductSet().getProductId())) {
							accountDao.delete(accProd);
						}
					}
				}
			}			
		} catch (Exception e) {
			log.warn("reduceProduct failed as " + e.getMessage());
		}
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
