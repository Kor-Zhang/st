package com.st.back.pageModel;

import java.io.Serializable;
import java.sql.Timestamp;

import com.st.model.Imgs;
import com.st.pagemodel.BaseReceivePage;

public class PageAboutUs  extends BaseReceivePage implements Serializable{
	
	// Fields
	
	private String imgName;

	private String id;
	private Imgs imgs;
	private Timestamp createTime;
	private String introduction;

	private Timestamp minCreateTime;
	private Timestamp maxCreateTime;
	
	
	public Timestamp getMinCreateTime() {
		return minCreateTime;
	}
	public void setMinCreateTime(Timestamp minCreateTime) {
		this.minCreateTime = minCreateTime;
	}
	public Timestamp getMaxCreateTime() {
		return maxCreateTime;
	}
	public void setMaxCreateTime(Timestamp maxCreateTime) {
		this.maxCreateTime = maxCreateTime;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Imgs getImgs() {
		return imgs;
	}
	public void setImgs(Imgs imgs) {
		this.imgs = imgs;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	
	
	
}
