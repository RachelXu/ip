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
			// �û�����
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append(",type=?");
				paramList.add(form.getType());
			}
			// �û�״̬
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append(",state=?");
				paramList.add(form.getState());
			}
			// ʣ������
			if (!CommonUtil.isEmpty(form.getRestDay())) {
				sqlbuffer.append(",restDay=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay()));
			}
			// �û���������
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
			// �û�ID����ʼ��
			if (!CommonUtil.isEmpty(form.getId1())) {
				sqlbuffer.append("and id>=?");
				paramList.add(form.getId1());
			}
			// �û�ID��������
			if (!CommonUtil.isEmpty(form.getId2())) {
				sqlbuffer.append("and id<=?");
				paramList.add(form.getId2());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// �û�״̬
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// ʣ������(��ʼ)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// ʣ������(����)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// �û���������(��ʼ)
			if (!CommonUtil.isEmpty(form.getGroup1())) {
				sqlbuffer.append("and pici>=?");
				paramList.add(form.getGroup1());
			}
			// �û���������(����)
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
			// �û�ID����ʼ��
			if (!CommonUtil.isEmpty(form.getId1())) {
				sqlbuffer.append("and id>=?");
				paramList.add(form.getId1());
			}
			// �û�ID��������
			if (!CommonUtil.isEmpty(form.getId2())) {
				sqlbuffer.append("and id<=?");
				paramList.add(form.getId2());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// �û�״̬
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// ʣ������(��ʼ)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// ʣ������(����)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// �û���������(��ʼ)
			if (!CommonUtil.isEmpty(form.getGroup1())) {
				sqlbuffer.append("and pici>=?");
				paramList.add(form.getGroup1());
			}
			// �û���������(����)
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
			// �û�ID
			if (!CommonUtil.isEmpty(form.getId())) {
				sqlbuffer.append("and id=?");
				paramList.add(form.getId());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getName())) {
				sqlbuffer.append("and name like ?");
				paramList.add("%" + form.getName() + "%");
			}
			// �û��绰
			if (!CommonUtil.isEmpty(form.getPhone())) {
				sqlbuffer.append("and phone=?");
				paramList.add(form.getPhone());
			}
			// �û�סַ
			if (!CommonUtil.isEmpty(form.getAddress())) {
				sqlbuffer.append("and address like ?");
				paramList.add("%" + form.getAddress() + "%");
			}
			// �û�״̬
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// ʣ������(��ʼ)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// ʣ������(����)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// �û���������
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
			// �û�ID
			if (!CommonUtil.isEmpty(form.getId())) {
				sqlbuffer.append("and id=?");
				paramList.add(form.getId());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getType())) {
				sqlbuffer.append("and type=?");
				paramList.add(form.getType());
			}
			// �û�����
			if (!CommonUtil.isEmpty(form.getName())) {
				sqlbuffer.append("and name like ?");
				paramList.add("%" + form.getName() + "%");
			}
			// �û��绰
			if (!CommonUtil.isEmpty(form.getPhone())) {
				sqlbuffer.append("and phone=?");
				paramList.add(form.getPhone());
			}
			// �û�סַ
			if (!CommonUtil.isEmpty(form.getAddress())) {
				sqlbuffer.append("and address like ?");
				paramList.add("%" + form.getAddress() + "%");
			}
			// �û�״̬
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and state=?");
				paramList.add(form.getState());
			}
			// ʣ������(��ʼ)
			if (!CommonUtil.isEmpty(form.getRestDay1())) {
				sqlbuffer.append("and restDay>=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay1()));
			}
			// ʣ������(����)
			if (!CommonUtil.isEmpty(form.getRestDay2())) {
				sqlbuffer.append("and restDay<=?");
				paramList.add(CommonUtil.formatStringToInteger(form
						.getRestDay2()));
			}
			// �û���������
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
			// ʣ������
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
			// ʣ������
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
