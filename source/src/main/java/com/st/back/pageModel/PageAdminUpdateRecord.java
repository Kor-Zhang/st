package com.st.back.pageModel;

import java.sql.Timestamp;

import com.st.pagemodel.BaseReceivePage;

public class PageAdminUpdateRecord  extends BaseReceivePage implements java.io.Serializable {
	

	private String updateRecordId;
	private String doneAdminId;
	private String doAdminId;
	private String item;
	private Timestamp updateTime;
	

	public String getUpdateRecordId() {
		return updateRecordId;
	}
	public void setUpdateRecordId(String updateRecordId) {
		this.updateRecordId = updateRecordId;
	}
	public String getDoneAdminId() {
		return doneAdminId;
	}
	public void setDoneAdminId(String doneAdminId) {
		this.doneAdminId = doneAdminId;
	}
	public String getDoAdminId() {
		return doAdminId;
	}
	public void setDoAdminId(String doAdminId) {
		this.doAdminId = doAdminId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public PageAdminUpdateRecord(String updateRecordId, String doneAdminId,
			String doAdminId, String item, Timestamp updateTime) {
		super();
		this.updateRecordId = updateRecordId;
		this.doneAdminId = doneAdminId;
		this.doAdminId = doAdminId;
		this.item = item;
		this.updateTime = updateTime;
	}
	public PageAdminUpdateRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}