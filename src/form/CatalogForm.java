package form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dao.Catalog;

public class CatalogForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1564248494271508985L;
	/** 目录id */
	private Integer catalogId;
	/** 上级目录 */
	private Catalog catalog;
	/** 目录中文名 */
	private String catalogZhName;
	/** 目录英文名 */
	private String catalogEnName;
	/** 显示顺序 */
	private Integer order;
	/** 上级目录id */
	private Integer superId;
	/** 检索结果 */
	private List<CatalogDetil> resultList = new ArrayList<CatalogDetil>();;
	/** 第一级列表（下拉列表） */
	private List<LabelValueIntBean> firstLeveList = new ArrayList<LabelValueIntBean>();
	/** 第二级列表标签 */
	private List<String> secondLabel = new ArrayList<String>();
	/** 第二级列表（下拉列表） */
	private List<List<LabelValueIntBean>> sencondLeveList = new ArrayList<List<LabelValueIntBean>>();
	/** 检索结果显示标示 */
	private boolean resultFlag;

	public void copy(CatalogForm form) {
		this.setResultFlag(form.isResultFlag());
		this.resultList.addAll(form.getResultList());
		this.firstLeveList.addAll(form.getFirstLeveList());
		this.secondLabel.addAll(form.getSecondLabel());
		this.sencondLeveList.addAll(form.getSencondLeveList());
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
	 * @return the catalog
	 */
	public Catalog getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog
	 *            the catalog to set
	 */
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
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
	 * @return the resultList
	 */
	public List<CatalogDetil> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<CatalogDetil> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the firstLeveList
	 */
	public List<LabelValueIntBean> getFirstLeveList() {
		return firstLeveList;
	}

	/**
	 * @param firstLeveList
	 *            the firstLeveList to set
	 */
	public void setFirstLeveList(List<LabelValueIntBean> firstLeveList) {
		this.firstLeveList = firstLeveList;
	}

	/**
	 * @return the secondLabel
	 */
	public List<String> getSecondLabel() {
		return secondLabel;
	}

	/**
	 * @param secondLabel
	 *            the secondLabel to set
	 */
	public void setSecondLabel(List<String> secondLabel) {
		this.secondLabel = secondLabel;
	}

	/**
	 * @return the sencondLeveList
	 */
	public List<List<LabelValueIntBean>> getSencondLeveList() {
		return sencondLeveList;
	}

	/**
	 * @param sencondLeveList
	 *            the sencondLeveList to set
	 */
	public void setSencondLeveList(List<List<LabelValueIntBean>> sencondLeveList) {
		this.sencondLeveList = sencondLeveList;
	}

	/**
	 * @return the superId
	 */
	public Integer getSuperId() {
		return superId;
	}

	/**
	 * @param superId
	 *            the superId to set
	 */
	public void setSuperId(Integer superId) {
		this.superId = superId;
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

}
