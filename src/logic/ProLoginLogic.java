/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.Admin;
import dao.AdminDAO;
import form.AdminForm;

/**
 * 用户登录主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProLoginLogic {

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
	public LogicDTO doLogic(AdminForm adminForm) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		List<Admin> result = dao.findByAdminName(adminForm.getUsername());
		if (result.size() != 0) {
			Admin admin = result.get(0);
			if (!admin.getPwd().equals(
					CommonUtil.chgPasswordByMD5(adminForm.getPassword()))) {
				dto.setResult(false);
				dto.setErrorCode(Contants.E002);
			} else {
				adminForm.setAdminId(admin.getAdminId());
				adminForm.setLevel(admin.getLevel());
			}
		} else {
			dto.setResult(false);
			dto.setErrorCode(Contants.E001);
		}
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
