/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import dao.User;
import dao.UserDAOplus;

/**
 * 批量上传用户信息主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProUserUploadLogic {

	private UserDAOplus dao;

	/**
	 * 批量上传用户信息主处理
	 * 
	 * @param userList
	 *            用户信息列表
	 * @return LogicDTO 结果
	 */
	public LogicDTO doLogic(List<User> userList) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		for (User user : userList) {
			try {
				dao.save(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
