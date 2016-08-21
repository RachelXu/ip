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
 * Language entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Language
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class LanguageDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(LanguageDAO.class);
	// property constants
	public static final String LANGUAGE_NAME = "languageName";

	protected void initDao() {
		// do nothing
	}

	public void save(Language transientInstance) {
		log.debug("saving Language instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Language persistentInstance) {
		log.debug("deleting Language instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Language findById(java.lang.Integer id) {
		log.debug("getting Language instance with id: " + id);
		try {
			Language instance = (Language) getHibernateTemplate().get(
					"dao.Language", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Language instance) {
		log.debug("finding Language instance by example");
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
		log.debug("finding Language instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Language as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLanguageName(Object languageName) {
		return findByProperty(LANGUAGE_NAME, languageName);
	}

	public List findAll() {
		log.debug("finding all Language instances");
		try {
			String queryString = "from Language";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Language merge(Language detachedInstance) {
		log.debug("merging Language instance");
		try {
			Language result = (Language) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Language instance) {
		log.debug("attaching dirty Language instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Language instance) {
		log.debug("attaching clean Language instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LanguageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LanguageDAO) ctx.getBean("LanguageDAO");
	}
}