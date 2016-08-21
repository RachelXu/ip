package dao;

import java.util.HashSet;
import java.util.Set;

/**
 * MediaDesc entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MediaDesc implements java.io.Serializable {

	// Fields

	private Integer mediaId;
	private MediaCatalog mediaCatalog;
	private Language language;
	private Area area;
	private String mediaName;
	private String year;
	private String director;
	private String actor;
	private String introduction;
	private Integer grade;
	private String pic;
	private String checkType;
	private String checkDate;
	private String endDate;
	private String vipState;
	private Set<SubMediaSource> subMediaSources = new HashSet(0);

	// Constructors

	/** default constructor */
	public MediaDesc() {
	}

	/** minimal constructor */
	public MediaDesc(Integer mediaId, MediaCatalog mediaCatalog,
			String mediaName, String checkType) {
		this.mediaId = mediaId;
		this.mediaCatalog = mediaCatalog;
		this.mediaName = mediaName;
		this.checkType = checkType;
	}

	/** full constructor */
	public MediaDesc(Integer mediaId, MediaCatalog mediaCatalog,
			Language language, Area area, String mediaName, String year,
			String director, String actor, String introduction, Integer grade,
			String pic, String checkType, String checkDate, String endDate,
			Set subMediaSources) {
		this.mediaId = mediaId;
		this.mediaCatalog = mediaCatalog;
		this.language = language;
		this.area = area;
		this.mediaName = mediaName;
		this.year = year;
		this.director = director;
		this.actor = actor;
		this.introduction = introduction;
		this.grade = grade;
		this.pic = pic;
		this.checkType = checkType;
		this.checkDate = checkDate;
		this.endDate = endDate;
		this.vipState = vipState;
		this.subMediaSources = subMediaSources;
	}

	// Property accessors

	public Integer getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	public MediaCatalog getMediaCatalog() {
		return this.mediaCatalog;
	}

	public void setMediaCatalog(MediaCatalog mediaCatalog) {
		this.mediaCatalog = mediaCatalog;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getMediaName() {
		return this.mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Set<SubMediaSource> getSubMediaSources() {
		return this.subMediaSources;
	}

	public void setSubMediaSources(Set<SubMediaSource> subMediaSources) {
		this.subMediaSources = subMediaSources;
	}

	public String getCheckType() {
		return this.checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getVipState() {
		return this.vipState;
	}

	public void setVipState(String vipState) {
		this.vipState = vipState;
	}
}