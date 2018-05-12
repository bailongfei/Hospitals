package com.aaa.entity;

/**
 * Westerndetails entity. @author MyEclipse Persistence Tools
 */

public class Westerndetails implements java.io.Serializable {

	// Fields

	private Integer westernDetailsId;
	private Westernprescribe westernprescribe;
	private Integer groupId;
	private String dose3;
	private String unit3;
	private String usage3;
	private String days3;
	private String useRate;
	private String count;
	private String drugId3;

	// Constructors

	/** default constructor */
	public Westerndetails() {
	}

	/** full constructor */
	public Westerndetails(Westernprescribe westernprescribe, Integer groupId, String dose3, String unit3, String usage3,
			String days3, String useRate, String count, String drugId3) {
		this.westernprescribe = westernprescribe;
		this.groupId = groupId;
		this.dose3 = dose3;
		this.unit3 = unit3;
		this.usage3 = usage3;
		this.days3 = days3;
		this.useRate = useRate;
		this.count = count;
		this.drugId3 = drugId3;
	}

	// Property accessors

	public Integer getWesternDetailsId() {
		return this.westernDetailsId;
	}

	public void setWesternDetailsId(Integer westernDetailsId) {
		this.westernDetailsId = westernDetailsId;
	}

	public Westernprescribe getWesternprescribe() {
		return this.westernprescribe;
	}

	public void setWesternprescribe(Westernprescribe westernprescribe) {
		this.westernprescribe = westernprescribe;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

	public String getUsage3() {
		return this.usage3;
	}

	public void setUsage3(String usage3) {
		this.usage3 = usage3;
	}

	public String getDays3() {
		return this.days3;
	}

	public void setDays3(String days3) {
		this.days3 = days3;
	}

	public String getUseRate() {
		return this.useRate;
	}

	public void setUseRate(String useRate) {
		this.useRate = useRate;
	}

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDrugId3() {
		return this.drugId3;
	}

	public void setDrugId3(String drugId3) {
		this.drugId3 = drugId3;
	}

}