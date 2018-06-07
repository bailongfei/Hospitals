package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Outhospital entity. @author MyEclipse Persistence Tools
 */

public class Outhospital implements java.io.Serializable {

	// Fields

	private Integer outhospitalid;
	private Outhosstate outhosstate;
	private Patient patient;
	private Integer stuffid2;
	private Date outhospitaldate;
	private Integer budgetstate;
	private String outhospnode;
	private Set patients = new HashSet(0);
	private Set outhosstates = new HashSet(0);

	// Constructors

	/** default constructor */
	public Outhospital() {
	}

	/** full constructor */
	public Outhospital(Outhosstate outhosstate, Patient patient, Integer stuffid2, Date outhospitaldate,
			Integer budgetstate, String outhospnode, Set patients, Set outhosstates) {
		this.outhosstate = outhosstate;
		this.patient = patient;
		this.stuffid2 = stuffid2;
		this.outhospitaldate = outhospitaldate;
		this.budgetstate = budgetstate;
		this.outhospnode = outhospnode;
		this.patients = patients;
		this.outhosstates = outhosstates;
	}

	// Property accessors

	public Integer getOuthospitalid() {
		return this.outhospitalid;
	}

	public void setOuthospitalid(Integer outhospitalid) {
		this.outhospitalid = outhospitalid;
	}

	public Outhosstate getOuthosstate() {
		return this.outhosstate;
	}

	public void setOuthosstate(Outhosstate outhosstate) {
		this.outhosstate = outhosstate;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getStuffid2() {
		return this.stuffid2;
	}

	public void setStuffid2(Integer stuffid2) {
		this.stuffid2 = stuffid2;
	}

	public Date getOuthospitaldate() {
		return this.outhospitaldate;
	}

	public void setOuthospitaldate(Date outhospitaldate) {
		this.outhospitaldate = outhospitaldate;
	}

	public Integer getBudgetstate() {
		return this.budgetstate;
	}

	public void setBudgetstate(Integer budgetstate) {
		this.budgetstate = budgetstate;
	}

	public String getOuthospnode() {
		return this.outhospnode;
	}

	public void setOuthospnode(String outhospnode) {
		this.outhospnode = outhospnode;
	}

	public Set getPatients() {
		return this.patients;
	}

	public void setPatients(Set patients) {
		this.patients = patients;
	}

	public Set getOuthosstates() {
		return this.outhosstates;
	}

	public void setOuthosstates(Set outhosstates) {
		this.outhosstates = outhosstates;
	}

}