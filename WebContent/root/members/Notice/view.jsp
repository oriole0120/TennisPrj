
<%@page import="com.htmtennis.prj.model.Notice"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcNoticeDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<%	
	String _code = request.getParameter("c");
	Notice n = new JdbcNoticeDao().getNotice(_code);
	pageContext.setAttribute("n", n);
		
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
    <jsp:include page="../../inc/header.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
        	<!-- aside -->
            <jsp:include page="../../inc/aside.jsp"></jsp:include>
    
    
    
    
    


            <main id="main">
                <div>
                    <h2 id="main-title">   Notice </h2>

                    <nav id="full-path">
                        <!--<h3>현재경로</h3>-->
                        <ol>
                            <li class="path">Home ></li>
                            <li class="path">Notice ></li>
                            
                        </ol>
                    </nav>

                    <div id="detail-view">
                        <!--글 보기 화면-->
                        <article class="detail space-top-l">
                            <dl>
                                <dt class="detail-cell detail-cell-title detail-cell-break">제목</dt>
                                <dd class="detail-cell text-highlight">${n.title}</dd>

                                <dt class="detail-cell detail-cell-title detail-cell-break">작성일</dt>
                                <dd class="detail-cell">${n.regdate}</dd>

                                <dt class="detail-cell detail-cell-title detail-cell-break">작성자</dt>
                                <dd class="detail-cell detail-cell-half">${n.writer}</dd>

                                <dt class="detail-cell detail-cell-title ">조회수</dt>
                                <dd class="detail-cell detail-cell-half">${n.hit}</dd>

                                <%-- <dt class="detail-cell detail-cell-title ">추천</dt>
                                <dd class="detail-cell detail-cell-half">${n.thumb}</dd> --%>

                                <dt class="detail-cell detail-cell-title ">첨부파일</dt>
                                <dd class="detail-cell detail-cell-half"></dd>

                                <dt class="hidden">내용</dt>
                                <dd class="detail-cell-content detail-cell-break">
                                   ${n.contents}
                                </dd>
                            </dl>
                            <div id="space-top">
                                <p class="space-top text-center">
                                    <a class="btn btn-list" href="list.html">목록</a>
                                </p>
                                <p class="space-top text-center">
                                    <a class="btn btn-list" href="view.html">이전글</a>
                                </p>

                                <p class="space-top text-center">
                                    <a class="btn btn-list" href="view.html">다음글</a>
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
