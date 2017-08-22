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
 * Menutree entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menutree", catalog = "st")
public class Menutree implements java.io.Serializable {

	// Fields

	private String id;
	private Menutree menutree;
	private String iconCls;
	private String text;
	private String url;
	private Set<Menutree> menutrees = new HashSet<Menutree>(0);

	// Constructors

	/** default constructor */
	public Menutree() {
	}

	/** minimal constructor */
	public Menutree(String id, String text) {
		this.id = id;
		this.text = text;
	}

	/** full constructor */
	public Menutree(String id, Menutree menutree, String iconCls, String text,
			String url, Set<Menutree> menutrees) {
		this.id = id;
		this.menutree = menutree;
		this.iconCls = iconCls;
		this.text = text;
		this.url = url;
		this.menutrees = menutrees;
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
	public Menutree getMenutree() {
		return this.menutree;
	}

	public void setMenutree(Menutree menutree) {
		this.menutree = menutree;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menutree")
	public Set<Menutree> getMenutrees() {
		return this.menutrees;
	}

	public void setMenutrees(Set<Menutree> menutrees) {
		this.menutrees = menutrees;
	}

}