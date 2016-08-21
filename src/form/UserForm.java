package form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dao.model.Account;
import util.Contants;

public class UserForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	/** �û�id */
	private Integer id;
	/** �û�id(��ʼ) */
	private Integer id1;
	/** �û�id(����) */
	private Integer id2;
	/** �û���� */
	private String name;
	/** �û����� */
	private String pwd;
	/** �û����� */
	private Integer age;
	/** �û��绰 */
	private String phone;
	/** �û�סַ */
	private String address;
	/** �û�״̬ */
	private Integer state;
	/** �û����� */
	private Integer type;
	/** �û�����ʣ������ʼ�� */
	private String restDay1;
	/** �û�����ʣ��������� */
	private String restDay2;
	/** �û�����ʣ������ */
	private String restDay;
	/** �û�������� */
	private Integer group;
	/** �û�������Σ���ʼ�� */
	private Integer group1;
	/** �û�������Σ����� */
	private Integer group2;
	/** �û���ע */
	private String comment;
	/** �û��ĳ�ֵ����Ϣ */
	private List<CardForm> cards = new ArrayList<CardForm>();
	/** ���������ʾ��ʾ */
	private boolean resultFlag;
	/** ������� */
	private List<UserDetil> resultList;
	private List<Account> accountList;
	/** �û���״̬�������б? */
	private List<LabelValueIntBean> stateList = new ArrayList<LabelValueIntBean>();
	/** �û������ͣ������б? */
	private List<LabelValueIntBean> typeList = new ArrayList<LabelValueIntBean>();
	/** ��ǰҳ�� */
	private Integer currentPage;
	/** ��ҳ�� */
	private Integer pageCount;
	/** ����������� */
	private Integer resultCount;

	public void initView(boolean resultFlag) {
		// �û���״̬
		this.stateList.add(new LabelValueIntBean(Contants.USER_STATE_1, 1));
		this.stateList.add(new LabelValueIntBean(Contants.USER_STATE_2, 2));
		// �û�������
		this.typeList.add(new LabelValueIntBean(Contants.USER_TYPE_1, 1));
		this.typeList.add(new LabelValueIntBean(Contants.USER_TYPE_2, 2));
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the group
	 */
	public Integer getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(Integer group) {
		this.group = group;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the cards
	 */
	public List<CardForm> getCards() {
		return cards;
	}

	/**
	 * @param cards
	 *            the cards to set
	 */
	public void setCards(List<CardForm> cards) {
		this.cards = cards;
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
	 * @return the typeList
	 */
	public List<LabelValueIntBean> getTypeList() {
		return typeList;
	}

	/**
	 * @param typeList
	 *            the typeList to set
	 */
	public void setTypeList(List<LabelValueIntBean> typeList) {
		this.typeList = typeList;
	}

	/**
	 * @return the resultList
	 */
	public List<UserDetil> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<UserDetil> resultList) {
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
	 * @return the group1
	 */
	public Integer getGroup1() {
		return group1;
	}

	/**
	 * @param group1
	 *            the group1 to set
	 */
	public void setGroup1(Integer group1) {
		this.group1 = group1;
	}

	/**
	 * @return the group2
	 */
	public Integer getGroup2() {
		return group2;
	}

	/**
	 * @param group2
	 *            the group2 to set
	 */
	public void setGroup2(Integer group2) {
		this.group2 = group2;
	}

	/**
	 * @return the restDay1
	 */
	public String getRestDay1() {
		return restDay1;
	}

	/**
	 * @param restDay1
	 *            the restDay1 to set
	 */
	public void setRestDay1(String restDay1) {
		this.restDay1 = restDay1;
	}

	/**
	 * @return the restDay2
	 */
	public String getRestDay2() {
		return restDay2;
	}

	/**
	 * @param restDay2
	 *            the restDay2 to set
	 */
	public void setRestDay2(String restDay2) {
		this.restDay2 = restDay2;
	}

	/**
	 * @return the restDay
	 */
	public String getRestDay() {
		return restDay;
	}

	/**
	 * @param restDay
	 *            the restDay to set
	 */
	public void setRestDay(String restDay) {
		this.restDay = restDay;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

}
