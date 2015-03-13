<%@page import="com.htmtennis.prj.model.Member"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcMemberDao"%>
<%@page import="com.htmtennis.prj.dao.MemberDao"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	String mid = request.getParameter("mid");
	String pwd = request.getParameter("pwd");
	
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	int studentNum = Integer.parseInt(request.getParameter("studentNum"));
	String authority = request.getParameter("authority");
	
	
	
	Member member = new Member();
	
	member.setMid(mid);
	member.setPwd(pwd);
	
	member.setName(name);
	member.setGender(gender);
	member.setEmail(email);
	member.setPhone(phone);
	
	member.setStudentNum(studentNum);
	member.setAuthority(authority);
	
	
	
	MemberDao memberDao = new JdbcMemberDao();
	memberDao.insert(member);
	
	/* if( member.getPwd()!=""&&member.getPwd()!=null
	&& member.getName()!=""&&member.getName()!=null
	&& member.getEmail()!=""&&member.getEmail()!=null
	&& member.getPhone()!=""&&member.getPhone()!=null
	/* && member.getStudentNum()!=""&&member.getStudentNum()!=null ){*/
	//memberDao.update(member);
	response.sendRedirect("member.jsp");
%>
