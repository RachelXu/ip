/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import dao.CardDAOplus;
import form.CardDetil;
import form.CardForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProCardBatchEditExecLogic {

	private CardDAOplus dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
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
