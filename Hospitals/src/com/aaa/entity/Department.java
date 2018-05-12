package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer departmentId;
	private Departmenttype departmenttype;
	private Room room;
	private Clinicregister clinicregister;
	private String departmentName;
	private String intro;
	private Date foundTime;
	private String mainperson;
	private String comment;
	private Set stuffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(Departmenttype departmenttype, Room room, Clinicregister clinicregister, String departmentName,
			String intro, Date foundTime, String mainperson, String comment, Set stuffs) {
		this.departmenttype = departmenttype;
		this.room = room;
		this.clinicregister = clinicregister;
		this.departmentName = departmentName;
		this.intro = intro;
		this.foundTime = foundTime;
		this.mainperson = mainperson;
		this.comment = comment;
		this.stuffs = stuffs;
	}

	// Property accessors

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Departmenttype getDepartmenttype() {
		return this.departmenttype;
	}

	public void setDepartmenttype(Departmenttype departmenttype) {
		this.departmenttype = departmenttype;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Clinicregister getClinicregister() {
		return this.clinicregister;
	}

	public void setClinicregister(Clinicregister clinicregister) {
		this.clinicregister = clinicregister;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getFoundTime() {
		return this.foundTime;
	}

	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}

	public String getMainperson() {
		return this.mainperson;
	}

	public void setMainperson(String mainperson) {
		this.mainperson = mainperson;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set getStuffs() {
		return this.stuffs;
	}

	public void setStuffs(Set stuffs) {
		this.stuffs = stuffs;
	}

}