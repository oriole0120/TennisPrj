<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

   
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
   

    <link href="css/fullcalendar.css" rel="stylesheet" />
    <link href="css/fullcalendar.print.css" rel="stylesheet" media="print" />
    <script src="js/moment.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/fullcalendar.min.js"></script>
    <script src="js/lang-all.js"></script>
    <script src="js/jquery.alerts.js"></script>
      
    <script type="text/javascript" src="../js/modernizr.js"></script>
    
    
    <script>

$(document).ready(function() {
	$("#calendar").fullCalendar({
		header: {
			left: "prev,next today",
			center: "title",
			right: "month,agendaWeek,agendaDay"
		},

		lang: "ko",
		events: [
		         {
		        	title: 'My Event',
		            start: '2014-11-14'
		         }
		         ],
		editable: true,		
		eventClick: function(calEvent, jsEvent, view) {
			alert("test");
		},
		selectable: true,
		selectHelper: true,
		select: function(start, end) {
			jDetail("", "", "새 이벤트 만들기", function(r) {
				var title = r;
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					};
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
				$('#calendar').fullCalendar('unselect');
				
			});
		}
	});
});

</script>
    
<style>
/* body {
	margin: 200px 200px;
	padding: 0;
	font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	font-size: 14px;
} */

#calendar {
	max-width: 700px;
	margin: 0 auto;
}


 #popup_container {
	font-family: Arial, sans-serif;
	font-size: 12px;
	min-width: 700px; /* Dialog will be no smaller than this */
	max-width: 700px; /* Dialog will wrap after this width */
	background: #FFF;
	border: solid 5px #999;
	color: #000;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

#popup_title {
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	line-height: 1.75em;
	color: #666;
	background: #CCC top repeat-x;
	border: solid 1px #FFF;
	border-bottom: solid 1px #999;
	cursor: default;
	padding: 0em;
	margin: 0em;
}

#popup_content {
	padding: 1em 1.75em;
	margin: 0em;
}

#popup_panel {
	text-align: center;
	margin: 1em 0em 0em 1em;
}

#popup_prompt {
	margin: .5em 0em;
} 
</style>   
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
                <div >
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


                  <div id='calendar'></div>
                  
                  
                  
                 <!--  //////---/// -->
                  



                    <!--///////////-->



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
