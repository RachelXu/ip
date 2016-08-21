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
 * ServiecType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.ServiecType
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ServiecTypeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ServiecTypeDAO.class);
	// property constants
	public static final String SERVICE_NAME = "serviceName";
	public static final String SERVICE_DAY = "serviceDay";

	protected void initDao() {
		// do nothing
	}

	public void save(ServiecType transientInstance) {
		log.debug("saving ServiecType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ServiecType persistentInstance) {
		log.debug("deleting ServiecType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ServiecType findById(java.lang.Integer id) {
		log.debug("getting ServiecType instance with id: " + id);
		try {
			ServiecType instance = (ServiecType) getHibernateTemplate().get(
					"dao.ServiecType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ServiecType instance) {
		log.debug("finding ServiecType instance by example");
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
		log.debug("finding ServiecType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ServiecType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByServiceName(Object serviceName) {
		return findByProperty(SERVICE_NAME, serviceName);
	}

	public List findByServiceDay(Object serviceDay) {
		return findByProperty(SERVICE_DAY, serviceDay);
	}

	public List findAll() {
		log.debug("finding all ServiecType instances");
		try {
			String queryString = "from ServiecType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ServiecType merge(ServiecType detachedInstance) {
		log.debug("merging ServiecType instance");
		try {
			ServiecType result = (ServiecType) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ServiecType instance) {
		log.debug("attaching dirty ServiecType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ServiecType instance) {
		log.debug("attaching clean ServiecType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ServiecTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ServiecTypeDAO) ctx.getBean("ServiecTypeDAO");
	}
}