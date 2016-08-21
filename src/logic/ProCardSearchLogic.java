/**
 * IPTV播控平台
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
 * 充值卡检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardSearchLogic {

	private ProductCardDAO dao;

	/**
	 * 充值卡检索逻辑主处理
	 * 
	 * @param form
	 *            充值卡信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(ProductCardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = dao.getCount(form);
		// 检索结果数量为0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<ProductCard> cardList = dao.getProductCards(form);
			form.setProductCardSet(cardList);
			
			// 总页数
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// 记录数
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
