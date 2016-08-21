/**
 * IPTV����ƽ̨
 */
package logic;

import util.Contants;
import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.ServiceForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class PreServiceEditLogic {

	private ServiecTypeDAO dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �����ײ���Ϣ��
	 * @return DTO DTO��Ϣ
	 */
	public LogicDTO doLogic(String editId, ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		ServiecType serviceType = dao.findById(Integer.valueOf(editId));
		if (serviceType == null) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E013);
		} else {
			form.setServiceId(serviceType.getServiceId());
			form.setServiceName(serviceType.getServiceName());
			form.setServiceDay(serviceType.getServiceDay());
		}
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
