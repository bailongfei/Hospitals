package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Doctorwork entity. @author MyEclipse Persistence Tools
 */

public class Doctorwork implements java.io.Serializable {

	// Fields

	private Integer docworkid;
	private String worktype;
	private Date workdate;
	private Set docworklogs = new HashSet(0);
	private Set stuffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Doctorwork() {
	}

	/** full constructor */
	public Doctorwork(String worktype, Date workdate, Set docworklogs, Set stuffs) {
		this.worktype = worktype;
		this.workdate = workdate;
		this.docworklogs = docworklogs;
		this.stuffs = stuffs;
	}

	// Property accessors

	public Integer getDocworkid() {
		return this.docworkid;
	}

	public void setDocworkid(Integer docworkid) {
		this.docworkid = docworkid;
	}

	public String getWorktype() {
		return this.worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public Date getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}

	public Set getDocworklogs() {
		return this.docworklogs;
	}

	public void setDocworklogs(Set docworklogs) {
		this.docworklogs = docworklogs;
	}

	public Set getStuffs() {
		return this.stuffs;
	}

	public void setStuffs(Set stuffs) {
		this.stuffs = stuffs;
	}

}