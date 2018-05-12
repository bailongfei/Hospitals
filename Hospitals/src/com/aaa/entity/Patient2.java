package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Patient2 entity. @author MyEclipse Persistence Tools
 */

public class Patient2 implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private String patientname3;
	private String sex4;
	private Date birthdayDay;
	private String idnumber;
	private Integer phone4;
	private String nation3;
	private String marry;
	private String job;
	private String workAddress;
	private String sources;
	private String currentIllness;
	private String illnessHistory;
	private String personalIllness;
	private String familyIllness;
	private Integer medicalRecord;
	private Set chineseprescribes = new HashSet(0);
	private Set icclips = new HashSet(0);
	private Set westernprescribes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Patient2() {
	}

	/** full constructor */
	public Patient2(String patientname3, String sex4, Date birthdayDay, String idnumber, Integer phone4, String nation3,
			String marry, String job, String workAddress, String sources, String currentIllness, String illnessHistory,
			String personalIllness, String familyIllness, Integer medicalRecord, Set chineseprescribes, Set icclips,
			Set westernprescribes) {
		this.patientname3 = patientname3;
		this.sex4 = sex4;
		this.birthdayDay = birthdayDay;
		this.idnumber = idnumber;
		this.phone4 = phone4;
		this.nation3 = nation3;
		this.marry = marry;
		this.job = job;
		this.workAddress = workAddress;
		this.sources = sources;
		this.currentIllness = currentIllness;
		this.illnessHistory = illnessHistory;
		this.personalIllness = personalIllness;
		this.familyIllness = familyIllness;
		this.medicalRecord = medicalRecord;
		this.chineseprescribes = chineseprescribes;
		this.icclips = icclips;
		this.westernprescribes = westernprescribes;
	}

	// Property accessors

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientname3() {
		return this.patientname3;
	}

	public void setPatientname3(String patientname3) {
		this.patientname3 = patientname3;
	}

	public String getSex4() {
		return this.sex4;
	}

	public void setSex4(String sex4) {
		this.sex4 = sex4;
	}

	public Date getBirthdayDay() {
		return this.birthdayDay;
	}

	public void setBirthdayDay(Date birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public Integer getPhone4() {
		return this.phone4;
	}

	public void setPhone4(Integer phone4) {
		this.phone4 = phone4;
	}

	public String getNation3() {
		return this.nation3;
	}

	public void setNation3(String nation3) {
		this.nation3 = nation3;
	}

	public String getMarry() {
		return this.marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getSources() {
		return this.sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public String getCurrentIllness() {
		return this.currentIllness;
	}

	public void setCurrentIllness(String currentIllness) {
		this.currentIllness = currentIllness;
	}

	public String getIllnessHistory() {
		return this.illnessHistory;
	}

	public void setIllnessHistory(String illnessHistory) {
		this.illnessHistory = illnessHistory;
	}

	public String getPersonalIllness() {
		return this.personalIllness;
	}

	public void setPersonalIllness(String personalIllness) {
		this.personalIllness = personalIllness;
	}

	public String getFamilyIllness() {
		return this.familyIllness;
	}

	public void setFamilyIllness(String familyIllness) {
		this.familyIllness = familyIllness;
	}

	public Integer getMedicalRecord() {
		return this.medicalRecord;
	}

	public void setMedicalRecord(Integer medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Set getChineseprescribes() {
		return this.chineseprescribes;
	}

	public void setChineseprescribes(Set chineseprescribes) {
		this.chineseprescribes = chineseprescribes;
	}

	public Set getIcclips() {
		return this.icclips;
	}

	public void setIcclips(Set icclips) {
		this.icclips = icclips;
	}

	public Set getWesternprescribes() {
		return this.westernprescribes;
	}

	public void setWesternprescribes(Set westernprescribes) {
		this.westernprescribes = westernprescribes;
	}

}