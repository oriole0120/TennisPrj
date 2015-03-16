<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="com.htmtennis.prj.dao.PhotoDao"%>
<%@page import="com.htmtennis.prj.model.Photo"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="ctxName" value="${pageContext.request.servletContext.contextPath}" />
<%	String ctx = request.getContextPath();	%>
	
<% 
	int npage = 1;
	String nquery="";
	String nfield="TITLE";
	
	String _page = request.getParameter("pg");
	String _query = request.getParameter("qy");
	String _field = request.getParameter("fd");
	
	if(_page != null && !_page.equals(""))
		npage = Integer.parseInt(_page);
	if(_query!= null && !_query.equals(""))
		nquery = _query;
	if(_field!= null && !_field.equals(""))
		nfield = _field;
	
	SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
	PhotoDao photoDao = sqlSession.getMapper(PhotoDao.class);
 	
	List<Photo> list = photoDao.getPhotos(npage, nquery, nfield);
	
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("total", photoDao.getSize("", "TITLE"));
	
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

    <link href="../css/bind.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/modernizr.js"></script>
</head>

<body>
    <!-- header -->
    <%-- <jsp:include page="../../../inc/header.jsp"></jsp:include> --%>
    <tiles:insertAttribute name="header"/>

    <div id="body">
        <div class="content-wrapper clearfix">
        
        	<!-- aside -->
            <%-- <jsp:include page="../../../inc/aside.jsp"></jsp:include> --%>
            <tiles:insertAttribute name="aside" />

			
			<!-- main 부분 -->
			<tiles:insertAttribute name="main" />

            
        </div>
    </div>


		<!-- footer -->
		<%-- <jsp:include page="../../../inc/footer.jsp"></jsp:include> --%>
		<tiles:insertAttribute name="footer" />

	</body>
</html>
