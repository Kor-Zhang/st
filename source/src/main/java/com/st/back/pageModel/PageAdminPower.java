package com.st.back.pageModel;

import com.st.model.Admins;
import com.st.pagemodel.BaseReceivePage;

public class PageAdminPower  extends BaseReceivePage{

	private String id;
	private String powerId;
	private Admins admins;
	private Integer status;
	private Boolean isDelete;
	
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
	public Admins getAdmins() {
		return admins;
	}
	public void setAdmins(Admins admins) {
		this.admins = admins;
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
	
}
