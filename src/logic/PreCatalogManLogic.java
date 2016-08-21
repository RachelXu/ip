/**
 * IPTV播控平台
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
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreCatalogManLogic {

	private CatalogDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(CatalogForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);

		List<Catalog> catalogList = dao.selectAll();
		List<Catalog> firstLeveList = new ArrayList<Catalog>();
		if (catalogList == null || catalogList.size() == 0) {
			form.setResultFlag(false);
			return dto;
		} else {
			form.setResultFlag(true);
		}
		// 取第一级目录
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
		// 取第二级目录
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
		// 获取详细信息显示列表
		SortedSet<Catalog> set0 = new TreeSet<Catalog>();
		set0.addAll(firstLeveList);
		makeTree(set0, form, 0);
		return dto;
	}

	private void makeTree(SortedSet<Catalog> set, CatalogForm form, int level) {
		if (!set.isEmpty()) {
			for (Catalog catalog : set) {
				form.getResultList()
						.add(
								CommonUtil.catalogConvertToCatalogDetil(
										catalog, level));
				SortedSet<Catalog> set1 = new TreeSet<Catalog>();
				set1.addAll(catalog.getCatalogs());
				makeTree(set1, form, level + 1);
			}
		}
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
