package com.aaa.entity;

import java.util.Date;

/**
 * Watebill entity. @author MyEclipse Persistence Tools
 */

public class Watebill implements java.io.Serializable {

	// Fields

	private Integer billid;
	private Integer adviceid;
	private Integer accountid;
	private Date billdate;
	private String billexecutor;
	private String billcondition;

	// Constructors

	/** default constructor */
	public Watebill() {
	}

	/** full constructor */
	public Watebill(Integer adviceid, Integer accountid, Date billdate, String billexecutor, String billcondition) {
		this.adviceid = adviceid;
		this.accountid = accountid;
		this.billdate = billdate;
		this.billexecutor = billexecutor;
		this.billcondition = billcondition;
	}

	// Property accessors

	public Integer getBillid() {
		return this.billid;
	}

	public void setBillid(Integer billid) {
		this.billid = billid;
	}

	public Integer getAdviceid() {
		return this.adviceid;
	}

	public void setAdviceid(Integer adviceid) {
		this.adviceid = adviceid;
	}

	public Integer getAccountid() {
		return this.accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Date getBilldate() {
		return this.billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public String getBillexecutor() {
		return this.billexecutor;
	}

	public void setBillexecutor(String billexecutor) {
		this.billexecutor = billexecutor;
	}

	public String getBillcondition() {
		return this.billcondition;
	}

	public void setBillcondition(String billcondition) {
		this.billcondition = billcondition;
	}

}