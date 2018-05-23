package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Registeredtype entity. @author MyEclipse Persistence Tools
 */

public class Registeredtype implements java.io.Serializable {

	// Fields

	private Integer ghId;
	private String typeName;
	private Set clinicregisters = new HashSet(0);

	// Constructors

	/** default constructor */
	public Registeredtype() {
	}

	/** full constructor */
	public Registeredtype(String typeName, Set clinicregisters) {
		this.typeName = typeName;
		this.clinicregisters = clinicregisters;
	}

	// Property accessors

	public Integer getGhId() {
		return this.ghId;
	}

	public void setGhId(Integer ghId) {
		this.ghId = ghId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getClinicregisters() {
		return this.clinicregisters;
	}

	public void setClinicregisters(Set clinicregisters) {
		this.clinicregisters = clinicregisters;
	}

}