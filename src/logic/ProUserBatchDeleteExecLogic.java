/**
 * IPTV播控平台
 */
package logic;

import dao.User;
import dao.UserDAOplus;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProUserBatchDeleteExecLogic {

	private UserDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(String[] deleteCkeck) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer id = null;
		User user = null;
		for (String strid : deleteCkeck) {
			id = Integer.valueOf(strid);
			user = dao.findById(id);
			dao.delete(user);
		}
		return dto;
	}

	/**
	 * @return the dao
	 */
	public UserDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(UserDAOplus dao) {
		this.dao = dao;
	}

}
