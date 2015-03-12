package com.htmtennis.prj.model;

public class Member {
private String mid;
private String pwd;
private String name;
private String gender;
private int studentNum;
private String email;
private String phone;
private String authority;


public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public int getStudentNum() {
	return studentNum;
}
public void setStudentNum(int studentNum) {
	this.studentNum = studentNum;
}
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}



}
