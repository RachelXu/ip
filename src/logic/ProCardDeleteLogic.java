/**
 * IPTV����ƽ̨
 */
package logic;

import dao.Card;
import dao.CardDAOplus;

/**
 * �û�ɾ�����߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCardDeleteLogic {

	private CardDAOplus dao;

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
		Card card = dao.findById(Integer.valueOf(deleteId));
		dao.delete(card);
		return dto;
	}

	/**
	 * @return the dao
	 */
	public CardDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(CardDAOplus dao) {
		this.dao = dao;
	}

}
