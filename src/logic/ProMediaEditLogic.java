/**
 * IPTV播控平台
 */
package logic;

import util.CommonUtil;
import dao.Area;
import dao.AreaDAO;
import dao.Catalog;
import dao.CatalogDAOplus;
import dao.Language;
import dao.LanguageDAO;
import dao.MediaCatalog;
import dao.MediaDesc;
import dao.MediaDescDAOplus;
import form.MediaForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProMediaEditLogic {

	private MediaDescDAOplus dao1;
	private LanguageDAO dao2;
	private AreaDAO dao3;
	private CatalogDAOplus dao4;

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
		// 语言
		MediaDesc mediaDesc = dao1.findById(form.getMediaId());
		if (!CommonUtil.isEmpty(form.getLanguageId())) {
			Language language = dao2.findById(Integer.valueOf(form
					.getLanguageId()));
			mediaDesc.setLanguage(language);
		}
		// 地区
		if (!CommonUtil.isEmpty(form.getAreaId())) {
			Area area = dao3.findById(form.getAreaId());
			mediaDesc.setArea(area);
		}
		// 目录
		if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
			for (Integer id : form.getMediaCatalogId()) {
				Catalog catalog = dao4.findById(id);
				MediaCatalog entityMediaCatalog = new MediaCatalog();
				entityMediaCatalog.getCatalogs().add(catalog);
				entityMediaCatalog.setMediaCatalogName(form.getMediaName());
				entityMediaCatalog.setCatalogEnName(form.getMediaNameEn());
				mediaDesc.setMediaCatalog(entityMediaCatalog);
			}
		}
		mediaDesc.setMediaName(form.getMediaName());
		mediaDesc.setYear(form.getYear());
		mediaDesc.setDirector(form.getDirector());
		mediaDesc.setActor(form.getActor());
		mediaDesc.setGrade(form.getGrade());
		mediaDesc.setIntroduction(form.getIntroduction());

		dao1.update(mediaDesc);
		return dto;
	}

	/**
	 * @return the dao1
	 */
	public MediaDescDAOplus getDao1() {
		return dao1;
	}

	/**
	 * @param dao1
	 *            the dao1 to set
	 */
	public void setDao1(MediaDescDAOplus dao1) {
		this.dao1 = dao1;
	}

	/**
	 * @return the dao2
	 */
	public LanguageDAO getDao2() {
		return dao2;
	}

	/**
	 * @param dao2
	 *            the dao2 to set
	 */
	public void setDao2(LanguageDAO dao2) {
		this.dao2 = dao2;
	}

	/**
	 * @return the dao3
	 */
	public AreaDAO getDao3() {
		return dao3;
	}

	/**
	 * @param dao3
	 *            the dao3 to set
	 */
	public void setDao3(AreaDAO dao3) {
		this.dao3 = dao3;
	}

	/**
	 * @return the dao4
	 */
	public CatalogDAOplus getDao4() {
		return dao4;
	}

	/**
	 * @param dao4
	 *            the dao4 to set
	 */
	public void setDao4(CatalogDAOplus dao4) {
		this.dao4 = dao4;
	}

}
