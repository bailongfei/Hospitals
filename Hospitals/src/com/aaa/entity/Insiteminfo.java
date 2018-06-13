package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Insiteminfo entity. @author MyEclipse Persistence Tools
 */

public class Insiteminfo implements java.io.Serializable {

	// Fields

	private Integer iid;
	private Inspectionitem inspectionitem;
	private String iname;
	private Integer count;
	private Integer price;
	private Set inspections = new HashSet(0);

	// Constructors

	/** default constructor */
	public Insiteminfo() {
	}

	/** full constructor */
	public Insiteminfo(Inspectionitem inspectionitem, String iname, Integer count, Integer price, Set inspections) {
		this.inspectionitem = inspectionitem;
		this.iname = iname;
		this.count = count;
		this.price = price;
		this.inspections = inspections;
	}

	// Property accessors

	public Integer getIid() {
		return this.iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Inspectionitem getInspectionitem() {
		return this.inspectionitem;
	}

	public void setInspectionitem(Inspectionitem inspectionitem) {
		this.inspectionitem = inspectionitem;
	}

	public String getIname() {
		return this.iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
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

	public Set getInspections() {
		return this.inspections;
	}

	public void setInspections(Set inspections) {
		this.inspections = inspections;
	}

}