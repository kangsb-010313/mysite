<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/guestbook.css">
        <!-- js -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-3.7.1.js"></script>
    </head>


	<body>
		  <div class="wrap">
			<!-- 헤더 + 네비 ---------------------------------------------->
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
			<!-- 헤더 ---------------------------------------------->
		
            <div class="content2 clearfix">
                <aside>
                    <h2>방명록</h2>
                    <ul>
                        <li><a href="">일반방명록</a></li>
                        <li><a href="">ajax방명록</a></li>
                    </ul>
                </aside>

				<main>
					
				    <div class="main-head clearfix">
                        <h3>일반방명록</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>방명록</li>
                            <li>일반방명록</li>
                        </ol>
                    </div>

					<div id="guestbook-addlist">
						<form id="formAdd" class="form-box" action="" method="get">
							<table>
								<colgroup>
									<col style="width: 70px;">
									<col style="width: 340px;">
									<col style="width: 70px;">
									<col style="width: 340px;">
								</colgroup>
								<tbody>
									<tr>
										<th>
											<label for="txt-name">이름</label>
										</th>
										<td>
											<input id="txt-name" type="text" name="name" value="">
										</td>
										<th>
											<label for="txt-password">패스워드</label>
										</th>
										<td>
											<input id="txt-password"type="password" name="password" value="">
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<textarea id="text-content" name="content"></textarea>
										</td>
									</tr>
									<tr>
										<td colspan="4" class="btn-box">
											<button class="btn btn-blue btn-lg" type="submit">등록</button>
										</td>
									</tr>
								</tbody>
								
							</table>
						</form>	
						
						<!-- <button id="btnList" class="btn btn-blue btn-md" type="button">전체데이터 요청</button> -->
						
						
						<div id="gbListArea">
							<!-- 리스트가 출력되는자리 -->
						</div>
						
						
					
					</div>
			    
                </main>
            </div>
            
			<!-- 푸터 ------------------------------------------>
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>	
			<!-- 푸터 ------------------------------------------>

        </div>
        
    <!-- ---------------------------------------------------------- -->
    <script>
    $(document).ready(function(){
    	console.log('돔트리완료');
    	
    	fetchList(); //리스트데이터 요청해서 그리는 함수
    	
    	/*
    	//버튼 클릭할 때
    	$('#btnList').on('click', function(){
    		console.log('버튼클릭');
    		
    		fetchList(); //리스트데이터 요청해서 그리는 함수
    		
    		
    	});
    	*/
    	
    	//등록버튼을 클릭했을 때
    	$('#formAdd').on('submit', function(event){
    		console.log('등록버튼클릭');
    		event.preventDefault();
    		
    		//value값 수집
    		let name = $('#txt-name').val();
    		let pw = $('#txt-password').val();
    		let content = $('#text-content').val();
    		
    		//vo묶기
    		let guestbookVO = {
    			name: name,
    			password: pw,
    			content: content
    		};
    	
    		console.log(guestbookVO);
    		
    		//서버에 저장 요청
    		$.ajax({
    			
    			url : '${pageContext.request.contextPath }/api/guestbook/add',		
    			type : 'post',
    			//contentType : 'application/json',
    			data : guestbookVO,

    			dataType : 'json',
    			success : function(guestbookVO){
    				/*성공시 처리해야될 코드 작성*/
    				
    				
    				/* 화면에 그리기 */
    				render(guestbookVO, 'up');
    				
    				/* 입력폼 비우기 */
    	    		$('#txt-name').val('');
    	    		$('#txt-password').val('');
    	    		$('#text-content').val('');
    				
    			},
    			error : function(XHR, status, error) {
    				console.error(status + ' : ' + error);
    			}
    		});

        	
    	});
    		
	
    	
    	
    	
    });//돔트리
    
    
    //리스트데이터 요청해서 그리는 함수
    function fetchList(){
		$.ajax({
			
			//보내는거
			url : "${pageContext.request.contextPath}/api/guestbook/list",		
			type : "post",
			//contentType : "application/json",
			//data : {name: "홍길동"}, 

			//받는 거
			dataType : "json",
			success : function(guestbookList){
				/*성공시 처리해야될 코드 작성*/
				//console.log(guestbookList);
				
				//화면에 그린다
				for(let i=0; i<guestbookList.length; i++){
					render(guestbookList[i], 'down');	
				}
				   					
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
    }
    
	
    //guestbookVO 1개를 화면에 그린다
    function render(guestbookVO, updown){
    	console.log(guestbookVO);
    	
    	let str = '';
    	str += '<table class="guestbook-item">';
    	str += '	<colgroup>';
    	str += '		<col style="width: 10%;">';
    	str += '		<col style="width: 40%;">';
    	str += '		<col style="width: 40%;">';
    	str += '		<col style="width: 10%;">';
    	str += '	</colgroup>';
    	str += '	<tbody>';
    	str += '		<tr>';
    	str += '			<td>'+ guestbookVO.no + '</td>';
    	str += '			<td>'+ guestbookVO.name + '</td>';
    	str += '			<td>'+ guestbookVO.regDate + '</td>';
    	str += '			<td class="txt-center">';
    	str += '				<a class="btn btn-gray btn-sm" href="">삭제</a>';
    	str += '			</td>';
    	str += '			</tr>';
    	str += '			<tr>';
    	str += '				<td colspan=4>'+ guestbookVO.content + '</td>';
    	str += '			</tr>';
    	str += '	</tbody>';
    	str += '</table>';
    	
    	if(updown == 'up'){
    		$('#gbListArea').prepend(str);	
    	}else if(updown == 'down'){
    		$('#gbListArea').append(str);
    	}else{
    		console.log('방향체크');
    	}
    	
    	
    	
    	
    	
    }

    
    </script>
     
    </body>
</html>