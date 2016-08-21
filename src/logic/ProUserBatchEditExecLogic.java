/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import dao.UserDAOplus;
import form.UserDetil;
import form.UserForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProUserBatchEditExecLogic {

	private UserDAOplus dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
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
