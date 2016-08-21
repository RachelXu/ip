package form;

import java.io.Serializable;
import java.util.List;

import dao.ServiecType;

public class ServiceForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	/** 服务套餐ID */
	private Integer serviceId;
	/** 服务套餐名称 */
	private String serviceName;
	/** 服务天数 */
	private Integer serviceDay;
	/** 检索结果显示标示 */
	private boolean resultFlag;
	/** 检索结果 */
	private List<ServiecType> resultList;
	/** 当前页码 */
	private Integer currentPage;
	/** 总页码 */
	private Integer pageCount;
	/** 检索结果总数 */
	private Integer resultCount;

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the serviceDay
	 */
	public Integer getServiceDay() {
		return serviceDay;
	}

	/**
	 * @param serviceDay
	 *            the serviceDay to set
	 */
	public void setServiceDay(Integer serviceDay) {
		this.serviceDay = serviceDay;
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
	public List<ServiecType> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<ServiecType> resultList) {
		this.resultList = resultList;
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
	 * @return the serviceId
	 */
	public Integer getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId
	 *            the serviceId to set
	 */
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

}