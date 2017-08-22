package com.st.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OfficialwebsiteContactUs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "officialwebsite_contact_us", catalog = "st")
public class OfficialwebsiteContactUs implements java.io.Serializable {

	// Fields

	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String name;
	private String orgName;
	private String email;
	private String phoneNumber;
	private String msg;
	private String adminNote;
	private String dealAdminId;

	// Constructors

	/** default constructor */
	public OfficialwebsiteContactUs() {
	}

	/** minimal constructor */
	public OfficialwebsiteContactUs(String id, Integer status,
			Boolean isDelete, Timestamp createTime, Timestamp updateTime,
			String name, String orgName, String email, String phoneNumber,
			String msg) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.name = name;
		this.orgName = orgName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.msg = msg;
	}

	/** full constructor */
	public OfficialwebsiteContactUs(String id, Integer status,
			Boolean isDelete, Timestamp createTime, Timestamp updateTime,
			Timestamp deleteTime, String name, String orgName, String email,
			String phoneNumber, String msg, String adminNote, String dealAdminId) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.name = name;
		this.orgName = orgName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.msg = msg;
		this.adminNote = adminNote;
		this.dealAdminId = dealAdminId;
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

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "updateTime", nullable = false, length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "deleteTime", length = 19)
	public Timestamp getDeleteTime() {
		return this.deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "orgName", nullable = false)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phoneNumber", nullable = false, length = 25)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "msg", nullable = false)
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name = "adminNote", length = 65535)
	public String getAdminNote() {
		return this.adminNote;
	}

	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}

	@Column(name = "dealAdminId", length = 36)
	public String getDealAdminId() {
		return this.dealAdminId;
	}

	public void setDealAdminId(String dealAdminId) {
		this.dealAdminId = dealAdminId;
	}

}