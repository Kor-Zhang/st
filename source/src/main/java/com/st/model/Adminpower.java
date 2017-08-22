package com.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Adminpower entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adminpower", catalog = "st")
public class Adminpower implements java.io.Serializable {

	// Fields

	private String id;
	private Powers powers;
	private Admins admins;
	private Integer status;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public Adminpower() {
	}

	/** full constructor */
	public Adminpower(String id, Powers powers, Admins admins, Integer status,
			Boolean isDelete) {
		this.id = id;
		this.powers = powers;
		this.admins = admins;
		this.status = status;
		this.isDelete = isDelete;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "powerId", nullable = false)
	public Powers getPowers() {
		return this.powers;
	}

	public void setPowers(Powers powers) {
		this.powers = powers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId", nullable = false)
	public Admins getAdmins() {
		return this.admins;
	}

	public void setAdmins(Admins admins) {
		this.admins = admins;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}