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
public class ProAdminInsertLogic {

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
		List<Admin> adminList = dao.findByAdminName(adminForm.getUsername());
		if (adminList.size() != 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E047);
			return dto;
		}
		Admin admin = new Admin();
		admin.setAdminName(adminForm.getUsername());
		admin.setPwd(CommonUtil.chgPasswordByMD5(adminForm.getPassword1()));
		admin.setLevel(adminForm.getLevelEdit());
		dao.save(admin);

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
