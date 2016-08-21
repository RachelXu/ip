/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import util.Contants;
import dao.Card;
import dao.CardDAOplus;
import form.CardForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardDownloadLogic {

	private CardDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(Integer batchNum, CardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		List<Card> cardList = dao.findByBatchNo(batchNum);
		if (cardList.size() == 0) {
			dto.setErrorCode(Contants.E003);
			dto.setResult(false);
			return dto;
		}
		if (form == null) {
			return dto;
		}
		form.setDownloadList(cardList);
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
