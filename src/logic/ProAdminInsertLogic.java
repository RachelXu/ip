/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.Admin;
import dao.AdminDAO;
import form.AdminForm;

/**
 * �û���¼���߼�������
 * 
 * @author ֣��
 * 
 */
public class ProAdminInsertLogic {

	private AdminDAO dao;

	/**
	 * �û���¼�߼�������
	 * 
	 * @param userName
	 *            �û���
	 * @param password
	 *            ����
	 * @return UserDTO �û���ϢDTO
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
