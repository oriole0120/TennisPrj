<%@page import="com.htmtennis.prj.model.Join"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcJoinDao"%>
<%@page import="com.htmtennis.prj.dao.JoinDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	JoinDao joinDao = new JdbcJoinDao();

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
		/* JoinDao joinDao = new JdbcJoinDao();		
		joinDao.insert(Join); */
	/* JoinDao joinDao = new JdbcJoinDao();
	List<Join> list = joinDao.getJoins(npage, query, field);
	
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
                            <table border="1">
                            
                                <tr>
                                    <td align="center" width=130>아이디</td>
                                    <td colspan=3>
                                   <%--  <c:forEach var="jn" items="${list}">
                                    </c:forEach> --%>
                                        <input type="text" name="id" id="name" value="">${jn.mid }</input>
                                    
                                    </td>
                                </tr>
 							
                                <tr>
                                    <td align="center">비밀번호</td>
                                    <td colspan=3>
                                        <input type="password" name="pw" id="name" value="" />
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
                                    <td align="center">학번</td>
                                    <td colspan=3>
                                        <input type="text" name="name" id="name" value="" />
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center">성별</td>
                                    <td colspan='3'>
                                        <fieldset data-role="controlgroup">
                                            <input type="radio" name="gender" id="radio-choice-1" value="choice-1" checked="checked" />
                                            <label for="radio-choice-1">남자</label>

                                            <input type="radio" name="gender" id="radio-choice-2" value="choice-2" />
                                            <label for="radio-choice-2">여자</label>
                                        </fieldset>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center"> 생년월일</td>
                                    <td>
                                        <select name="year">
                                            <option value="2000" selected>2000</option>
                                            <option value="2001" selected>2001</option>
                                            <option value="2002" selected>2002</option>
                                            <option value="2003" selected>2003</option>
                                            <option value="2004" selected>2004</option>
                                        </select>
                                    </td>
                                    <td>

                                        <select name="month">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="day">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="26">26</option>
                                            <option value="27">27</option>
                                            <option value="28">28</option>
                                            <option value="29">29</option>
                                            <option value="30">30</option>
                                            <option value="31">31</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                            <button class="md-close">완료</button>
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
