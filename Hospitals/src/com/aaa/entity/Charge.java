package com.aaa.entity;

/**
 * Charge entity. @author MyEclipse Persistence Tools
 */

public class Charge implements java.io.Serializable {

	// Fields

	private Integer tollId;
	private Cure cure;
	private Integer patientId;
	private String registrationToll;
	private String pillToll;
	private String checkToll;
	private String checkoutToll;
	private String opstoll;

	// Constructors

	/** default constructor */
	public Charge() {
	}

	/** full constructor */
	public Charge(Cure cure, Integer patientId, String registrationToll, String pillToll, String checkToll,
			String checkoutToll, String opstoll) {
		this.cure = cure;
		this.patientId = patientId;
		this.registrationToll = registrationToll;
		this.pillToll = pillToll;
		this.checkToll = checkToll;
		this.checkoutToll = checkoutToll;
		this.opstoll = opstoll;
	}

	// Property accessors

	public Integer getTollId() {
		return this.tollId;
	}

	public void setTollId(Integer tollId) {
		this.tollId = tollId;
	}

	public Cure getCure() {
		return this.cure;
	}

	public void setCure(Cure cure) {
		this.cure = cure;
	}

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getRegistrationToll() {
		return this.registrationToll;
	}

	public void setRegistrationToll(String registrationToll) {
		this.registrationToll = registrationToll;
	}

	public String getPillToll() {
		return this.pillToll;
	}

	public void setPillToll(String pillToll) {
		this.pillToll = pillToll;
	}

	public String getCheckToll() {
		return this.checkToll;
	}

	public void setCheckToll(String checkToll) {
		this.checkToll = checkToll;
	}

	public String getCheckoutToll() {
		return this.checkoutToll;
	}

	public void setCheckoutToll(String checkoutToll) {
		this.checkoutToll = checkoutToll;
	}

	public String getOpstoll() {
		return this.opstoll;
	}

	public void setOpstoll(String opstoll) {
		this.opstoll = opstoll;
	}

}