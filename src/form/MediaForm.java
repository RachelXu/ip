package form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Contants;
import dao.SubMediaSource;

public class MediaForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	/** 节目ID */
	private Integer mediaId;
	/** 节目ID（开始） */
	private Integer mediaId1;
	/** 节目ID（结束） */
	private Integer mediaId2;
	/** 节目所在目录 */
	private Integer[] mediaCatalogId;
	/** 语言 */
	private Integer languageId;
	/** 地区 */
	private Integer areaId;
	/** 节目名称 */
	private String mediaName;
	/** 节目英文名称 */
	private String mediaNameEn;
	/** 年代 */
	private String year;
	/** 年代（开始） */
	private String year1;
	/** 年代（结束） */
	private String year2;
	/** 导演 */
	private String director;
	/** 演员 */
	private String actor;
	/** 简介 */
	private String introduction;
	/** 评分 */
	private Integer grade;
	/** 评分（开始） */
	private Integer grade1;
	/** 评分（结束） */
	private Integer grade2;
	/** 有效日期 */
	private String endDate;
	/** 节目审核状态 */
	private String checkType;
	/** 节目服务类型 */
	private String serviceType;
	/** 视频源链接 */
	private String sourceLink;
	/** 单选按钮标示 */
	private Integer radioCheck;
	/** 检索结果显示标示 */
	private boolean resultFlag;
	/** 检索结果 */
	private List<MediaDetil> resultList;
	/** 目录的下拉列表 */
	private List<LabelValueIntBean> catalogList = new ArrayList<LabelValueIntBean>();
	/** 语言的下拉列表 */
	private List<LabelValueIntBean> languageList = new ArrayList<LabelValueIntBean>();
	/** 地区的下拉列表 */
	private List<LabelValueIntBean> areaList = new ArrayList<LabelValueIntBean>();
	/** 节目审核状态的下拉列表 */
	private List<LabelValueStrBean> typeList = new ArrayList<LabelValueStrBean>();
	/** 当前页码 */
	private Integer currentPage;
	/** 总页码 */
	private Integer pageCount;
	/** 检索结果总数 */
	private Integer resultCount;
	/** 视频源链接列表 */
	private List<SubMediaSource> subMediaSourceList = new ArrayList<SubMediaSource>();

	public void copy(MediaForm meidiaForm) {
		this.areaList.addAll(meidiaForm.getAreaList());
		this.languageList.addAll(meidiaForm.getLanguageList());
		this.catalogList.addAll(meidiaForm.getCatalogList());
	}

	public void initView(boolean resultFlag) {
		// 节目的状态
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_1, "1"));
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_2, "2"));
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_3, "3"));
		// 检索结果显示标示
		this.resultFlag = resultFlag;
	}

	/**
	 * @return the mediaId
	 */
	public Integer getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * @return the mediaId1
	 */
	public Integer getMediaId1() {
		return mediaId1;
	}

	/**
	 * @param mediaId1
	 *            the mediaId1 to set
	 */
	public void setMediaId1(Integer mediaId1) {
		this.mediaId1 = mediaId1;
	}

	/**
	 * @return the mediaId2
	 */
	public Integer getMediaId2() {
		return mediaId2;
	}

	/**
	 * @param mediaId2
	 *            the mediaId2 to set
	 */
	public void setMediaId2(Integer mediaId2) {
		this.mediaId2 = mediaId2;
	}

	/**
	 * @return the mediaCatalogId
	 */
	public Integer[] getMediaCatalogId() {
		return mediaCatalogId;
	}

	/**
	 * @param mediaCatalogId
	 *            the mediaCatalogId to set
	 */
	public void setMediaCatalogId(Integer[] mediaCatalogId) {
		this.mediaCatalogId = mediaCatalogId;
	}

	/**
	 * @return the languageId
	 */
	public Integer getLanguageId() {
		return languageId;
	}

	/**
	 * @param languageId
	 *            the languageId to set
	 */
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	/**
	 * @return the areaId
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId
	 *            the areaId to set
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return the mediaName
	 */
	public String getMediaName() {
		return mediaName;
	}

	/**
	 * @param mediaName
	 *            the mediaName to set
	 */
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the year1
	 */
	public String getYear1() {
		return year1;
	}

	/**
	 * @param year1
	 *            the year1 to set
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
	}

	/**
	 * @return the year2
	 */
	public String getYear2() {
		return year2;
	}

	/**
	 * @param year2
	 *            the year2 to set
	 */
	public void setYear2(String year2) {
		this.year2 = year2;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}

	/**
	 * @param actor
	 *            the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}

	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction
	 *            the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * @return the grade1
	 */
	public Integer getGrade1() {
		return grade1;
	}

	/**
	 * @param grade1
	 *            the grade1 to set
	 */
	public void setGrade1(Integer grade1) {
		this.grade1 = grade1;
	}

	/**
	 * @return the grade2
	 */
	public Integer getGrade2() {
		return grade2;
	}

	/**
	 * @param grade2
	 *            the grade2 to set
	 */
	public void setGrade2(Integer grade2) {
		this.grade2 = grade2;
	}

	/**
	 * @return the resultFlag
	 */
	public boolean isResultFlag() {
		return resultFlag;
	}

	/**
	 * @param resultFlag
	 *            the resultFlag to set
	 */
	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}

	/**
	 * @return the resultList
	 */
	public List<MediaDetil> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<MediaDetil> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the catalogList
	 */
	public List<LabelValueIntBean> getCatalogList() {
		return catalogList;
	}

	/**
	 * @param catalogList
	 *            the catalogList to set
	 */
	public void setCatalogList(List<LabelValueIntBean> catalogList) {
		this.catalogList = catalogList;
	}

	/**
	 * @return the languageList
	 */
	public List<LabelValueIntBean> getLanguageList() {
		return languageList;
	}

	/**
	 * @param languageList
	 *            the languageList to set
	 */
	public void setLanguageList(List<LabelValueIntBean> languageList) {
		this.languageList = languageList;
	}

	/**
	 * @return the areaList
	 */
	public List<LabelValueIntBean> getAreaList() {
		return areaList;
	}

	/**
	 * @param areaList
	 *            the areaList to set
	 */
	public void setAreaList(List<LabelValueIntBean> areaList) {
		this.areaList = areaList;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the resultCount
	 */
	public Integer getResultCount() {
		return resultCount;
	}

	/**
	 * @param resultCount
	 *            the resultCount to set
	 */
	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	/**
	 * @return the radioCheck
	 */
	public Integer getRadioCheck() {
		return radioCheck;
	}

	/**
	 * @param radioCheck
	 *            the radioCheck to set
	 */
	public void setRadioCheck(Integer radioCheck) {
		this.radioCheck = radioCheck;
	}

	/**
	 * @return the mediaNameEn
	 */
	public String getMediaNameEn() {
		return mediaNameEn;
	}

	/**
	 * @param mediaNameEn
	 *            the mediaNameEn to set
	 */
	public void setMediaNameEn(String mediaNameEn) {
		this.mediaNameEn = mediaNameEn;
	}

	/**
	 * @return the sourceLink
	 */
	public String getSourceLink() {
		return sourceLink;
	}

	/**
	 * @param sourceLink
	 *            the sourceLink to set
	 */
	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}

	/**
	 * @return the subMediaSourceList
	 */
	public List<SubMediaSource> getSubMediaSourceList() {
		return subMediaSourceList;
	}

	/**
	 * @param subMediaSourceList
	 *            the subMediaSourceList to set
	 */
	public void setSubMediaSourceList(List<SubMediaSource> subMediaSourceList) {
		this.subMediaSourceList = subMediaSourceList;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the checkType
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * @param checkType
	 *            the checkType to set
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	/**
	 * @return the typeList
	 */
	public List<LabelValueStrBean> getTypeList() {
		return typeList;
	}

	/**
	 * @param typeList
	 *            the typeList to set
	 */
	public void setTypeList(List<LabelValueStrBean> typeList) {
		this.typeList = typeList;
	}

	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType
	 *            the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}