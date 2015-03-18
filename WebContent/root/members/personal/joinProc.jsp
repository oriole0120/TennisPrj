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


Member member = new Member();

member.setMid(mid);
member.setPwd(pwd);
member.setName(name);
member.setGender(gender);
member.setEmail(email);
member.setPhone(phone);
member.setStudentNum(studentNum);
member.setAuthority(authority);


//System.out.println(join.getMid());

MemberDao memberDao = new JdbcMemberDao();
memberDao.insert(member);

/* if( join.getPwd()!=""&&join.getPwd()!=null
&& join.getName()!=""&&join.getName()!=null
&& join.getEmail()!=""&&join.getEmail()!=null
&& join.getPhone()!=""&&join.getPhone()!=null
/* && join.getStudentNum()!=""&&join.getStudentNum()!=null ){*/
//joinDao.update(join);
response.sendRedirect("join.jsp");


%>
