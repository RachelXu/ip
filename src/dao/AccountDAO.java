package dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import dao.model.Account;
import form.UserForm;
import util.CommonUtil;
import util.Contants;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see dao.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AccountDAO extends BaseDAO<Account> {
	private static final Log log = LogFactory.getLog(AccountDAO.class);


	public int getCount(UserForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("select count(*) from Account where 1=1");
			// �û�ID
			if (!CommonUtil.isEmpty(form.getName())) {
				sqlbuffer.append("and accountId=?");
				paramList.add(form.getName());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			return (Integer) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("failed to getCount.");
			throw re;
		}
	}
	
	public List<Account> getAccount(UserForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("from Account where 1=1");
			// �û�ID
			if (!CommonUtil.isEmpty(form.getName())) {
				sqlbuffer.append("and accountId=?");
				paramList.add(form.getName());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			sqlbuffer.append("order by accountId");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			queryObject.setFirstResult((form.getCurrentPage() - 1)
					* Contants.PAGE_SIZE);
			queryObject.setMaxResults(Contants.PAGE_SIZE);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("failed to getAccount.");
			throw re;
		}
	}
}