package com.st.back.officialwebsite.pageModel;

import java.sql.Timestamp;
import java.util.Date;

import com.st.pagemodel.BaseReceivePage;

public class PageOwMembersBack extends BaseReceivePage{

	private String id;
	private Integer status;
	private Boolean isDelete;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp deleteTime;
	private String head;
	private String name;
	private String sex;
	private String position;
	private String introduction;
	private Integer age;
	private Date birthday;
	private String nation;
	private String faith;
	private String language;
	private String qq;
	private String email;
	private String phone;
	private Date joinTime;
	private Date outTime;
	private String degree;
	private String lastGraduateSchool;
	private String membersStatus;
	private String note;

	
	
	

	public String getMembersStatus() {
		return membersStatus;
	}
	public void setMembersStatus(String membersStatus) {
		this.membersStatus = membersStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getLastGraduateSchool() {
		return lastGraduateSchool;
	}
	public void setLastGraduateSchool(String lastGraduateSchool) {
		this.lastGraduateSchool = lastGraduateSchool;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public PageOwMembersBack() {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//添加.replaceAll(" ", "");，因为复选框的值整合时，会出现空格
	public String getSex() {
		return sex.replaceAll(" ", "");
	}
	public void setSex(String sex) {
		this.sex = sex.replaceAll(" ", "");
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation.replaceAll(" ", "");
	}
	public void setNation(String nation) {
		this.nation = nation.replaceAll(" ", "");
	}
	public String getFaith() {
		return faith.replaceAll(" ", "");
	}
	public void setFaith(String faith) {
		this.faith = faith.replaceAll(" ", "");
	}
	public String getLanguage() {
		return language.replaceAll(" ", "");
	}
	public void setLanguage(String language) {
		this.language = language.replaceAll(" ", "");
	}
	public PageOwMembersBack(String id, Integer status, Boolean isDelete,
			Timestamp deleteTime, String name, String sex, String position,
			String introduction, Integer age, Date birthday, String nation,
			String faith, String language) {
		super();
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.deleteTime = deleteTime;
		this.name = name;
		this.sex = sex;
		this.position = position;
		this.introduction = introduction;
		this.age = age;
		this.birthday = birthday;
		this.nation = nation;
		this.faith = faith;
		this.language = language;
	}
	
}
