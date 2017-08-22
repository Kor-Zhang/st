package com.st.back.pageModel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.st.model.Systemddl;
import com.st.pagemodel.BaseReceivePage;


public class PageSystemddl extends BaseReceivePage implements Serializable{
	
	
	private String state;
	private Map<String,Object> attrbutes;
	// Fields

	private String id;
	private String parentId;
	private String iconCls;
	private String text;
	private String url;
	private Integer currtHigh;
	private Integer high;
	private String tb;
	private String field;
	private Integer rank;
	
	
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getCurrtHigh() {
		return currtHigh;
	}
	public void setCurrtHigh(Integer currtHigh) {
		this.currtHigh = currtHigh;
	}
	public Integer getHigh() {
		return high;
	}
	public void setHigh(Integer high) {
		this.high = high;
	}
	
	public String getTb() {
		return tb;
	}
	public void setTb(String tb) {
		this.tb = tb;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Map<String, Object> getAttrbutes() {
		return attrbutes;
	}
	public void setAttrbutes(Map<String, Object> attrbutes) {
		this.attrbutes = attrbutes;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
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
	
}
