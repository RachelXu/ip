/**
 * IPTV����ƽ̨
 */
package logic;

import java.util.List;

import dao.Iptvsoftware;
import dao.IptvsoftwareDAO;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class PreIptvHistoryLogic {

	private IptvsoftwareDAO dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(List<Iptvsoftware> resultList) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		List<Iptvsoftware> result = dao.findAll();
		if (result.size() != 0) {
			resultList.addAll(result);
		}

		return dto;
	}

	/**
	 * @return the dao
	 */
	public IptvsoftwareDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(IptvsoftwareDAO dao) {
		this.dao = dao;
	}

}
