package com.aaa.entity;

/**
 * Treatment entity. @author MyEclipse Persistence Tools
 */

public class Treatment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Cure cure;
	private String zjm;
	private String tname;
	private String monad;
	private Integer count;
	private Integer price;
	private String date;

	// Constructors

	/** default constructor */
	public Treatment() {
	}

	/** full constructor */
	public Treatment(Cure cure, String zjm, String tname, String monad, Integer count, Integer price, String date) {
		this.cure = cure;
		this.zjm = zjm;
		this.tname = tname;
		this.monad = monad;
		this.count = count;
		this.price = price;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cure getCure() {
		return this.cure;
	}

	public void setCure(Cure cure) {
		this.cure = cure;
	}

	public String getZjm() {
		return this.zjm;
	}

	public void setZjm(String zjm) {
		this.zjm = zjm;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getMonad() {
		return this.monad;
	}

	public void setMonad(String monad) {
		this.monad = monad;
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

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}