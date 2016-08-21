/**
 * IPTV播控平台
 */
package logic;

import util.CommonUtil;
import dao.Admin;
import dao.AdminDAO;
import form.AdminForm;

/**
 * 用户登录主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProAdminPasswordLogic {

	private AdminDAO dao;

	/**
	 * 用户登录逻辑主处理
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(AdminForm adminForm1, AdminForm adminForm)
			throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Admin admin = dao.findById(adminForm.getAdminId());
		admin.setPwd(CommonUtil.chgPasswordByMD5(adminForm1.getPassword1()));
		dao.attachDirty(admin);

		return dto;
	}

	/**
	 * @return the dao
	 */
	public AdminDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(AdminDAO dao) {
		this.dao = dao;
	}

}
