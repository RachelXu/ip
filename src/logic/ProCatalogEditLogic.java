/**
 * IPTV播控平台
 */
package logic;

import util.CommonUtil;
import dao.Catalog;
import dao.CatalogDAOplus;
import form.CatalogForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCatalogEditLogic {

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
