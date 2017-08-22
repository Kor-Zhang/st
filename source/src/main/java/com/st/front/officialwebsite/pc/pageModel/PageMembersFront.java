package com.st.front.officialwebsite.pc.pageModel;

import java.sql.Timestamp;
import java.util.Date;

import com.st.pagemodel.BaseReceivePage;


public class PageMembersFront extends BaseReceivePage {

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

	
	//搜索条件
	private String eqSex;
	private String eqNation;
	private String eqFaith;
	private String eqLanguage;
	private String eqMembersStatus;
	private String eqDegree;
	private String eqProvince;
	
	
	
	public String getEqProvince() {
		return eqProvince;
	}
	public void setEqProvince(String eqProvince) {
		this.eqProvince = eqProvince;
	}
	public String getEqMembersStatus() {
		return eqMembersStatus;
	}
	public void setEqMembersStatus(String eqMembersStatus) {
		this.eqMembersStatus = eqMembersStatus;
	}
	public String getEqDegree() {
		return eqDegree;
	}
	public void setEqDegree(String eqDegree) {
		this.eqDegree = eqDegree;
	}
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
	public String getEqSex() {
		return eqSex;
	}
	public void setEqSex(String eqSex) {
		this.eqSex = eqSex;
	}
	public String getEqNation() {
		return eqNation;
	}
	public void setEqNation(String eqNation) {
		this.eqNation = eqNation;
	}
	public String getEqFaith() {
		return eqFaith;
	}
	public void setEqFaith(String eqFaith) {
		this.eqFaith = eqFaith;
	}
	public String getEqLanguage() {
		return eqLanguage;
	}
	public void setEqLanguage(String eqLanguage) {
		this.eqLanguage = eqLanguage;
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
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getFaith() {
		return faith;
	}
	public void setFaith(String faith) {
		this.faith = faith;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public PageMembersFront() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageMembersFront(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String head, String name, String sex, String position,
			String introduction, Integer age, Date birthday, String nation,
			String faith, String language) {
		super();
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.head = head;
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