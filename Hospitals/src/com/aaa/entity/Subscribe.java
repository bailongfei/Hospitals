package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Subscribe entity. @author MyEclipse Persistence Tools
 */

public class Subscribe implements java.io.Serializable {

	// Fields

	private Integer subscribeId;
	private Integer icid;
	private Integer registerId;
	private Integer patientId;
	private String departmentId4;
	private String subscribeType;
	private String stuffId11;
	private String subscribeContent;
	private Integer subscribeNumber;
	private Date subscribeTime;
	private Date visitTime3;
	private String remark6;
	private Integer state8;
	private Set icclips = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subscribe() {
	}

	/** full constructor */
	public Subscribe(Integer icid, Integer registerId, Integer patientId, String departmentId4, String subscribeType,
			String stuffId11, String subscribeContent, Integer subscribeNumber, Date subscribeTime, Date visitTime3,
			String remark6, Integer state8, Set icclips) {
		this.icid = icid;
		this.registerId = registerId;
		this.patientId = patientId;
		this.departmentId4 = departmentId4;
		this.subscribeType = subscribeType;
		this.stuffId11 = stuffId11;
		this.subscribeContent = subscribeContent;
		this.subscribeNumber = subscribeNumber;
		this.subscribeTime = subscribeTime;
		this.visitTime3 = visitTime3;
		this.remark6 = remark6;
		this.state8 = state8;
		this.icclips = icclips;
	}

	// Property accessors

	public Integer getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(Integer subscribeId) {
		this.subscribeId = subscribeId;
	}

	public Integer getIcid() {
		return this.icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	public Integer getRegisterId() {
		return this.registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getDepartmentId4() {
		return this.departmentId4;
	}

	public void setDepartmentId4(String departmentId4) {
		this.departmentId4 = departmentId4;
	}

	public String getSubscribeType() {
		return this.subscribeType;
	}

	public void setSubscribeType(String subscribeType) {
		this.subscribeType = subscribeType;
	}

	public String getStuffId11() {
		return this.stuffId11;
	}

	public void setStuffId11(String stuffId11) {
		this.stuffId11 = stuffId11;
	}

	public String getSubscribeContent() {
		return this.subscribeContent;
	}

	public void setSubscribeContent(String subscribeContent) {
		this.subscribeContent = subscribeContent;
	}

	public Integer getSubscribeNumber() {
		return this.subscribeNumber;
	}

	public void setSubscribeNumber(Integer subscribeNumber) {
		this.subscribeNumber = subscribeNumber;
	}

	public Date getSubscribeTime() {
		return this.subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Date getVisitTime3() {
		return this.visitTime3;
	}

	public void setVisitTime3(Date visitTime3) {
		this.visitTime3 = visitTime3;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public Integer getState8() {
		return this.state8;
	}

	public void setState8(Integer state8) {
		this.state8 = state8;
	}

	public Set getIcclips() {
		return this.icclips;
	}

	public void setIcclips(Set icclips) {
		this.icclips = icclips;
	}

}