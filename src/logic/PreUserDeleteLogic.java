/**
 * IPTV播控平台
 */
package logic;

import util.CommonUtil;
import util.Contants;
import dao.User;
import dao.UserDAOplus;
import form.UserForm;

/**
 * 用户删除主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreUserDeleteLogic {

	private UserDAOplus dao;

	/**
	 * 用户删除逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(String deleteId, UserForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		User user = dao.findById(Integer.valueOf(deleteId));
		if (user == null) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E013);
		} else {
			form.setId(user.getId());
			form.setName(user.getName());
			form.setPwd(user.getPwd());
			form.setAge(user.getAge());
			form.setPhone(user.getPhone());
			form.setAddress(user.getAddress());
			form.setState(user.getState());
			form.setType(user.getType());
			form
					.setRestDay(CommonUtil.formatIntegerToString(user
							.getRestDay()));
			form.setGroup(user.getPici());
			form.setComment(user.getComment());
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
