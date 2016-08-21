/**
 * IPTV����ƽ̨
 */
package logic;

import util.Contants;
import dao.Card;
import dao.CardDAOplus;
import form.CardForm;

/**
 * �û�ɾ�����߼�������
 * 
 * @author ֣��
 * 
 */
public class PreCardDeleteLogic {

	private CardDAOplus dao;

	/**
	 * �û�ɾ���߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(String deleteId, CardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Card card = dao.findById(Integer.valueOf(deleteId));
		if (card == null) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E013);
		} else {
			form.setId(card.getId());
			form.setPwd(card.getPwd());
			form.setState(card.getState());
			form.setDay(card.getDay());
			form.setEnddate(card.getEnddate());
			form.setChargedate(card.getChargedate());
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
