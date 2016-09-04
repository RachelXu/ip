package dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import dao.model.ProductSet;
import form.ProductForm;
import util.CommonUtil;
import util.Contants;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see dao.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ProductSetDAO extends BaseDAO<ProductSet> {
	private static final Log log = LogFactory.getLog(ProductSetDAO.class);


	public int getCount(ProductForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("select count(*) from ProductSet where 1=1");
			if (!CommonUtil.isEmpty(form.getProduct().getProductId())) {
				sqlbuffer.append("and productId=?");
				paramList.add(form.getProduct().getProductId());
			}
			if (!CommonUtil.isEmpty(form.getProduct().getProductName())) {
				sqlbuffer.append("and productName=?");
				paramList.add(form.getProduct().getProductName());
			}
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			return (Integer) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("failed to getCount.");
			throw re;
		}
	}
	
	public List<ProductSet> getList(String productId, String productName, int pageNumber) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("from ProductSet where 1=1");
			if (!CommonUtil.isEmpty(productId)) {
				sqlbuffer.append("and productId=?");
				paramList.add(productId);
			}
			if (!CommonUtil.isEmpty(productName)) {
				sqlbuffer.append("and productName=?");
				paramList.add(productName);
			}
			sqlbuffer.append("order by productId");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			if (pageNumber > 0) {
				//get one page
				queryObject.setFirstResult((pageNumber - 1)
						* Contants.PAGE_SIZE);
				queryObject.setMaxResults(Contants.PAGE_SIZE);
			}
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("failed to getAccount.");
			throw re;
		}
	}
	
	public void create(ProductForm form) {
		ProductSet product = new ProductSet(form.getProduct().getProductId(), form.getProduct().getProductName());
		this.saveOrUpdate(product);
	}
	
	public void update(ProductForm form) {
		ProductSet product = new ProductSet(form.getProduct().getProductId(), form.getProduct().getProductName());
		this.update(product);
	}
}