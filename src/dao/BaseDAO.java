package dao;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 */
public class BaseDAO<T> {
	private static final Log log = LogFactory.getLog(BaseDAO.class);

	SessionFactory sessionFactory;
	
	public void saveOrUpdate(Object transientInstance) {
		log.debug("saveOrUpdate instance");
		Session session = getSession();
		try {
			session.saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Object transientInstance) {
		log.debug("update instance");
		Session session = getSession();
		try {
			session.update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(Object persistentInstance) {
		log.debug("deleting instance");
		Session session = getSession();
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Object findById(Class<T> cls, Serializable id)
    {
		log.debug("getting instance with id: " + id + " for class:" + cls.getName());
		Session session = getSession();
		Object obj = session.get(cls, id);
        return obj;
    }

	public Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}
	
	protected Session getSession() {
    	return sessionFactory.getCurrentSession();
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}