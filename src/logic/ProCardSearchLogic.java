/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import dao.Card;
import dao.CardDAOplus;
import dao.ProductCardDAO;
import dao.model.ProductCard;
import form.CardDetil;
import form.ProductCardForm;
import util.CommonUtil;
import util.Contants;

/**
 * ��ֵ���������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCardSearchLogic {

	private ProductCardDAO dao;

	/**
	 * ��ֵ�������߼�������
	 * 
	 * @param form
	 *            ��ֵ����Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(ProductCardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = dao.getCount(form);
		// �����������Ϊ0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<ProductCard> cardList = dao.getProductCards(form);
			form.setProductCardSet(cardList);
			
			// ��ҳ��
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// ��¼��
			form.setResultCount(resultCount);
		}
		return dto;
	}

	public ProductCardDAO getDao() {
		return dao;
	}

	public void setDao(ProductCardDAO dao) {
		this.dao = dao;
	}


}
