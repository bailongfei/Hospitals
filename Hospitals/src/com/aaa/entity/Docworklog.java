package com.aaa.entity;

import java.util.Date;

/**
 * Docworklog entity. @author MyEclipse Persistence Tools
 */

public class Docworklog implements java.io.Serializable {

	// Fields

	private Integer docWorkLogId;
	private Doctorwork doctorwork;
	private Date workdate;
	private String workcontent;
	private String remark;

	// Constructors

	/** default constructor */
	public Docworklog() {
	}

	/** full constructor */
	public Docworklog(Doctorwork doctorwork, Date workdate, String workcontent, String remark) {
		this.doctorwork = doctorwork;
		this.workdate = workdate;
		this.workcontent = workcontent;
		this.remark = remark;
	}

	// Property accessors

	public Integer getDocWorkLogId() {
		return this.docWorkLogId;
	}

	public void setDocWorkLogId(Integer docWorkLogId) {
		this.docWorkLogId = docWorkLogId;
	}

	public Doctorwork getDoctorwork() {
		return this.doctorwork;
	}

	public void setDoctorwork(Doctorwork doctorwork) {
		this.doctorwork = doctorwork;
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