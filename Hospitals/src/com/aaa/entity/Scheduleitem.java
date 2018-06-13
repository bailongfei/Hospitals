package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Scheduleitem entity. @author MyEclipse Persistence Tools
 */

public class Scheduleitem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Scheduletype scheduletype;
	private Stuff stuff;
	private String week;
	private Set stuffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Scheduleitem() {
	}

	/** full constructor */
	public Scheduleitem(Scheduletype scheduletype, Stuff stuff, String week, Set stuffs) {
		this.scheduletype = scheduletype;
		this.stuff = stuff;
		this.week = week;
		this.stuffs = stuffs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Scheduletype getScheduletype() {
		return this.scheduletype;
	}

	public void setScheduletype(Scheduletype scheduletype) {
		this.scheduletype = scheduletype;
	}

	public Stuff getStuff() {
		return this.stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public Set getStuffs() {
		return this.stuffs;
	}

	public void setStuffs(Set stuffs) {
		this.stuffs = stuffs;
	}

}