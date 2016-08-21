/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.ServiceForm;

/**
 * ��ֵ���������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProServiceSearchLogic {

	private ServiecTypeDAO dao;

	/**
	 * ��ֵ�������߼�������
	 * 
	 * @param form
	 *            ��ֵ����Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		ServiecType entity = new ServiecType();
		if (!CommonUtil.isEmpty(form.getServiceName())) {
			entity.setServiceName(form.getServiceName());
		}
		entity.setServiceDay(form.getServiceDay());
		List<ServiecType> serviecTypeList = dao.findByExample(entity);
		int resultCount = serviecTypeList.size();
		// �����������Ϊ0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {

			// ��ҳ��
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// ��¼��
			form.setResultCount(resultCount);
			form.setResultList(serviecTypeList);
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
