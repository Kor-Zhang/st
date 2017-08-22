package com.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Imgs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "imgs", catalog = "st")
public class Imgs implements java.io.Serializable {

	// Fields

	private String id;
	private String imgName;

	// Constructors

	/** default constructor */
	public Imgs() {
	}

	/** full constructor */
	public Imgs(String id, String imgName) {
		this.id = id;
		this.imgName = imgName;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "imgName", nullable = false)
	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}