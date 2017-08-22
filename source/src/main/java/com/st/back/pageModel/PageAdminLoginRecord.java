package com.st.back.pageModel;

import java.sql.Timestamp;

import com.st.pagemodel.BaseReceivePage;


public class PageAdminLoginRecord extends BaseReceivePage implements java.io.Serializable{
	
	
	private String loginRecordId;
	private String id;
	private Timestamp loginTime;
	private Timestamp logoffTime;
	private String loginAddress;
	private String loginIp;

	private String adminId;
	
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getLoginRecordId() {
		return loginRecordId;
	}
	public void setLoginRecordId(String loginRecordId) {
		this.loginRecordId = loginRecordId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public Timestamp getLogoffTime() {
		return logoffTime;
	}
	public void setLogoffTime(Timestamp logoffTime) {
		this.logoffTime = logoffTime;
	}
	public String getLoginAddress() {
		return loginAddress;
	}
	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	
	
}
