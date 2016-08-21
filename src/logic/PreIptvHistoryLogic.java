/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import dao.Iptvsoftware;
import dao.IptvsoftwareDAO;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreIptvHistoryLogic {

	private IptvsoftwareDAO dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
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
