/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import dao.AccountDAO;
import dao.UserDAOplus;
import dao.model.Account;
import form.UserForm;
import util.CommonUtil;
import util.Contants;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProUserSearchLogic {

	private UserDAOplus dao;

	private AccountDAO accountDao;
	
	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ�?
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(UserForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = accountDao.getCount(form);
		// �����������Ϊ0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<Account> userList = accountDao.getAccount(form);
			
			// ��ҳ��
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// ��¼��
			form.setResultCount(resultCount);
			form.setAccountList(userList);
		}
		return dto;
	}

	/**
	 * @return the dao
	 */
	public UserDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(UserDAOplus dao) {
		this.dao = dao;
	}

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

}
