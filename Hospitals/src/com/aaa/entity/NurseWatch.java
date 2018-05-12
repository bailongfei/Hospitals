package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * NurseWatch entity. @author MyEclipse Persistence Tools
 */

public class NurseWatch implements java.io.Serializable {

	// Fields

	private Integer nurworkid;
	private Date workdate;
	private String worktype;
	private Set stuffs = new HashSet(0);
	private Set nurworklogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public NurseWatch() {
	}

	/** full constructor */
	public NurseWatch(Date workdate, String worktype, Set stuffs, Set nurworklogs) {
		this.workdate = workdate;
		this.worktype = worktype;
		this.stuffs = stuffs;
		this.nurworklogs = nurworklogs;
	}

	// Property accessors

	public Integer getNurworkid() {
		return this.nurworkid;
	}

	public void setNurworkid(Integer nurworkid) {
		this.nurworkid = nurworkid;
	}

	public Date getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}

	public String getWorktype() {
		return this.worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public Set getStuffs() {
		return this.stuffs;
	}

	public void setStuffs(Set stuffs) {
		this.stuffs = stuffs;
	}

	public Set getNurworklogs() {
		return this.nurworklogs;
	}

	public void setNurworklogs(Set nurworklogs) {
		this.nurworklogs = nurworklogs;
	}

}