package dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Language entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Language implements java.io.Serializable {

	// Fields

	private Integer languageId;
	private String languageName;
	private Set<MediaDesc> mediaDescs = new HashSet<MediaDesc>(0);

	// Constructors

	/** default constructor */
	public Language() {
	}

	/** minimal constructor */
	public Language(Integer languageId, String languageName) {
		this.languageId = languageId;
		this.languageName = languageName;
	}

	/** full constructor */
	public Language(Integer languageId, String languageName, Set mediaDescs) {
		this.languageId = languageId;
		this.languageName = languageName;
		this.mediaDescs = mediaDescs;
	}

	// Property accessors

	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Set<MediaDesc> getMediaDescs() {
		return this.mediaDescs;
	}

	public void setMediaDescs(Set<MediaDesc> mediaDescs) {
		this.mediaDescs = mediaDescs;
	}

}