package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;
	private Integer stockPrice3;
	private Integer tradePrice3;
	private Integer retailPrice3;
	private Set drugs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(String aname, Integer stockPrice3, Integer tradePrice3, Integer retailPrice3, Set drugs) {
		this.aname = aname;
		this.stockPrice3 = stockPrice3;
		this.tradePrice3 = tradePrice3;
		this.retailPrice3 = retailPrice3;
		this.drugs = drugs;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getStockPrice3() {
		return this.stockPrice3;
	}

	public void setStockPrice3(Integer stockPrice3) {
		this.stockPrice3 = stockPrice3;
	}

	public Integer getTradePrice3() {
		return this.tradePrice3;
	}

	public void setTradePrice3(Integer tradePrice3) {
		this.tradePrice3 = tradePrice3;
	}

	public Integer getRetailPrice3() {
		return this.retailPrice3;
	}

	public void setRetailPrice3(Integer retailPrice3) {
		this.retailPrice3 = retailPrice3;
	}

	public Set getDrugs() {
		return this.drugs;
	}

	public void setDrugs(Set drugs) {
		this.drugs = drugs;
	}

}