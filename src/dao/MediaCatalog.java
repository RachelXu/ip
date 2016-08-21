package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MediaCatalog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MediaCatalog implements java.io.Serializable {

	// Fields

	private Integer mediaCatalogId;
	private String mediaCatalogName;
	private String catalogEnName;
	private Date updateTstamp;
	private String pic;
	private Set<MediaDesc> mediaDescs = new HashSet<MediaDesc>(0);
	private Set<Catalog> catalogs = new HashSet<Catalog>(0);

	// Constructors

	/** default constructor */
	public MediaCatalog() {
	}

	/** minimal constructor */
	public MediaCatalog(Integer mediaCatalogId, String mediaCatalogName,
			String catalogEnName) {
		this.mediaCatalogId = mediaCatalogId;
		this.mediaCatalogName = mediaCatalogName;
		this.catalogEnName = catalogEnName;
	}

	/** full constructor */
	public MediaCatalog(Integer mediaCatalogId, String mediaCatalogName,
			String catalogEnName, Date updateTstamp, String pic,
			Set mediaDescs, Set catalogs) {
		this.mediaCatalogId = mediaCatalogId;
		this.mediaCatalogName = mediaCatalogName;
		this.catalogEnName = catalogEnName;
		this.updateTstamp = updateTstamp;
		this.pic = pic;
		this.mediaDescs = mediaDescs;
		this.catalogs = catalogs;
	}

	// Property accessors

	public Integer getMediaCatalogId() {
		return this.mediaCatalogId;
	}

	public void setMediaCatalogId(Integer mediaCatalogId) {
		this.mediaCatalogId = mediaCatalogId;
	}

	public String getMediaCatalogName() {
		return this.mediaCatalogName;
	}

	public void setMediaCatalogName(String mediaCatalogName) {
		this.mediaCatalogName = mediaCatalogName;
	}

	public String getCatalogEnName() {
		return this.catalogEnName;
	}

	public void setCatalogEnName(String catalogEnName) {
		this.catalogEnName = catalogEnName;
	}

	public Date getUpdateTstamp() {
		return this.updateTstamp;
	}

	public void setUpdateTstamp(Date updateTstamp) {
		this.updateTstamp = updateTstamp;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Set<MediaDesc> getMediaDescs() {
		return this.mediaDescs;
	}

	public void setMediaDescs(Set<MediaDesc> mediaDescs) {
		this.mediaDescs = mediaDescs;
	}

	public Set<Catalog> getCatalogs() {
		return this.catalogs;
	}

	public void setCatalogs(Set<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

}