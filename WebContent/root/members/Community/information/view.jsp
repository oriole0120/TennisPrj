<%@page import="com.htmtennis.prj.dao.mybatis.MyBInformationDao"%>
<%@page import="com.htmtennis.prj.dao.InformationDao"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcInformationDao"%>
<%@page import="com.htmtennis.prj.model.Information"%>
<%	
	String _code = request.getParameter("c");
	/* Information inf = new JdbcInformationDao().getInformation(_code); */
	/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
	InformationDao informationDao = sqlSession.getMapper(InformationDao.class); */
	
	InformationDao informationDao = new MyBInformationDao();
	
	Information inf = informationDao.getInformation(_code);
	
	pageContext.setAttribute("inf", inf);
	pageContext.setAttribute("prev", informationDao.prevInformation(_code));
	pageContext.setAttribute("next", informationDao.nextInformation(_code));
		
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
    <jsp:include page="../../../inc/header.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
        	<!-- aside -->
            <jsp:include page="../../../inc/aside.jsp"></jsp:include>


            <main id="main">
                <div>
                    <h2 id="main-title">정보게시판</h2>

                    <nav id="full-path">
                        <!--<h3>현재경로</h3>-->
                        <ol>
                            <!--<li class="path">Home ></li>-->
                            <li class="path">Community ></li>
                            <li class="path">정보게시판 </li>
                        </ol>
                    </nav>

                    <div id="detail-view">
                        <!--글 보기 화면-->
                        <article class="detail space-top-l">
                            <dl>
                                <dt class="detail-cell detail-cell-title detail-cell-break">제목</dt>
                                <dd class="detail-cell text-highlight">${inf.title}</dd>

                                <dt class="detail-cell detail-cell-title detail-cell-break">작성일</dt>
                                <dd class="detail-cell">${inf.regdate}</dd>

                                <dt class="detail-cell detail-cell-title detail-cell-break">작성자</dt>
                                <dd class="detail-cell detail-cell-half">${inf.writer}</dd>

                                <dt class="detail-cell detail-cell-title ">조회수</dt>
                                <dd class="detail-cell detail-cell-half">${inf.hit}</dd>

                                <dt class="detail-cell detail-cell-title ">추천</dt>
                                <dd class="detail-cell detail-cell-half">${inf.thumb}</dd>

                                <dt class="detail-cell detail-cell-title ">첨부파일</dt>
                                <dd class="detail-cell detail-cell-half"></dd>

                                <dt class="hidden">내용</dt>
                                <dd class="detail-cell-content detail-cell-break">
                                    ${inf.contents}
                                </dd>
                            </dl>
                            <div id="space-top">
                                <p class="space-top text-center">
                                    <a class="btn btn-list" href="view.jsp?c=${prev.code}">이전글</a>
                                </p>

                                <p class="space-top text-center">
                                    <a class="btn btn-list" href="view.jsp?c=${next.code}">다음글</a>                                                  			    
                                </p>	
                            </div>
                            
                            <div id="space-top-two">          
                            	<p class="space-top-two text-center">
                                    <a class="btn btn-list" href="list.jsp">목록</a>
                                </p>
                                
                                <p class="space-top-two text-center">
                                	<a href="edit.jsp?c=${inf.code}">수정</a>
                                </p>
                                
                                <p class="space-top-two text-center">    
                                	<a id="btn-del-pop" href="viewDelProc.jsp?c=${inf.code}">삭제</a>
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
		<jsp:include page="../../../inc/footer.jsp"></jsp:include>

</body>
</html>
