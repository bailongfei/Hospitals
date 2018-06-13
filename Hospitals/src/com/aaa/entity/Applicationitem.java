package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Applicationitem entity. @author MyEclipse Persistence Tools
 */

public class Applicationitem implements java.io.Serializable {

	// Fields

	private Integer jcxId;
	private Integer jcId;
	private String name;
	private Integer price;
	private String info;
	private Set applicationforms = new HashSet(0);
	private Set appiteminfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Applicationitem() {
	}

	/** full constructor */
	public Applicationitem(Integer jcId, String name, Integer price, String info, Set applicationforms,
			Set appiteminfos) {
		this.jcId = jcId;
		this.name = name;
		this.price = price;
		this.info = info;
		this.applicationforms = applicationforms;
		this.appiteminfos = appiteminfos;
	}

	// Property accessors

	public Integer getJcxId() {
		return this.jcxId;
	}

	public void setJcxId(Integer jcxId) {
		this.jcxId = jcxId;
	}

	public Integer getJcId() {
		return this.jcId;
	}

	public void setJcId(Integer jcId) {
		this.jcId = jcId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set getApplicationforms() {
		return this.applicationforms;
	}

	public void setApplicationforms(Set applicationforms) {
		this.applicationforms = applicationforms;
	}

	public Set getAppiteminfos() {
		return this.appiteminfos;
	}

	public void setAppiteminfos(Set appiteminfos) {
		this.appiteminfos = appiteminfos;
	}

}