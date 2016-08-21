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
public class ProServiceInsertLogic {

	private ServiecTypeDAO dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		ServiecType entity = new ServiecType();
		entity.setServiceName(form.getServiceName());
		entity.setServiceDay(form.getServiceDay());
		dao.save(entity);
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
