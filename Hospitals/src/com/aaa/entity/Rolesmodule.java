package com.aaa.entity;

/**
 * Rolesmodule entity. @author MyEclipse Persistence Tools
 */

public class Rolesmodule implements java.io.Serializable {

	// Fields

	private Integer rmId;
	private Modules modules;
	private Roles roles;

	// Constructors

	/** default constructor */
	public Rolesmodule() {
	}

	/** full constructor */
	public Rolesmodule(Modules modules, Roles roles) {
		this.modules = modules;
		this.roles = roles;
	}

	// Property accessors

	public Integer getRmId() {
		return this.rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	public Modules getModules() {
		return this.modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}