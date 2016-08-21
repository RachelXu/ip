/**
 * IPTV����ƽ̨
 */
package logic;

import dao.Iptvsoftware;
import dao.IptvsoftwareDAO;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProIptvDownLoadLogic {

	private IptvsoftwareDAO dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(String downId, Iptvsoftware iptvsoftware)
			throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Iptvsoftware result = dao.findById(Integer.valueOf(downId));
		iptvsoftware.setFilename(result.getFilename());
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
