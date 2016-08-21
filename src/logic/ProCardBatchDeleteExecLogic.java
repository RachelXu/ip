/**
 * IPTV播控平台
 */
package logic;

import dao.Card;
import dao.CardDAOplus;

/**
 * 充值卡批量删除主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardBatchDeleteExecLogic {

	private CardDAOplus dao;

	/**
	 * 充值卡批量删除逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
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
