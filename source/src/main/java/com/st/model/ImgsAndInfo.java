package com.st.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ImgsAndInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "imgs_and_info", catalog = "st")
public class ImgsAndInfo implements java.io.Serializable {

	// Fields

	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String imgId;
	private String infoId;
	private Boolean main;

	// Constructors

	/** default constructor */
	public ImgsAndInfo() {
	}

	/** minimal constructor */
	public ImgsAndInfo(String id, Integer status, Boolean isDelete,
			String imgId, String infoId, Boolean main) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.imgId = imgId;
		this.infoId = infoId;
		this.main = main;
	}

	/** full constructor */
	public ImgsAndInfo(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String imgId, String infoId, Boolean main) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.imgId = imgId;
		this.infoId = infoId;
		this.main = main;
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

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "updateTime", length = 19)
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

	@Column(name = "imgId", nullable = false, length = 36)
	public String getImgId() {
		return this.imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	@Column(name = "infoId", nullable = false, length = 36)
	public String getInfoId() {
		return this.infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	@Column(name = "main", nullable = false)
	public Boolean getMain() {
		return this.main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}

}