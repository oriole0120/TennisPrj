<%@page import="com.htmtennis.prj.dao.ShopDao"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <% 
   String code = request.getParameter("c");
   
   /* Court ct = new Court(); */
   
   SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
   ShopDao shopDao = sqlSession.getMapper(ShopDao.class);
   
   /* FreeDao frDao = new JdbcFreeDao(); */
   shopDao.delete(code);
   
   response.sendRedirect("adminShop.jsp");
%>