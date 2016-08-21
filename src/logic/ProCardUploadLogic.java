/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import dao.Card;
import dao.CardDAOplus;

/**
 * 批量上传用户信息主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardUploadLogic {

	private CardDAOplus dao;

	/**
	 * 批量上传用户信息主处理
	 * 
	 * @param cardList
	 *            用户信息列表
	 * @return LogicDTO 结果
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
