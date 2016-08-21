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
			// ����û�ѡ����Ŀ¼�������б�
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append(",Catalog c ");
			}
			sqlbuffer.append("where 1=1 ");
			// ����û�ѡ����Ŀ¼�������б����Ŀ¼id�ļ�������
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append("and c.catalogId in (:X1) ");
				sqlbuffer.append("and c  in elements(mc.catalogs) ");
			}
			// ��ĿID����ʼ��
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				sqlbuffer.append(" and md.mediaId>=:X2");
			}
			// ��ĿID��������
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				sqlbuffer.append(" and md.mediaId<=:X3");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				sqlbuffer.append(" and md.mediaName like :X4");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getDirector())) {
				sqlbuffer.append(" and md.director like :X5");
			}
			// ��Ա
			if (!CommonUtil.isEmpty(form.getActor())) {
				sqlbuffer.append(" and md.actor like :X6");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				sqlbuffer.append(" and l.languageId=:X7");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				sqlbuffer.append(" and a.areaId=:X8");
			}
			// �������ʼ��
			if (!CommonUtil.isEmpty(form.getYear1())) {
				sqlbuffer.append(" and md.year>=:X9");
			}
			// �����������
			if (!CommonUtil.isEmpty(form.getYear2())) {
				sqlbuffer.append(" and md.year<=:X10");
			}
			// ����(��ʼ)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				sqlbuffer.append(" and md.grade>=:X11");
			}
			// ����(����)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				sqlbuffer.append(" and md.grade<=:X12");
			}
			// ���״̬
			if (!CommonUtil.isEmpty(form.getCheckType())) {
				sqlbuffer.append(" and md.checkType=:X13");
			}
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			// ����û�ѡ����Ŀ¼�������б����Ŀ¼id�ļ�������
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				queryObject.setParameterList("X1", form.getMediaCatalogId());
			}
			// ��ĿID����ʼ��
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				queryObject.setParameter("X2", form.getMediaId1());
			}
			// ��ĿID��������
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				queryObject.setParameter("X3", form.getMediaId2());
			}
			// ����
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				queryObject.setParameter("X4", "%" + form.getMediaName() + "%");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getDirector())) {
				queryObject.setParameter("X5", "%" + form.getDirector() + "%");
			}
			// ��Ա
			if (!CommonUtil.isEmpty(form.getActor())) {
				queryObject.setParameter("X6", "%" + form.getActor() + "%");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				queryObject.setParameter("X7", form.getLanguageId());
			}
			// ����
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				queryObject.setParameter("X8", form.getAreaId());
			}
			// �������ʼ��
			if (!CommonUtil.isEmpty(form.getYear1())) {
				queryObject.setParameter("X9", form.getYear1());
			}
			// �����������
			if (!CommonUtil.isEmpty(form.getYear2())) {
				queryObject.setParameter("X10", form.getYear2());
			}
			// ����(��ʼ)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				queryObject.setParameter("X11", form.getGrade1());
			}
			// ����(����)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				queryObject.setParameter("X12", form.getGrade2());
			}
			// ���״̬
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
			// ����û�ѡ����Ŀ¼�������б�
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append(",Catalog c ");
			}
			sqlbuffer.append("where 1=1 ");
			// ����û�ѡ����Ŀ¼�������б����Ŀ¼id�ļ�������
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				sqlbuffer.append("and c.catalogId in (:X1) ");
				sqlbuffer.append("and c  in elements(mc.catalogs) ");
			}
			// ��ĿID����ʼ��
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				sqlbuffer.append(" and md.mediaId>=:X2");
			}
			// ��ĿID��������
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				sqlbuffer.append(" and md.mediaId<=:X3");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				sqlbuffer.append(" and md.mediaName like :X4");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getDirector())) {
				sqlbuffer.append(" and md.director like :X5");
			}
			// ��Ա
			if (!CommonUtil.isEmpty(form.getActor())) {
				sqlbuffer.append(" and md.actor like :X6");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				sqlbuffer.append(" and l.languageId=:X7");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				sqlbuffer.append(" and a.areaId=:X8");
			}
			// �������ʼ��
			if (!CommonUtil.isEmpty(form.getYear1())) {
				sqlbuffer.append(" and md.year>=:X9");
			}
			// �����������
			if (!CommonUtil.isEmpty(form.getYear2())) {
				sqlbuffer.append(" and md.year<=:X10");
			}
			// ����(��ʼ)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				sqlbuffer.append(" and md.grade>=:X11");
			}
			// ����(����)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				sqlbuffer.append(" and md.grade<=:X12");
			}
			// ���״̬
			if (!CommonUtil.isEmpty(form.getCheckType())) {
				sqlbuffer.append(" and md.checkType=:X13");
			}
			sqlbuffer.append(" order by  md.mediaId");
			String sqlstring = sqlbuffer.toString();
			Query queryObject = getSession().createQuery(sqlstring);
			// ����û�ѡ����Ŀ¼�������б����Ŀ¼id�ļ�������
			if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
				queryObject.setParameterList("X1", form.getMediaCatalogId());
			}
			// ��ĿID����ʼ��
			if (!CommonUtil.isEmpty(form.getMediaId1())) {
				queryObject.setParameter("X2", form.getMediaId1());
			}
			// ��ĿID��������
			if (!CommonUtil.isEmpty(form.getMediaId2())) {
				queryObject.setParameter("X3", form.getMediaId2());
			}
			// ����
			if (!CommonUtil.isEmpty(form.getMediaName())) {
				queryObject.setParameter("X4", "%" + form.getMediaName() + "%");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getDirector())) {
				queryObject.setParameter("X5", "%" + form.getDirector() + "%");
			}
			// ��Ա
			if (!CommonUtil.isEmpty(form.getActor())) {
				queryObject.setParameter("X6", "%" + form.getActor() + "%");
			}
			// ����
			if (!CommonUtil.isEmpty(form.getLanguageId())) {
				queryObject.setParameter("X7", form.getLanguageId());
			}
			// ����
			if (!CommonUtil.isEmpty(form.getAreaId())) {
				queryObject.setParameter("X8", form.getAreaId());
			}
			// �������ʼ��
			if (!CommonUtil.isEmpty(form.getYear1())) {
				queryObject.setParameter("X9", form.getYear1());
			}
			// �����������
			if (!CommonUtil.isEmpty(form.getYear2())) {
				queryObject.setParameter("X10", form.getYear2());
			}
			// ����(��ʼ)
			if (!CommonUtil.isEmpty(form.getGrade1())) {
				queryObject.setParameter("X11", form.getGrade1());
			}
			// ����(����)
			if (!CommonUtil.isEmpty(form.getGrade2())) {
				queryObject.setParameter("X12", form.getGrade2());
			}
			// ���״̬
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
			// ��Ŀ��Чʱ��
			if (!CommonUtil.isEmpty(form.getEndDate())) {
				sqlbuffer.append(",endDate=?");
				paramList.add(form.getEndDate());
			}
			// ��Ŀ״̬
			if (!CommonUtil.isEmpty(type)) {
				sqlbuffer.append(",checkType=?");
				paramList.add(type);
			}
			// ��Ŀ���ͨ��ʱ��
			if (!CommonUtil.isEmpty(checkDate)) {
				sqlbuffer.append(",checkDate=?");
				paramList.add(checkDate);
			}
			// ��Ŀ��������
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
			// ������
			sqlbuffer.append("checkType='3'");
			// �Ѿ�ʧЧ�Ľ�Ŀ
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