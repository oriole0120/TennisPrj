

<%@page import="com.htmtennis.prj.model.Schedule"%>
<%@page import="java.util.List"%>
<%@page import="com.htmtennis.prj.dao.ScheduleDao"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcScheduleDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	int npage = 1;
	String field = "TITLE";
	String query = "";

	String _page = request.getParameter("p");
	String _field = request.getParameter("f");
	String _query = request.getParameter("q");

	if (_page != null && !_page.equals(""))
		npage = Integer.parseInt(_page);
	if (_field != null && !_field.equals(""))
		field = _field;

	if (_query != null && !_query.equals(""))
		query = _query;

	ScheduleDao scheduleDao = new JdbcScheduleDao();
	List<Schedule> list = scheduleDao.getSchedules(npage, query, field);

	pageContext.setAttribute("list", list);
	pageContext.setAttribute("total", scheduleDao.getSize("", "TITLE"));
%> 
 


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

   <!--<link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/reset.css" rel="stylesheet" type="text/css" />
    <link href="css/layout.css" rel="stylesheet" type="text/css" />-->

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
                    <!--  main content part  -->
                    <h2 id="main-title">   Schedule </h2>

                    <nav id="full-path">
                        <!--<h3>현재경로</h3>-->
                        <ol>
                            <li class="path">Home ></li>
                            <li class="path">Schedule ></li>
                            
                        </ol>
                    </nav>

                    


                    <!--///// ----/////-->


                    <table width="600" height="320" style="table-layout:fixed">

                        <tr>
                            <th id="thm" colspan="7">2015년 1월</th>

                        </tr>


                        <tr>
                            <th><a href="">월</a></th>
                            <th><a href="">화</a></th>
                            <th><a href="">수</a></th>
                            <th><a href="">목</a></th>
                            <th><a href="">금</a></th>
                            <th><a href="">토</a></th>
                            <th><a href="">일</a></th>

                        </tr>
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th>1  </th>
                            <th>2</th>
                            <th>3</th>


                        </tr>
                        <tr>
                            <th>4</th>
                            <th>5</th>
                            <th>6</th>
                            <th>7</th>
                            <th>8</th>
                            <th>9</th>
                            <th>10</th>


                        </tr>
                        <tr>
                            <th>11</th>
                            <th>12</th>
                            <th>13</th>
                            <th>14</th>
                            <th>15</th>
                            <th>16</th>
                            <th>17</th>


                        </tr>
                        <tr>
                            <th>18</th>
                            <th>19</th>
                            <th>20</th>
                            <th>21</th>
                            <th>22</th>
                            <th>23</th>
                            <th>24</th>


                        </tr>
                        <tr>
                            <th>25</th>
                            <th>26</th>
                            <th>27</th>
                            <th>28</th>
                            <th>29</th>
                            <th>30</th>
                            <th>31</th>


                        </tr>

                    </table>




                    <!--///////-->
                    <div class="board">
                    <table id="day" width="400" height="100" style="table-layout:fixed">
                       <thead>
                        <tr class="board-row">
                            <th class ="board-cell-th board-cell-width-60  text-center">순서</th>
                            <th class ="board-cell-th board-cell-width-140  text-center">일정</th>
                            <th class ="board-cell-th board-cell-width-200  text-center">일자</th>
                        </tr>
                       </thead>
                       
                       
                        <tbody>
                        
                        <c:forEach var="sch" items="${list}"> 
                        <tr>
                        
                        <td> ${sch.code}</td>
                        <td><a class="board-list-item-text" href="view.jsp?c=${sch.code}"> ${sch.contents}</a></td>
                        <td> ${sch.eventdate}</td>
                        
                        
                        </tr>
                    </c:forEach> 
                        
                      
                       
                       
                        
                        </tbody>
                        

                    </table>
                 </div>




               <%-- <div> 
                         <!--<h3>현재페이지위치</h3>--> 
                         <p id="page-list">1/5 page</p> 
                     </div> 
 
 
                     <div> 
                         <!--<h3>페이지선택목록</h3>--> 
                         <p><a class="page" href="list.jsp">이전</a></p> 
                          
                         <ul class="page" >
                         
                          
                          
                          
                         <ui:pager total="${total}"/> 
                         <p><a href="list.jsp">다음</a></p> 
                     </div>  --%>


                    <div id="main-search-form">
                        <!--<h3>영상게시물 검색폼</h3>-->
                        <form>
                            <!-- <fieldset>
                                <legend>영상검색필드</legend>
                                <select>
                                    <option>작성자</option>
                                    <option>제목</option>
                                    <option>본문</option>
                                </select>

                                <input class="search" type="text" name="query" />
                                <input class="search" type="submit" value="검색" />

                            </fieldset> -->
                            
                            <fieldset>
                                                            
                                <legend class="hidden">링크 검색 필드</legend>
							<label for="field" class="hidden">검색분류</label> 
								<select
									class="search-field" name="f">
									<option ${param.f=='writer' ? 'selected' : ""} value="writer">작성자</option>
									<option ${param.f=='title' ? 'selected' : ""} value="title">제목</option>
									<option ${param.f=='contents' ? 'selected' : ""} value="contents">본문</option>
								</select> 
                                    <input class="search" type="text" name="q" value=${param.q }></input>
                                	<input class="search" type="submit" value="검색" />
                            </fieldset>
                        </form>
                    </div>



                       <div>
                        <form class="write-btn-item">
                            <fieldset>
                                <!--<legend>글쓰기</legend>-->
                                <input type="button" value="일정등록" onclick="location.href = ' write.jsp'">
                            </fieldset>
                        </form>
                    </div>








                    <!--///////////-->


                    


                 

                </div>
            </main>

        </div>
    </div>

    <!-- footer -->
		<jsp:include page="../../inc/footer.jsp"></jsp:include>


    
</body>
</html>
