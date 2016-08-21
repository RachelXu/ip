package dao;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String pwd;
	private Integer age;
	private String phone;
	private String address;
	private Integer state;
	private Integer type;
	private Integer pici;
	private String comment;
	private Integer restDay;
	private Set cards = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public User(Integer id, String name, String pwd, Integer age, String phone,
			String address, Integer state, Integer type, Integer pici,
			String comment, Integer restDay, Set cards) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.state = state;
		this.type = type;
		this.pici = pici;
		this.comment = comment;
		this.restDay = restDay;
		this.cards = cards;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPici() {
		return this.pici;
	}

	public void setPici(Integer pici) {
		this.pici = pici;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set getCards() {
		return this.cards;
	}

	public void setCards(Set cards) {
		this.cards = cards;
	}

	public Integer getRestDay() {
		return this.restDay;
	}

	public void setRestDay(Integer restDay) {
		this.restDay = restDay;
	}

}