/**
 * IPTV����ƽ̨
 */
package logic;

import dao.Card;
import dao.CardDAOplus;
import form.CardForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCardEditLogic {

	private CardDAOplus dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(CardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Card card = dao.findById(form.getId());
		card.setDay(form.getDay());
		card.setEnddate(form.getEnddate());
		card.setChargedate(form.getChargedate());
		card.setPwd(form.getPwd());
		card.setState(form.getState());
		dao.update(card);
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
