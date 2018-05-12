package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Chineseprescribe entity. @author MyEclipse Persistence Tools
 */

public class Chineseprescribe implements java.io.Serializable {

	// Fields

	private Integer chinesePrescribeId;
	private Patient2 patient2;
	private Cure cure;
	private String tcmname;
	private String countDeposit;
	private Date prescribeTime3;
	private Set chinesedetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Chineseprescribe() {
	}

	/** full constructor */
	public Chineseprescribe(Patient2 patient2, Cure cure, String tcmname, String countDeposit, Date prescribeTime3,
			Set chinesedetailses) {
		this.patient2 = patient2;
		this.cure = cure;
		this.tcmname = tcmname;
		this.countDeposit = countDeposit;
		this.prescribeTime3 = prescribeTime3;
		this.chinesedetailses = chinesedetailses;
	}

	// Property accessors

	public Integer getChinesePrescribeId() {
		return this.chinesePrescribeId;
	}

	public void setChinesePrescribeId(Integer chinesePrescribeId) {
		this.chinesePrescribeId = chinesePrescribeId;
	}

	public Patient2 getPatient2() {
		return this.patient2;
	}

	public void setPatient2(Patient2 patient2) {
		this.patient2 = patient2;
	}

	public Cure getCure() {
		return this.cure;
	}

	public void setCure(Cure cure) {
		this.cure = cure;
	}

	public String getTcmname() {
		return this.tcmname;
	}

	public void setTcmname(String tcmname) {
		this.tcmname = tcmname;
	}

	public String getCountDeposit() {
		return this.countDeposit;
	}

	public void setCountDeposit(String countDeposit) {
		this.countDeposit = countDeposit;
	}

	public Date getPrescribeTime3() {
		return this.prescribeTime3;
	}

	public void setPrescribeTime3(Date prescribeTime3) {
		this.prescribeTime3 = prescribeTime3;
	}

	public Set getChinesedetailses() {
		return this.chinesedetailses;
	}

	public void setChinesedetailses(Set chinesedetailses) {
		this.chinesedetailses = chinesedetailses;
	}

}