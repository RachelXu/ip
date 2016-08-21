/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import dao.Card;
import dao.CardDAOplus;

/**
 * �����ϴ��û���Ϣ���߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCardUploadLogic {

	private CardDAOplus dao;

	/**
	 * �����ϴ��û���Ϣ������
	 * 
	 * @param cardList
	 *            �û���Ϣ�б�
	 * @return LogicDTO ���
	 */
	public LogicDTO doLogic(List<Card> cardList) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		for (Card card : cardList) {
			try {
				dao.save(card);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
