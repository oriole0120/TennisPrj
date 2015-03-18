<%@page import="com.htmtennis.prj.dao.mybatis.MyBInformationDao"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcInformationDao"%>
<%@page import="com.htmtennis.prj.dao.InformationDao"%>
<%@page import="com.htmtennis.prj.model.Information"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
   String code = request.getParameter("c");
   
   Information inf = new Information();
   
   /* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
   InformationDao informationDao = sqlSession.getMapper(InformationDao.class); */
   
   InformationDao informationDao = new MyBInformationDao();
   
   /* InformationDao infDao = new JdbcInformationDao(); */
   informationDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>