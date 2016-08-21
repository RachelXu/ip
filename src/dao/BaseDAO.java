package dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 */
public class BaseDAO<T> extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(BaseDAO.class);

	public void saveOrUpdate(Object transientInstance) {
		log.debug("saveOrUpdate instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Object findById(Class<T> cls, Serializable id)
    {
		log.debug("getting instance with id: " + id + " for class:" + cls.getName());
        Object obj = getHibernateTemplate().get(cls, id);
        return obj;
    }
	

	public List findAll(Class<T> cls)
    {
        return getHibernateTemplate().loadAll(cls);
    }
}