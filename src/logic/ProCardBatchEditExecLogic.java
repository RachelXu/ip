/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import dao.CardDAOplus;
import form.CardDetil;
import form.CardForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardBatchEditExecLogic {

	private CardDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(CardForm form, List<CardDetil> cardDetilList)
			throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer id = null;
		for (CardDetil cardDetil : cardDetilList) {
			id = cardDetil.getId();
			dao.batchEditUpdate(form, id);
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
