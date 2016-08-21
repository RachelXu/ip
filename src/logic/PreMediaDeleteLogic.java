/**
 * IPTV播控平台
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import util.Contants;
import dao.Catalog;
import dao.MediaCatalog;
import dao.MediaDesc;
import dao.MediaDescDAOplus;
import form.MediaForm;

/**
 * 用户删除主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class PreMediaDeleteLogic {

	private MediaDescDAOplus dao;

	/**
	 * 用户删除逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(String deleteId, MediaForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		MediaDesc mediaDesc = dao.findById(Integer.valueOf(deleteId));
		if (mediaDesc == null) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E013);
		} else {
			form.setMediaId(mediaDesc.getMediaId());
			form.setMediaName(mediaDesc.getMediaName());
			if (mediaDesc.getLanguage() != null) {
				form.setLanguageId(mediaDesc.getLanguage().getLanguageId());
			}
			if (mediaDesc.getArea() != null) {
				form.setAreaId(mediaDesc.getArea().getAreaId());
			}
			form.setYear(mediaDesc.getYear());
			form.setDirector(mediaDesc.getDirector());
			form.setActor(mediaDesc.getActor());
			form.setGrade(mediaDesc.getGrade());
			List<Integer> mediaCatalogList = new ArrayList<Integer>();
			MediaCatalog mc = mediaDesc.getMediaCatalog();
			form.setMediaNameEn(mc.getCatalogEnName());
			for (Catalog catalog : mc.getCatalogs()) {
				mediaCatalogList.add(catalog.getCatalogId());
			}
			form.setMediaCatalogId(mediaCatalogList.toArray(new Integer[0]));

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
