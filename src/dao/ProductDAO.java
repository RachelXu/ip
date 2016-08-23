package dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import dao.model.Product;
import form.ProductForm;
import util.Contants;


@Transactional
public class ProductDAO extends BaseDAO<Product> {
	private static final Log log = LogFactory.getLog(ProductDAO.class);

	public int getCount(ProductForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("select count(*) from ProductSet where 1=1");
//			if (!CommonUtil.isEmpty(form.getName())) {
//				sqlbuffer.append("and accountId=?");
//				paramList.add(form.getName());
//			}
//			if (!CommonUtil.isEmpty(form.getState())) {
//				sqlbuffer.append("and state=?");
//				paramList.add(form.getState());
//			}
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
	
	public List<Product> getProducts(ProductForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("from Product where 1=1");
//			// �û�ID
//			if (!CommonUtil.isEmpty(form.getName())) {
//				sqlbuffer.append("and accountId=?");
//				paramList.add(form.getName());
//			}
//			// �û�����
//			if (!CommonUtil.isEmpty(form.getState())) {
//				sqlbuffer.append("and state=?");
//				paramList.add(form.getState());
//			}
			sqlbuffer.append("order by productID");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			queryObject.setFirstResult((form.getCurrentPage() - 1)
					* Contants.PAGE_SIZE);
			queryObject.setMaxResults(Contants.PAGE_SIZE);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("failed to getProduct.");
			throw re;
		}
	}

}