package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for Batch
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see dao.Batch
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BatchDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(BatchDAO.class);
	// property constants
	public static final String BATCH_STATE = "batchState";
	public static final String BATCH_DATE = "batchDate";

	protected void initDao() {
		// do nothing
	}

	public void save(Batch transientInstance) {
		log.debug("saving Batch instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Batch persistentInstance) {
		log.debug("deleting Batch instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Batch findById(java.lang.Integer id) {
		log.debug("getting Batch instance with id: " + id);
		try {
			Batch instance = (Batch) getHibernateTemplate()
					.get("dao.Batch", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Batch instance) {
		log.debug("finding Batch instance by example");
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
		log.debug("finding Batch instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Batch as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBatchState(Object batchState) {
		return findByProperty(BATCH_STATE, batchState);
	}

	public List findByBatchDate(Object batchDate) {
		return findByProperty(BATCH_DATE, batchDate);
	}

	public List findAll() {
		log.debug("finding all Batch instances");
		try {
			String queryString = "from Batch";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Batch merge(Batch detachedInstance) {
		log.debug("merging Batch instance");
		try {
			Batch result = (Batch) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Batch instance) {
		log.debug("attaching dirty Batch instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Batch instance) {
		log.debug("attaching clean Batch instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BatchDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BatchDAO) ctx.getBean("BatchDAO");
	}
}