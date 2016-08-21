/**
 * IPTV播控平台
 */
package logic;

import util.CommonUtil;
import dao.Card;
import dao.CardDAOplus;
import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.CardForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProCardBatchInsertLogic {

	private CardDAOplus dao1;

	private ServiecTypeDAO dao2;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(CardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer maxBatch = dao1.getMaxBatch();
		if (CommonUtil.isEmpty(maxBatch)) {
			maxBatch = 0;
		}
		int batchNo = maxBatch + 1;
		form.setBatchNum(batchNo);
		Card entity = null;
		for (int i = 0; i < form.getProductNum(); i++) {
			entity = new Card();
			entity.setPwd(CommonUtil.getRandString(6));
			entity.setEnddate(form.getEnddate());
			ServiecType serviecType = dao2.findById(form.getService());
			entity.setServiecType(serviecType);
			entity.setDay(serviecType.getServiceDay());
			entity.setBatchNo(batchNo);
			entity.setState(1);
			dao1.save(entity);
		}
		return dto;
	}

	/**
	 * @return the dao1
	 */
	public CardDAOplus getDao1() {
		return dao1;
	}

	/**
	 * @param dao1
	 *            the dao1 to set
	 */
	public void setDao1(CardDAOplus dao1) {
		this.dao1 = dao1;
	}

	/**
	 * @return the dao2
	 */
	public ServiecTypeDAO getDao2() {
		return dao2;
	}

	/**
	 * @param dao2
	 *            the dao2 to set
	 */
	public void setDao2(ServiecTypeDAO dao2) {
		this.dao2 = dao2;
	}

}
