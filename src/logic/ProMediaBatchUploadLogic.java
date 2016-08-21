/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import dao.MediaDesc;
import dao.MediaDescDAOplus;

/**
 * �����ϴ��û���Ϣ���߼�������
 * 
 * @author ֣��
 * 
 */
public class ProMediaBatchUploadLogic {

	private MediaDescDAOplus dao;

	/**
	 * �����ϴ��û���Ϣ������
	 * 
	 * @param userList
	 *            �û���Ϣ�б�
	 * @return LogicDTO ���
	 */
	public LogicDTO doLogic(List<MediaDesc> entityList) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		for (MediaDesc entity : entityList) {
			try {
				// ӰƬ���״̬1�������
				entity.setCheckType("1");
				dao.save(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
