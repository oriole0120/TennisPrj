<%@page import="com.htmtennis.prj.dao.mybatis.MyBVideoDao"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.VideoDao"%>
<%@page import="com.htmtennis.prj.model.Video"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% 
	String code = request.getParameter("c");
   
	Video v = new Video();
   	VideoDao videoDao = new MyBVideoDao();
	videoDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>