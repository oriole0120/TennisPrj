
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
    
    <script type="text/javascript" src="../../js/modernizr.js"></script>
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
    
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">
	
	function initialize() {
		 
  		var myLatlng = new google.maps.LatLng(-34.397, 150.644);
  		var myOptions = {
  			zoom: 8,
			center: myLatlng,
  			mapTypeId: google.maps.MapTypeId.ROADMAP
		
}
		var marker;
  		var latlng = new google.maps.LatLng(-34.397, 150.644);
  		marker = new google.maps.Marker({ 
  			   position: latlng, 
  			   map: map,
  			   title: '마커'
  		});
var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
var marker = new google.maps.Marker();  		
}
</script>
    
    
</head>



<body onload="initialize()">
   <!-- header -->
    <jsp:include page="../../inc/header.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
        	<!-- aside -->
            <jsp:include page="../../inc/aside.jsp"></jsp:include>


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
                </div>

                <div id="map_canvas" class="text-center" style="width:500px; height:300px;"></div>
            </main>



        </div>
    </div>



    <footer id="footer">
        <!--  footer part  -->
        <div class="content-wrapper clearfix">

            <div id="logo-footer-container">
                <h2><img src="../../images/logo_m.png" alt="동아리정보" /></h2>
            </div>

            <div id="company-info-container">
                <div id="company-info">
                    <h3 class="hidden">동아리정보</h3>
                    <dl class="clearfix">
                        <dt class="company-info-item item-title item-newline"> 주소</dt>
                        <dd class="company-info-item item-data">서울특별시 성북구 삼선교로 16길 116</dd>
                        <dt class="company-info-item item-title">연락처</dt>
                        <dd class="company-info-item item-data">02-760-5528</dd>

                        <dt class="company-info-item item-title item-newline">관리자메일</dt>
                        <dd class="company-info-item item-data">oriole0120@naver.com</dd>
                        <dt class="company-info-item item-title">회장</dt>
                        <dd class="company-info-item item-data">###</dd>
                        <dt class="company-info-item item-title">HTM</dt>
                        <dd class="company-info-item item-data">[Hansung Tennis Membership]</dd>
                    </dl>
                </div>

                <div id="copyright">
                    <h3 class="hidden">저작권정보</h3>
                    <p>Copyright@chanCompany 2015</p>
                </div>
            </div>
        </div>

    </footer>

</body>
</html>