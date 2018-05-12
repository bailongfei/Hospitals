package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Buliding entity. @author MyEclipse Persistence Tools
 */

public class Buliding implements java.io.Serializable {

	// Fields

	private Integer bulidingid;
	private String bulidingname;
	private Set floors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Buliding() {
	}

	/** full constructor */
	public Buliding(String bulidingname, Set floors) {
		this.bulidingname = bulidingname;
		this.floors = floors;
	}

	// Property accessors

	public Integer getBulidingid() {
		return this.bulidingid;
	}

	public void setBulidingid(Integer bulidingid) {
		this.bulidingid = bulidingid;
	}

	public String getBulidingname() {
		return this.bulidingname;
	}

	public void setBulidingname(String bulidingname) {
		this.bulidingname = bulidingname;
	}

	public Set getFloors() {
		return this.floors;
	}

	public void setFloors(Set floors) {
		this.floors = floors;
	}

}