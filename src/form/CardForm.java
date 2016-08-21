package form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Contants;
import dao.Card;

public class CardForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1819300729584227725L;
	/** ��ֵ��id */
	private Integer id;
	/** ��ֵ��id(��ʼ) */
	private Integer id1;
	/** ��ֵ��id(����) */
	private Integer id2;
	/** �û��� */
	private String userName;
	/** ��ֵ������ */
	private String pwd;
	/** ��ֵ��״̬ */
	private Integer state;
	/** �����ײ����� */
	private Integer service;
	/** ��ֵʱ�� */
	private Integer day;
	/** ��ֵʱ������ʼ�� */
	private Integer day1;
	/** ��ֵʱ���������� */
	private Integer day2;
	/** ��ֹʱ�� */
	private String enddate;
	/** ��ֹʱ�䣨��ʼ�� */
	private String enddate1;
	/** ��ֹʱ�䣨������ */
	private String enddate2;
	/** ��ֵʱ�� */
	private String chargedate;
	/** ��ֵʱ�䣨��ʼ�� */
	private String chargedate1;
	/** ��ֵʱ�䣨������ */
	private String chargedate2;
	/** ���������ʾ��ʾ */
	private boolean resultFlag;
	/** ��ֵ����״̬�������б� */
	private List<LabelValueIntBean> stateList = new ArrayList<LabelValueIntBean>();
	/** ��ֵ���ķ����ײͣ������б� */
	private List<LabelValueIntBean> serviceList = new ArrayList<LabelValueIntBean>();
	/** ��ǰҳ�� */
	private Integer currentPage;
	/** ��ҳ�� */
	private Integer pageCount;
	/** ����������� */
	private Integer resultCount;
	/** ������� */
	private List<CardDetil> resultList;
	/** ���ɳ�ֵ������ */
	private Integer productNum;
	/** ���α�� */
	private Integer batchNum;
	/** ���ؽ�� */
	private List<Card> downloadList;

	public void copy(CardForm meidiaForm) {
		this.serviceList.addAll(meidiaForm.getServiceList());
	}

	public void initView(boolean resultFlag) {

		// ��ֵ����״̬
		this.stateList.add(new LabelValueIntBean(Contants.CARD_STATE_1, 1));
		this.stateList.add(new LabelValueIntBean(Contants.CARD_STATE_2, 2));
		this.stateList.add(new LabelValueIntBean(Contants.CARD_STATE_3, 3));
		// ���������ʾ��ʾ
		this.resultFlag = resultFlag;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @return the day
	 */
	public Integer getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(Integer day) {
		this.day = day;
	}

	/**
	 * @return the day1
	 */
	public Integer getDay1() {
		return day1;
	}

	/**
	 * @param day1
	 *            the day1 to set
	 */
	public void setDay1(Integer day1) {
		this.day1 = day1;
	}

	/**
	 * @return the day2
	 */
	public Integer getDay2() {
		return day2;
	}

	/**
	 * @param day2
	 *            the day2 to set
	 */
	public void setDay2(Integer day2) {
		this.day2 = day2;
	}

	/**
	 * @return the enddate
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * @param enddate
	 *            the enddate to set
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * @return the enddate1
	 */
	public String getEnddate1() {
		return enddate1;
	}

	/**
	 * @param enddate1
	 *            the enddate1 to set
	 */
	public void setEnddate1(String enddate1) {
		this.enddate1 = enddate1;
	}

	/**
	 * @return the enddate2
	 */
	public String getEnddate2() {
		return enddate2;
	}

	/**
	 * @param enddate2
	 *            the enddate2 to set
	 */
	public void setEnddate2(String enddate2) {
		this.enddate2 = enddate2;
	}

	/**
	 * @return the chargedate
	 */
	public String getChargedate() {
		return chargedate;
	}

	/**
	 * @param chargedate
	 *            the chargedate to set
	 */
	public void setChargedate(String chargedate) {
		this.chargedate = chargedate;
	}

	/**
	 * @return the chargedate1
	 */
	public String getChargedate1() {
		return chargedate1;
	}

	/**
	 * @param chargedate1
	 *            the chargedate1 to set
	 */
	public void setChargedate1(String chargedate1) {
		this.chargedate1 = chargedate1;
	}

	/**
	 * @return the chargedate2
	 */
	public String getChargedate2() {
		return chargedate2;
	}

	/**
	 * @param chargedate2
	 *            the chargedate2 to set
	 */
	public void setChargedate2(String chargedate2) {
		this.chargedate2 = chargedate2;
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
	 * @return the stateList
	 */
	public List<LabelValueIntBean> getStateList() {
		return stateList;
	}

	/**
	 * @param stateList
	 *            the stateList to set
	 */
	public void setStateList(List<LabelValueIntBean> stateList) {
		this.stateList = stateList;
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
	 * @return the resultList
	 */
	public List<CardDetil> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<CardDetil> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the id1
	 */
	public Integer getId1() {
		return id1;
	}

	/**
	 * @param id1
	 *            the id1 to set
	 */
	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	/**
	 * @return the id2
	 */
	public Integer getId2() {
		return id2;
	}

	/**
	 * @param id2
	 *            the id2 to set
	 */
	public void setId2(Integer id2) {
		this.id2 = id2;
	}

	/**
	 * @return the serviceList
	 */
	public List<LabelValueIntBean> getServiceList() {
		return serviceList;
	}

	/**
	 * @param serviceList
	 *            the serviceList to set
	 */
	public void setServiceList(List<LabelValueIntBean> serviceList) {
		this.serviceList = serviceList;
	}

	/**
	 * @return the service
	 */
	public Integer getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(Integer service) {
		this.service = service;
	}

	/**
	 * @return the productNum
	 */
	public Integer getProductNum() {
		return productNum;
	}

	/**
	 * @param productNum
	 *            the productNum to set
	 */
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	/**
	 * @return the batchNum
	 */
	public Integer getBatchNum() {
		return batchNum;
	}

	/**
	 * @param batchNum
	 *            the batchNum to set
	 */
	public void setBatchNum(Integer batchNum) {
		this.batchNum = batchNum;
	}

	/**
	 * @return the downloadList
	 */
	public List<Card> getDownloadList() {
		return downloadList;
	}

	/**
	 * @param downloadList
	 *            the downloadList to set
	 */
	public void setDownloadList(List<Card> downloadList) {
		this.downloadList = downloadList;
	}

}
