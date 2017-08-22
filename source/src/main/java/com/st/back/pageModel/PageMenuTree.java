package com.st.back.pageModel;

import java.io.Serializable;
import java.util.Map;

import com.st.pagemodel.BaseReceivePage;


public class PageMenuTree  extends BaseReceivePage implements Serializable {
	private String parentId;
	private String parentText;
	private String state;
	
	private String id;
	private String text;
	private String icon;
	private Map<String,Object> attrbutes;
	
	public Map<String, Object> getAttrbutes() {
		return attrbutes;
	}


	public void setAttrbutes(Map<String, Object> attrbutes) {
		this.attrbutes = attrbutes;
	}


	public PageMenuTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "PageMenuTree [parentId=" + parentId + ", parentText="
				+ parentText + ", state=" + state + ", id=" + id + ", text="
				+ text + ", icon=" + icon + ", attrbutes=" + attrbutes + "]";
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
	public String getParentText() {
		return parentText;
	}
	public void setParentText(String parentText) {
		this.parentText = parentText;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}


	public PageMenuTree(String parentId, String parentText, String state,
			String id, String text, String icon, Map<String, Object> attrbutes) {
		super();
		this.parentId = parentId;
		this.parentText = parentText;
		this.state = state;
		this.id = id;
		this.text = text;
		this.icon = icon;
		this.attrbutes = attrbutes;
	}
	

}
