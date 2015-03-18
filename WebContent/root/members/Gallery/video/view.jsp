<%@page import="com.htmtennis.prj.dao.mybatis.MyBVideoDao"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.VideoDao"%>
<%@page import="com.htmtennis.prj.model.Video"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%	
 	String _code = request.getParameter("c");

	VideoDao videoDao = new MyBVideoDao();
	
	Video v = videoDao.getVideo(_code);
	pageContext.setAttribute("v", v);
	
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

    <link href="../css/bind.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/modernizr.js"></script>
    <script>
    	function init(){
    		var btnDel=document.getElementById("btn-del");
    		btnDel.onclick=btnDelClick;
    	}
    	function btnDelClick(){
    		if(!confirm( '삭제 하시겠습니까?' )){
    			return false;
    		}
    	}
    	window.onload=init;
    </script>
</head>

<body>
    
	<!-- header -->
    <jsp:include page="../../../inc/header.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
        	<!-- aside -->
            <jsp:include page="../../../inc/aside.jsp"></jsp:include>

            <main id="main">
               <!--  main content part  -->
                <div id="main-title-bar">
                    <p> >>Video </p>
                </div>

                <div>
                    <article class="space-top-l">

                        <div class="video-pic-box">
                            <div class="video-prev-btn">
                                <img class="btn-slide-prev" src="../images/btn-prev.png" />
                            </div>
                            <div class="video-pic-clipper">

                                <ul class="video-pic-list">
                                    <li class="video-pic-item">
                                        <a href="">
                                            <img class="video-pic" src="../images/pho1.jpg" />
                                        </a>
                                    </li>
                                    <li class="video-pic-item">
                                        <a href="">
                                            <img class="video-pic" src="../images/pho2.jpg" />
                                        </a>
                                    </li>
                                    <li class="video-pic-item">
                                        <a href="">
                                            <img class="video-pic" src="../images/pho3.jpg" />
                                        </a>
                                    </li>
                                    <li class="video-pic-item">
                                        <a href="">
                                            <img class="video-pic" src="../images/pho1.jpg" />
                                        </a>
                                    </li>
                                    <li class="video-pic-item">
                                        <a href="">
                                            <img class="video-pic" src="../images/pho2.jpg" />
                                        </a>
                                    </li>
                                    <li class="video-pic-item">
                                        <a href="">
                                            <img class="video-pic" src="../images/pho3.jpg" />
                                        </a>
                                    </li>
                                    <li class="video-pic-item">
                                        <a href="">
                                            <img class="video-pic" src="../images/pho1.jpg" />
                                        </a>
                                    </li>
                                </ul>

                            </div>

                            <div class="video-next-btn">
                                <img class="btn-slide-next" src="../images/btn-next.png" />
                            </div>
                        </div>

                        <article class="detail">
                            <dl>
                            	<dt class="detail-cell title newrow">제목</dt>
		                        <dd class="detail-cell text-highlight">${v.title}</dd>
		                        <dt class="detail-cell title newrow">작성일</dt>
		                        <dd class="detail-cell">${v.regdate}</dd>
		                        <dt class="detail-cell title newrow">작성자</dt>
		                        <dd class="detail-cell half-cell">${v.writer}</dd>
		                        <dt class="detail-cell title">조회수</dt>
		                        <dd class="detail-cell half-cell">${v.hit}</dd>
		                        <dt class="detail-cell title newrow">첨부파일</dt>
		                        <dd class="detail-cell"></dd>
		                        <dt class="hidden">내용</dt>
		                        <dd class="content newrow">${v.contents}</dd>
                            </dl>

                            <p class="space-top text-center "> <!-- btn btn-list -->
                                <a id="btn-list" href="list.jsp">목록</a>
                                <a id="btn-edit" href="edit.jsp?c=${v.code}">수정</a>
                                <a id="btn-del" href="delProc.jsp?c=${v.code}">삭제</a>
                            </p>

                        </div>
                    </article>

                </div>
            </main>

        </div>
    </div>


		<!-- footer -->
		<jsp:include page="../../../inc/footer.jsp"></jsp:include>

</body>
</html>
