package com.st.pagemodel;

import java.util.List;

import com.st.util.PubTools;

public class BaseReturnPage<T> {
	//基本返回参数
	private Boolean success = true;
	private String msg = "";
	private Boolean online = true;
	private Integer total = 0;
	private List<T> rows = PubTools.getArrayList();
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
