package com.st.front.officialwebsite.pc.pageModel;

import java.sql.Timestamp;

import com.st.pagemodel.BaseReceivePage;


public class PageServiceFront extends BaseReceivePage {
	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String title;
	private String introduction;
	private Timestamp releaseTime;
	private String clazz;
	private String developers;
	private String investor;
	private String rateOfProgress;
	

	private String eqClazz;
	private String eqRateOfProgress;
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
	public String getDevelopers() {
		return developers;
	}
	public void setDevelopers(String developers) {
		this.developers = developers;
	}
	public String getInvestor() {
		return investor;
	}
	public void setInvestor(String investor) {
		this.investor = investor;
	}
	public String getRateOfProgress() {
		return rateOfProgress;
	}
	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}
	public String getEqClazz() {
		return eqClazz;
	}
	public void setEqClazz(String eqClazz) {
		this.eqClazz = eqClazz;
	}
	public String getEqRateOfProgress() {
		return eqRateOfProgress;
	}
	public void setEqRateOfProgress(String eqRateOfProgress) {
		this.eqRateOfProgress = eqRateOfProgress;
	}
	public PageServiceFront() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageServiceFront(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String title, String introduction, Timestamp releaseTime,
			String clazz, String developers, String investor,
			String rateOfProgress, String eqClazz, String eqRateOfProgress) {
		super();
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.title = title;
		this.introduction = introduction;
		this.releaseTime = releaseTime;
		this.clazz = clazz;
		this.developers = developers;
		this.investor = investor;
		this.rateOfProgress = rateOfProgress;
		this.eqClazz = eqClazz;
		this.eqRateOfProgress = eqRateOfProgress;
	}
					
}