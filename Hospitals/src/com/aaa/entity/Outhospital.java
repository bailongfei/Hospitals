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
	private Stuff stuff;
	private Outhosstate outhosstate;
	private Patient patient;
	private Date outhospitaldate;
	private Integer budgetstate;
	private String outhospnode;
	private Set outhosstates = new HashSet(0);

	// Constructors

	/** default constructor */
	public Outhospital() {
	}

	/** full constructor */
	public Outhospital(Stuff stuff, Outhosstate outhosstate, Patient patient, Date outhospitaldate, Integer budgetstate,
			String outhospnode, Set outhosstates) {
		this.stuff = stuff;
		this.outhosstate = outhosstate;
		this.patient = patient;
		this.outhospitaldate = outhospitaldate;
		this.budgetstate = budgetstate;
		this.outhospnode = outhospnode;
		this.outhosstates = outhosstates;
	}

	// Property accessors

	public Integer getOuthospitalid() {
		return this.outhospitalid;
	}

	public void setOuthospitalid(Integer outhospitalid) {
		this.outhospitalid = outhospitalid;
	}

	public Stuff getStuff() {
		return this.stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
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

	public Set getOuthosstates() {
		return this.outhosstates;
	}

	public void setOuthosstates(Set outhosstates) {
		this.outhosstates = outhosstates;
	}

}