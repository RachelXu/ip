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
	/** ��ĿID */
	private Integer mediaId;
	/** ��ĿID����ʼ�� */
	private Integer mediaId1;
	/** ��ĿID�������� */
	private Integer mediaId2;
	/** ��Ŀ����Ŀ¼ */
	private Integer[] mediaCatalogId;
	/** ���� */
	private Integer languageId;
	/** ���� */
	private Integer areaId;
	/** ��Ŀ���� */
	private String mediaName;
	/** ��ĿӢ������ */
	private String mediaNameEn;
	/** ��� */
	private String year;
	/** �������ʼ�� */
	private String year1;
	/** ����������� */
	private String year2;
	/** ���� */
	private String director;
	/** ��Ա */
	private String actor;
	/** ��� */
	private String introduction;
	/** ���� */
	private Integer grade;
	/** ���֣���ʼ�� */
	private Integer grade1;
	/** ���֣������� */
	private Integer grade2;
	/** ��Ч���� */
	private String endDate;
	/** ��Ŀ���״̬ */
	private String checkType;
	/** ��Ŀ�������� */
	private String serviceType;
	/** ��ƵԴ���� */
	private String sourceLink;
	/** ��ѡ��ť��ʾ */
	private Integer radioCheck;
	/** ���������ʾ��ʾ */
	private boolean resultFlag;
	/** ������� */
	private List<MediaDetil> resultList;
	/** Ŀ¼�������б� */
	private List<LabelValueIntBean> catalogList = new ArrayList<LabelValueIntBean>();
	/** ���Ե������б� */
	private List<LabelValueIntBean> languageList = new ArrayList<LabelValueIntBean>();
	/** �����������б� */
	private List<LabelValueIntBean> areaList = new ArrayList<LabelValueIntBean>();
	/** ��Ŀ���״̬�������б� */
	private List<LabelValueStrBean> typeList = new ArrayList<LabelValueStrBean>();
	/** ��ǰҳ�� */
	private Integer currentPage;
	/** ��ҳ�� */
	private Integer pageCount;
	/** ����������� */
	private Integer resultCount;
	/** ��ƵԴ�����б� */
	private List<SubMediaSource> subMediaSourceList = new ArrayList<SubMediaSource>();

	public void copy(MediaForm meidiaForm) {
		this.areaList.addAll(meidiaForm.getAreaList());
		this.languageList.addAll(meidiaForm.getLanguageList());
		this.catalogList.addAll(meidiaForm.getCatalogList());
	}

	public void initView(boolean resultFlag) {
		// ��Ŀ��״̬
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_1, "1"));
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_2, "2"));
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_3, "3"));
		// ���������ʾ��ʾ
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