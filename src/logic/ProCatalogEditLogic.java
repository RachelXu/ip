/**
 * IPTV����ƽ̨
 */
package logic;

import util.CommonUtil;
import dao.Catalog;
import dao.CatalogDAOplus;
import form.CatalogForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCatalogEditLogic {

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
		Catalog catalog = new Catalog();
		catalog.setCatalogId(form.getCatalogId());
		catalog.setCatalogZhName(form.getCatalogZhName());
		catalog.setCatalogEnName(form.getCatalogEnName());
		catalog.setOrder1(form.getOrder());
		if (!CommonUtil.isEmpty(form.getSuperId())) {
			Catalog superCatalog = dao.findById(form.getSuperId());
			catalog.setCatalog(superCatalog);
		}
		dao.update(catalog);
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
