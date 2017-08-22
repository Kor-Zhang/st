package com.st.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OfficialwebsiteNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "officialwebsite_news", catalog = "st")
public class OfficialwebsiteNews implements java.io.Serializable {

	// Fields

	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String title;
	private String text;
	private String authour;
	private Timestamp releaseTime;
	private String clazz;

	// Constructors

	/** default constructor */
	public OfficialwebsiteNews() {
	}

	/** minimal constructor */
	public OfficialwebsiteNews(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, String title,
			String text, String authour, Timestamp releaseTime, String clazz) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.title = title;
		this.text = text;
		this.authour = authour;
		this.releaseTime = releaseTime;
		this.clazz = clazz;
	}

	/** full constructor */
	public OfficialwebsiteNews(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String title, String text, String authour, Timestamp releaseTime,
			String clazz) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.title = title;
		this.text = text;
		this.authour = authour;
		this.releaseTime = releaseTime;
		this.clazz = clazz;
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

	@Column(name = "text", nullable = false, length = 65535)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "authour", nullable = false)
	public String getAuthour() {
		return this.authour;
	}

	public void setAuthour(String authour) {
		this.authour = authour;
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

}