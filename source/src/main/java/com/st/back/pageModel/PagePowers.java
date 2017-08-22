package com.st.back.pageModel;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.st.pagemodel.BaseReceivePage;

public class PagePowers  extends BaseReceivePage implements java.io.Serializable {
	private String id;
	private String powerId;
	private String text;
	private String url;
	private String iconCls;
	private Timestamp createTime;
	private Integer status;
	private Boolean isDelete;
	private String state;
	private List<PagePowers> children;
	private Boolean checked;
	//选中的权限
	private String checkedId;
	//id当前查询额admin的
	private String adminId;
	
	
	
	public String getCheckedId() {
		return checkedId;
	}
	public void setCheckedId(String checkedId) {
		this.checkedId = checkedId;
	}
	public List<PagePowers> getChildren() {
		return children;
	}
	public void setChildren(List<PagePowers> children) {
		this.children = children;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	private Map<String,Object> attrbutes;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Map<String, Object> getAttrbutes() {
		return attrbutes;
	}
	public void setAttrbutes(Map<String, Object> attrbutes) {
		this.attrbutes = attrbutes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	public String getPowerId() {
		return powerId;
	}
	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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
	@Override
	public String toString() {
		return "PagePowers [id=" + id + ", powerId=" + powerId + ", text="
				+ text + ", url=" + url + ", iconCls=" + iconCls
				+ ", createTime=" + createTime + ", status=" + status
				+ ", isDelete=" + isDelete + ", state=" + state + ", children="
				+ children + ", checked=" + checked + ", adminId=" + adminId
				+ ", attrbutes=" + attrbutes + "]";
	}
	
		
}