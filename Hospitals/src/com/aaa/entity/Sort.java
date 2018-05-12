package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sort entity. @author MyEclipse Persistence Tools
 */

public class Sort implements java.io.Serializable {

	// Fields

	private Integer sortid3;
	private Checktype checktype;
	private String sortname;
	private String remark6;
	private Date endtime;
	private Integer charge;
	private String expense;
	private Set rooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sort() {
	}

	/** full constructor */
	public Sort(Checktype checktype, String sortname, String remark6, Date endtime, Integer charge, String expense,
			Set rooms) {
		this.checktype = checktype;
		this.sortname = sortname;
		this.remark6 = remark6;
		this.endtime = endtime;
		this.charge = charge;
		this.expense = expense;
		this.rooms = rooms;
	}

	// Property accessors

	public Integer getSortid3() {
		return this.sortid3;
	}

	public void setSortid3(Integer sortid3) {
		this.sortid3 = sortid3;
	}

	public Checktype getChecktype() {
		return this.checktype;
	}

	public void setChecktype(Checktype checktype) {
		this.checktype = checktype;
	}

	public String getSortname() {
		return this.sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getCharge() {
		return this.charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public String getExpense() {
		return this.expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

}