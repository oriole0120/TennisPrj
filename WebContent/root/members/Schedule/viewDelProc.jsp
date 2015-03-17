

<%@page import="com.htmtennis.prj.dao.jdbc.JdbcScheduleDao"%>
<%@page import="com.htmtennis.prj.dao.ScheduleDao"%>
<%@page import="com.htmtennis.prj.model.Schedule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<% 
   String code = request.getParameter("c");
   
   Schedule s = new Schedule();
   
   ScheduleDao sDao = new JdbcScheduleDao();
   sDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>