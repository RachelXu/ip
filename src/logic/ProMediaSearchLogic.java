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
public class ProMediaSearchLogic {

	private MediaDescDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(MediaForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = dao.count(form);
		// 检索结果数量为0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<MediaDesc> mediaList = dao.search(form);
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
			// 总页数
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// 记录数
			form.setResultCount(resultCount);
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
