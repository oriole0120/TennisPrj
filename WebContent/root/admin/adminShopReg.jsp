<%@page import="com.htmtennis.prj.model.Shop"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.ShopDao"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcShopDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	int npage=1;
	String field = "name";
	String query = "";
	
	String _page = request.getParameter("p");
	String _field = request.getParameter("f");
	String _query = request.getParameter("q");
	
	if(_page != null && !_page.equals(""))
		npage=Integer.parseInt(_page);
	
	if(_field != null && !_field.equals(""))
		field =_field;
		
	if(_query != null && !_query.equals(""))
		query =_query;

	ShopDao shopDao = new JdbcShopDao();
	List<Shop> list = shopDao.getShops(npage, query, field);
	
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("total", shopDao.getSize(""));
	
	
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
                <h2 id="main-title">Shop</h2>
                <table>
                    <tr>
                        <td>코트이름</td>
                        <td><input type="text" name="Shop_name" /></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><input type="text" name="Shop_address" /></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="password" name="Shop_ph" /></td>
                    </tr>
                    <tr>
                        <td>사이트</td>
                        <td><input type="text" name="Shop_site" /></td>
                    </tr>
                    <tr>
                        <td>좌표</td>
                     	<td>X <input type="text" name="Shop_positionX" /></td>
                     	<td>Y <input type="text" name="Shop_positionY" /></td>
                    </tr>
                   
                    
                    <tr>
                       
                        <td>
                            <input type="submit" name="submit" value="저장" />
                            <input type="submit" name="cancel" value="취소" />
                        </td>
                    </tr>
                </table>
			</main>
	</div>
</div>
    <!-- footer -->
			<jsp:include page="../inc/footer.jsp"></jsp:include>


</body>
</html>
