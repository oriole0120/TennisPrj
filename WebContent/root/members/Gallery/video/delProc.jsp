

<%@page import="com.htmtennis.prj.dao.jdbc.JdbcPhotoDao"%>
<%@page import="com.htmtennis.prj.dao.PhotoDao"%>
<%@page import="com.htmtennis.prj.model.Photo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% 
   String code = request.getParameter("c");
   
   Photo ph = new Photo();
   
   PhotoDao photoDao = new JdbcPhotoDao();
   photoDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>