package com.aaa.entity;

import java.util.Date;

/**
 * Accounts entity. @author MyEclipse Persistence Tools
 */

public class Accounts implements java.io.Serializable {

	// Fields

	private Integer accountid;
	private Patient patient;
	private Double balance;
	private Date zhdate;
	private String zhState;
	private String zhperson;
	private String zhway;

	// Constructors

	/** default constructor */
	public Accounts() {
	}

	/** full constructor */
	public Accounts(Patient patient, Double balance, Date zhdate, String zhState, String zhperson, String zhway) {
		this.patient = patient;
		this.balance = balance;
		this.zhdate = zhdate;
		this.zhState = zhState;
		this.zhperson = zhperson;
		this.zhway = zhway;
	}

	// Property accessors

	public Integer getAccountid() {
		return this.accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getZhdate() {
		return this.zhdate;
	}

	public void setZhdate(Date zhdate) {
		this.zhdate = zhdate;
	}

	public String getZhState() {
		return this.zhState;
	}

	public void setZhState(String zhState) {
		this.zhState = zhState;
	}

	public String getZhperson() {
		return this.zhperson;
	}

	public void setZhperson(String zhperson) {
		this.zhperson = zhperson;
	}

	public String getZhway() {
		return this.zhway;
	}

	public void setZhway(String zhway) {
		this.zhway = zhway;
	}

}