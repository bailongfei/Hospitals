package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Cure entity. @author MyEclipse Persistence Tools
 */

public class Cure implements java.io.Serializable {

	// Fields

	private Integer cureId;
	private Integer orderId;
	private Integer medicalRecordId;
	private String cureName;
	private Integer cureNumber;
	private String moneyType;
	private Integer feesState;
	private Integer state8;
	private Set checktypes = new HashSet(0);
	private Set westernprescribes = new HashSet(0);
	private Set charges = new HashSet(0);
	private Set chineseprescribes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cure() {
	}

	/** full constructor */
	public Cure(Integer orderId, Integer medicalRecordId, String cureName, Integer cureNumber, String moneyType,
			Integer feesState, Integer state8, Set checktypes, Set westernprescribes, Set charges,
			Set chineseprescribes) {
		this.orderId = orderId;
		this.medicalRecordId = medicalRecordId;
		this.cureName = cureName;
		this.cureNumber = cureNumber;
		this.moneyType = moneyType;
		this.feesState = feesState;
		this.state8 = state8;
		this.checktypes = checktypes;
		this.westernprescribes = westernprescribes;
		this.charges = charges;
		this.chineseprescribes = chineseprescribes;
	}

	// Property accessors

	public Integer getCureId() {
		return this.cureId;
	}

	public void setCureId(Integer cureId) {
		this.cureId = cureId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMedicalRecordId() {
		return this.medicalRecordId;
	}

	public void setMedicalRecordId(Integer medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getCureName() {
		return this.cureName;
	}

	public void setCureName(String cureName) {
		this.cureName = cureName;
	}

	public Integer getCureNumber() {
		return this.cureNumber;
	}

	public void setCureNumber(Integer cureNumber) {
		this.cureNumber = cureNumber;
	}

	public String getMoneyType() {
		return this.moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public Integer getFeesState() {
		return this.feesState;
	}

	public void setFeesState(Integer feesState) {
		this.feesState = feesState;
	}

	public Integer getState8() {
		return this.state8;
	}

	public void setState8(Integer state8) {
		this.state8 = state8;
	}

	public Set getChecktypes() {
		return this.checktypes;
	}

	public void setChecktypes(Set checktypes) {
		this.checktypes = checktypes;
	}

	public Set getWesternprescribes() {
		return this.westernprescribes;
	}

	public void setWesternprescribes(Set westernprescribes) {
		this.westernprescribes = westernprescribes;
	}

	public Set getCharges() {
		return this.charges;
	}

	public void setCharges(Set charges) {
		this.charges = charges;
	}

	public Set getChineseprescribes() {
		return this.chineseprescribes;
	}

	public void setChineseprescribes(Set chineseprescribes) {
		this.chineseprescribes = chineseprescribes;
	}

}