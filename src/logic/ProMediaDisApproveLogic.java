/**
 * IPTV����ƽ̨
 */
package logic;

import dao.MediaDescDAOplus;
import form.MediaForm;

/**
 * ��Ŀ������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProMediaDisApproveLogic {

	private MediaDescDAOplus dao;

	/**
	 * ��Ŀ����߼�������
	 * 
	 * @param form
	 *            ��Ŀ��Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(MediaForm form, String[] approveCkeck)
			throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer id = null;
		for (String strid : approveCkeck) {
			id = Integer.valueOf(strid);
			// ����
			dao.approved(form, id, "3", null);
		}
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
