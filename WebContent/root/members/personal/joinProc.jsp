<%@page import="com.htmtennis.prj.model.Join"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcJoinDao"%>
<%@page import="com.htmtennis.prj.dao.JoinDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String mid = request.getParameter("mid");
String pwd = request.getParameter("pwd");
//String pwd2 = request.getParameter("pwd2");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
int studentNum = Integer.parseInt(request.getParameter("studentNum"));
String authority = request.getParameter("authority");

/* 	if(islunar=="lunar")
	islunar = "true";
else islunar = "false"; */


Join join = new Join();

join.setMid(mid);
join.setPwd(pwd);
//join.setPwd2(pwd2);
join.setName(name);
join.setGender(gender);
join.setEmail(email);
join.setPhone(phone);
//int _studentNum;
join.setStudentNum(studentNum);
join.setAuthority(authority);



//System.out.println(join.getMid());

JoinDao joinDao = new JdbcJoinDao();
joinDao.insert(join);

/* if( join.getPwd()!=""&&join.getPwd()!=null
&& join.getName()!=""&&join.getName()!=null
&& join.getEmail()!=""&&join.getEmail()!=null
&& join.getPhone()!=""&&join.getPhone()!=null
/* && join.getStudentNum()!=""&&join.getStudentNum()!=null ){*/
//joinDao.update(join);
response.sendRedirect("join.jsp");



%>
