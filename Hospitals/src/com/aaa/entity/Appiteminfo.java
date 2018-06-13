package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Appiteminfo entity. @author MyEclipse Persistence Tools
 */

public class Appiteminfo implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Applicationitem applicationitem;
	private String aname;
	private Integer count;
	private Integer price;
	private Set applicationforms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Appiteminfo() {
	}

	/** full constructor */
	public Appiteminfo(Applicationitem applicationitem, String aname, Integer count, Integer price,
			Set applicationforms) {
		this.applicationitem = applicationitem;
		this.aname = aname;
		this.count = count;
		this.price = price;
		this.applicationforms = applicationforms;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Applicationitem getApplicationitem() {
		return this.applicationitem;
	}

	public void setApplicationitem(Applicationitem applicationitem) {
		this.applicationitem = applicationitem;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Set getApplicationforms() {
		return this.applicationforms;
	}

	public void setApplicationforms(Set applicationforms) {
		this.applicationforms = applicationforms;
	}

}