package dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import util.CommonUtil;
import util.Contants;
import form.MediaForm;

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
public class MediaDescDAOplus extends MediaDescDAO {

	public void update(MediaDesc transientInstance) {
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Integer count(MediaForm form) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			sqlbuffer.append("select count(distinct md.mediaId) ");
			sqlbuffer.append("from MediaDesc md ");
			sqlbuffer.append("left join md.mediaCatalog mc ");
			sqlbuffer.append("left join md.area a ");
			sqlbuffer.append("left join md.language l ");
			// 如果用户选择了目录的下拉列表
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append(",Catalog c ");
			}
			sqlbuffer.append("where 1=1 ");
			// 如果用户选择了目录的下拉列表，添加目录id的检索条件
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append("and c.catalogId in (:X1) ");
				sqlbuffer.append("and c  in elements(mc.catalogs) ");
			}
			// 节目ID（开始）
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				sqlbuffer.append(" and md.mediaId>=:X2");
			}
			// 节目ID（结束）
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				sqlbuffer.append(" and md.mediaId<=:X3");
			}
			// 名称
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				sqlbuffer.append(" and md.mediaName like :X4");
			}
			// 导演
			if (!CommonUtil.isEmpty(form.getDirector())) {
				sqlbuffer.append(" and md.director like :X5");
			}
			// 演员
			if (!CommonUtil.isEmpty(form.getActor())) {
				sqlbuffer.append(" and md.actor like :X6");
			}
			// 语言
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				sqlbuffer.append(" and l.languageId=:X7");
			}
			// 地区
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				sqlbuffer.append(" and a.areaId=:X8");
			}
			// 年代（开始）
			if (!CommonUtil.isEmpty(form.getYear1())) {
				sqlbuffer.append(" and md.year>=:X9");
			}
			// 年代（结束）
			if (!CommonUtil.isEmpty(form.getYear2())) {
				sqlbuffer.append(" and md.year<=:X10");
			}
			// 评分(开始)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				sqlbuffer.append(" and md.grade>=:X11");
			}
			// 评分(结束)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				sqlbuffer.append(" and md.grade<=:X12");
			}
			// 审核状态
			if (!CommonUtil.isEmpty(form.getCheckType())) {
				sqlbuffer.append(" and md.checkType=:X13");
			}
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			// 如果用户选择了目录的下拉列表，添加目录id的检索条件
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				queryObject.setParameterList("X1", form.getMediaCatalogId());
			}
			// 节目ID（开始）
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				queryObject.setParameter("X2", form.getMediaId1());
			}
			// 节目ID（结束）
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				queryObject.setParameter("X3", form.getMediaId2());
			}
			// 名称
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				queryObject.setParameter("X4", "%" + form.getMediaName() + "%");
			}
			// 导演
			if (!CommonUtil.isEmpty(form.getDirector())) {
				queryObject.setParameter("X5", "%" + form.getDirector() + "%");
			}
			// 演员
			if (!CommonUtil.isEmpty(form.getActor())) {
				queryObject.setParameter("X6", "%" + form.getActor() + "%");
			}
			// 语言
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				queryObject.setParameter("X7", form.getLanguageId());
			}
			// 地区
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				queryObject.setParameter("X8", form.getAreaId());
			}
			// 年代（开始）
			if (!CommonUtil.isEmpty(form.getYear1())) {
				queryObject.setParameter("X9", form.getYear1());
			}
			// 年代（结束）
			if (!CommonUtil.isEmpty(form.getYear2())) {
				queryObject.setParameter("X10", form.getYear2());
			}
			// 评分(开始)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				queryObject.setParameter("X11", form.getGrade1());
			}
			// 评分(结束)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				queryObject.setParameter("X12", form.getGrade2());
			}
			// 审核状态
			if (!CommonUtil.isEmpty(form.getCheckType())) {
				queryObject.setParameter("X13", form.getCheckType());
			}
			return (Integer) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<MediaDesc> search(MediaForm form) {

		try {
			StringBuilder sqlbuffer = new StringBuilder();
			sqlbuffer.append("select distinct md ");
			sqlbuffer.append("from MediaDesc md ");
			sqlbuffer.append("left join md.mediaCatalog mc ");
			sqlbuffer.append("left join md.area a ");
			sqlbuffer.append("left join md.language l ");
			// 如果用户选择了目录的下拉列表
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append(",Catalog c ");
			}
			sqlbuffer.append("where 1=1 ");
			// 如果用户选择了目录的下拉列表，添加目录id的检索条件
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append("and c.catalogId in (:X1) ");
				sqlbuffer.append("and c  in elements(mc.catalogs) ");
			}
			// 节目ID（开始）
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				sqlbuffer.append(" and md.mediaId>=:X2");
			}
			// 节目ID（结束）
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				sqlbuffer.append(" and md.mediaId<=:X3");
			}
			// 名称
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				sqlbuffer.append(" and md.mediaName like :X4");
			}
			// 导演
			if (!CommonUtil.isEmpty(form.getDirector())) {
				sqlbuffer.append(" and md.director like :X5");
			}
			// 演员
			if (!CommonUtil.isEmpty(form.getActor())) {
				sqlbuffer.append(" and md.actor like :X6");
			}
			// 语言
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				sqlbuffer.append(" and l.languageId=:X7");
			}
			// 地区
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				sqlbuffer.append(" and a.areaId=:X8");
			}
			// 年代（开始）
			if (!CommonUtil.isEmpty(form.getYear1())) {
				sqlbuffer.append(" and md.year>=:X9");
			}
			// 年代（结束）
			if (!CommonUtil.isEmpty(form.getYear2())) {
				sqlbuffer.append(" and md.year<=:X10");
			}
			// 评分(开始)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				sqlbuffer.append(" and md.grade>=:X11");
			}
			// 评分(结束)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				sqlbuffer.append(" and md.grade<=:X12");
			}
			// 审核状态
			if (!CommonUtil.isEmpty(form.getCheckType())) {
				sqlbuffer.append(" and md.checkType=:X13");
			}
			sqlbuffer.append(" order by  md.mediaId");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			// 如果用户选择了目录的下拉列表，添加目录id的检索条件
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				queryObject.setParameterList("X1", form.getMediaCatalogId());
			}
			// 节目ID（开始）
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				queryObject.setParameter("X2", form.getMediaId1());
			}
			// 节目ID（结束）
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				queryObject.setParameter("X3", form.getMediaId2());
			}
			// 名称
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				queryObject.setParameter("X4", "%" + form.getMediaName() + "%");
			}
			// 导演
			if (!CommonUtil.isEmpty(form.getDirector())) {
				queryObject.setParameter("X5", "%" + form.getDirector() + "%");
			}
			// 演员
			if (!CommonUtil.isEmpty(form.getActor())) {
				queryObject.setParameter("X6", "%" + form.getActor() + "%");
			}
			// 语言
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				queryObject.setParameter("X7", form.getLanguageId());
			}
			// 地区
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				queryObject.setParameter("X8", form.getAreaId());
			}
			// 年代（开始）
			if (!CommonUtil.isEmpty(form.getYear1())) {
				queryObject.setParameter("X9", form.getYear1());
			}
			// 年代（结束）
			if (!CommonUtil.isEmpty(form.getYear2())) {
				queryObject.setParameter("X10", form.getYear2());
			}
			// 评分(开始)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				queryObject.setParameter("X11", form.getGrade1());
			}
			// 评分(结束)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				queryObject.setParameter("X12", form.getGrade2());
			}
			// 审核状态
			if (!CommonUtil.isEmpty(form.getCheckType())) {
				queryObject.setParameter("X13", form.getCheckType());
			}
			queryObject.setFirstResult((form.getCurrentPage() - 1)
					* Contants.PAGE_SIZE);
			queryObject.setMaxResults(Contants.PAGE_SIZE);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * @param form
	 * @param id
	 * @return
	 */
	public int approved(MediaForm form, Integer id, String type,
			String checkDate) {
		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("update MediaDesc set mediaId=mediaId");
			// 节目有效时间
			if (!CommonUtil.isEmpty(form.getEndDate())) {
				sqlbuffer.append(",endDate=?");
				paramList.add(form.getEndDate());
			}
			// 节目状态
			if (!CommonUtil.isEmpty(type)) {
				sqlbuffer.append(",checkType=?");
				paramList.add(type);
			}
			// 节目审核通过时间
			if (!CommonUtil.isEmpty(checkDate)) {
				sqlbuffer.append(",checkDate=?");
				paramList.add(checkDate);
			}
			// 节目服务类型
			if (!CommonUtil.isEmpty(form.getServiceType())) {
				sqlbuffer.append(",vipState=?");
				paramList.add(form.getServiceType());
			}

			sqlbuffer.append(" where mediaId=?");
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

	public void deleteNightBatch() {

		try {
			StringBuilder sqlbuffer = new StringBuilder();
			List<Object> paramList = new LinkedList<Object>();
			sqlbuffer.append("from MediaDesc ");
			sqlbuffer.append("where ");
			// 发布的
			sqlbuffer.append("checkType='3'");
			// 已经失效的节目
			sqlbuffer.append("and endDate<?");
			paramList.add(CommonUtil.formatDateToCharYYYYMMDD(new Date()));
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			for (int i = 0; i < paramList.size(); i++) {
				queryObject.setParameter(i, paramList.get(i));
			}
			List<MediaDesc> resultList = queryObject.list();
			for (MediaDesc entity : resultList) {
				this.delete(entity);
			}
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}
}