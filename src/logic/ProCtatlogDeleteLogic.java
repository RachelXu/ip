/**
 * IPTV播控平台
 */
package logic;

import util.Contants;
import dao.Catalog;
import dao.CatalogDAOplus;

/**
 * 用户删除主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCtatlogDeleteLogic {

	private CatalogDAOplus dao;

	/**
	 * 用户删除逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(String deleteId) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Catalog catalog = dao.findById(Integer.valueOf(deleteId));
		if (catalog.getCatalogs().size() != 0
				|| catalog.getMediaCatalogs().size() != 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E042);
		} else {
			dao.delete(catalog);
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
