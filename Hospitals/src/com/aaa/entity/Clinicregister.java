package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clinicregister entity. @author MyEclipse Persistence Tools
 */

public class Clinicregister implements java.io.Serializable {

	// Fields

	private Integer registerId;
	private Integer medicalRecordId;
	private Integer triageId;
	private Integer icid;
	private Integer subscribeId;
	private String stuffId11;
	private String departmentId4;
	private Integer number;
	private Date presentTime;
	private Integer empId;
	private String floorId4;
	private Set triages = new HashSet(0);
	private Set departments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clinicregister() {
	}

	/** full constructor */
	public Clinicregister(Integer medicalRecordId, Integer triageId, Integer icid, Integer subscribeId,
			String stuffId11, String departmentId4, Integer number, Date presentTime, Integer empId, String floorId4,
			Set triages, Set departments) {
		this.medicalRecordId = medicalRecordId;
		this.triageId = triageId;
		this.icid = icid;
		this.subscribeId = subscribeId;
		this.stuffId11 = stuffId11;
		this.departmentId4 = departmentId4;
		this.number = number;
		this.presentTime = presentTime;
		this.empId = empId;
		this.floorId4 = floorId4;
		this.triages = triages;
		this.departments = departments;
	}

	// Property accessors

	public Integer getRegisterId() {
		return this.registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getMedicalRecordId() {
		return this.medicalRecordId;
	}

	public void setMedicalRecordId(Integer medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public Integer getTriageId() {
		return this.triageId;
	}

	public void setTriageId(Integer triageId) {
		this.triageId = triageId;
	}

	public Integer getIcid() {
		return this.icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	public Integer getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(Integer subscribeId) {
		this.subscribeId = subscribeId;
	}

	public String getStuffId11() {
		return this.stuffId11;
	}

	public void setStuffId11(String stuffId11) {
		this.stuffId11 = stuffId11;
	}

	public String getDepartmentId4() {
		return this.departmentId4;
	}

	public void setDepartmentId4(String departmentId4) {
		this.departmentId4 = departmentId4;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getPresentTime() {
		return this.presentTime;
	}

	public void setPresentTime(Date presentTime) {
		this.presentTime = presentTime;
	}

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFloorId4() {
		return this.floorId4;
	}

	public void setFloorId4(String floorId4) {
		this.floorId4 = floorId4;
	}

	public Set getTriages() {
		return this.triages;
	}

	public void setTriages(Set triages) {
		this.triages = triages;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

}