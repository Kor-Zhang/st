package com.st.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PubReturnJSON<T> implements Serializable{
	private Boolean success = true;
	private String msg = "";
	private Object obj = new Object();
	private Boolean online = true;
	
	/*datagrid*/
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
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
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
	@Override
	public String toString() {
		return "ReturnJSON [success=" + success + ", msg=" + msg + ", obj="
				+ obj + ", online=" + online + ", total=" + total + ", rows="
				+ rows + "]";
	}
	
}
