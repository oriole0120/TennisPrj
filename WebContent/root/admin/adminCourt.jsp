
<%@page import="com.htmtennis.prj.model.Court"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcCourtDao"%>
<%@page import="com.htmtennis.prj.dao.CourtDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	int npage = 1;
	String field = "name";
	String query = "";

	String _page = request.getParameter("p");
	String _field = request.getParameter("f");
	String _query = request.getParameter("q");

	if (_page != null && !_page.equals(""))
		npage = Integer.parseInt(_page);

	if (_field != null && !_field.equals(""))
		field = _field;

	if (_query != null && !_query.equals(""))
		query = _query;

	CourtDao courtDao = new JdbcCourtDao();
	List<Court> list = courtDao.getCourts(npage, query, field);

	pageContext.setAttribute("list", list);
	pageContext.setAttribute("total", courtDao.getSize(""));
%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/bind.css" rel="stylesheet" type="text/css" />
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
			<h2 id="main-title">Court</h2>
			<!--<div class="breadcrumb">
                    <h3 class="hidden">현재경로</h3>
                    <ul>
                        <li class="breadcrumb-item breadcrumb-item-size">Home</li>
                        <li class="breadcrumb-item breadcrumb-item-size">Link</li>
                        <li class="breadcrumb-item breadcrumb-item-size">Court</li>
                    </ul>
                </div>-->
			<div class="text-center main-item">
				<a href=""><img src="../images/link-map.jpg" width="500"
					height="250" alt="맵"></a>
			</div>

			<div class="text-center main-item">
				<div class="wrapper">
					<h3 class="hidden">링크게시물 검색폼</h3>
					<form action="court.jsp" method="get">
						<fieldset>

							<a>지도를 클릭하시면 서울 및 지역구별 검색을 할수 있습니다</a>
							<legend class="hidden">링크 검색 필드</legend>
							<label for="field" class="hidden">검색분류</label> <select
								class="search-field" name="f">
								<option ${param.f=='name' ? 'selected' : ""} value="name">이름</option>
								<option ${param.f=='address' ? 'selected' : ""} value="address">주소</option>
							</select> 
									<input class="input-normal" type="text" name="q" value=${param.q }></input>
									<input class="btn btn-search" type="submit" value="검색" />
						</fieldset>
					</form>
				</div>
			</div>
			<div class="board">
				<table class="board-table text-center">
					<thead>
						<tr class="board-row">
							<th class="board-cell-th board-cell-width-60  text-center">번호</th>
							<th class="board-cell-th board-cell-width-140  text-center">이름</th>
							<th class="board-cell-th board-cell-width-270  text-center">주소</th>
							<th class="board-cell-th board-cell-width-100  text-center">전화번호</th>
							<th class="board-cell-th board-cell-width-100 text-center">사이트</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ct" items="${list}">
							<tr class="board-row">
								<th class="board-cell board-cell-width-60  text-center">${ct.code }</th>
								<th class="board-cell board-cell-width-140  text-center"><a
									href="courtDetail.jsp?c=${ct.code}">${ct.name}</a></th>
								<th class="board-cell board-cell-width-270  text-center">${ct.address}</th>
								<th class="board-cell board-cell-width-100  text-center">${ct.phoneNumber}</th>
								<th class="board-cell-th board-cell-width-100 text-center">${ct.site}</th>
							</tr>
						</c:forEach>


					</tbody>
				</table>
				<a href="adminCourtReg.jsp"><button style="float: right;">
					테니스장등록
				</button></a>
			</div>


			</main>

		</div>
	</div>



	<!-- footer -->
			<jsp:include page="../inc/footer.jsp"></jsp:include>


</body>
</html>
