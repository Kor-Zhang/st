package com.st.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OfficialwebsiteAboutUs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "officialwebsite_about_us", catalog = "st")
public class OfficialwebsiteAboutUs implements java.io.Serializable {

	// Fields

	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String introduction;
	private String imgName;

	// Constructors

	/** default constructor */
	public OfficialwebsiteAboutUs() {
	}

	/** minimal constructor */
	public OfficialwebsiteAboutUs(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, String imgName) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.imgName = imgName;
	}

	/** full constructor */
	public OfficialwebsiteAboutUs(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String introduction, String imgName) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.introduction = introduction;
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

	@Column(name = "introduction")
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "imgName", nullable = false)
	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}