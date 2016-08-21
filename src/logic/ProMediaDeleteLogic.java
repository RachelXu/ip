/**
 * IPTV播控平台
 */
package logic;

import dao.MediaDesc;
import dao.MediaDescDAOplus;

/**
 * 用户删除主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProMediaDeleteLogic {

	private MediaDescDAOplus dao;

	/**
	 * 用户删除逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(String deleteId) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		MediaDesc user = dao.findById(Integer.valueOf(deleteId));
		dao.delete(user);
		return dto;
	}

	/**
	 * @return the dao
	 */
	public MediaDescDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(MediaDescDAOplus dao) {
		this.dao = dao;
	}

}
