package com.st.front.officialwebsite.phone.pageModel;

import java.sql.Timestamp;

import com.st.pagemodel.BaseReceivePage;


public class PageAboutUsFront extends BaseReceivePage {
	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp deleteTime;
	private String introduction;
	private String imgName;
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
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public PageAboutUsFront() {
		super();
	}			
}