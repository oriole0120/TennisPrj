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
                <h2 id="main-title-write">   글 작성 </h2>

                 <form id="text-area" action="regProc.jsp" method="post" enctype="multipart/form-data">
                    	<fieldset>
	                    	<legend class="hidden">본문입력필드</legend>
	                    	
	                    	<dl>
		                        <dt class="detail-cell-commu title-free newrow">제목</dt>
		                        <dd class="detail-cell-commu text-highlight"><input type="text" name="title" /></dd>
		                        
		                        <dt class="hidden">내용</dt>
		                        <dd class="content newrow">
		                        	<textarea name="content" id="content" rows="10" cols="100" style="width: 690px; height: 400px; display: none;">
		                        		본문입력됨?
		                        	</textarea>
		                        	
				                        	<script type="text/javascript">
				                        	$(function(){
				                        	    //전역변수선언
				                        	    var editor_object = [];
				                        	     
				                        	    nhn.husky.EZCreator.createInIFrame({
				                        	        oAppRef: editor_object,
				                        	        elPlaceHolder: "smarteditor",
				                        	        sSkinURI: "../../../editor/SmartEditor2Skin.html", 
				                        	        htParams : {
				                        	            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				                        	            bUseToolbar : true,             
				                        	            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				                        	            bUseVerticalResizer : true,     
				                        	            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				                        	            bUseModeChanger : true, 
				                        	        }
				                        	    });
				                        	     
				                        	    //전송버튼 클릭이벤트
				                        	    $("#savebutton").click(function(){
				                        	        //id가 smarteditor인 textarea에 에디터에서 대입
				                        	        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
				                        	         
				                        	        // 이부분에 에디터 validation 검증
				                        	         
				                        	        //폼 submit
				                        	        $("#frm").submit();
				                        	    })
				                        	})


							                    function setDefaultFont() {
							                    	var sDefaultFont = '맑은고딕';
							                    	var nFontSize = 20;
							                    	oEditors.getById["content"].setDefaultFont(sDefaultFont, nFontSize);
							                    }
							                    
						                	</script>
				                	
		                        </dd>
		                    </dl>
                    	</fieldset>
                    
	                    <p id="button-container" class="space-top text-center">
	                    	<input id="savebutton" type = "submit" value="등록" />
	                    	<a href="list.jsp">취소</a>
	                    </p>
          
                	</form>
                </div>

            </main>

        </div>
    </div>



    <!-- footer -->
		<jsp:include page="../../../inc/footer.jsp"></jsp:include>

</body>
</html>
