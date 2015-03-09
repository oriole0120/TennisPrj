package com.newlecture.jspprj.model;

public class Member {

	private String uid;
	//private String uid;
	private String photo;
	private String pwd;
	private String pwd2;
	private String name;
	private String nicname;
	private String gender;
	private String birth;
	private String islunar;
	private String phone;
	private String email;
	private String zipcode;
	private String zipseq;
	private String year;
	private String month;
	private String day;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUid() {
		return uid;
	}

/*	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}*/
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNicname() {
		return nicname;
	}
	public void setNicname(String nicname) {
		this.nicname = nicname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getZipseq() {
		return zipseq;
	}
	public void setZipseq(String zipseq) {
		this.zipseq = zipseq;
	}
	public String getIslunar() {
		return islunar;
	}
	public void setIslunar(String islunar) {
		this.islunar = islunar;
	}

}
