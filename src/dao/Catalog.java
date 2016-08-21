package dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Catalog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable, Comparable<Catalog> {

	// Fields

	private Integer catalogId;
	private Catalog catalog;
	private String catalogZhName;
	private String catalogEnName;
	private Integer order1;
	private Set<Catalog> catalogs = new HashSet<Catalog>(0);
	private Set<MediaCatalog> mediaCatalogs = new HashSet<MediaCatalog>(0);

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** minimal constructor */
	public Catalog(Integer catalogId, String catalogZhName,
			String catalogEnName, Integer order1) {
		this.catalogId = catalogId;
		this.catalogZhName = catalogZhName;
		this.catalogEnName = catalogEnName;
		this.order1 = order1;
	}

	/** full constructor */
	public Catalog(Integer catalogId, Catalog catalog, String catalogZhName,
			String catalogEnName, Integer order1, Set catalogs,
			Set mediaCatalogs) {
		this.catalogId = catalogId;
		this.catalog = catalog;
		this.catalogZhName = catalogZhName;
		this.catalogEnName = catalogEnName;
		this.order1 = order1;
		this.catalogs = catalogs;
		this.mediaCatalogs = mediaCatalogs;
	}

	// Property accessors

	public Integer getCatalogId() {
		return this.catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public String getCatalogZhName() {
		return this.catalogZhName;
	}

	public void setCatalogZhName(String catalogZhName) {
		this.catalogZhName = catalogZhName;
	}

	public String getCatalogEnName() {
		return this.catalogEnName;
	}

	public void setCatalogEnName(String catalogEnName) {
		this.catalogEnName = catalogEnName;
	}

	public Integer getOrder1() {
		return this.order1;
	}

	public void setOrder1(Integer order1) {
		this.order1 = order1;
	}

	public Set<Catalog> getCatalogs() {
		return this.catalogs;
	}

	public void setCatalogs(Set<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public Set<MediaCatalog> getMediaCatalogs() {
		return this.mediaCatalogs;
	}

	public void setMediaCatalogs(Set<MediaCatalog> mediaCatalogs) {
		this.mediaCatalogs = mediaCatalogs;
	}

	public int compareTo(Catalog o) {
		if (this.getOrder1() > o.getOrder1()) {
			return -1;
		} else if (this.getOrder1() == o.getOrder1()) {
			return 0;
		} else {
			return 1;
		}
	}
}