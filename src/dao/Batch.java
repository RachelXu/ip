package dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Batch entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Batch implements java.io.Serializable {

	// Fields

	private Integer batchId;
	private String batchState;
	private String batchDate;
	private Set cards = new HashSet(0);

	// Constructors

	/** default constructor */
	public Batch() {
	}

	/** minimal constructor */
	public Batch(Integer batchId, String batchState) {
		this.batchId = batchId;
		this.batchState = batchState;
	}

	/** full constructor */
	public Batch(Integer batchId, String batchState, String batchDate, Set cards) {
		this.batchId = batchId;
		this.batchState = batchState;
		this.batchDate = batchDate;
		this.cards = cards;
	}

	// Property accessors

	public Integer getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getBatchState() {
		return this.batchState;
	}

	public void setBatchState(String batchState) {
		this.batchState = batchState;
	}

	public String getBatchDate() {
		return this.batchDate;
	}

	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}

	public Set getCards() {
		return this.cards;
	}

	public void setCards(Set cards) {
		this.cards = cards;
	}

}