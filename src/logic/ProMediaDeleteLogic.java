/**
 * IPTV����ƽ̨
 */
package logic;

import dao.MediaDesc;
import dao.MediaDescDAOplus;

/**
 * �û�ɾ�����߼�������
 * 
 * @author ֣��
 * 
 */
public class ProMediaDeleteLogic {

	private MediaDescDAOplus dao;

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
		MediaDesc user = dao.findById(Integer.valueOf(deleteId));
		dao.delete(user);
		return dto;
	}

	/**
	 * @return the dao
	 */
	public MediaDescDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(MediaDescDAOplus dao) {
		this.dao = dao;
	}

}
