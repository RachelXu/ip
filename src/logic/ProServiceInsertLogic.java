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
public class ProServiceInsertLogic {

	private ServiecTypeDAO dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		ServiecType entity = new ServiecType();
		entity.setServiceName(form.getServiceName());
		entity.setServiceDay(form.getServiceDay());
		dao.save(entity);
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
