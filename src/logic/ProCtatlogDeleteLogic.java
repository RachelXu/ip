/**
 * IPTV����ƽ̨
 */
package logic;

import util.Contants;
import dao.Catalog;
import dao.CatalogDAOplus;

/**
 * �û�ɾ�����߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCtatlogDeleteLogic {

	private CatalogDAOplus dao;

	/**
	 * �û�ɾ���߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
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
