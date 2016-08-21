/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import dao.UserDAOplus;
import form.UserDetil;
import form.UserForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProUserBatchEditExecLogic {

	private UserDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(UserForm form, List<UserDetil> userDetilList)
			throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer id = null;
		for (UserDetil userDetil : userDetilList) {
			id = userDetil.getId();
			dao.batchEditUpdate(form, id);
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
