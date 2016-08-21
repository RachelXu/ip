/**
 * IPTV播控平台
 */
package logic;

import dao.MediaDescDAOplus;
import form.MediaForm;

/**
 * 节目审核主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProMediaDisApproveLogic {

	private MediaDescDAOplus dao;

	/**
	 * 节目审核逻辑主处理
	 * 
	 * @param form
	 *            节目信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(MediaForm form, String[] approveCkeck)
			throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		Integer id = null;
		for (String strid : approveCkeck) {
			id = Integer.valueOf(strid);
			// 发布
			dao.approved(form, id, "3", null);
		}
		return dto;
	}

	/**
	 * @return the dao
	 */
	public MediaDescDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(MediaDescDAOplus dao) {
		this.dao = dao;
	}

}
