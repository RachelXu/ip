/**
 * IPTV播控平台
 */
package logic;

import dao.Iptvsoftware;
import dao.IptvsoftwareDAO;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProIptvDownLoadLogic {

	private IptvsoftwareDAO dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
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
