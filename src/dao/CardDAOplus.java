package dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import util.CommonUtil;
import util.Contants;
import form.CardForm;

/**
 * @author Administrator
 * 
 */
@Transactional
public class CardDAOplus extends CardDAO {

	/**
	 * @param form
	 * @param id
	 * @return
	 */
	public int batchEditUpdate(CardForm form, Integer id) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("update Card set id=id");
			// 状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append(",state=?");
				paramList.add(form.getState());
			}
			// 充值时长
			if (!CommonUtil.isEmpty(form.getDay())) {
				sqlbuffer.append(",day=?");
				paramList.add(form.getDay());
			}
			// 截止时间
			if (!CommonUtil.isEmpty(form.getEnddate())) {
				sqlbuffer.append(",enddate=?");
				paramList.add(form.getEnddate());
			}
			// 充值时间
			if (!CommonUtil.isEmpty(form.getChargedate())) {
				sqlbuffer.append(",chargedate=?");
				paramList.add(form.getChargedate());
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

	/**
	 * @param form
	 * @return
	 */
	public List<Card> batchEditSearch(CardForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer
					.append("select c from Card as c left join c.user as u where 1=1");
			// 用户ID（开始）
			if (!CommonUtil.isEmpty(form.getId1())) {
				sqlbuffer.append("and c.id>=?");
				paramList.add(form.getId1());
			}
			// 用户ID(结束)
			if (!CommonUtil.isEmpty(form.getId2())) {
				sqlbuffer.append("and c.id<=?");
				paramList.add(form.getId2());
			}
			// 用户名称
			if (!CommonUtil.isEmpty(form.getUserName())) {
				sqlbuffer.append("and u.name like ?");
				paramList.add("%" + form.getUserName() + "%");
			}
			// 充值卡状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and c.state=?");
				paramList.add(form.getState());
			}
			// 充值时长(开始)
			if (!CommonUtil.isEmpty(form.getDay1())) {
				sqlbuffer.append("and c.day>=?");
				paramList.add(form.getDay1());
			}
			// 充值时长(结束)
			if (!CommonUtil.isEmpty(form.getDay2())) {
				sqlbuffer.append("and c.day<=?");
				paramList.add(form.getDay2());
			}
			// 截止时间(开始)
			if (!CommonUtil.isEmpty(form.getEnddate1())) {
				sqlbuffer.append("and c.enddate>=?");
				paramList.add(form.getEnddate1());
			}
			// 截止时间(结束)
			if (!CommonUtil.isEmpty(form.getEnddate2())) {
				sqlbuffer.append("and c.enddate<=?");
				paramList.add(form.getEnddate2());
			}
			// 充值时间开始)
			if (!CommonUtil.isEmpty(form.getChargedate1())) {
				sqlbuffer.append("and c.chargedate>=?");
				paramList.add(form.getChargedate1());
			}
			// 充值时间(结束)
			if (!CommonUtil.isEmpty(form.getChargedate2())) {
				sqlbuffer.append("and c.chargedate<=?");
				paramList.add(form.getChargedate2());
			}
			// 批次
			if (!CommonUtil.isEmpty(form.getBatchNum())) {
				sqlbuffer.append("and c.batchNo=?");
				paramList.add(form.getBatchNum());
			}
			sqlbuffer.append("order by c.id");
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

	public Integer batchEditCount(CardForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer
					.append("select count(*) from Card as c left join c.user as u where 1=1");
			// 用户ID（开始）
			if (!CommonUtil.isEmpty(form.getId1())) {
				sqlbuffer.append("and c.id>=?");
				paramList.add(form.getId1());
			}
			// 用户ID(结束)
			if (!CommonUtil.isEmpty(form.getId2())) {
				sqlbuffer.append("and c.id<=?");
				paramList.add(form.getId2());
			}
			// 用户名称
			if (!CommonUtil.isEmpty(form.getUserName())) {
				sqlbuffer.append("and u.name like ?");
				paramList.add("%" + form.getUserName() + "%");
			}
			// 充值卡状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and c.state=?");
				paramList.add(form.getState());
			}
			// 充值时长(开始)
			if (!CommonUtil.isEmpty(form.getDay1())) {
				sqlbuffer.append("and c.day>=?");
				paramList.add(form.getDay1());
			}
			// 充值时长(结束)
			if (!CommonUtil.isEmpty(form.getDay2())) {
				sqlbuffer.append("and c.day<=?");
				paramList.add(form.getDay2());
			}
			// 截止时间(开始)
			if (!CommonUtil.isEmpty(form.getEnddate1())) {
				sqlbuffer.append("and c.enddate>=?");
				paramList.add(form.getEnddate1());
			}
			// 截止时间(结束)
			if (!CommonUtil.isEmpty(form.getEnddate2())) {
				sqlbuffer.append("and c.enddate<=?");
				paramList.add(form.getEnddate2());
			}
			// 充值时间开始)
			if (!CommonUtil.isEmpty(form.getChargedate1())) {
				sqlbuffer.append("and c.chargedate>=?");
				paramList.add(form.getChargedate1());
			}
			// 充值时间(结束)
			if (!CommonUtil.isEmpty(form.getChargedate2())) {
				sqlbuffer.append("and c.chargedate<=?");
				paramList.add(form.getChargedate2());
			}
			// 批次
			if (!CommonUtil.isEmpty(form.getBatchNum())) {
				sqlbuffer.append("and c.batchNo=?");
				paramList.add(form.getBatchNum());
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

	public void update(Card transientInstance) {
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Integer count(CardForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer
					.append("select count(*) from Card as c left join c.user as u where 1=1");
			// 用户ID
			if (!CommonUtil.isEmpty(form.getId())) {
				sqlbuffer.append("and c.id=?");
				paramList.add(form.getId());
			}
			// 用户名称
			if (!CommonUtil.isEmpty(form.getUserName())) {
				sqlbuffer.append("and u.name like ?");
				paramList.add("%" + form.getUserName() + "%");
			}
			// 充值卡状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and c.state=?");
				paramList.add(form.getState());
			}
			// 充值时长(开始)
			if (!CommonUtil.isEmpty(form.getDay1())) {
				sqlbuffer.append("and c.day>=?");
				paramList.add(form.getDay1());
			}
			// 充值时长(结束)
			if (!CommonUtil.isEmpty(form.getDay2())) {
				sqlbuffer.append("and c.day<=?");
				paramList.add(form.getDay2());
			}
			// 截止时间(开始)
			if (!CommonUtil.isEmpty(form.getEnddate1())) {
				sqlbuffer.append("and c.enddate>=?");
				paramList.add(form.getEnddate1());
			}
			// 截止时间(结束)
			if (!CommonUtil.isEmpty(form.getEnddate2())) {
				sqlbuffer.append("and c.enddate<=?");
				paramList.add(form.getEnddate2());
			}
			// 充值时间开始)
			if (!CommonUtil.isEmpty(form.getChargedate1())) {
				sqlbuffer.append("and c.chargedate>=?");
				paramList.add(form.getChargedate1());
			}
			// 充值时间(结束)
			if (!CommonUtil.isEmpty(form.getChargedate2())) {
				sqlbuffer.append("and c.chargedate<=?");
				paramList.add(form.getChargedate2());
			}
			// 批次
			if (!CommonUtil.isEmpty(form.getBatchNum())) {
				sqlbuffer.append("and c.batchNo=?");
				paramList.add(form.getBatchNum());
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

	public List<Card> search(CardForm form) {

		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer
					.append("select c from Card as c left join c.user as u where 1=1");
			// 用户ID
			if (!CommonUtil.isEmpty(form.getId())) {
				sqlbuffer.append("and c.id=?");
				paramList.add(form.getId());
			}
			// 用户名称
			if (!CommonUtil.isEmpty(form.getUserName())) {
				sqlbuffer.append("and u.name like ?");
				paramList.add("%" + form.getUserName() + "%");
			}
			// 充值卡状态
			if (!CommonUtil.isEmpty(form.getState())) {
				sqlbuffer.append("and c.state=?");
				paramList.add(form.getState());
			}
			// 充值时长(开始)
			if (!CommonUtil.isEmpty(form.getDay1())) {
				sqlbuffer.append("and c.day>=?");
				paramList.add(form.getDay1());
			}
			// 充值时长(结束)
			if (!CommonUtil.isEmpty(form.getDay2())) {
				sqlbuffer.append("and c.day<=?");
				paramList.add(form.getDay2());
			}
			// 截止时间(开始)
			if (!CommonUtil.isEmpty(form.getEnddate1())) {
				sqlbuffer.append("and c.enddate>=?");
				paramList.add(form.getEnddate1());
			}
			// 截止时间(结束)
			if (!CommonUtil.isEmpty(form.getEnddate2())) {
				sqlbuffer.append("and c.enddate<=?");
				paramList.add(form.getEnddate2());
			}
			// 充值时间开始)
			if (!CommonUtil.isEmpty(form.getChargedate1())) {
				sqlbuffer.append("and c.chargedate>=?");
				paramList.add(form.getChargedate1());
			}
			// 充值时间(结束)
			if (!CommonUtil.isEmpty(form.getChargedate2())) {
				sqlbuffer.append("and c.chargedate<=?");
				paramList.add(form.getChargedate2());
			}
			// 批次
			if (!CommonUtil.isEmpty(form.getBatchNum())) {
				sqlbuffer.append("and c.batchNo=?");
				paramList.add(form.getBatchNum());
			}
			sqlbuffer.append("order by c.id");
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

	public void cardInvalidBatch() {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("update Card set ");
			// 剩余天数
			sqlbuffer.append(" state=3");
			sqlbuffer.append(" where endDate<?");
			paramList.add(CommonUtil.formatDateToCharYYYYMMDD(new Date()));
			sqlbuffer.append(" and state=1");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}

	public Integer getMaxBatch() {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			sqlbuffer.append("select max(batchNo) from Card ");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			return (Integer) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
