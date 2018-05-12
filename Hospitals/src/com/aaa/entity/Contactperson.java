package com.aaa.entity;

/**
 * Contactperson entity. @author MyEclipse Persistence Tools
 */

public class Contactperson implements java.io.Serializable {

	// Fields

	private Integer contactPersonId;
	private Integer patientId;
	private String contactPerson;
	private String relationShip;
	private String telephone;
	private String address3;

	// Constructors

	/** default constructor */
	public Contactperson() {
	}

	/** full constructor */
	public Contactperson(Integer patientId, String contactPerson, String relationShip, String telephone,
			String address3) {
		this.patientId = patientId;
		this.contactPerson = contactPerson;
		this.relationShip = relationShip;
		this.telephone = telephone;
		this.address3 = address3;
	}

	// Property accessors

	public Integer getContactPersonId() {
		return this.contactPersonId;
	}

	public void setContactPersonId(Integer contactPersonId) {
		this.contactPersonId = contactPersonId;
	}

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getRelationShip() {
		return this.relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

}