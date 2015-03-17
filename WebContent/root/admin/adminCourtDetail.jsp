
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcCourtDao"%>
<%@page import="com.htmtennis.prj.model.Court"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	String code = request.getParameter("c");
	Court ct = new JdbcCourtDao().getCourt(code);
	pageContext.setAttribute("ct", ct);
		
%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <script type="text/javascript" src="../../js/map.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript" src="../../js/modernizr.js"></script>
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
</head>
<script>
function init(){
    		var btnDelPop=document.getElementById("btn-del-pop");
    		btnDelPop.onclick=btnDelPopClick;
    	}
    	function btnDelPopClick(){
    		if(!confirm( '삭제 하시겠습니까?' )){
    			return false;
    		}	
    	}
    	window.onload=init;
</script>
<body> <!-- onload="initialize()" -->
   <!-- header -->
    <jsp:include page="../inc/header1.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
        	<!-- aside -->
            <jsp:include page="../inc/aside.jsp"></jsp:include>


            <main id="main">
                <!--<h2 id="main-title">Link</h2>-->


                <div class="text-center space-top">
                    <div class="wrapper">
                        <div class="main-item">
                            <!--<h3>영상게시물 검색폼</h3>-->
                            <form>
                                <fieldset>
                                    <a>지도를 클릭하시면 서울 및 지역구별 검색을 할수 있습니다</a>
                                    <input class="input-normal" type="text" name="query" />
                                    <input class="btn btn-search" type="submit" value="검색" />
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="space-top">
                    <table class="board-tabled text-center">
                        <thead>
                            <tr class="board-rowd">
                                <th class="board-cell-thd board-cell-width-60d  text-center"><a href="">번호</a></th>
                                <th class="board-cell-thd board-cell-width-140d  text-center"><a href="">이름</a></th>
                                <th class="board-cell-thd board-cell-width-270d  text-center"><a href="">주소</a></th>
                                <th class="board-cell-thd board-cell-width-100d  text-center"><a href="">전화번호</a></th>
                                <th class="board-cell-th board-cell-width-100d text-center"><a href="">사이트</a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="board-rowd">
                                <th class="board-celld board-cell-width-60d">${ct.code}</th>
                                <th class="board-celld board-cell-width-140d">${ct.name}</th>
                                <th class="board-celld board-cell-width-270d">${ct.address}</th>
                                <th class="board-celld board-cell-width-100d">${ct.phoneNumber}</th>
                                <th class="board-cell-th board-cell-width-100d">${ct.site}</th>
                            </tr>
                        </tbody>

                    </table>
                    <p>    
                     	<a id="btn-del-pop" href="adminCourtDelProc.jsp?c=${ct.code}">삭제</a>
                    </p>
                </div>

                <div id="map_canvas"></div>
            </main>



        </div>
    </div>



     <!-- footer -->
			<jsp:include page="../inc/footer.jsp"></jsp:include>


</body>
</html>