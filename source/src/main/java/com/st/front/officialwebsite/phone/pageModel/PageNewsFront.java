package com.st.front.officialwebsite.phone.pageModel;

import java.sql.Timestamp;

import com.st.pagemodel.BaseReceivePage;


public class PageNewsFront extends BaseReceivePage {
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
	

	private String eqClazz;
	
	public String getEqClazz() {
		return eqClazz;
	}
	public void setEqClazz(String eqClazz) {
		this.eqClazz = eqClazz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAuthour() {
		return authour;
	}
	public void setAuthour(String authour) {
		this.authour = authour;
	}
	public Timestamp getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "PageNewsFront [id=" + id + ", status=" + status + ", isDelete="
				+ isDelete + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", deleteTime=" + deleteTime + ", title="
				+ title + ", text=" + text + ", authour=" + authour
				+ ", releaseTime=" + releaseTime + ", clazz=" + clazz + "]";
	}
	public PageNewsFront() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageNewsFront(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String title, String text, String authour, Timestamp releaseTime,
			String clazz) {
		super();
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
				
}