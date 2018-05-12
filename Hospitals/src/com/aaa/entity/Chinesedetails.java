package com.aaa.entity;

/**
 * Chinesedetails entity. @author MyEclipse Persistence Tools
 */

public class Chinesedetails implements java.io.Serializable {

	// Fields

	private Integer chineseDetailsId;
	private Chineseprescribe chineseprescribe;
	private String dose3;
	private String unit3;
	private String explain3;
	private String usage3;
	private String frequency;
	private String days3;
	private String drugId3;

	// Constructors

	/** default constructor */
	public Chinesedetails() {
	}

	/** full constructor */
	public Chinesedetails(Chineseprescribe chineseprescribe, String dose3, String unit3, String explain3, String usage3,
			String frequency, String days3, String drugId3) {
		this.chineseprescribe = chineseprescribe;
		this.dose3 = dose3;
		this.unit3 = unit3;
		this.explain3 = explain3;
		this.usage3 = usage3;
		this.frequency = frequency;
		this.days3 = days3;
		this.drugId3 = drugId3;
	}

	// Property accessors

	public Integer getChineseDetailsId() {
		return this.chineseDetailsId;
	}

	public void setChineseDetailsId(Integer chineseDetailsId) {
		this.chineseDetailsId = chineseDetailsId;
	}

	public Chineseprescribe getChineseprescribe() {
		return this.chineseprescribe;
	}

	public void setChineseprescribe(Chineseprescribe chineseprescribe) {
		this.chineseprescribe = chineseprescribe;
	}

	public String getDose3() {
		return this.dose3;
	}

	public void setDose3(String dose3) {
		this.dose3 = dose3;
	}

	public String getUnit3() {
		return this.unit3;
	}

	public void setUnit3(String unit3) {
		this.unit3 = unit3;
	}

	public String getExplain3() {
		return this.explain3;
	}

	public void setExplain3(String explain3) {
		this.explain3 = explain3;
	}

	public String getUsage3() {
		return this.usage3;
	}

	public void setUsage3(String usage3) {
		this.usage3 = usage3;
	}

	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDays3() {
		return this.days3;
	}

	public void setDays3(String days3) {
		this.days3 = days3;
	}

	public String getDrugId3() {
		return this.drugId3;
	}

	public void setDrugId3(String drugId3) {
		this.drugId3 = drugId3;
	}

}