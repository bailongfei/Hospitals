package com.aaa.entity;

/**
 * Applicationresult entity. @author MyEclipse Persistence Tools
 */

public class Applicationresult implements java.io.Serializable {

	// Fields

	private Integer jcjId;
	private Inspectionitem inspectionitem;
	private Applicationform applicationform;
	private Patients patients;
	private String sample;
	private String trouble;
	private String diagnose;
	private String unit;

	// Constructors

	/** default constructor */
	public Applicationresult() {
	}

	/** full constructor */
	public Applicationresult(Inspectionitem inspectionitem, Applicationform applicationform, Patients patients,
			String sample, String trouble, String diagnose, String unit) {
		this.inspectionitem = inspectionitem;
		this.applicationform = applicationform;
		this.patients = patients;
		this.sample = sample;
		this.trouble = trouble;
		this.diagnose = diagnose;
		this.unit = unit;
	}

	// Property accessors

	public Integer getJcjId() {
		return this.jcjId;
	}

	public void setJcjId(Integer jcjId) {
		this.jcjId = jcjId;
	}

	public Inspectionitem getInspectionitem() {
		return this.inspectionitem;
	}

	public void setInspectionitem(Inspectionitem inspectionitem) {
		this.inspectionitem = inspectionitem;
	}

	public Applicationform getApplicationform() {
		return this.applicationform;
	}

	public void setApplicationform(Applicationform applicationform) {
		this.applicationform = applicationform;
	}

	public Patients getPatients() {
		return this.patients;
	}

	public void setPatients(Patients patients) {
		this.patients = patients;
	}

	public String getSample() {
		return this.sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getTrouble() {
		return this.trouble;
	}

	public void setTrouble(String trouble) {
		this.trouble = trouble;
	}

	public String getDiagnose() {
		return this.diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}