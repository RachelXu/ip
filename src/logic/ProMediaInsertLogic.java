/**
 * IPTV播控平台
 */
package logic;

import util.CommonUtil;
import util.Contants;
import dao.Area;
import dao.AreaDAO;
import dao.Catalog;
import dao.CatalogDAOplus;
import dao.Language;
import dao.LanguageDAO;
import dao.MediaCatalog;
import dao.MediaDesc;
import dao.MediaDescDAOplus;
import dao.SubMediaSource;
import dao.SubMediaSourceDAO;
import dao.SubMediaSourceId;
import form.MediaForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProMediaInsertLogic {

	private MediaDescDAOplus dao1;
	private CatalogDAOplus dao2;
	private LanguageDAO dao3;
	private AreaDAO dao4;
	private SubMediaSourceDAO dao5;

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
		MediaDesc entityMediaDesc = new MediaDesc();
		MediaCatalog entityMediaCatalog = new MediaCatalog();
		SubMediaSource entitySubMediaSource = new SubMediaSource();
		// 语言
		if (!CommonUtil.isEmpty(form.getLanguageId())) {
			Language language = dao3.findById(form.getLanguageId());
			entityMediaDesc.setLanguage(language);
		}
		// 地区
		if (!CommonUtil.isEmpty(form.getAreaId())) {
			Area area = dao4.findById(form.getAreaId());
			entityMediaDesc.setArea(area);
		}
		// 目录
		if (!CommonUtil.isEmpty(form.getMediaCatalogId())) {
			for (Integer id : form.getMediaCatalogId()) {
				Catalog catalog = dao2.findById(id);
				entityMediaCatalog.getCatalogs().add(catalog);
			}
		} else {
			dto.setResult(false);
			dto.setErrorCode(Contants.E027);
			return dto;
		}
		// 节目中文名称
		entityMediaCatalog.setMediaCatalogName(form.getMediaName());
		entityMediaDesc.setMediaName(form.getMediaName());
		// 节目英文名称
		entityMediaCatalog.setCatalogEnName(form.getMediaNameEn());
		// 年代
		if (!CommonUtil.isEmpty(form.getYear())) {
			if (CommonUtil.isyyyyMMdd(form.getYear())) {
				entityMediaDesc.setYear(form.getYear());
			} else {
				dto.setResult(false);
				dto.setErrorCode(Contants.E028);
				return dto;
			}
		}
		// 导演
		entityMediaDesc.setDirector(form.getDirector());
		// 演员
		entityMediaDesc.setActor(form.getActor());
		// 评分
		entityMediaDesc.setGrade(form.getGrade());
		// 简介
		entityMediaDesc.setIntroduction(form.getIntroduction());
		entityMediaDesc.setMediaCatalog(entityMediaCatalog);
		// 审核状态(待审核)
		entityMediaDesc.setCheckType("1");
		dao1.save(entityMediaDesc);
		// 源链接
		if (form.getRadioCheck() == 1) {
			// 上传单个链接的情况
			entitySubMediaSource.setOrder1(1);
			entitySubMediaSource.setId(new SubMediaSourceId(entityMediaDesc,
					form.getSourceLink()));
			dao5.save(entitySubMediaSource);
		} else {
			// 上传多个链接的情况
			for (SubMediaSource tem : form.getSubMediaSourceList()) {
				tem.getId().setMediaDesc(entityMediaDesc);
				dao5.save(tem);
			}
		}
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
	public CatalogDAOplus getDao2() {
		return dao2;
	}

	/**
	 * @param dao2
	 *            the dao2 to set
	 */
	public void setDao2(CatalogDAOplus dao2) {
		this.dao2 = dao2;
	}

	/**
	 * @return the dao3
	 */
	public LanguageDAO getDao3() {
		return dao3;
	}

	/**
	 * @param dao3
	 *            the dao3 to set
	 */
	public void setDao3(LanguageDAO dao3) {
		this.dao3 = dao3;
	}

	/**
	 * @return the dao4
	 */
	public AreaDAO getDao4() {
		return dao4;
	}

	/**
	 * @param dao4
	 *            the dao4 to set
	 */
	public void setDao4(AreaDAO dao4) {
		this.dao4 = dao4;
	}

	/**
	 * @return the dao5
	 */
	public SubMediaSourceDAO getDao5() {
		return dao5;
	}

	/**
	 * @param dao5
	 *            the dao5 to set
	 */
	public void setDao5(SubMediaSourceDAO dao5) {
		this.dao5 = dao5;
	}

}
