/**
 * IPTV����ƽ̨
 */
package logic;

import util.CommonUtil;
import dao.Admin;
import dao.AdminDAO;
import form.AdminForm;

/**
 * �û���¼���߼�������
 * 
 * @author ֣��
 * 
 */
public class ProAdminPasswordLogic {

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
