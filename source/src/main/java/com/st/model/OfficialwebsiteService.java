package com.st.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OfficialwebsiteService entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "officialwebsite_service", catalog = "st")
public class OfficialwebsiteService implements java.io.Serializable {

	// Fields

	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String title;
	private String introduction;
	private Timestamp releaseTime;
	private String clazz;
	private String developers;
	private String investor;
	private String rateOfProgress;

	// Constructors

	/** default constructor */
	public OfficialwebsiteService() {
	}

	/** minimal constructor */
	public OfficialwebsiteService(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, String title,
			String introduction, Timestamp releaseTime, String clazz) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.title = title;
		this.introduction = introduction;
		this.releaseTime = releaseTime;
		this.clazz = clazz;
	}

	/** full constructor */
	public OfficialwebsiteService(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String title, String introduction, Timestamp releaseTime,
			String clazz, String developers, String investor,
			String rateOfProgress) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.title = title;
		this.introduction = introduction;
		this.releaseTime = releaseTime;
		this.clazz = clazz;
		this.developers = developers;
		this.investor = investor;
		this.rateOfProgress = rateOfProgress;
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

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "introduction", nullable = false, length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "releaseTime", nullable = false, length = 19)
	public Timestamp getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Column(name = "clazz", nullable = false)
	public String getClazz() {
		return this.clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	@Column(name = "developers")
	public String getDevelopers() {
		return this.developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers;
	}

	@Column(name = "investor")
	public String getInvestor() {
		return this.investor;
	}

	public void setInvestor(String investor) {
		this.investor = investor;
	}

	@Column(name = "rateOfProgress")
	public String getRateOfProgress() {
		return this.rateOfProgress;
	}

	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}

}