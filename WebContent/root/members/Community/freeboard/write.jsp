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
							                    var oEditors = [];
							                    nhn.husky.EZCreator.createInIFrame({
							                        oAppRef: oEditors,
							                        elPlaceHolder: "content",
							                        sSkinURI: "../../../editor/SmartEditor2Skin.html",
							                        htParams : {
							                    		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
							                    		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
							                    		bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
							                    		fOnBeforeUnload : function(){
							                    			alert("완료!");
							                    		}
							                    	},
							                    	fOnAppLoad : function(){
							                    		
							                    		//예제 코드
							                    		//oEditors.getById["content"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
							                    	},
							                        fCreator: "createSEditor2"
							                    });
							                    
							                    // 추가 글꼴 목록
							                    //var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

							                    	

							                    /* function pasteHTML() {
							                    	var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
							                    	oEditors.getById["content"].exec("PASTE_HTML", [sHTML]);
							                    }

							                    function showHTML() {
							                    	var sHTML = oEditors.getById["content"].getIR();
							                    	alert(sHTML);
							                    } */
							                    	
							                     function submitContents(elClickedObj) {
							                    	oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []); 	// 에디터의 내용이 textarea에 적용됩니다.
							                    	
							                    	// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
							                    	
							                     	try {
							                    		elClickedObj.form.submit();
							                    	} catch(e) {}
							                    } 
							                    
							                    /* $("#btn-reg").click(function(){

		                                             oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
		                                             $("#text-area").submit();
		                                             
		                                       }); */

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
	                    	<input type = "submit" value="등록" />
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
