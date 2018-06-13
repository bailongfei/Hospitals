package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Cure entity. @author MyEclipse Persistence Tools
 */

public class Cure implements java.io.Serializable {

	// Fields

	private Integer cureId;
	private Patients patients;
	private String cureName;
	private String monad;
	private Integer price;
	private Integer count;
	private Integer countMoney;
	private Integer state;
	private Set treatments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cure() {
	}

	/** full constructor */
	public Cure(Patients patients, String cureName, String monad, Integer price, Integer count, Integer countMoney,
			Integer state, Set treatments) {
		this.patients = patients;
		this.cureName = cureName;
		this.monad = monad;
		this.price = price;
		this.count = count;
		this.countMoney = countMoney;
		this.state = state;
		this.treatments = treatments;
	}

	// Property accessors

	public Integer getCureId() {
		return this.cureId;
	}

	public void setCureId(Integer cureId) {
		this.cureId = cureId;
	}

	public Patients getPatients() {
		return this.patients;
	}

	public void setPatients(Patients patients) {
		this.patients = patients;
	}

	public String getCureName() {
		return this.cureName;
	}

	public void setCureName(String cureName) {
		this.cureName = cureName;
	}

	public String getMonad() {
		return this.monad;
	}

	public void setMonad(String monad) {
		this.monad = monad;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCountMoney() {
		return this.countMoney;
	}

	public void setCountMoney(Integer countMoney) {
		this.countMoney = countMoney;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getTreatments() {
		return this.treatments;
	}

	public void setTreatments(Set treatments) {
		this.treatments = treatments;
	}

}