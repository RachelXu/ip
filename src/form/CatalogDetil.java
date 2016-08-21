package form;

import java.io.Serializable;

public class CatalogDetil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3693600896480176941L;
	/** 目录id */
	private Integer catalogId;
	/** 目录中文名 */
	private String catalogZhName;
	/** 目录英文名 */
	private String catalogEnName;
	/** 显示顺序 */
	private Integer order;

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
	 * @return the catalogZhName
	 */
	public String getCatalogZhName() {
		return catalogZhName;
	}

	/**
	 * @param catalogZhName
	 *            the catalogZhName to set
	 */
	public void setCatalogZhName(String catalogZhName) {
		this.catalogZhName = catalogZhName;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * @return the catalogEnName
	 */
	public String getCatalogEnName() {
		return catalogEnName;
	}

	/**
	 * @param catalogEnName
	 *            the catalogEnName to set
	 */
	public void setCatalogEnName(String catalogEnName) {
		this.catalogEnName = catalogEnName;
	}

}
