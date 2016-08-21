/**
 * IPTV����ƽ̨
 */
package logic;

import util.Contants;
import dao.Catalog;
import dao.CatalogDAOplus;
import form.CatalogForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class PreCatalogEditLogic {

	private CatalogDAOplus dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(String editId, CatalogForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Catalog catalog = dao.findById(Integer.valueOf(editId));
		if (catalog == null) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E013);
		} else {
			form.setCatalogId(catalog.getCatalogId());
			form.setCatalogZhName(catalog.getCatalogZhName());
			form.setCatalogEnName(catalog.getCatalogEnName());
			form.setOrder(catalog.getOrder1());
			form.setSuperId(catalog.getCatalog() != null ? catalog.getCatalog()
					.getCatalogId() : null);

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
