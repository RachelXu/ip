/**
 * IPTV����ƽ̨
 */
package logic;

import dao.Card;
import dao.CardDAOplus;

/**
 * ��ֵ������ɾ�����߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCardBatchDeleteExecLogic {

	private CardDAOplus dao;

	/**
	 * ��ֵ������ɾ���߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(String[] deleteCkeck) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer id = null;
		Card card = null;
		for (String strid : deleteCkeck) {
			id = Integer.valueOf(strid);
			card = dao.findById(id);
			dao.delete(card);
		}
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
