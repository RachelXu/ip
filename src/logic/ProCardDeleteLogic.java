/**
 * IPTV播控平台
 */
package logic;

import dao.Card;
import dao.CardDAOplus;

/**
 * 用户删除主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardDeleteLogic {

	private CardDAOplus dao;

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
