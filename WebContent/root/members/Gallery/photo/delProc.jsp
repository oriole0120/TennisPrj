<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.PhotoDao"%>
<%@page import="com.htmtennis.prj.model.Photo"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% 
   String code = request.getParameter("c");
   
   Photo ph = new Photo();
   
//   PhotoDao photoDao = new JdbcPhotoDao();
	SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
	PhotoDao photoDao = sqlSession.getMapper(PhotoDao.class);
	
	photoDao.delete(code);
   
   response.sendRedirect("list.jsp");
%>