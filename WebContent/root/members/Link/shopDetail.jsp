
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcShopDao"%>
<%@page import="com.htmtennis.prj.model.Shop"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	String code = request.getParameter("c");
	Shop sh = new JdbcShopDao().getShop(code);
	pageContext.setAttribute("sh", sh);
		
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
    <header id="header">
        <!--  header part  -->
        <div class="content-wrapper">
            <h1 class="hidden">Header</h1>
            <div class="logo">
                <a href=""><img src="../../images/logo_s.png" alt="동아리로고"></a>
                <p>Hansung Tennis Membership</p>
            </div>

            <section class="header-item-container">
                <h2 class="hidden">머릿말</h2>
                <nav id="member-menu">
                    <h3 class="hidden">회원메뉴</h3>
                    <ul class="clearfix">
                        <li class="member-menu-item"><a class="member-menu-text" href="">홈</a></li>
                        <li class="member-menu-item"><a class="member-menu-text" href="">로그인</a></li>
                        <li class="member-menu-item"><a class="member-menu-text" href="">가입</a></li>
                    </ul>
                </nav>

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
                <img id="slide-img" src="../../images/slide-img01.png" />
            </div>

        </div>
    </header>


    <div id="body">
        <div class="content-wrapper clearfix">

            <aside id="side">
                <!--  aside menu part  -->
                <!--<h2 class="hidden">Menu</h2>-->
                <nav id="side-menu">
                    <ul class="clearfix">
                        <li class="side-menu-item"><a class="side-menu-text" href="">Notice</a></li>
                        <li class="side-menu-item"><a class="side-menu-text" href="">Tennis</a></li>

                        <li class="side-menu-item">
                            <a class="side-menu-text" href="">Community</a>
                            <ul>
                                <li class="side-menu-detail"><a class="side-menu-text" href="">Free</a>
                                <li class="side-menu-detail"><a class="side-menu-text" href="">Info</a>
                            </ul>
                        </li>

                        <li class="side-menu-item">
                            <a class="side-menu-text" href="">Gallery</a>
                            <ul>
                                <li class="side-menu-detail"><a class="side-menu-text" href="">Photo</a>
                                <li class="side-menu-detail"><a class="side-menu-text" href="">Video</a>
                            </ul>
                        </li>

                        <li class="side-menu-item"><a class="side-menu-text" href="">Schedule</a></li>
                        <li class="side-menu-item"><a class="side-menu-text" href="">Link</a></li>
                    </ul>
                </nav>

            </aside>


            <main id="main">
                <!--<h2 id="main-title">Link</h2>-->


                <div class="text-center space-top">
                    <div class="wrapper">
                        <div class="main-item">
                            <!--<h3>영상게시물 검색폼</h3>-->
                            <form>
                                <fieldset>
                                    <a>지도를 클릭하시면 서울 및 지역구별 검색을 할수 있습니다</a>
                                    <input class="input-normal" type="text" name="query" />
                                    <input class="btn btn-search" type="submit" value="검색" />
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="space-top">
                    <table class="board-tabled text-center">
                        <thead>
                            <tr class="board-rowd">
                                <th class="board-cell-thd board-cell-width-60d  text-center"><a href="">번호</a></th>
                                <th class="board-cell-thd board-cell-width-100d  text-center"><a href="">이름</a></th>
                                <th class="board-cell-thd board-cell-width-300d  text-center"><a href="">주소</a></th>
                                <th class="board-cell-thd board-cell-width-160d  text-center"><a href="">전화번호</a></th>
                                <th class="board-cell-thd board-cell-width-160d  text-center"><a href="">사이트</a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="board-rowd">
                                <th class="board-celld board-cell-width-60d">${sh.code}</th>
                                <th class="board-celld board-cell-width-100d">${sh.name}</th>
                                <th class="board-celld board-cell-width-300d">${sh.address}</th>
                                <th class="board-celld board-cell-width-160d">${sh.phoneNumber}</th>
                                <th class="board-cell-thd board-cell-width-160d text-center">${sh.site}</th>
                            </tr>
                        </tbody>

                    </table>
                </div>
                <div class="text-center">
                    <a class="court" href=""><img src="../../images/map-detail.png" width="500" height="350" alt="맵"></a>
                </div>

            </main>



        </div>
    </div>



    <footer id="footer">
        <!--  footer part  -->
        <div class="content-wrapper clearfix">

            <div id="logo-footer-container">
                <h2><img src="../../images/logo_m.png" alt="동아리정보" /></h2>
            </div>

            <div id="company-info-container">
                <div id="company-info">
                    <h3 class="hidden">동아리정보</h3>
                    <dl class="clearfix">
                        <dt class="company-info-item item-title item-newline"> 주소</dt>
                        <dd class="company-info-item item-data">서울특별시 성북구 삼선교로 16길 116</dd>
                        <dt class="company-info-item item-title">연락처</dt>
                        <dd class="company-info-item item-data">02-760-5528</dd>

                        <dt class="company-info-item item-title item-newline">관리자메일</dt>
                        <dd class="company-info-item item-data">oriole0120@naver.com</dd>
                        <dt class="company-info-item item-title">회장</dt>
                        <dd class="company-info-item item-data">###</dd>
                        <dt class="company-info-item item-title">HTM</dt>
                        <dd class="company-info-item item-data">[Hansung Tennis Membership]</dd>
                    </dl>
                </div>

                <div id="copyright">
                    <h3 class="hidden">저작권정보</h3>
                    <p>Copyright@chanCompany 2015</p>
                </div>
            </div>
        </div>

    </footer>

</body>
</html>