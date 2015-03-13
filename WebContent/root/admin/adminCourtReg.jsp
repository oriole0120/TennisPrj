<%@page import="com.htmtennis.prj.model.Court"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcCourtDao"%>
<%@page import="com.htmtennis.prj.dao.CourtDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	CourtDao courtDao = new JdbcCourtDao();
%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/bind.css" rel="stylesheet" type="text/css" />
<!--<link href="css/style.css" rel="stylesheet" type="text/css"/>-->
<!--<script type="text/javascript" src="../js/modernizr.js"></script>-->
<script type="text/javascript" src="../js/modernizr.js"></script>



</head>

<body>

	<!-- header -->
	<jsp:include page="../inc/header.jsp"></jsp:include>

	<div id="body">
		<div class="content-wrapper clearfix">

			<!-- aside -->
			<jsp:include page="../inc/aside.jsp"></jsp:include>


			<main id="main">
			<h2 id="main-title">코트 등록</h2>
			<!--  main content part  --> <!--<div class="text-center margin-top">-->

			<form action="adminCourtRegProc.jsp" method="post">
			<table>
				<!-- <tr>
					<td>번호</td>
					<td><input type="text" name="code" id="name" value=""/></td>
				</tr> -->
				<tr>
					<td>코트이름</td>
					<td><input type="text" name="name" id="name" value=""/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" id="name" value=""/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phonenumber" id="name" value=""/></td>
				</tr>
				<tr>
					<td>사이트</td>
					<td><input type="text" name="site" id="name" value=""/></td>
				</tr>
				<tr>
					<td>좌표</td>
					<td>X <input type="text" name="positionX" id="name" value=""/></td>
					<td>Y <input type="text" name="positionY" id="name" value=""/></td>
				</tr>


				<tr>
					<td>
					<input type="submit" name="submit" value="저장" /> 
					<input type="submit" name="cancel" value="취소" />
					</td>
				</tr>
			</table>
			</form>
			</main>

		</div>
	</div>



	<!-- footer -->
			<jsp:include page="../inc/footer.jsp"></jsp:include>


</body>
</html>
