<%@page import="com.newlecture.jspprj.dao.MemberDao"%>
<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcMemberDao"%>
<%@page import="com.newlecture.jspprj.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	String pwd2 = request.getParameter("pwd2");
	String name = request.getParameter("name");
	String nicname = request.getParameter("nicname");
	String photo = request.getParameter("photo");
	String gender = request.getParameter("gender");
	//String birth = request.getParameter("birth");
	String islunar = request.getParameter("islunar");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String birth = year+"-"+month+"-"+day;
/* 	if(islunar=="lunar")
		islunar = "true";
	else islunar = "false"; */
	
	
	Member member = new Member();
	
	member.setUid(uid);
	member.setPwd(pwd);
	member.setPwd2(pwd2);
	member.setName(name);
	member.setNicname(nicname);
	member.setPhoto(photo);
	member.setGender(gender);
	member.setBirth(birth);
	member.setIslunar(islunar);
	member.setPhone(phone);
	member.setEmail(email);
	member.setYear(year);
	member.setMonth(month);
	member.setDay(day);

	
	//System.out.println(member.getMid());
	
	MemberDao memberDao = new JdbcMemberDao();
	memberDao.insert(member);
	
	response.sendRedirect("reg.jsp");
	
	/* String url = String.format("noticeDetail.jsp?c=%s", notice.getCode()); */
%>

