package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Departmenttype entity. @author MyEclipse Persistence Tools
 */

public class Departmenttype implements java.io.Serializable {

	// Fields

	private Integer departmentTypeid;
	private String genre;
	private String mainperson;
	private String location;
	private String departmentName;
	private Set departments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Departmenttype() {
	}

	/** full constructor */
	public Departmenttype(String genre, String mainperson, String location, String departmentName, Set departments) {
		this.genre = genre;
		this.mainperson = mainperson;
		this.location = location;
		this.departmentName = departmentName;
		this.departments = departments;
	}

	// Property accessors

	public Integer getDepartmentTypeid() {
		return this.departmentTypeid;
	}

	public void setDepartmentTypeid(Integer departmentTypeid) {
		this.departmentTypeid = departmentTypeid;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMainperson() {
		return this.mainperson;
	}

	public void setMainperson(String mainperson) {
		this.mainperson = mainperson;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

}