package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for Card
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see dao.Card
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CardDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CardDAO.class);
	// property constants
	public static final String PWD = "pwd";
	public static final String STATE = "state";
	public static final String DAY = "day";
	public static final String ENDDATE = "enddate";
	public static final String CHARGEDATE = "chargedate";
	public static final String BATCH_NO = "batchNo";

	protected void initDao() {
		// do nothing
	}

	public void save(Card transientInstance) {
		log.debug("saving Card instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Card persistentInstance) {
		log.debug("deleting Card instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Card findById(java.lang.Integer id) {
		log.debug("getting Card instance with id: " + id);
		try {
			Card instance = (Card) getHibernateTemplate().get("dao.Card", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Card instance) {
		log.debug("finding Card instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Card instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Card as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByDay(Object day) {
		return findByProperty(DAY, day);
	}

	public List findByEnddate(Object enddate) {
		return findByProperty(ENDDATE, enddate);
	}

	public List findByChargedate(Object chargedate) {
		return findByProperty(CHARGEDATE, chargedate);
	}

	public List findByBatchNo(Object batchNo) {
		return findByProperty(BATCH_NO, batchNo);
	}

	public List findAll() {
		log.debug("finding all Card instances");
		try {
			String queryString = "from Card";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Card merge(Card detachedInstance) {
		log.debug("merging Card instance");
		try {
			Card result = (Card) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Card instance) {
		log.debug("attaching dirty Card instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Card instance) {
		log.debug("attaching clean Card instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CardDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CardDAO) ctx.getBean("CardDAO");
	}
}