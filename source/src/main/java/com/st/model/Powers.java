package com.st.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Powers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "powers", catalog = "st")
public class Powers implements java.io.Serializable {

	// Fields

	private String id;
	private Powers powers;
	private String text;
	private String url;
	private String iconCls;
	private Timestamp createTime;
	private Integer status;
	private Boolean isDelete;
	private Set<Powers> powerses = new HashSet<Powers>(0);
	private Set<Adminpower> adminpowers = new HashSet<Adminpower>(0);

	// Constructors

	/** default constructor */
	public Powers() {
	}

	/** minimal constructor */
	public Powers(String id, String text, Timestamp createTime, Integer status,
			Boolean isDelete) {
		this.id = id;
		this.text = text;
		this.createTime = createTime;
		this.status = status;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public Powers(String id, Powers powers, String text, String url,
			String iconCls, Timestamp createTime, Integer status,
			Boolean isDelete, Set<Powers> powerses, Set<Adminpower> adminpowers) {
		this.id = id;
		this.powers = powers;
		this.text = text;
		this.url = url;
		this.iconCls = iconCls;
		this.createTime = createTime;
		this.status = status;
		this.isDelete = isDelete;
		this.powerses = powerses;
		this.adminpowers = adminpowers;
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
	@JoinColumn(name = "parentId")
	public Powers getPowers() {
		return this.powers;
	}

	public void setPowers(Powers powers) {
		this.powers = powers;
	}

	@Column(name = "text", nullable = false)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "iconCls")
	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "powers")
	public Set<Powers> getPowerses() {
		return this.powerses;
	}

	public void setPowerses(Set<Powers> powerses) {
		this.powerses = powerses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "powers")
	public Set<Adminpower> getAdminpowers() {
		return this.adminpowers;
	}

	public void setAdminpowers(Set<Adminpower> adminpowers) {
		this.adminpowers = adminpowers;
	}

}