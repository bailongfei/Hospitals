package com.aaa.entity;

import java.util.Date;

/**
 * Medicalrecord entity. @author MyEclipse Persistence Tools
 */

public class Medicalrecord implements java.io.Serializable {

	// Fields

	private Integer medicalRecordId;
	private Integer registerId;
	private Integer patientId;
	private Integer age3;
	private String stuffId11;
	private String acceptsType;
	private String enquire;
	private String curesuggest;
	private Date visitTime3;

	// Constructors

	/** default constructor */
	public Medicalrecord() {
	}

	/** full constructor */
	public Medicalrecord(Integer registerId, Integer patientId, Integer age3, String stuffId11, String acceptsType,
			String enquire, String curesuggest, Date visitTime3) {
		this.registerId = registerId;
		this.patientId = patientId;
		this.age3 = age3;
		this.stuffId11 = stuffId11;
		this.acceptsType = acceptsType;
		this.enquire = enquire;
		this.curesuggest = curesuggest;
		this.visitTime3 = visitTime3;
	}

	// Property accessors

	public Integer getMedicalRecordId() {
		return this.medicalRecordId;
	}

	public void setMedicalRecordId(Integer medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public Integer getRegisterId() {
		return this.registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getAge3() {
		return this.age3;
	}

	public void setAge3(Integer age3) {
		this.age3 = age3;
	}

	public String getStuffId11() {
		return this.stuffId11;
	}

	public void setStuffId11(String stuffId11) {
		this.stuffId11 = stuffId11;
	}

	public String getAcceptsType() {
		return this.acceptsType;
	}

	public void setAcceptsType(String acceptsType) {
		this.acceptsType = acceptsType;
	}

	public String getEnquire() {
		return this.enquire;
	}

	public void setEnquire(String enquire) {
		this.enquire = enquire;
	}

	public String getCuresuggest() {
		return this.curesuggest;
	}

	public void setCuresuggest(String curesuggest) {
		this.curesuggest = curesuggest;
	}

	public Date getVisitTime3() {
		return this.visitTime3;
	}

	public void setVisitTime3(Date visitTime3) {
		this.visitTime3 = visitTime3;
	}

}