/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import util.CommonUtil;
import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.CardForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreCardBatchInsertLogic {

	private ServiecTypeDAO dao;

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

		// 获取服务套餐类型下拉列表
		List<ServiecType> serviceList = dao.findAll();
		for (ServiecType service : serviceList) {
			form.getServiceList().add(
					CommonUtil.serviceConvertToLabelValueBean(service));
		}
		return dto;
	}

	/**
	 * @return the dao
	 */
	public ServiecTypeDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(ServiecTypeDAO dao) {
		this.dao = dao;
	}

}
