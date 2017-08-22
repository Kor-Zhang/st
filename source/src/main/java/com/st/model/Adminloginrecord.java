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
 * Adminloginrecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adminloginrecord", catalog = "st")
public class Adminloginrecord implements java.io.Serializable {

	// Fields

	private String loginRecordId;
	private Admins admins;
	private Timestamp loginTime;
	private Timestamp logoffTime;
	private String loginAddress;
	private String loginIp;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public Adminloginrecord() {
	}

	/** full constructor */
	public Adminloginrecord(String loginRecordId, Admins admins,
			Timestamp loginTime, Timestamp logoffTime, String loginAddress,
			String loginIp, Boolean isDelete) {
		this.loginRecordId = loginRecordId;
		this.admins = admins;
		this.loginTime = loginTime;
		this.logoffTime = logoffTime;
		this.loginAddress = loginAddress;
		this.loginIp = loginIp;
		this.isDelete = isDelete;
	}

	// Property accessors
	@Id
	@Column(name = "loginRecordId", unique = true, nullable = false, length = 36)
	public String getLoginRecordId() {
		return this.loginRecordId;
	}

	public void setLoginRecordId(String loginRecordId) {
		this.loginRecordId = loginRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId", nullable = false)
	public Admins getAdmins() {
		return this.admins;
	}

	public void setAdmins(Admins admins) {
		this.admins = admins;
	}

	@Column(name = "loginTime", nullable = false, length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "logoffTime", nullable = false, length = 19)
	public Timestamp getLogoffTime() {
		return this.logoffTime;
	}

	public void setLogoffTime(Timestamp logoffTime) {
		this.logoffTime = logoffTime;
	}

	@Column(name = "loginAddress", nullable = false)
	public String getLoginAddress() {
		return this.loginAddress;
	}

	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}

	@Column(name = "loginIP", nullable = false)
	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}