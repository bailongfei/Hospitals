package com.aaa.entity;

import java.util.Date;

/**
 * Nurworklog entity. @author MyEclipse Persistence Tools
 */

public class Nurworklog implements java.io.Serializable {

	// Fields

	private Integer nurWorkLogid;
	private NurseWatch nurseWatch;
	private Date workdate;
	private String workcontent;
	private String remark;

	// Constructors

	/** default constructor */
	public Nurworklog() {
	}

	/** full constructor */
	public Nurworklog(NurseWatch nurseWatch, Date workdate, String workcontent, String remark) {
		this.nurseWatch = nurseWatch;
		this.workdate = workdate;
		this.workcontent = workcontent;
		this.remark = remark;
	}

	// Property accessors

	public Integer getNurWorkLogid() {
		return this.nurWorkLogid;
	}

	public void setNurWorkLogid(Integer nurWorkLogid) {
		this.nurWorkLogid = nurWorkLogid;
	}

	public NurseWatch getNurseWatch() {
		return this.nurseWatch;
	}

	public void setNurseWatch(NurseWatch nurseWatch) {
		this.nurseWatch = nurseWatch;
	}

	public Date getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}

	public String getWorkcontent() {
		return this.workcontent;
	}

	public void setWorkcontent(String workcontent) {
		this.workcontent = workcontent;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}