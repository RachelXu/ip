/**
 * IPTV����ƽ̨
 */
package logic;

import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.ServiceForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProServiceDeleteLogic {

	private ServiecTypeDAO dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �����ײ���Ϣ��
	 * @return DTO DTO��Ϣ
	 */
	public LogicDTO doLogic(ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		ServiecType serviceType = dao.findById(form.getServiceId());
		dao.delete(serviceType);
		return dto;
	}

	/**
	 * @return the dao
	 */
	public ServiecTypeDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(ServiecTypeDAO dao) {
		this.dao = dao;
	}

}
