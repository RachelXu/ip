/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import util.CommonUtil;
import dao.Catalog;
import dao.CatalogDAOplus;
import form.CatalogForm;
import form.LabelValueIntBean;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCatalogManLogic {

	private CatalogDAOplus dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(CatalogForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Catalog insertCatalog = new Catalog();
		insertCatalog.setCatalogZhName(form.getCatalogZhName());
		insertCatalog.setCatalogEnName(form.getCatalogEnName());
		insertCatalog.setOrder1(form.getOrder());
		if (!CommonUtil.isEmpty(form.getSuperId())) {
			Catalog parentCatalog = dao.findById(form.getSuperId());
			insertCatalog.setCatalog(parentCatalog);
		}
		dao.save(insertCatalog);
		List<Catalog> catalogList = dao.selectAll();
		List<Catalog> firstLeveList = new ArrayList<Catalog>();
		if (catalogList == null || catalogList.size() == 0) {
			form.setResultFlag(false);
			return dto;
		} else {
			form.setResultFlag(true);
		}
		// ȡ��һ��Ŀ¼
		LabelValueIntBean first = null;
		for (Catalog catalog : catalogList) {
			if (catalog.getCatalog() == null) {
				first = new LabelValueIntBean(catalog.getCatalogZhName(),
						catalog.getCatalogId());
				form.getFirstLeveList().add(first);
				form.getSecondLabel().add(catalog.getCatalogZhName());
				firstLeveList.add(catalog);
			}
		}
		// ȡ�ڶ���Ŀ¼
		List<LabelValueIntBean> sencondLeveListElement = null;
		for (Catalog catalog1 : firstLeveList) {
			sencondLeveListElement = new ArrayList<LabelValueIntBean>();
			LabelValueIntBean sencond = null;
			for (Catalog catalog2 : catalog1.getCatalogs()) {
				sencond = new LabelValueIntBean(catalog2.getCatalogZhName(),
						catalog2.getCatalogId());
				sencondLeveListElement.add(sencond);
			}
			form.getSencondLeveList().add(sencondLeveListElement);
		}
		// ��ȡ��ϸ��Ϣ��ʾ�б�
		for (Catalog catalog : firstLeveList) {
			form.getResultList().add(
					CommonUtil.catalogConvertToCatalogDetil(catalog, 0));
			SortedSet<Catalog> set1 = new TreeSet<Catalog>();
			set1.addAll(catalog.getCatalogs());
			for (Catalog catalog1 : set1) {
				form.getResultList().add(
						CommonUtil.catalogConvertToCatalogDetil(catalog1, 1));
				SortedSet<Catalog> set2 = new TreeSet<Catalog>();
				set2.addAll(catalog1.getCatalogs());
				for (Catalog catalog2 : set2) {
					form.getResultList().add(
							CommonUtil
									.catalogConvertToCatalogDetil(catalog2, 2));
				}
			}
		}
		return dto;
	}

	/**
	 * @return the dao
	 */
	public CatalogDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(CatalogDAOplus dao) {
		this.dao = dao;
	}
}
