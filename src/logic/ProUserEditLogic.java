/**
 * IPTV播控平台
 */
package logic;

import util.CommonUtil;
import dao.User;
import dao.UserDAOplus;
import form.UserForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProUserEditLogic {

	private UserDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(UserForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		User user = new User();
		user.setId(form.getId());
		user.setName(form.getName());
		user.setAddress(form.getAddress());
		user.setAge(form.getAge());
		user.setRestDay(CommonUtil.formatStringToInteger(form.getRestDay()));
		user.setComment(form.getComment());
		user.setPhone(form.getPhone());
		user.setPici(form.getGroup());
		user.setPwd(form.getPwd());
		user.setState(form.getState());
		user.setType(form.getType());
		dao.update(user);
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
