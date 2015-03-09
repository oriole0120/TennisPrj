<%@page import="com.htmtennis.prj.dao.jdbc.JdbcInformationDao"%>
<%@page import="com.htmtennis.prj.dao.InformationDao"%>
<%@page import="com.htmtennis.prj.model.Information"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
   String code = request.getParameter("c");
   
   Information inf = new Information();
   
   InformationDao infDao = new JdbcInformationDao();
   infDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>