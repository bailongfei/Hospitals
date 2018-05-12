package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private Integer roomid3;
	private Sort sort;
	private Floor floor;
	private String roomname;
	private String roomtype;
	private Integer state8;
	private Set departments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** full constructor */
	public Room(Sort sort, Floor floor, String roomname, String roomtype, Integer state8, Set departments) {
		this.sort = sort;
		this.floor = floor;
		this.roomname = roomname;
		this.roomtype = roomtype;
		this.state8 = state8;
		this.departments = departments;
	}

	// Property accessors

	public Integer getRoomid3() {
		return this.roomid3;
	}

	public void setRoomid3(Integer roomid3) {
		this.roomid3 = roomid3;
	}

	public Sort getSort() {
		return this.sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Floor getFloor() {
		return this.floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public String getRoomname() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getState8() {
		return this.state8;
	}

	public void setState8(Integer state8) {
		this.state8 = state8;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

}