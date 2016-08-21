/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import util.CommonUtil;
import dao.Area;
import dao.AreaDAO;
import dao.Catalog;
import dao.CatalogDAOplus;
import dao.Language;
import dao.LanguageDAO;
import form.MediaForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class PreMediaSearchLogic {

	private CatalogDAOplus dao1;
	private LanguageDAO dao2;
	private AreaDAO dao3;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(MediaForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);

		List<Catalog> catalogList = dao1.selectAll();
		List<Catalog> firstLeveList = new ArrayList<Catalog>();
		// ȡ��һ��Ŀ¼
		for (Catalog catalog : catalogList) {
			if (catalog.getCatalog() == null) {
				firstLeveList.add(catalog);
			}
		}
		// ��ȡĿ¼�����б�
		for (Catalog catalog : firstLeveList) {
			form.getCatalogList().add(
					CommonUtil.catalogConvertToLabelValueBean(catalog, 0));
			SortedSet<Catalog> set1 = new TreeSet<Catalog>();
			set1.addAll(catalog.getCatalogs());
			for (Catalog catalog1 : set1) {
				form.getCatalogList().add(
						CommonUtil.catalogConvertToLabelValueBean(catalog1, 1));
				SortedSet<Catalog> set2 = new TreeSet<Catalog>();
				set2.addAll(catalog1.getCatalogs());
				for (Catalog catalog2 : set2) {
					form.getCatalogList().add(
							CommonUtil.catalogConvertToLabelValueBean(catalog2,
									2));
				}
			}
		}
		// ��ȡ���������б�
		List<Language> languageList = dao2.findAll();
		for (Language language : languageList) {
			form.getLanguageList().add(
					CommonUtil.languageConvertToLabelValueBean(language));
		}
		// ��ȡ���������б�
		List<Area> areaList = dao3.findAll();
		for (Area area : areaList) {
			form.getAreaList()
					.add(CommonUtil.areaConvertToLabelValueBean(area));
		}
		return dto;
	}

	/**
	 * @return the dao1
	 */
	public CatalogDAOplus getDao1() {
		return dao1;
	}

	/**
	 * @param dao1
	 *            the dao1 to set
	 */
	public void setDao1(CatalogDAOplus dao1) {
		this.dao1 = dao1;
	}

	/**
	 * @return the dao2
	 */
	public LanguageDAO getDao2() {
		return dao2;
	}

	/**
	 * @param dao2
	 *            the dao2 to set
	 */
	public void setDao2(LanguageDAO dao2) {
		this.dao2 = dao2;
	}

	/**
	 * @return the dao3
	 */
	public AreaDAO getDao3() {
		return dao3;
	}

	/**
	 * @param dao3
	 *            the dao3 to set
	 */
	public void setDao3(AreaDAO dao3) {
		this.dao3 = dao3;
	}

}
