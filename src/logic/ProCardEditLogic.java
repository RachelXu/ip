/**
 * IPTV播控平台
 */
package logic;

import dao.Card;
import dao.CardDAOplus;
import form.CardForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardEditLogic {

	private CardDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
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
