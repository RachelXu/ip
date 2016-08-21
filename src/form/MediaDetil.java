package form;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import dao.SubMediaSource;

public class MediaDetil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -905740278451152166L;
	/** 节目ID */
	private Integer mediaId;
	/** 目录ID */
	private Integer catalogId;
	/** 语言 */
	private String language;
	/** 地区 */
	private String area;
	/** 节目中文名称 */
	private String mediaName;
	/** 节目英文名称 */
	private String mediaNameEn;
	/** 年代 */
	private String year;
	/** 导演 */
	private String director;
	/** 演员 */
	private String actor;
	/** 简介 */
	private String introduction;
	/** 评分 */
	private Integer grade;
	/** 图片 */
	private String pic;
	/** 链接 */
	private String link;
	/** 链接集合 */
	private Set<SubMediaSource> subMediaSources = new HashSet<SubMediaSource>(0);
	/** 行号 */
	private Integer row;
	/** 错误信息 */
	private String errorMessage;

	private String deleteCkeck;

	public MediaDetil(Integer row, String errorMessage) {
		super();
		this.row = row;
		this.errorMessage = errorMessage;
	}

	public MediaDetil() {

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
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(String area) {
		this.area = area;
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
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * @param pic
	 *            the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * @return the subMediaSources
	 */
	public Set<SubMediaSource> getSubMediaSources() {
		return subMediaSources;
	}

	/**
	 * @param subMediaSources
	 *            the subMediaSources to set
	 */
	public void setSubMediaSources(Set<SubMediaSource> subMediaSources) {
		this.subMediaSources = subMediaSources;
	}

	/**
	 * @return the row
	 */
	public Integer getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(Integer row) {
		this.row = row;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the deleteCkeck
	 */
	public String getDeleteCkeck() {
		return deleteCkeck;
	}

	/**
	 * @param deleteCkeck
	 *            the deleteCkeck to set
	 */
	public void setDeleteCkeck(String deleteCkeck) {
		this.deleteCkeck = deleteCkeck;
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
	 * @return the catalogId
	 */
	public Integer getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId
	 *            the catalogId to set
	 */
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

}
