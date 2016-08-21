/**
 * IPTV播控平台
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.MediaDesc;
import dao.MediaDescDAOplus;
import form.MediaDetil;
import form.MediaForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreMediaApproveLogic {

	private MediaDescDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(MediaForm form, String checkType) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		List<MediaDesc> mediaList = dao.findByCheckType(checkType);
		int resultCount = mediaList.size();
		// 检索结果数量为0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E043);
		} else {
			List<MediaDetil> resultList = new ArrayList<MediaDetil>();
			MediaDetil mediaDetil = null;
			for (MediaDesc media : mediaList) {
				mediaDetil = new MediaDetil();
				mediaDetil.setMediaId(media.getMediaId());
				if (!CommonUtil.isEmpty(media.getLanguage())) {
					mediaDetil.setLanguage(media.getLanguage()
							.getLanguageName());
				}
				if (!CommonUtil.isEmpty(media.getArea())) {
					mediaDetil.setArea(media.getArea().getAreaName());
				}
				mediaDetil.setMediaName(media.getMediaName());
				mediaDetil.setYear(media.getYear());
				mediaDetil.setDirector(media.getDirector());
				mediaDetil.setActor(media.getActor());
				mediaDetil.setGrade(media.getGrade());
				resultList.add(mediaDetil);
			}
			form.setResultList(resultList);
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
