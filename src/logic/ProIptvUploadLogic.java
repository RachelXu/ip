/**
 * IPTV����ƽ̨
 */
package logic;

import dao.Iptvsoftware;
import dao.IptvsoftwareDAO;

/**
 * �����ϴ��û���Ϣ���߼�������
 * 
 * @author ֣��
 * 
 */
public class ProIptvUploadLogic {

	private IptvsoftwareDAO dao;

	/**
	 * �����ϴ��û���Ϣ������
	 * 
	 * @param userList
	 *            �û���Ϣ�б�
	 * @return LogicDTO ���
	 */
	public LogicDTO doLogic(String version, String update, String content,
			String usedate, String filename) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Iptvsoftware iptvsoftware = new Iptvsoftware();
		iptvsoftware.setContent(content);
		iptvsoftware.setFilename(filename);
		iptvsoftware.setUpDate(update);
		iptvsoftware.setUsedate(usedate);
		iptvsoftware.setVersion(version);
		dao.save(iptvsoftware);
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
