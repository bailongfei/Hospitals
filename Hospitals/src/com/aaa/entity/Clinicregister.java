package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clinicregister entity. @author MyEclipse Persistence Tools
 */

public class Clinicregister implements java.io.Serializable {

	// Fields

	private Integer registerId;
	private Office office;
	private Charge charge;
	private Patients patients;
	private Stuff stuff;
	private Registeredtype registeredtype;
	private String serialNumber;
	private String iphone;
	private Date presentTime;
	private Set offices = new HashSet(0);
	private Set stuffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clinicregister() {
	}

	/** full constructor */
	public Clinicregister(Office office, Charge charge, Patients patients, Stuff stuff, Registeredtype registeredtype,
			String serialNumber, String iphone, Date presentTime, Set offices, Set stuffs) {
		this.office = office;
		this.charge = charge;
		this.patients = patients;
		this.stuff = stuff;
		this.registeredtype = registeredtype;
		this.serialNumber = serialNumber;
		this.iphone = iphone;
		this.presentTime = presentTime;
		this.offices = offices;
		this.stuffs = stuffs;
	}

	// Property accessors

	public Integer getRegisterId() {
		return this.registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Charge getCharge() {
		return this.charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public Patients getPatients() {
		return this.patients;
	}

	public void setPatients(Patients patients) {
		this.patients = patients;
	}

	public Stuff getStuff() {
		return this.stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	public Registeredtype getRegisteredtype() {
		return this.registeredtype;
	}

	public void setRegisteredtype(Registeredtype registeredtype) {
		this.registeredtype = registeredtype;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getIphone() {
		return this.iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	public Date getPresentTime() {
		return this.presentTime;
	}

	public void setPresentTime(Date presentTime) {
		this.presentTime = presentTime;
	}

	public Set getOffices() {
		return this.offices;
	}

	public void setOffices(Set offices) {
		this.offices = offices;
	}

	public Set getStuffs() {
		return this.stuffs;
	}

	public void setStuffs(Set stuffs) {
		this.stuffs = stuffs;
	}

}