package com.aaa.entity;

/**
 * Illnesscase entity. @author MyEclipse Persistence Tools
 */

public class Illnesscase implements java.io.Serializable {

	// Fields

	private Integer illnessCaseId;
	private Integer medicalRecordId;
	private String illnessCaseName;

	// Constructors

	/** default constructor */
	public Illnesscase() {
	}

	/** full constructor */
	public Illnesscase(Integer medicalRecordId, String illnessCaseName) {
		this.medicalRecordId = medicalRecordId;
		this.illnessCaseName = illnessCaseName;
	}

	// Property accessors

	public Integer getIllnessCaseId() {
		return this.illnessCaseId;
	}

	public void setIllnessCaseId(Integer illnessCaseId) {
		this.illnessCaseId = illnessCaseId;
	}

	public Integer getMedicalRecordId() {
		return this.medicalRecordId;
	}

	public void setMedicalRecordId(Integer medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getIllnessCaseName() {
		return this.illnessCaseName;
	}

	public void setIllnessCaseName(String illnessCaseName) {
		this.illnessCaseName = illnessCaseName;
	}

}