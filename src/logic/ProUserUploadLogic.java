/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import dao.User;
import dao.UserDAOplus;

/**
 * �����ϴ��û���Ϣ���߼�������
 * 
 * @author ֣��
 * 
 */
public class ProUserUploadLogic {

	private UserDAOplus dao;

	/**
	 * �����ϴ��û���Ϣ������
	 * 
	 * @param userList
	 *            �û���Ϣ�б�
	 * @return LogicDTO ���
	 */
	public LogicDTO doLogic(List<User> userList) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		for (User user : userList) {
			try {
				dao.save(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
