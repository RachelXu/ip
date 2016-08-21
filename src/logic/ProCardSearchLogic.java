/**
 * IPTV播控平台
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.Card;
import dao.CardDAOplus;
import form.CardDetil;
import form.CardForm;

/**
 * 充值卡检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardSearchLogic {

	private CardDAOplus dao;

	/**
	 * 充值卡检索逻辑主处理
	 * 
	 * @param form
	 *            充值卡信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(CardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = dao.count(form);
		// 检索结果数量为0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<Card> cardList = dao.search(form);
			List<CardDetil> resultList = new ArrayList<CardDetil>();
			CardDetil cardDetil = null;
			for (Card card : cardList) {
				cardDetil = new CardDetil();
				// id
				cardDetil.setId(card.getId());
				// 状态
				if (!CommonUtil.isEmpty(card.getState())) {
					cardDetil.setState(Contants.CARD_STATE_ARRAY[card
							.getState()]);
				}

				// 充值时长
				cardDetil.setDay(card.getDay());
				// 截止日期
				cardDetil.setEnddate(card.getEnddate());
				// 充值日期
				cardDetil.setChargedate(card.getChargedate());
				resultList.add(cardDetil);
			}
			// 总页数
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// 记录数
			form.setResultCount(resultCount);
			form.setResultList(resultList);
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
