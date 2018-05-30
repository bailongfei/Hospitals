package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer rolesId;
	private String rolesName;
	private String rolesdescribe;
	private Set usertables = new HashSet(0);
	private Set rolesmodules = new HashSet(0);

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** full constructor */
	public Roles(String rolesName, String rolesdescribe, Set usertables, Set rolesmodules) {
		this.rolesName = rolesName;
		this.rolesdescribe = rolesdescribe;
		this.usertables = usertables;
		this.rolesmodules = rolesmodules;
	}

	// Property accessors

	public Integer getRolesId() {
		return this.rolesId;
	}

	public void setRolesId(Integer rolesId) {
		this.rolesId = rolesId;
	}

	public String getRolesName() {
		return this.rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

	public String getRolesdescribe() {
		return this.rolesdescribe;
	}

	public void setRolesdescribe(String rolesdescribe) {
		this.rolesdescribe = rolesdescribe;
	}

	public Set getUsertables() {
		return this.usertables;
	}

	public void setUsertables(Set usertables) {
		this.usertables = usertables;
	}

	public Set getRolesmodules() {
		return this.rolesmodules;
	}

	public void setRolesmodules(Set rolesmodules) {
		this.rolesmodules = rolesmodules;
	}

}