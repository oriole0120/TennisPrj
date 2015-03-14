<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%	String ctx = request.getContextPath();	%>	
	
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

                <!--  main content part  -->
                <section id="board-detail" class="space-top-l">
                    <h1 class="hidden">본문 작성</h1>
                    
                    <div id="main-title-bar">
    	                <p> >>Video </p>
	                </div>
        
                    
                    <form id="text-area" action="regProc.jsp" method="post" enctype="multipart/form-data">
                    	<fieldset>
	                    	<legend class="hidden">본문입력필드</legend>
	                    	
	                    	<dl>
		                        <dt class="detail-cell title newrow">제목</dt>
		                        <dd class="detail-cell text-highlight"><input type="text" name="title" /></dd>
		                        
		                        <dt class="hidden">내용</dt>
		                        <dd class="content newrow">
		                        	<textarea name="ir1" id="ir1" rows="10" cols="100" style="width: 690px; height: 400px; display: none;"></textarea>
		                        	
				                        	<script type="text/javascript">
							                    var oEditors = [];
							                    nhn.husky.EZCreator.createInIFrame({
							                        oAppRef: oEditors,
							                        elPlaceHolder: "ir1",
							                        sSkinURI: "../../../editor/SmartEditor2Skin.html",
							                        htParams : {
							                    		bUseToolbar : true,				
							                    		bUseVerticalResizer : false,		
							                    		bUseModeChanger : false,		
							                    		fOnBeforeUnload : function(){
							                    			//alert("작성 완료!");
							                    			alert(getById["ir1"].value);
							                    		}
							                    	},
							                    	fOnAppLoad : function(){
							                    		getById["ir1"].value
							                    		//기존글 수정시 사용
							                    		//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
							                    	},
							                        fCreator: "createSEditor2"
							                    });
							                    
							                     function submitContents(elClickedObj) {
							                    	 oEditors.getByID("ir1").exec("UPDATE_CONTENTS_FIELD", []);	
							                       		
							                    	try {
							                    		elClickedObj.form.submit();
							                    	} catch(e) {}
							                    }
							                    
							                    function setDefaultFont() {
							                    	var sDefaultFont = '맑은고딕';
							                    	var nFontSize = 20;
							                    	oEditors.getByID("ir1").setDefaultFont(sDefaultFont, nFontSize);
							                    }
							                    
							                  <!-- onclick="write()" -->
							                  $("#btn-reg").click(function(){
							                		var contentArea = oEditors.getByID("ir1");
							                		
							                		if(!contentArea)
								                		alert("내용을 작성해주세요");
							                		else {
							                			contentArea.exec("UPDATE_CONTENTS_FIELD", []);
							                			$("#text-area").submit();
							                		}
							                        
							                		
							                		
							                  });

							             
						                	</script>
				                	
		                        </dd>
		                    </dl>
                    	</fieldset>
                    
	                    <p id="button-container" class="space-top text-center">
	                    
	                    	<input id="btn-reg" type = "submit" value="등록"   />
	                    	<a href="list.jsp">취소</a>
	                    </p>
          
                	</form>
            	</section>
            </main>
        </div>
    </div>

		<!-- footer -->
		<jsp:include page="../../../inc/footer.jsp"></jsp:include>
		
        </body>
        </html>
