/**
 * IPTV播控平台
 */
package logic;

import util.Contants;
import dao.Card;
import dao.CardDAOplus;
import form.CardForm;

/**
 * 用户删除主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreCardDeleteLogic {

	private CardDAOplus dao;

	/**
	 * 用户删除逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
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
