package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import util.CommonUtil;
import util.Contants;
import form.UserForm;

@Transactional
public class UserDAOplus extends UserDAO {

	public int batchEditUpdate(UserForm form, Integer id) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("update User set age=age");
			// 用户类型
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append(",type=?");
				paramList.add(form.getType());
			}
			// 用户状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append(",state=?");
				paramList.add(form.getState());
			}
			// 剩余天数
			if (!CommonUtil.isEmpty(form.getRestDay())) {
				sqlbuffer.append(",restDay=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay()));
			}
			// 用户所属批次
			if (!CommonUtil.isEmpty(form.getGroup())) {
				sqlbuffer.append(",pici=?");
				paramList.add(form.getGroup());
			}
			sqlbuffer.append(" where id=?");
			paramList.add(id);
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			return queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<User> batchEditSearch(UserForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("from User where 1=1");
			// 用户ID（开始）
			if (!CommonUtil.isEmpty(form.getId1())) {
				sqlbuffer.append("and id>=?");
				paramList.add(form.getId1());
			}
			// 用户ID（结束）
			if (!CommonUtil.isEmpty(form.getId2())) {
				sqlbuffer.append("and id<=?");
				paramList.add(form.getId2());
			}
			// 用户类型
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// 用户状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// 剩余天数(开始)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// 剩余天数(结束)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// 用户所属批次(开始)
			if (!CommonUtil.isEmpty(form.getGroup1())) {
				sqlbuffer.append("and pici>=?");
				paramList.add(form.getGroup1());
			}
			// 用户所属批次(结束)
			if (!CommonUtil.isEmpty(form.getGroup2())) {
				sqlbuffer.append("and pici<=?");
				paramList.add(form.getGroup2());
			}
			sqlbuffer.append("order by id");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Integer batchEditCount(UserForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("select count(*) from User where 1=1");
			// 用户ID（开始）
			if (!CommonUtil.isEmpty(form.getId1())) {
				sqlbuffer.append("and id>=?");
				paramList.add(form.getId1());
			}
			// 用户ID（结束）
			if (!CommonUtil.isEmpty(form.getId2())) {
				sqlbuffer.append("and id<=?");
				paramList.add(form.getId2());
			}
			// 用户类型
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// 用户状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// 剩余天数(开始)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// 剩余天数(结束)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// 用户所属批次(开始)
			if (!CommonUtil.isEmpty(form.getGroup1())) {
				sqlbuffer.append("and pici>=?");
				paramList.add(form.getGroup1());
			}
			// 用户所属批次(结束)
			if (!CommonUtil.isEmpty(form.getGroup2())) {
				sqlbuffer.append("and pici<=?");
				paramList.add(form.getGroup2());
			}
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			return (Integer) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(User transientInstance) {
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Integer count(UserForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("select count(*) from User where 1=1");
			// 用户ID
			if (!CommonUtil.isEmpty(form.getId())) {
				sqlbuffer.append("and id=?");
				paramList.add(form.getId());
			}
			// 用户类型
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// 用户名称
			if (!CommonUtil.isEmpty(form.getName())) {
				sqlbuffer.append("and name like ?");
				paramList.add("%" + form.getName() + "%");
			}
			// 用户电话
			if (!CommonUtil.isEmpty(form.getPhone())) {
				sqlbuffer.append("and phone=?");
				paramList.add(form.getPhone());
			}
			// 用户住址
			if (!CommonUtil.isEmpty(form.getAddress())) {
				sqlbuffer.append("and address like ?");
				paramList.add("%" + form.getAddress() + "%");
			}
			// 用户状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// 剩余天数(开始)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// 剩余天数(结束)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// 用户所属批次
			if (!CommonUtil.isEmpty(form.getGroup())) {
				sqlbuffer.append("and pici=?");
				paramList.add(form.getGroup());
			}
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			return (Integer) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<User> search(UserForm form) {

		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("from User where 1=1");
			// 用户ID
			if (!CommonUtil.isEmpty(form.getId())) {
				sqlbuffer.append("and id=?");
				paramList.add(form.getId());
			}
			// 用户类型
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// 用户名称
			if (!CommonUtil.isEmpty(form.getName())) {
				sqlbuffer.append("and name like ?");
				paramList.add("%" + form.getName() + "%");
			}
			// 用户电话
			if (!CommonUtil.isEmpty(form.getPhone())) {
				sqlbuffer.append("and phone=?");
				paramList.add(form.getPhone());
			}
			// 用户住址
			if (!CommonUtil.isEmpty(form.getAddress())) {
				sqlbuffer.append("and address like ?");
				paramList.add("%" + form.getAddress() + "%");
			}
			// 用户状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// 剩余天数(开始)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// 剩余天数(结束)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// 用户所属批次
			if (!CommonUtil.isEmpty(form.getGroup())) {
				sqlbuffer.append("and pici=?");
				paramList.add(form.getGroup());
			}
			sqlbuffer.append("order by id");
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
			throw re;
		}
	}

	public void userChargingBatch() {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			sqlbuffer.append("update User set ");
			// 剩余天数
			sqlbuffer.append(" restDay=restDay-1");
			sqlbuffer.append(" where state=1");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}

	public void userStopBatch() {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			sqlbuffer.append("update User set ");
			// 剩余天数
			sqlbuffer.append(" state=2");
			sqlbuffer.append(" where restDay<=0");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}
}
