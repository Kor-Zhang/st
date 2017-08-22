package com.st.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OfficialwebsiteMembers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "officialwebsite_members", catalog = "st")
public class OfficialwebsiteMembers implements java.io.Serializable {

	// Fields

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
	private String province;
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

	// Constructors

	/** default constructor */
	public OfficialwebsiteMembers() {
	}

	/** minimal constructor */
	public OfficialwebsiteMembers(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, String head,
			String name, String sex, String position, Integer age,
			Date birthday, Date joinTime, String membersStatus) {
		this.id = id;
		this.status = status;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.head = head;
		this.name = name;
		this.sex = sex;
		this.position = position;
		this.age = age;
		this.birthday = birthday;
		this.joinTime = joinTime;
		this.membersStatus = membersStatus;
	}

	/** full constructor */
	public OfficialwebsiteMembers(String id, Integer status, Boolean isDelete,
			Timestamp createTime, Timestamp updateTime, Timestamp deleteTime,
			String head, String name, String sex, String position,
			String introduction, Integer age, Date birthday, String nation,
			String province, String faith, String language, String qq,
			String email, String phone, Date joinTime, Date outTime,
			String degree, String lastGraduateSchool, String membersStatus,
			String note) {
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
		this.province = province;
		this.faith = faith;
		this.language = language;
		this.qq = qq;
		this.email = email;
		this.phone = phone;
		this.joinTime = joinTime;
		this.outTime = outTime;
		this.degree = degree;
		this.lastGraduateSchool = lastGraduateSchool;
		this.membersStatus = membersStatus;
		this.note = note;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "updateTime", nullable = false, length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "deleteTime", length = 19)
	public Timestamp getDeleteTime() {
		return this.deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Column(name = "head", nullable = false)
	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", nullable = false)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "position", nullable = false)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "introduction")
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "age", nullable = false)
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", nullable = false, length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "nation")
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "province")
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "faith")
	public String getFaith() {
		return this.faith;
	}

	public void setFaith(String faith) {
		this.faith = faith;
	}

	@Column(name = "language")
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "qq", length = 15)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "joinTime", nullable = false, length = 10)
	public Date getJoinTime() {
		return this.joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "outTime", length = 10)
	public Date getOutTime() {
		return this.outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	@Column(name = "degree")
	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "lastGraduateSchool")
	public String getLastGraduateSchool() {
		return this.lastGraduateSchool;
	}

	public void setLastGraduateSchool(String lastGraduateSchool) {
		this.lastGraduateSchool = lastGraduateSchool;
	}

	@Column(name = "membersStatus", nullable = false)
	public String getMembersStatus() {
		return this.membersStatus;
	}

	public void setMembersStatus(String membersStatus) {
		this.membersStatus = membersStatus;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}