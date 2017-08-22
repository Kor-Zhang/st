package com.st.front.officialwebsite.pc.pageModel;

import java.sql.Timestamp;

import com.st.front.officialwebsite.pc.util.OwFrontTools;
import com.st.pagemodel.BaseReceivePage;

public class PageContactUsFront extends BaseReceivePage{
	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String name;
	private String orgName;
	private String email;
	private String phoneNumber;
	private String msg;
	private String adminNote;
	private String dealAdminId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMsg() {
		return OwFrontTools.cleanStringWrap(msg);
	}
	public void setMsg(String msg) {
		this.msg = OwFrontTools.cleanStringWrap(msg);
	}
	public String getAdminNote() {
		return adminNote;
	}
	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}
	public String getDealAdminId() {
		return dealAdminId;
	}
	public void setDealAdminId(String dealAdminId) {
		this.dealAdminId = dealAdminId;
	}
	public PageContactUsFront() {
		super();
	}
		
}