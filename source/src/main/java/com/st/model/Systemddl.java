package com.st.model;

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
 * Systemddl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "systemddl", catalog = "st")
public class Systemddl implements java.io.Serializable {

	// Fields

	private String id;
	private Systemddl systemddl;
	private String iconCls;
	private String text;
	private String url;
	private Integer currtHigh;
	private Integer high;
	private String tb;
	private String field;
	private Integer rank;
	private Set<Systemddl> systemddls = new HashSet<Systemddl>(0);

	// Constructors

	/** default constructor */
	public Systemddl() {
	}

	/** minimal constructor */
	public Systemddl(String id, String text, Integer currtHigh, Integer high) {
		this.id = id;
		this.text = text;
		this.currtHigh = currtHigh;
		this.high = high;
	}

	/** full constructor */
	public Systemddl(String id, Systemddl systemddl, String iconCls,
			String text, String url, Integer currtHigh, Integer high,
			String tb, String field, Integer rank, Set<Systemddl> systemddls) {
		this.id = id;
		this.systemddl = systemddl;
		this.iconCls = iconCls;
		this.text = text;
		this.url = url;
		this.currtHigh = currtHigh;
		this.high = high;
		this.tb = tb;
		this.field = field;
		this.rank = rank;
		this.systemddls = systemddls;
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
	public Systemddl getSystemddl() {
		return this.systemddl;
	}

	public void setSystemddl(Systemddl systemddl) {
		this.systemddl = systemddl;
	}

	@Column(name = "iconCls", length = 50)
	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column(name = "text", nullable = false, length = 100)
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

	@Column(name = "currtHigh", nullable = false)
	public Integer getCurrtHigh() {
		return this.currtHigh;
	}

	public void setCurrtHigh(Integer currtHigh) {
		this.currtHigh = currtHigh;
	}

	@Column(name = "high", nullable = false)
	public Integer getHigh() {
		return this.high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	@Column(name = "tb")
	public String getTb() {
		return this.tb;
	}

	public void setTb(String tb) {
		this.tb = tb;
	}

	@Column(name = "field")
	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Column(name = "rank")
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "systemddl")
	public Set<Systemddl> getSystemddls() {
		return this.systemddls;
	}

	public void setSystemddls(Set<Systemddl> systemddls) {
		this.systemddls = systemddls;
	}

}