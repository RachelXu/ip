/**
 * IPTV����ƽ̨
 */
package logic;

import dao.User;
import dao.UserDAOplus;

/**
 * �û�ɾ�����߼�������
 * 
 * @author ֣��
 * 
 */
public class ProUserDeleteLogic {

	private UserDAOplus dao;

	/**
	 * �û�ɾ���߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(String deleteId) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		User user = dao.findById(Integer.valueOf(deleteId));
		dao.delete(user);
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
