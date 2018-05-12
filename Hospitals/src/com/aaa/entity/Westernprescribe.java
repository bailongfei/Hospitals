package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Westernprescribe entity. @author MyEclipse Persistence Tools
 */

public class Westernprescribe implements java.io.Serializable {

	// Fields

	private Integer westernPrescribeId;
	private Patient2 patient2;
	private Cure cure;
	private String westernName;
	private String cost;
	private String stuffId11;
	private Date prescribeTime3;
	private Set westerndetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Westernprescribe() {
	}

	/** full constructor */
	public Westernprescribe(Patient2 patient2, Cure cure, String westernName, String cost, String stuffId11,
			Date prescribeTime3, Set westerndetailses) {
		this.patient2 = patient2;
		this.cure = cure;
		this.westernName = westernName;
		this.cost = cost;
		this.stuffId11 = stuffId11;
		this.prescribeTime3 = prescribeTime3;
		this.westerndetailses = westerndetailses;
	}

	// Property accessors

	public Integer getWesternPrescribeId() {
		return this.westernPrescribeId;
	}

	public void setWesternPrescribeId(Integer westernPrescribeId) {
		this.westernPrescribeId = westernPrescribeId;
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

	public String getWesternName() {
		return this.westernName;
	}

	public void setWesternName(String westernName) {
		this.westernName = westernName;
	}

	public String getCost() {
		return this.cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getStuffId11() {
		return this.stuffId11;
	}

	public void setStuffId11(String stuffId11) {
		this.stuffId11 = stuffId11;
	}

	public Date getPrescribeTime3() {
		return this.prescribeTime3;
	}

	public void setPrescribeTime3(Date prescribeTime3) {
		this.prescribeTime3 = prescribeTime3;
	}

	public Set getWesterndetailses() {
		return this.westerndetailses;
	}

	public void setWesterndetailses(Set westerndetailses) {
		this.westerndetailses = westerndetailses;
	}

}