package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Chargetype entity. @author MyEclipse Persistence Tools
 */

public class Chargetype implements java.io.Serializable {

	// Fields

	private Integer sftId;
	private String name;
	private Set charges = new HashSet(0);

	// Constructors

	/** default constructor */
	public Chargetype() {
	}

	/** full constructor */
	public Chargetype(String name, Set charges) {
		this.name = name;
		this.charges = charges;
	}

	// Property accessors

	public Integer getSftId() {
		return this.sftId;
	}

	public void setSftId(Integer sftId) {
		this.sftId = sftId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getCharges() {
		return this.charges;
	}

	public void setCharges(Set charges) {
		this.charges = charges;
	}

}