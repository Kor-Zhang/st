package com.st.back.pageModel;

import java.io.Serializable;
import java.sql.Timestamp;

import com.st.pagemodel.BaseReceivePage;

public class PageAdmins extends BaseReceivePage implements Serializable{
	/**特殊字段**/
	private Boolean online;
	private String msg;
	private Boolean success;
	
	private String id;
	private String password;
	private Integer status;
	private Integer isSuperAdmin;
	private Integer canAdd;
	private Integer canDelete;
	private Integer canQuery;
	private Integer canUpdate;
	private Integer canAddAdmin;
	private Integer canDeleteAdmin;
	private Integer canQueryAdmin;
	private Integer canUpdateAdmin;
	private String theme;
	private Timestamp createTime;
	private Boolean isDelete;
	private String introduction;
	
	
	/***************搜索条件****************/
	private String searchId;
	private Integer searchStatus;
	private Integer searchCanAdd;
	private Integer searchCanDelete;
	private Integer searchCanQuery;
	private Integer searchCanUpdate;
	private Integer searchCanAddAdmin;
	private Integer searchCanDeleteAdmin;
	private Integer searchCanQueryAdmin;
	private Integer searchCanUpdateAdmin;
	private String searchTheme;
	private Timestamp maxCreateTime;
	private Timestamp minCreateTime;
	private String searchIntroduction;
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsSuperAdmin() {
		return isSuperAdmin;
	}
	public void setIsSuperAdmin(Integer isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
	public Integer getCanAdd() {
		return canAdd;
	}
	public void setCanAdd(Integer canAdd) {
		this.canAdd = canAdd;
	}
	public Integer getCanDelete() {
		return canDelete;
	}
	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
	}
	public Integer getCanQuery() {
		return canQuery;
	}
	public void setCanQuery(Integer canQuery) {
		this.canQuery = canQuery;
	}
	public Integer getCanUpdate() {
		return canUpdate;
	}
	public void setCanUpdate(Integer canUpdate) {
		this.canUpdate = canUpdate;
	}
	public Integer getCanAddAdmin() {
		return canAddAdmin;
	}
	public void setCanAddAdmin(Integer canAddAdmin) {
		this.canAddAdmin = canAddAdmin;
	}
	public Integer getCanDeleteAdmin() {
		return canDeleteAdmin;
	}
	public void setCanDeleteAdmin(Integer canDeleteAdmin) {
		this.canDeleteAdmin = canDeleteAdmin;
	}
	public Integer getCanQueryAdmin() {
		return canQueryAdmin;
	}
	public void setCanQueryAdmin(Integer canQueryAdmin) {
		this.canQueryAdmin = canQueryAdmin;
	}
	public Integer getCanUpdateAdmin() {
		return canUpdateAdmin;
	}
	public void setCanUpdateAdmin(Integer canUpdateAdmin) {
		this.canUpdateAdmin = canUpdateAdmin;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public Integer getSearchStatus() {
		return searchStatus;
	}
	public void setSearchStatus(Integer searchStatus) {
		this.searchStatus = searchStatus;
	}
	public Integer getSearchCanAdd() {
		return searchCanAdd;
	}
	public void setSearchCanAdd(Integer searchCanAdd) {
		this.searchCanAdd = searchCanAdd;
	}
	public Integer getSearchCanDelete() {
		return searchCanDelete;
	}
	public void setSearchCanDelete(Integer searchCanDelete) {
		this.searchCanDelete = searchCanDelete;
	}
	public Integer getSearchCanQuery() {
		return searchCanQuery;
	}
	public void setSearchCanQuery(Integer searchCanQuery) {
		this.searchCanQuery = searchCanQuery;
	}
	public Integer getSearchCanUpdate() {
		return searchCanUpdate;
	}
	public void setSearchCanUpdate(Integer searchCanUpdate) {
		this.searchCanUpdate = searchCanUpdate;
	}
	public Integer getSearchCanAddAdmin() {
		return searchCanAddAdmin;
	}
	public void setSearchCanAddAdmin(Integer searchCanAddAdmin) {
		this.searchCanAddAdmin = searchCanAddAdmin;
	}
	public Integer getSearchCanDeleteAdmin() {
		return searchCanDeleteAdmin;
	}
	public void setSearchCanDeleteAdmin(Integer searchCanDeleteAdmin) {
		this.searchCanDeleteAdmin = searchCanDeleteAdmin;
	}
	public Integer getSearchCanQueryAdmin() {
		return searchCanQueryAdmin;
	}
	public void setSearchCanQueryAdmin(Integer searchCanQueryAdmin) {
		this.searchCanQueryAdmin = searchCanQueryAdmin;
	}
	public Integer getSearchCanUpdateAdmin() {
		return searchCanUpdateAdmin;
	}
	public void setSearchCanUpdateAdmin(Integer searchCanUpdateAdmin) {
		this.searchCanUpdateAdmin = searchCanUpdateAdmin;
	}
	public String getSearchTheme() {
		return searchTheme;
	}
	public void setSearchTheme(String searchTheme) {
		this.searchTheme = searchTheme;
	}
	public Timestamp getMaxCreateTime() {
		return maxCreateTime;
	}
	public void setMaxCreateTime(Timestamp maxCreateTime) {
		this.maxCreateTime = maxCreateTime;
	}
	public Timestamp getMinCreateTime() {
		return minCreateTime;
	}
	public void setMinCreateTime(Timestamp minCreateTime) {
		this.minCreateTime = minCreateTime;
	}
	public String getSearchIntroduction() {
		return searchIntroduction;
	}
	public void setSearchIntroduction(String searchIntroduction) {
		this.searchIntroduction = searchIntroduction;
	}
	@Override
	public String toString() {
		return "PageAdmins [online=" + online + ", msg=" + msg + ", success="
				+ success + ", id=" + id + ", password=" + password
				+ ", status=" + status + ", isSuperAdmin=" + isSuperAdmin
				+ ", canAdd=" + canAdd + ", canDelete=" + canDelete
				+ ", canQuery=" + canQuery + ", canUpdate=" + canUpdate
				+ ", canAddAdmin=" + canAddAdmin + ", canDeleteAdmin="
				+ canDeleteAdmin + ", canQueryAdmin=" + canQueryAdmin
				+ ", canUpdateAdmin=" + canUpdateAdmin + ", theme=" + theme
				+ ", createTime=" + createTime + ", isDelete=" + isDelete
				+ ", introduction=" + introduction + ", searchId=" + searchId
				+ ", searchStatus=" + searchStatus + ", searchCanAdd="
				+ searchCanAdd + ", searchCanDelete=" + searchCanDelete
				+ ", searchCanQuery=" + searchCanQuery + ", searchCanUpdate="
				+ searchCanUpdate + ", searchCanAddAdmin=" + searchCanAddAdmin
				+ ", searchCanDeleteAdmin=" + searchCanDeleteAdmin
				+ ", searchCanQueryAdmin=" + searchCanQueryAdmin
				+ ", searchCanUpdateAdmin=" + searchCanUpdateAdmin
				+ ", searchTheme=" + searchTheme + ", maxCreateTime="
				+ maxCreateTime + ", minCreateTime=" + minCreateTime
				+ ", searchIntroduction=" + searchIntroduction + "]";
	}
	
}
