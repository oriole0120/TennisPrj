<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.model.Photo"%>
<%@page import="com.htmtennis.prj.dao.PhotoDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String _code = request.getParameter("c");
	//PhotoDao photoDao = new JdbcPhotoDao();
	
	SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
	PhotoDao photoDao = sqlSession.getMapper(PhotoDao.class);
	
	Photo ph = photoDao.getPhoto(_code);
	pageContext.setAttribute("ph", ph);
%>

	
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

    <link href="../css/bind.css" rel="stylesheet" type="text/css" />
    <!--<script type="text/javascript" src="../js/modernizr.js"></script>-->
    <script type="text/javascript" src="../../../editor/js/HuskyEZCreator.js" charset="utf8"></script>


 
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
                <section id="board-detail" class="space-top-l">
                    <h1 class="hidden">본문 작성</h1>
                    
                    <div id="main-title-bar">
    	                <p> >>Photo </p>
	                </div>
        
                    
                    <form id="text-area" action="photoRegProc.jsp" method="post" enctype="multipart/form-data">
                    	<fieldset>
	                    	<legend class="hidden">본문입력필드</legend>
	                    	
	                    	<dl>
		                        <dt class="detail-cell title newrow">제목</dt>
		                        <dd class="detail-cell text-highlight"><input type="text" name="title" /></dd>
		                        
		                        <dt class="hidden">내용</dt>
		                        <dd class="content newrow">
		                        	<textarea name="content" id="content" rows="10" cols="100" style="width: 690px; height: 400px; display: none;">
		                        		수정내용
		                        	</textarea>
		                        	<script type="text/javascript">
					                    var oEditors = [];
					                    nhn.husky.EZCreator.createInIFrame({
					                        oAppRef: oEditors,
					                        elPlaceHolder: "content",
					                        sSkinURI: "../../../editor/SmartEditor2Skin.html",
					                        fCreator: "createSEditor2"
					                    });
				                	</script>
		                        </dd>
		                    </dl>
                    	</fieldset>
                    
	                    <p id="button-container" class="space-top text-center">
	                    	<input type = "submit" value="등록" />
	                    	<a href="list.jsp">취소</a>
	                    </p>
          
                	</form>
            	</section>
            </main>
        </div>
    </div>

		<!-- footer -->
		<jsp:include page="../../../inc/footer.jsp"></jsp:include>

        </body>
        </html>
