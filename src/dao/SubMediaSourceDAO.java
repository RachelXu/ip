package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * SubMediaSource entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.SubMediaSource
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SubMediaSourceDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(SubMediaSourceDAO.class);
	// property constants
	public static final String ORDER1 = "order1";

	protected void initDao() {
		// do nothing
	}

	public void save(SubMediaSource transientInstance) {
		log.debug("saving SubMediaSource instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SubMediaSource persistentInstance) {
		log.debug("deleting SubMediaSource instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubMediaSource findById(dao.SubMediaSourceId id) {
		log.debug("getting SubMediaSource instance with id: " + id);
		try {
			SubMediaSource instance = (SubMediaSource) getHibernateTemplate()
					.get("dao.SubMediaSource", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SubMediaSource instance) {
		log.debug("finding SubMediaSource instance by example");
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
		log.debug("finding SubMediaSource instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SubMediaSource as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOrder(Object order) {
		return findByProperty(ORDER1, order);
	}

	public List findAll() {
		log.debug("finding all SubMediaSource instances");
		try {
			String queryString = "from SubMediaSource";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SubMediaSource merge(SubMediaSource detachedInstance) {
		log.debug("merging SubMediaSource instance");
		try {
			SubMediaSource result = (SubMediaSource) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SubMediaSource instance) {
		log.debug("attaching dirty SubMediaSource instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubMediaSource instance) {
		log.debug("attaching clean SubMediaSource instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SubMediaSourceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SubMediaSourceDAO) ctx.getBean("SubMediaSourceDAO");
	}
}