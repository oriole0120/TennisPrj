<%@page import="com.htmtennis.prj.model.Join"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcJoinDao"%>
<%@page import="com.htmtennis.prj.dao.JoinDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	int npage=1;
	String Mid = request.getParameter("mid");
	//String query = "";
	Join join = new Join();
	
	join.setMid("mid");
	/* String _page = request.getParameter("p");
	String _field = request.getParameter("f");
	String _query = request.getParameter("q");
	
	if(_page != null && !_page.equals(""))
		npage=Integer.parseInt(_page);
	
	if(_field != null && !_field.equals(""))
		field =_field;
		
	if(_query != null && !_query.equals(""))
		query =_query; */
		JoinDao joinDao = new JdbcJoinDao();		
		joinDao.insert(join);
	/* JoinDao joinDao = new JdbcJoinDao();
	List<Join> list = joinDao.getJoins(npage, query, field);
	
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("total", joinDao.getSize(""));  */
	response.sendRedirect("join.jsp");
%>
