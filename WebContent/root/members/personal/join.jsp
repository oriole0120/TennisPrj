<%@page import="com.htmtennis.prj.model.Member"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcMemberDao"%>
<%@page import="com.htmtennis.prj.dao.MemberDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	MemberDao joinDao = new JdbcMemberDao();

	/* int npage=1;
	String Mid = request.getParameter("mid"); */
	//String query = "";
	
	
	
	/* String _page = request.getParameter("p");
	String _field = request.getParameter("f");
	String _query = request.getParameter("q");
	
	if(_page != null && !_page.equals(""))
		npage=Integer.parseInt(_page);
	
	if(_field != null && !_field.equals(""))
		field =_field;
		
	if(_query != null && !_query.equals(""))
		query =_query; */
		/* MemberDao joinDao = new JdbcMemberDao();		
		joinDao.insert(Member); */
	/* MemberDao joinDao = new JdbcMemberDao();
	List<Member> list = joinDao.getMembers(npage, query, field);
	
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("total", joinDao.getSize(""));  */
	/* response.sendRedirect("join.jsp"); */
%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
    <link href="css/component.css" rel="stylesheet" type="text/css" />
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../js/modernizr.js"></script>
    
    <script src="../../js/modernizr.custom.js"></script>


</head>

<body>
    <!-- header -->
    <jsp:include page="../../inc/header.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
           <!-- aside -->
            <jsp:include page="../../inc/aside.jsp"></jsp:include>

            <div class="container">
                <div class="main clearfix">
                    <div class="column">

                        <button class="md-trigger" data-modal="modal-12">회원가입</button>

                    </div>

                </div><!-- /container -->
             </div>  
            
            <div class="md-modal md-effect-12 " id="modal-12">
                <div class="md-content">
                    <h3>회원가입</h3>
                    <div id="aa">
                        <!--<p>This is a modal window. You can do the following things with it:</p>-->
                        <div id="aa1">
                        <form action="joinProc.jsp" method="post">
                            <table border="1">
                            
                                <tr>
                                    <td align="center" width=130>아이디</td>
                                    <td colspan=3>
                                   <%--  <c:forEach var="jn" items="${list}">
                                    </c:forEach> --%>
                                        <input type="text" name="mid" id="name" value=""/>
                                    
                                    </td>
                                </tr>
 							
                                <tr>
                                    <td align="center">비밀번호</td>
                                    <td colspan=3>
                                        <input type="password" name="pwd" id="name" value="" />
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">비밀번호 확인</td>
                                    <td colspan=3>
                                        <input type="password" name="pwr" id="name" value="" />
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">이름</td>
                                    <td colspan=3>
                                        <input type="text" name="name" id="name" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">성별</td>
                                    <td colspan='3'>
                                        <fieldset data-role="controlgroup">
                                            <input type="radio" name="gender" id="male" value="choice-1" checked="checked" />
                                            <label for="male">남자</label>

                                            <input type="radio" name="gender" id="female" value="choice-2" />
                                            <label for="female">여자</label>
                                        </fieldset>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td align="center">학번</td>
                                    <td colspan=3>
                                        <input type="text" name="studentNum" id="name" value="" />
                                    </td>
                                </tr>
								<tr>
                                    <td align="center">이메일</td>
                                    <td colspan=3>
                                        <input type="text" name="email" id="name" value="" />
                                    </td>
                                </tr>
								<tr>
                                    <td align="center">연락처</td>
                                    <td colspan=3>
                                        <input type="text" name="phone" id="name" value="" />
                                    </td>
                                </tr>

                            </table>
                            <input type="submit" />
                            <!-- <button type="submit" class="md-close">완료</button> -->
                            <button><a href="../Community/freeboard/list.jsp">취소</a></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="md-overlay"></div>
            </div>
        </div>
    
            <!-- footer -->
			<jsp:include page="../../inc/footer.jsp"></jsp:include>

            <!--자바스크립트 팝업-->
            <script src="../../js/classie.js"></script>
            <script src="../../js/modalEffects.js"></script>
            <script>
                // this is important for IEs
                var polyfilter_scriptpath = '/js/';
            </script>
            <script src="../../js/cssParser.js"></script>
            <script src="../../js/css-filters-polyfill.js"></script>-->
</body>
</html>
