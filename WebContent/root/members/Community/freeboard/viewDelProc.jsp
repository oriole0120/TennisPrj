<%@page import="com.htmtennis.prj.dao.jdbc.JdbcFreeDao"%>
<%@page import="com.htmtennis.prj.dao.FreeDao"%>
<%@page import="com.htmtennis.prj.model.Free"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<% 
   String code = request.getParameter("c");
   
   Free fr = new Free();
   
   FreeDao frDao = new JdbcFreeDao();
   frDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>