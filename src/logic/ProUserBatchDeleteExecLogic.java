/**
 * IPTV����ƽ̨
 */
package logic;

import dao.User;
import dao.UserDAOplus;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProUserBatchDeleteExecLogic {

	private UserDAOplus dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(String[] deleteCkeck) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer id = null;
		User user = null;
		for (String strid : deleteCkeck) {
			id = Integer.valueOf(strid);
			user = dao.findById(id);
			dao.delete(user);
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
