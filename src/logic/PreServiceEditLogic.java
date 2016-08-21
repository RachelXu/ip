/**
 * IPTV播控平台
 */
package logic;

import util.Contants;
import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.ServiceForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreServiceEditLogic {

	private ServiecTypeDAO dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            服务套餐信息表单
	 * @return DTO DTO信息
	 */
	public LogicDTO doLogic(String editId, ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		ServiecType serviceType = dao.findById(Integer.valueOf(editId));
		if (serviceType == null) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E013);
		} else {
			form.setServiceId(serviceType.getServiceId());
			form.setServiceName(serviceType.getServiceName());
			form.setServiceDay(serviceType.getServiceDay());
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
