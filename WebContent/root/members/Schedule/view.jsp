

<%@page import="com.htmtennis.prj.dao.jdbc.JdbcScheduleDao"%>
<%@page import="com.htmtennis.prj.model.Schedule"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<%	
String _code = request.getParameter("c");
Schedule s = new JdbcScheduleDao().getSchedule(_code);
pageContext.setAttribute("s", s);
	
		
%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

    <link href="css/bind.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/modernizr.js"></script>
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
</head>

<body>
    
    <!-- header -->
    <jsp:include page="../../inc/header.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
        	<!-- aside -->
            <jsp:include page="../../inc/aside.jsp"></jsp:include>
    
    
    
    
    


            <main id="main">
                <div>
                    <h2 id="main-title">   Schedule </h2>

                    <nav id="full-path">
                        <!--<h3>현재경로</h3>-->
                        <ol>
                            <li class="path">Home ></li>
                            <li class="path">Schedule ></li>
                            
                        </ol>
                    </nav>

                    <div id="detail-view">
                        <!--글 보기 화면-->
                        <article class="detail space-top-l">
                            <dl>
                                <dt class="detail-cell detail-cell-title detail-cell-break">제목</dt>
                                <dd class="detail-cell text-highlight">${s.title}</dd>

                                <dt class="detail-cell detail-cell-title detail-cell-break">작성일</dt>
                                <dd class="detail-cell">${s.regdate}</dd>

                                <dt class="detail-cell detail-cell-title detail-cell-break">작성자</dt>
                                <dd class="detail-cell detail-cell-half">${s.writer}</dd>

                                <dt class="detail-cell detail-cell-title ">기념일</dt>
                                <dd class="detail-cell detail-cell-half">${s.eventdate}</dd>

                                <%-- <dt class="detail-cell detail-cell-title ">추천</dt>
                                <dd class="detail-cell detail-cell-half">${n.thumb}</dd> --%>

                                <dt class="detail-cell detail-cell-title ">첨부파일</dt>
                                <dd class="detail-cell detail-cell-half"></dd>

                                <dt class="hidden">내용</dt>
                                <dd class="detail-cell-content detail-cell-break">
                                   ${s.contents}
                                </dd>
                            </dl>
                            <div id="space-top">
                                <p class="space-top text-center">
                                    <a class="btn btn-list" href="view.html">이전글</a>
                                </p>

                                <p class="space-top text-center">
                                    <a class="btn btn-list" href="view.html">다음글</a>                                                  			    
                                </p>	
                            </div>
                            
                            <div id="space-top-two">          
                            	<p class="space-top-two text-center">
                                    <a class="btn btn-list" href="list.html">목록</a>
                                </p>
                                
                                <p class="space-top-two text-center">
                                	<a href="noticeEdit.jsp?c=${n.code}">수정</a>
                                </p>
									
                                <%-- <p class="space-top-two text-center">    
                                	<a href="viewDelProc.jsp?c=${fr.code}">삭제</a>
                                </p> --%>
                                
                                <p class="space-top-two text-center">    
                                	<a id="btn-del-pop" href="viewDelProc.jsp?c=${n.code}">삭제</a>
                                </p>
                                                 
                                </div>
                        </article>

    </div>
                    <!--<h3>영상게시물 검색폼</h3>-->

                    <!--<div id="main-search-form">
                        
                        <form>
                            <fieldset>
                               
                                <select>
                                    <option>작성자</option>
                                    <option>제목</option>
                                    <option>본문</option>
                                </select>

                                <input class="search" type="text" name="query" />
                                <input class="search" type="submit" value="검색" />

                            </fieldset>
                        </form>
                    </div>-->
                </div>
            </main>

        </div>
    </div>



   <!-- footer -->
		<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>
