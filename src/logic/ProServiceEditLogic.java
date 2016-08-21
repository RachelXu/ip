/**
 * IPTV播控平台
 */
package logic;

import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.ServiceForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProServiceEditLogic {

	private ServiecTypeDAO dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            服务套餐信息表单
	 * @return DTO DTO信息
	 */
	public LogicDTO doLogic(ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		ServiecType serviceType = dao.findById(form.getServiceId());
		serviceType.setServiceName(form.getServiceName());
		serviceType.setServiceDay(form.getServiceDay());
		dao.attachDirty(serviceType);
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
