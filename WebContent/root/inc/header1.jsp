<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
 <c:set var="ctxName" value="${pageContext.request.servletContext.contextPath}" />
 
<link href="/component.css" rel="stylesheet" type="text/css" />
<link href="/default.css" rel="stylesheet" type="text/css" />	
<script type="text/javascript" src="../../js/modernizr.js"></script>
<script src="/modernizr.custom.js"></script>

    <header id="header">
        <!--  header part  -->
        <div class="content-wrapper">
            <h1 class="hidden">Header</h1>
            <div class="logo">
                <a href=""><img src="${ctxName}/root/images/logo_s.png" alt="동아리로고"></a>
                <p>Hansung Tennis Membership</p>
            </div>

            <section class="header-item-container">
                <h2 class="hidden">머릿말</h2>
                <nav id="member-menu">
                    <h3 class="hidden">회원메뉴</h3>
                    <ul class="clearfix">
                        <li class="member-menu-item md-trigger" data-modal="modal-12"><a class="member-menu-text" href="">홈</a></li>
                        <li class="member-menu-item" ><a class="member-menu-text" href="">로그인</a></li>
                        <li class="member-menu-item"><a class="member-menu-text" href="">가입</a></li>

                    </ul>
                </nav>
                
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
                           
                            <div class="md-close">
                            	<button type="submit" >완료</button>
                            	<a href="../Community/freeboard/list.jsp"><button>취소</button></a>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="md-overlay"></div>
            </div>
        </div>
        
        <!--자바스크립트 팝업-->
            <script src="/classie.js"></script>
            <script src="/modalEffects.js"></script>
            <!-- <script>
                // this is important for IEs
                var polyfilter_scriptpath = '/js/';
            </script> -->
           <!--  <script src="../../js/cssParser.js"></script>
            <script src="../../js/css-filters-polyfill.js"></script> -->

                <nav id="search-form">
                    <h3 class="hidden">게시글검색폼</h3>
                    <form>
                        <fieldset>
                            <input id="search-input" type="text" />
                            <input id="search-button" type="submit" value="검색" />
                        </fieldset>
                    </form>
                </nav>
            </section>

            <div class="header-slide-img">
                <!--  image slide part  -->
                <img id="slide-img" src="${ctxName}/root/images/slide-img01.png" />
            </div>
        </div>
    </header>
   
    