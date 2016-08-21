/**
 * IPTV播控平台
 */
package logic;

import dao.Iptvsoftware;
import dao.IptvsoftwareDAO;

/**
 * 批量上传用户信息主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProIptvUploadLogic {

	private IptvsoftwareDAO dao;

	/**
	 * 批量上传用户信息主处理
	 * 
	 * @param userList
	 *            用户信息列表
	 * @return LogicDTO 结果
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
