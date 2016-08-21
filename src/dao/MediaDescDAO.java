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
 * MediaDesc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.MediaDesc
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MediaDescDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MediaDescDAO.class);
	// property constants
	public static final String MEDIA_NAME = "mediaName";
	public static final String YEAR = "year";
	public static final String DIRECTOR = "director";
	public static final String ACTOR = "actor";
	public static final String INTRODUCTION = "introduction";
	public static final String GRADE = "grade";
	public static final String PIC = "pic";
	public static final String CHECK_TYPE = "checkType";
	public static final String CHECK_DATE = "checkDate";
	public static final String END_DATE = "endDate";
	public static final String VIP_STATE = "vipState";

	protected void initDao() {
		// do nothing
	}

	public void save(MediaDesc transientInstance) {
		log.debug("saving MediaDesc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MediaDesc persistentInstance) {
		log.debug("deleting MediaDesc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MediaDesc findById(java.lang.Integer id) {
		log.debug("getting MediaDesc instance with id: " + id);
		try {
			MediaDesc instance = (MediaDesc) getHibernateTemplate().get(
					"dao.MediaDesc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MediaDesc instance) {
		log.debug("finding MediaDesc instance by example");
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
		log.debug("finding MediaDesc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MediaDesc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMediaName(Object mediaName) {
		return findByProperty(MEDIA_NAME, mediaName);
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByDirector(Object director) {
		return findByProperty(DIRECTOR, director);
	}

	public List findByActor(Object actor) {
		return findByProperty(ACTOR, actor);
	}

	public List findByIntroduction(Object introduction) {
		return findByProperty(INTRODUCTION, introduction);
	}

	public List findByGrade(Object grade) {
		return findByProperty(GRADE, grade);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findByCheckType(Object checkType) {
		return findByProperty(CHECK_TYPE, checkType);
	}

	public List findByCheckDate(Object checkDate) {
		return findByProperty(CHECK_DATE, checkDate);
	}

	public List findByEndDate(Object endDate) {
		return findByProperty(END_DATE, endDate);
	}

	public List findByVipState(Object vipState) {
		return findByProperty(VIP_STATE, vipState);
	}

	public List findAll() {
		log.debug("finding all MediaDesc instances");
		try {
			String queryString = "from MediaDesc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MediaDesc merge(MediaDesc detachedInstance) {
		log.debug("merging MediaDesc instance");
		try {
			MediaDesc result = (MediaDesc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MediaDesc instance) {
		log.debug("attaching dirty MediaDesc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MediaDesc instance) {
		log.debug("attaching clean MediaDesc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MediaDescDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MediaDescDAO) ctx.getBean("MediaDescDAO");
	}
}