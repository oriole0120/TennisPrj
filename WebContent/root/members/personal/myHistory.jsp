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
                    <h2 id="main-title">내글목록</h2>

                    <div id="delete-btn">
                        <input type="submit" value="삭제"></div>

                    <div>
                        <h3 class="hidden">영상목록부분</h3>

                        <table id="free-board-table">
                            <thead>
                                <tr class="free-board-row">
                                    <th class="free-board-cell num"><a class="board-list-item-text">번호</a></th>
                                    <th class="free-board-cell title"><a class="board-list-item-text">제목</a></th>
                                    <th class="free-board-cell writer"><a class="board-list-item-text">작성자</a></th>
                                    <th class="free-board-cell date"><a class="board-list-item-text">작성일</a></th>
                                    <th class="free-board-cell hit"><a class="board-list-item-text">조회수</a></th>
                                    <th class="free-board-cell recommend"><a class="board-list-item-text">추천</a></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">10</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">학교에서 테니스 치실분 계신가요~</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">나달짱짱</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-20</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">77</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">12</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">9</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">테니스 레슨시작했습니다!</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">페더러짱짱</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-19</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">17</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">52</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">8</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">오늘 테니스치기 좋은날씨네요ㅎㅎ</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">회장님</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-18</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">71</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">11</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">7</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">테니스 레슨에 관해서 질문있어요~!!</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">한성테니스</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-18</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">77</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">12</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">6</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">우리 동아리 가입하고 싶은 학생이 있다네요~</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">아자르</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-18</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">15</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">48</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">5</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">테니스는 즐거운 운동이네요^^테니스는 즐거운 운테니스는 즐거운 운테니스는 즐거운 운테니스는 즐거운 운테니스는 즐거운 운</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">운영자</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-17</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">53</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">22</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">4</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">테니스 질문있어요~!!</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">페더러</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-17</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">77</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">12</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">3</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">한성대테니스동아리에요ㅎㅎ</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">동아리10학번</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-17</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">55</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">25</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">2</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">테니스 엄청 힘든운동이네요ㅎㅎ</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">초보자</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-17</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">24</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">11</a></td>
                                </tr>
                                <tr>
                                    <td class="free-board-cell num"><a class="board-list-item-text">1</a></td>
                                    <td class="free-board-cell title"><a class="board-list-item-text" href="view.html">즐거운 모임이었어요^^</a></td>
                                    <td class="free-board-cell writer"><a class="board-list-item-text" href="">조코비치</a></td>
                                    <td class="free-board-cell date"><a class="board-list-item-text">2015-01-17</a></td>
                                    <td class="free-board-cell hit"><a class="board-list-item-text">51</a></td>
                                    <td class="free-board-cell recommend"><a class="board-list-item-text">33</a></td>
                                </tr>

                            </tbody>
                        </table>
                    </div>

                    <div>
                        <!--<h3>현재페이지위치</h3>-->
                        <p id="page-list">1/5 page</p>
                    </div>

                    <div>
                        <!--<h3>페이지선택목록</h3>-->
                        <p><a class="page" href="list.html">이전</a></p>
                        <ul>
                            <li class="page">1</li>
                            <li class="page">2</li>
                            <li class="page">3</li>
                            <li class="page">4</li>
                            <li class="page">5</li>
                        </ul>
                        <p><a href="list.html">다음</a></p>
                    </div>

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

                </div>
            </main>

        </div>
    </div>



    <!-- footer -->
		<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>
