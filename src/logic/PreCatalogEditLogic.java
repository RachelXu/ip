/**
 * IPTV播控平台
 */
package logic;

import util.Contants;
import dao.Catalog;
import dao.CatalogDAOplus;
import form.CatalogForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreCatalogEditLogic {

	private CatalogDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
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
