package com.aaa.entity;

/**
 * Relationship42Id entity. @author MyEclipse Persistence Tools
 */

public class Relationship42Id implements java.io.Serializable {

	// Fields

	private Bed bed;
	private Patient patient;

	// Constructors

	/** default constructor */
	public Relationship42Id() {
	}

	/** full constructor */
	public Relationship42Id(Bed bed, Patient patient) {
		this.bed = bed;
		this.patient = patient;
	}

	// Property accessors

	public Bed getBed() {
		return this.bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Relationship42Id))
			return false;
		Relationship42Id castOther = (Relationship42Id) other;

		return ((this.getBed() == castOther.getBed())
				|| (this.getBed() != null && castOther.getBed() != null && this.getBed().equals(castOther.getBed())))
				&& ((this.getPatient() == castOther.getPatient()) || (this.getPatient() != null
						&& castOther.getPatient() != null && this.getPatient().equals(castOther.getPatient())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBed() == null ? 0 : this.getBed().hashCode());
		result = 37 * result + (getPatient() == null ? 0 : this.getPatient().hashCode());
		return result;
	}

}