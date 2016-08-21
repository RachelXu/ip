/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import dao.MediaDesc;
import dao.MediaDescDAOplus;

/**
 * 批量上传用户信息主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProMediaBatchUploadLogic {

	private MediaDescDAOplus dao;

	/**
	 * 批量上传用户信息主处理
	 * 
	 * @param userList
	 *            用户信息列表
	 * @return LogicDTO 结果
	 */
	public LogicDTO doLogic(List<MediaDesc> entityList) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		for (MediaDesc entity : entityList) {
			try {
				// 影片审核状态1：待审核
				entity.setCheckType("1");
				dao.save(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
