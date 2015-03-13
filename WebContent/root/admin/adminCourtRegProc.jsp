<%@page import="com.htmtennis.prj.model.Court"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcCourtDao"%>
<%@page import="com.htmtennis.prj.dao.CourtDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

String code = request.getParameter("code");
String name = request.getParameter("name");
String address = request.getParameter("address");
String phoneNumber = request.getParameter("phoneNumber");
String site = request.getParameter("site");
int positionX = Integer.parseInt(request.getParameter("positionX"));
int positionY = Integer.parseInt(request.getParameter("positionY"));



Court court = new Court();

court.setCode(code);
court.setName(name);
court.setAddress(address);
court.setPhoneNumber(phoneNumber);
court.setSite(site);
court.setPositionX(positionX);
court.setPositionY(positionY);




//System.out.println(join.getMid());

CourtDao courtDao = new JdbcCourtDao();
courtDao.insert(court);

/* if( join.getPwd()!=""&&join.getPwd()!=null
&& join.getName()!=""&&join.getName()!=null
&& join.getEmail()!=""&&join.getEmail()!=null
&& join.getPhone()!=""&&join.getPhone()!=null
/* && join.getStudentNum()!=""&&join.getStudentNum()!=null ){*/
//joinDao.update(join);
response.sendRedirect("adminCourt.jsp");


%>
