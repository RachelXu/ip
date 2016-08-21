/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import util.CommonUtil;
import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.CardForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class PreCardBatchInsertLogic {

	private ServiecTypeDAO dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(CardForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);

		// ��ȡ�����ײ����������б�
		List<ServiecType> serviceList = dao.findAll();
		for (ServiecType service : serviceList) {
			form.getServiceList().add(
					CommonUtil.serviceConvertToLabelValueBean(service));
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
