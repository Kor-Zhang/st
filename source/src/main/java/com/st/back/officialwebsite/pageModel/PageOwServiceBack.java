package com.st.back.officialwebsite.pageModel;

import java.sql.Timestamp;

import com.st.pagemodel.BaseReceivePage;

/**
 * @author Kor_Zhang
 *
 */
public class PageOwServiceBack extends BaseReceivePage{
	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp deleteTime;
	private String title;
	private String introduction;
	private Timestamp releaseTime;
	private String clazz;
	private String developers;
	private String investor;
	private String rateOfProgress;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public PageOwServiceBack() {
		super();
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
	@Override
	public String toString() {
		return "PageOwServiceBack [id=" + id + ", status=" + status
				+ ", isDelete=" + isDelete + ", deleteTime=" + deleteTime
				+ ", title=" + title + ", introduction=" + introduction
				+ ", releaseTime=" + releaseTime + ", clazz=" + clazz
				+ ", developers=" + developers + ", investor=" + investor
				+ ", rateOfProgress=" + rateOfProgress + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}

		
}