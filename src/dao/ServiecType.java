package dao;

import java.util.HashSet;
import java.util.Set;

/**
 * ServiecType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ServiecType implements java.io.Serializable {

	// Fields

	private Integer serviceId;
	private String serviceName;
	private Integer serviceDay;
	private Set cards = new HashSet(0);

	// Constructors

	/** default constructor */
	public ServiecType() {
	}

	/** minimal constructor */
	public ServiecType(Integer serviceId, String serviceName, Integer serviceDay) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDay = serviceDay;
	}

	/** full constructor */
	public ServiecType(Integer serviceId, String serviceName,
			Integer serviceDay, Set cards) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDay = serviceDay;
		this.cards = cards;
	}

	// Property accessors

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getServiceDay() {
		return this.serviceDay;
	}

	public void setServiceDay(Integer serviceDay) {
		this.serviceDay = serviceDay;
	}

	public Set getCards() {
		return this.cards;
	}

	public void setCards(Set cards) {
		this.cards = cards;
	}

}