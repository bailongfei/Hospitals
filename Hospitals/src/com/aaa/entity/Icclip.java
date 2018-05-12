package com.aaa.entity;

/**
 * Icclip entity. @author MyEclipse Persistence Tools
 */

public class Icclip implements java.io.Serializable {

	// Fields

	private Integer icid;
	private Subscribe subscribe;
	private Patient2 patient2;
	private String patientname3;
	private Integer icmoney;

	// Constructors

	/** default constructor */
	public Icclip() {
	}

	/** full constructor */
	public Icclip(Subscribe subscribe, Patient2 patient2, String patientname3, Integer icmoney) {
		this.subscribe = subscribe;
		this.patient2 = patient2;
		this.patientname3 = patientname3;
		this.icmoney = icmoney;
	}

	// Property accessors

	public Integer getIcid() {
		return this.icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	public Subscribe getSubscribe() {
		return this.subscribe;
	}

	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
	}

	public Patient2 getPatient2() {
		return this.patient2;
	}

	public void setPatient2(Patient2 patient2) {
		this.patient2 = patient2;
	}

	public String getPatientname3() {
		return this.patientname3;
	}

	public void setPatientname3(String patientname3) {
		this.patientname3 = patientname3;
	}

	public Integer getIcmoney() {
		return this.icmoney;
	}

	public void setIcmoney(Integer icmoney) {
		this.icmoney = icmoney;
	}

}