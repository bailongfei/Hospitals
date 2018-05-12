package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Stuff entity. @author MyEclipse Persistence Tools
 */

public class Stuff implements java.io.Serializable {

	// Fields

	private Integer stuffid;
	private Jobtitle jobtitle;
	private Doctorwork doctorwork;
	private Position position;
	private Stufftype stufftype;
	private Department department;
	private NurseWatch nurseWatch;
	private String stuffname;
	private String sex;
	private String idcard;
	private String address;
	private String phone;
	private Date hiredate;
	private Date pbirthday;
	private String nation;
	private String cardNo;
	private String nativePlace;
	private String politics;
	private String photo;
	private Integer roomstate;
	private String stuffaccount;
	private String stuffpwd;
	private Set beds = new HashSet(0);
	private Set advices = new HashSet(0);
	private Set outhospitals = new HashSet(0);

	// Constructors

	/** default constructor */
	public Stuff() {
	}

	/** full constructor */
	public Stuff(Jobtitle jobtitle, Doctorwork doctorwork, Position position, Stufftype stufftype,
			Department department, NurseWatch nurseWatch, String stuffname, String sex, String idcard, String address,
			String phone, Date hiredate, Date pbirthday, String nation, String cardNo, String nativePlace,
			String politics, String photo, Integer roomstate, String stuffaccount, String stuffpwd, Set beds,
			Set advices, Set outhospitals) {
		this.jobtitle = jobtitle;
		this.doctorwork = doctorwork;
		this.position = position;
		this.stufftype = stufftype;
		this.department = department;
		this.nurseWatch = nurseWatch;
		this.stuffname = stuffname;
		this.sex = sex;
		this.idcard = idcard;
		this.address = address;
		this.phone = phone;
		this.hiredate = hiredate;
		this.pbirthday = pbirthday;
		this.nation = nation;
		this.cardNo = cardNo;
		this.nativePlace = nativePlace;
		this.politics = politics;
		this.photo = photo;
		this.roomstate = roomstate;
		this.stuffaccount = stuffaccount;
		this.stuffpwd = stuffpwd;
		this.beds = beds;
		this.advices = advices;
		this.outhospitals = outhospitals;
	}

	// Property accessors

	public Integer getStuffid() {
		return this.stuffid;
	}

	public void setStuffid(Integer stuffid) {
		this.stuffid = stuffid;
	}

	public Jobtitle getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(Jobtitle jobtitle) {
		this.jobtitle = jobtitle;
	}

	public Doctorwork getDoctorwork() {
		return this.doctorwork;
	}

	public void setDoctorwork(Doctorwork doctorwork) {
		this.doctorwork = doctorwork;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Stufftype getStufftype() {
		return this.stufftype;
	}

	public void setStufftype(Stufftype stufftype) {
		this.stufftype = stufftype;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public NurseWatch getNurseWatch() {
		return this.nurseWatch;
	}

	public void setNurseWatch(NurseWatch nurseWatch) {
		this.nurseWatch = nurseWatch;
	}

	public String getStuffname() {
		return this.stuffname;
	}

	public void setStuffname(String stuffname) {
		this.stuffname = stuffname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Date getPbirthday() {
		return this.pbirthday;
	}

	public void setPbirthday(Date pbirthday) {
		this.pbirthday = pbirthday;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getPolitics() {
		return this.politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getRoomstate() {
		return this.roomstate;
	}

	public void setRoomstate(Integer roomstate) {
		this.roomstate = roomstate;
	}

	public String getStuffaccount() {
		return this.stuffaccount;
	}

	public void setStuffaccount(String stuffaccount) {
		this.stuffaccount = stuffaccount;
	}

	public String getStuffpwd() {
		return this.stuffpwd;
	}

	public void setStuffpwd(String stuffpwd) {
		this.stuffpwd = stuffpwd;
	}

	public Set getBeds() {
		return this.beds;
	}

	public void setBeds(Set beds) {
		this.beds = beds;
	}

	public Set getAdvices() {
		return this.advices;
	}

	public void setAdvices(Set advices) {
		this.advices = advices;
	}

	public Set getOuthospitals() {
		return this.outhospitals;
	}

	public void setOuthospitals(Set outhospitals) {
		this.outhospitals = outhospitals;
	}

}