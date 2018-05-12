package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Checktype entity. @author MyEclipse Persistence Tools
 */

public class Checktype implements java.io.Serializable {

	// Fields

	private Integer checktypeid;
	private Examineresult examineresult;
	private Cure cure;
	private String price;
	private Integer sortid3;
	private String explain3;
	private Set sorts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Checktype() {
	}

	/** full constructor */
	public Checktype(Examineresult examineresult, Cure cure, String price, Integer sortid3, String explain3,
			Set sorts) {
		this.examineresult = examineresult;
		this.cure = cure;
		this.price = price;
		this.sortid3 = sortid3;
		this.explain3 = explain3;
		this.sorts = sorts;
	}

	// Property accessors

	public Integer getChecktypeid() {
		return this.checktypeid;
	}

	public void setChecktypeid(Integer checktypeid) {
		this.checktypeid = checktypeid;
	}

	public Examineresult getExamineresult() {
		return this.examineresult;
	}

	public void setExamineresult(Examineresult examineresult) {
		this.examineresult = examineresult;
	}

	public Cure getCure() {
		return this.cure;
	}

	public void setCure(Cure cure) {
		this.cure = cure;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getSortid3() {
		return this.sortid3;
	}

	public void setSortid3(Integer sortid3) {
		this.sortid3 = sortid3;
	}

	public String getExplain3() {
		return this.explain3;
	}

	public void setExplain3(String explain3) {
		this.explain3 = explain3;
	}

	public Set getSorts() {
		return this.sorts;
	}

	public void setSorts(Set sorts) {
		this.sorts = sorts;
	}

}