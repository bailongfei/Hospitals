package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Floor entity. @author MyEclipse Persistence Tools
 */

public class Floor implements java.io.Serializable {

	// Fields

	private Integer floorid3;
	private Buliding buliding;
	private String floorname;
	private Set rooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Floor() {
	}

	/** full constructor */
	public Floor(Buliding buliding, String floorname, Set rooms) {
		this.buliding = buliding;
		this.floorname = floorname;
		this.rooms = rooms;
	}

	// Property accessors

	public Integer getFloorid3() {
		return this.floorid3;
	}

	public void setFloorid3(Integer floorid3) {
		this.floorid3 = floorid3;
	}

	public Buliding getBuliding() {
		return this.buliding;
	}

	public void setBuliding(Buliding buliding) {
		this.buliding = buliding;
	}

	public String getFloorname() {
		return this.floorname;
	}

	public void setFloorname(String floorname) {
		this.floorname = floorname;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

}