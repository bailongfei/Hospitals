package com.aaa.entity;

import java.util.Date;

/**
 * Adviceinfo entity. @author MyEclipse Persistence Tools
 */

public class Adviceinfo implements java.io.Serializable {

	// Fields

	private Integer adviceinfoid;
	private Advice advice;
	private String yzproject;
	private Double dosage;
	private Double daysNum;
	private String usages;
	private String frequency;
	private Double unitprice;
	private Double totalprice;
	private String paystate;
	private Double yzgross;
	private Date yzstopdate;
	private String yzdrip;
	private String yzdripunit;
	private String yzpishi;
	private String yzpsresult;
	private String explains;

	// Constructors

	/** default constructor */
	public Adviceinfo() {
	}

	/** full constructor */
	public Adviceinfo(Advice advice, String yzproject, Double dosage, Double daysNum, String usages, String frequency,
			Double unitprice, Double totalprice, String paystate, Double yzgross, Date yzstopdate, String yzdrip,
			String yzdripunit, String yzpishi, String yzpsresult, String explains) {
		this.advice = advice;
		this.yzproject = yzproject;
		this.dosage = dosage;
		this.daysNum = daysNum;
		this.usages = usages;
		this.frequency = frequency;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
		this.paystate = paystate;
		this.yzgross = yzgross;
		this.yzstopdate = yzstopdate;
		this.yzdrip = yzdrip;
		this.yzdripunit = yzdripunit;
		this.yzpishi = yzpishi;
		this.yzpsresult = yzpsresult;
		this.explains = explains;
	}

	// Property accessors

	public Integer getAdviceinfoid() {
		return this.adviceinfoid;
	}

	public void setAdviceinfoid(Integer adviceinfoid) {
		this.adviceinfoid = adviceinfoid;
	}

	public Advice getAdvice() {
		return this.advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public String getYzproject() {
		return this.yzproject;
	}

	public void setYzproject(String yzproject) {
		this.yzproject = yzproject;
	}

	public Double getDosage() {
		return this.dosage;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public Double getDaysNum() {
		return this.daysNum;
	}

	public void setDaysNum(Double daysNum) {
		this.daysNum = daysNum;
	}

	public String getUsages() {
		return this.usages;
	}

	public void setUsages(String usages) {
		this.usages = usages;
	}

	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getPaystate() {
		return this.paystate;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	public Double getYzgross() {
		return this.yzgross;
	}

	public void setYzgross(Double yzgross) {
		this.yzgross = yzgross;
	}

	public Date getYzstopdate() {
		return this.yzstopdate;
	}

	public void setYzstopdate(Date yzstopdate) {
		this.yzstopdate = yzstopdate;
	}

	public String getYzdrip() {
		return this.yzdrip;
	}

	public void setYzdrip(String yzdrip) {
		this.yzdrip = yzdrip;
	}

	public String getYzdripunit() {
		return this.yzdripunit;
	}

	public void setYzdripunit(String yzdripunit) {
		this.yzdripunit = yzdripunit;
	}

	public String getYzpishi() {
		return this.yzpishi;
	}

	public void setYzpishi(String yzpishi) {
		this.yzpishi = yzpishi;
	}

	public String getYzpsresult() {
		return this.yzpsresult;
	}

	public void setYzpsresult(String yzpsresult) {
		this.yzpsresult = yzpsresult;
	}

	public String getExplains() {
		return this.explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

}