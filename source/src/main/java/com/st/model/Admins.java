package com.st.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Admins entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admins", catalog = "st")
public class Admins implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String password;
	private Integer status;
	private Integer isSuperAdmin;
	private String theme;
	private Timestamp createTime;
	private Boolean isDelete;
	private String introduction;
	private Set<Adminupdaterecord> adminupdaterecordsForDoneAdminId = new HashSet<Adminupdaterecord>(
			0);
	private Set<Adminupdaterecord> adminupdaterecordsForDoAdminId = new HashSet<Adminupdaterecord>(
			0);
	private Set<Adminpower> adminpowers = new HashSet<Adminpower>(0);
	private Set<Adminloginrecord> adminloginrecords = new HashSet<Adminloginrecord>(
			0);
	private Set<Notices> noticeses = new HashSet<Notices>(0);

	// Constructors

	/** default constructor */
	public Admins() {
	}

	/** minimal constructor */
	public Admins(String id, String password, Integer status,
			Integer isSuperAdmin, String theme, Timestamp createTime,
			Boolean isDelete, String introduction) {
		this.id = id;
		this.password = password;
		this.status = status;
		this.isSuperAdmin = isSuperAdmin;
		this.theme = theme;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.introduction = introduction;
	}

	/** full constructor */
	public Admins(String id, String name, String password, Integer status,
			Integer isSuperAdmin, String theme, Timestamp createTime,
			Boolean isDelete, String introduction,
			Set<Adminupdaterecord> adminupdaterecordsForDoneAdminId,
			Set<Adminupdaterecord> adminupdaterecordsForDoAdminId,
			Set<Adminpower> adminpowers,
			Set<Adminloginrecord> adminloginrecords, Set<Notices> noticeses) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.status = status;
		this.isSuperAdmin = isSuperAdmin;
		this.theme = theme;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.introduction = introduction;
		this.adminupdaterecordsForDoneAdminId = adminupdaterecordsForDoneAdminId;
		this.adminupdaterecordsForDoAdminId = adminupdaterecordsForDoAdminId;
		this.adminpowers = adminpowers;
		this.adminloginrecords = adminloginrecords;
		this.noticeses = noticeses;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 36)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "isSuperAdmin", nullable = false)
	public Integer getIsSuperAdmin() {
		return this.isSuperAdmin;
	}

	public void setIsSuperAdmin(Integer isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	@Column(name = "theme", nullable = false)
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "introduction", nullable = false)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adminsByDoneAdminId")
	public Set<Adminupdaterecord> getAdminupdaterecordsForDoneAdminId() {
		return this.adminupdaterecordsForDoneAdminId;
	}

	public void setAdminupdaterecordsForDoneAdminId(
			Set<Adminupdaterecord> adminupdaterecordsForDoneAdminId) {
		this.adminupdaterecordsForDoneAdminId = adminupdaterecordsForDoneAdminId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adminsByDoAdminId")
	public Set<Adminupdaterecord> getAdminupdaterecordsForDoAdminId() {
		return this.adminupdaterecordsForDoAdminId;
	}

	public void setAdminupdaterecordsForDoAdminId(
			Set<Adminupdaterecord> adminupdaterecordsForDoAdminId) {
		this.adminupdaterecordsForDoAdminId = adminupdaterecordsForDoAdminId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admins")
	public Set<Adminpower> getAdminpowers() {
		return this.adminpowers;
	}

	public void setAdminpowers(Set<Adminpower> adminpowers) {
		this.adminpowers = adminpowers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admins")
	public Set<Adminloginrecord> getAdminloginrecords() {
		return this.adminloginrecords;
	}

	public void setAdminloginrecords(Set<Adminloginrecord> adminloginrecords) {
		this.adminloginrecords = adminloginrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admins")
	public Set<Notices> getNoticeses() {
		return this.noticeses;
	}

	public void setNoticeses(Set<Notices> noticeses) {
		this.noticeses = noticeses;
	}

}