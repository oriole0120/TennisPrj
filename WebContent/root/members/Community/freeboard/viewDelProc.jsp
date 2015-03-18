<%@page import="com.htmtennis.prj.dao.mybatis.MyBFreeDao"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcFreeDao"%>
<%@page import="com.htmtennis.prj.dao.FreeDao"%>
<%@page import="com.htmtennis.prj.model.Free"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<% 
   String code = request.getParameter("c");
   
 	/* Free fr = new Free(); */
   
	/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
	FreeDao freeDao = sqlSession.getMapper(FreeDao.class); */
	
	FreeDao freeDao = new MyBFreeDao();
	
   /* FreeDao frDao = new JdbcFreeDao(); */
   freeDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>