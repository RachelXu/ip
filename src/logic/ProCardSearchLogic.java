/**
 * IPTV����ƽ̨
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
 * ��ֵ���������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCardSearchLogic {

	private CardDAOplus dao;

	/**
	 * ��ֵ�������߼�������
	 * 
	 * @param form
	 *            ��ֵ����Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(CardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = dao.count(form);
		// �����������Ϊ0
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
				// ״̬
				if (!CommonUtil.isEmpty(card.getState())) {
					cardDetil.setState(Contants.CARD_STATE_ARRAY[card
							.getState()]);
				}

				// ��ֵʱ��
				cardDetil.setDay(card.getDay());
				// ��ֹ����
				cardDetil.setEnddate(card.getEnddate());
				// ��ֵ����
				cardDetil.setChargedate(card.getChargedate());
				resultList.add(cardDetil);
			}
			// ��ҳ��
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// ��¼��
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
