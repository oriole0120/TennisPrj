<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

    <link href="css/bind.css" rel="stylesheet" type="text/css" />
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
                <h2 id="main-title-write">   글 작성 </h2>

                <form id="text-area">
                    <textarea name="ir1" id="ir1" rows="10" cols="100" style="width:750px; height:400px; display:none;">
                        에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.</textarea>
                </form>

                <script type="text/javascript">
                    var oEditors = [];
                    nhn.husky.EZCreator.createInIFrame({
                        oAppRef: oEditors,
                        elPlaceHolder: "ir1",
                        sSkinURI: "../../../editor/SmartEditor2Skin.html",
                        fCreator: "createSEditor2"
                    });
                 </script>

                <div>
                    <!--<h3>영상게시물 검색폼</h3>-->
                    <form>
                        <fieldset>
                            <!--<legend>영상검색필드</legend>-->
                            <div class="regis">
                               <p class="regis-btn"><a href="view.html">등록</a></p>
                               <p class ="regis-btn"><a href="list.html">취소</a></p>
                            </div>

                        </fieldset>
                    </form>
                </div>

            </main>

        </div>
    </div>



   <!-- footer -->
		<jsp:include page="../../../inc/footer.jsp"></jsp:include>

</body>
</html>
