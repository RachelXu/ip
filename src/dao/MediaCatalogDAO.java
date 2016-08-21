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
 * MediaCatalog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.MediaCatalog
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MediaCatalogDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MediaCatalogDAO.class);
	// property constants
	public static final String MEDIA_CATALOG_NAME = "mediaCatalogName";
	public static final String CATALOG_EN_NAME = "catalogEnName";
	public static final String PIC = "pic";

	protected void initDao() {
		// do nothing
	}

	public void save(MediaCatalog transientInstance) {
		log.debug("saving MediaCatalog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MediaCatalog persistentInstance) {
		log.debug("deleting MediaCatalog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MediaCatalog findById(java.lang.Integer id) {
		log.debug("getting MediaCatalog instance with id: " + id);
		try {
			MediaCatalog instance = (MediaCatalog) getHibernateTemplate().get(
					"dao.MediaCatalog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MediaCatalog instance) {
		log.debug("finding MediaCatalog instance by example");
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
		log.debug("finding MediaCatalog instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MediaCatalog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMediaCatalogName(Object mediaCatalogName) {
		return findByProperty(MEDIA_CATALOG_NAME, mediaCatalogName);
	}

	public List findByCatalogEnName(Object catalogEnName) {
		return findByProperty(CATALOG_EN_NAME, catalogEnName);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findAll() {
		log.debug("finding all MediaCatalog instances");
		try {
			String queryString = "from MediaCatalog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MediaCatalog merge(MediaCatalog detachedInstance) {
		log.debug("merging MediaCatalog instance");
		try {
			MediaCatalog result = (MediaCatalog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MediaCatalog instance) {
		log.debug("attaching dirty MediaCatalog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MediaCatalog instance) {
		log.debug("attaching clean MediaCatalog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MediaCatalogDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (MediaCatalogDAO) ctx.getBean("MediaCatalogDAO");
	}
}