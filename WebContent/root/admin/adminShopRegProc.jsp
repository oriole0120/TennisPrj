
<%@page import="com.htmtennis.prj.model.Shop"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcShopDao"%>
<%@page import="com.htmtennis.prj.dao.ShopDao"%>
<%@page import="java.util.List"%>


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



Shop shop = new Shop();

shop.setCode(code);
shop.setName(name);
shop.setAddress(address);
shop.setPhoneNumber(phoneNumber);
shop.setSite(site);
shop.setPositionX(positionX);
shop.setPositionY(positionY);




//System.out.println(join.getMid());

ShopDao shopDao = new JdbcShopDao();
shopDao.insert(shop);

/* if( join.getPwd()!=""&&join.getPwd()!=null
&& join.getName()!=""&&join.getName()!=null
&& join.getEmail()!=""&&join.getEmail()!=null
&& join.getPhone()!=""&&join.getPhone()!=null
/* && join.getStudentNum()!=""&&join.getStudentNum()!=null ){*/
//joinDao.update(join);
response.sendRedirect("adminShop.jsp");


%>
