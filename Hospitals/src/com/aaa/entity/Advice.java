package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Advice entity. @author MyEclipse Persistence Tools
 */

public class Advice implements java.io.Serializable {

	// Fields

	private Integer adviceid;
	private Stuff stuff;
	private Patient patient;
	private Yzmoid yzmoid;
	private Date beginTime;
	private Date outtime;
	private Double totalprice;
	private String context;
	private Integer adstate;
	private Set adviceinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Advice() {
	}

	/** full constructor */
	public Advice(Stuff stuff, Patient patient, Yzmoid yzmoid, Date beginTime, Date outtime, Double totalprice,
			String context, Integer adstate, Set adviceinfos) {
		this.stuff = stuff;
		this.patient = patient;
		this.yzmoid = yzmoid;
		this.beginTime = beginTime;
		this.outtime = outtime;
		this.totalprice = totalprice;
		this.context = context;
		this.adstate = adstate;
		this.adviceinfos = adviceinfos;
	}

	// Property accessors

	public Integer getAdviceid() {
		return this.adviceid;
	}

	public void setAdviceid(Integer adviceid) {
		this.adviceid = adviceid;
	}

	public Stuff getStuff() {
		return this.stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Yzmoid getYzmoid() {
		return this.yzmoid;
	}

	public void setYzmoid(Yzmoid yzmoid) {
		this.yzmoid = yzmoid;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getOuttime() {
		return this.outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getAdstate() {
		return this.adstate;
	}

	public void setAdstate(Integer adstate) {
		this.adstate = adstate;
	}

	public Set getAdviceinfos() {
		return this.adviceinfos;
	}

	public void setAdviceinfos(Set adviceinfos) {
		this.adviceinfos = adviceinfos;
	}

}