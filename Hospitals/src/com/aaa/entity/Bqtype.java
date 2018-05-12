package com.aaa.entity;

/**
 * Bqtype entity. @author MyEclipse Persistence Tools
 */

public class Bqtype implements java.io.Serializable {

	// Fields

	private Integer bqtypeid;
	private String bqtypename;

	// Constructors

	/** default constructor */
	public Bqtype() {
	}

	/** full constructor */
	public Bqtype(String bqtypename) {
		this.bqtypename = bqtypename;
	}

	// Property accessors

	public Integer getBqtypeid() {
		return this.bqtypeid;
	}

	public void setBqtypeid(Integer bqtypeid) {
		this.bqtypeid = bqtypeid;
	}

	public String getBqtypename() {
		return this.bqtypename;
	}

	public void setBqtypename(String bqtypename) {
		this.bqtypename = bqtypename;
	}

}