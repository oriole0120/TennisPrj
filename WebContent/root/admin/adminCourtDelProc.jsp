<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.CourtDao"%>
<%@page import="com.htmtennis.prj.model.Court"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <% 
   String code = request.getParameter("c");
   
   /* Court ct = new Court(); */
   
   SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
   CourtDao courtDao = sqlSession.getMapper(CourtDao.class);
   
   /* FreeDao frDao = new JdbcFreeDao(); */
   courtDao.delete(code);
   
   response.sendRedirect("adminCourt.jsp");
%>