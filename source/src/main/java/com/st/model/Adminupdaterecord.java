package com.st.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Adminupdaterecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adminupdaterecord", catalog = "st")
public class Adminupdaterecord implements java.io.Serializable {

	// Fields

	private String updateRecordId;
	private Admins adminsByDoneAdminId;
	private Admins adminsByDoAdminId;
	private String item;
	private Timestamp updateTime;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public Adminupdaterecord() {
	}

	/** full constructor */
	public Adminupdaterecord(String updateRecordId, Admins adminsByDoneAdminId,
			Admins adminsByDoAdminId, String item, Timestamp updateTime,
			Boolean isDelete) {
		this.updateRecordId = updateRecordId;
		this.adminsByDoneAdminId = adminsByDoneAdminId;
		this.adminsByDoAdminId = adminsByDoAdminId;
		this.item = item;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
	}

	// Property accessors
	@Id
	@Column(name = "updateRecordId", unique = true, nullable = false, length = 36)
	public String getUpdateRecordId() {
		return this.updateRecordId;
	}

	public void setUpdateRecordId(String updateRecordId) {
		this.updateRecordId = updateRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doneAdminId", nullable = false)
	public Admins getAdminsByDoneAdminId() {
		return this.adminsByDoneAdminId;
	}

	public void setAdminsByDoneAdminId(Admins adminsByDoneAdminId) {
		this.adminsByDoneAdminId = adminsByDoneAdminId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doAdminId", nullable = false)
	public Admins getAdminsByDoAdminId() {
		return this.adminsByDoAdminId;
	}

	public void setAdminsByDoAdminId(Admins adminsByDoAdminId) {
		this.adminsByDoAdminId = adminsByDoAdminId;
	}

	@Column(name = "item", nullable = false)
	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "updateTime", nullable = false, length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}