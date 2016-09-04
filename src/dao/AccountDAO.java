package dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import dao.model.Account;
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


	public int getCount(String accountId, int state, String productId) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("select count(distinct a) from Account a ");
			if (!CommonUtil.isEmpty(productId)) {
				sqlbuffer.append(" left join a.accountProds prod where prod.productSet.productId=? ");
				paramList.add(productId);
			} else {
				sqlbuffer.append(" where 1=1 ");
			}
			if (!CommonUtil.isEmpty(accountId)) {
				sqlbuffer.append("and a.accountId=?");
				paramList.add(accountId);
			}
			if (state != 0) {
				sqlbuffer.append("and a.state=?");
				paramList.add(state);
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
	
	public List<Account> getAccount(String accountId, int state, String productId, int pageNumber) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("select distinct a from Account a ");

			if (!CommonUtil.isEmpty(productId)) {
				sqlbuffer.append(" left join a.accountProds prod where prod.productSet.productId=? ");
				paramList.add(productId);
			} else {
				sqlbuffer.append(" where 1=1 ");
			}
			
			if (!CommonUtil.isEmpty(accountId)) {
				sqlbuffer.append("and a.accountId=?");
				paramList.add(accountId);
			}
			if (state != 0) {
				sqlbuffer.append("and a.state=?");
				paramList.add(state);
			}
			sqlbuffer.append("order by a.accountId");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			queryObject.setFirstResult((pageNumber - 1)
					* Contants.PAGE_SIZE);
			queryObject.setMaxResults(Contants.PAGE_SIZE);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("failed to getAccount.");
			throw re;
		}
	}
}