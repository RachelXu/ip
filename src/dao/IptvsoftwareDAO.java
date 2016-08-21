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
 * Iptvsoftware entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.Iptvsoftware
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class IptvsoftwareDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(IptvsoftwareDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String UP_DATE = "upDate";
	public static final String VERSION = "version";
	public static final String USEDATE = "usedate";
	public static final String FILENAME = "filename";

	protected void initDao() {
		// do nothing
	}

	public void save(Iptvsoftware transientInstance) {
		log.debug("saving Iptvsoftware instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Iptvsoftware persistentInstance) {
		log.debug("deleting Iptvsoftware instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Iptvsoftware findById(java.lang.Integer id) {
		log.debug("getting Iptvsoftware instance with id: " + id);
		try {
			Iptvsoftware instance = (Iptvsoftware) getHibernateTemplate().get(
					"dao.Iptvsoftware", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Iptvsoftware instance) {
		log.debug("finding Iptvsoftware instance by example");
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
		log.debug("finding Iptvsoftware instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Iptvsoftware as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByUpDate(Object upDate) {
		return findByProperty(UP_DATE, upDate);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findByUsedate(Object usedate) {
		return findByProperty(USEDATE, usedate);
	}

	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List findAll() {
		log.debug("finding all Iptvsoftware instances");
		try {
			String queryString = "from Iptvsoftware";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Iptvsoftware merge(Iptvsoftware detachedInstance) {
		log.debug("merging Iptvsoftware instance");
		try {
			Iptvsoftware result = (Iptvsoftware) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Iptvsoftware instance) {
		log.debug("attaching dirty Iptvsoftware instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Iptvsoftware instance) {
		log.debug("attaching clean Iptvsoftware instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IptvsoftwareDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IptvsoftwareDAO) ctx.getBean("IptvsoftwareDAO");
	}
}