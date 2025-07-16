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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/gallery.css">
<!-- js -->
<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-3.7.1.js"></script>

</head>

<body>
	<div class="wrap">
		<!-- 헤더 + 네비 ---------------------------------------------->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- 헤더 ---------------------------------------------->

		<div class="content2 clearfix">
         	<!-- aside ------------------------------------>
            <c:import url="/WEB-INF/views/include/asideAttach.jsp"></c:import>
            <!-- aside ------------------------------------>

			<main>
				<div class="main-head clearfix">
					<h3>일반갤러리</h3>
					<ol class="clearfix">
						<li>홈</li>
						<li>갤러리</li>
						<li>일반갤러리</li>
					</ol>
				</div>

				<div id="gallery-list">
					<c:if test="${not empty sessionScope.authUser}">
					<div class="btn-box">
						<button id="btnUpload" class="btn btn-blue btn-md" type="submit">이미지올리기</button>
					</div>
					</c:if>

					<ul class="clearfix">

						<c:forEach items="${requestScope.gaList}" var="galleryVO">
							<!-- 이미지반복영역 -->
							<li>
								<div class="card">
									<img src="${pageContext.request.contextPath}/upload/${galleryVO.saveName}">
									<div class="writer">
										작성자: <strong>${galleryVO.userName}</strong>
									</div>
								</div>
							</li>
							<!-- 이미지반복영역 -->
						</c:forEach>

					</ul>
				</div>

			</main>
		</div>

		<!-- 푸터 ------------------------------------------>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>	
		<!-- 푸터 ------------------------------------------>

	</div>





	<!-- 모달창 -->
	<!-- 업로드 모달창 -->
	<div id="modal-upload" class="modal-bg">

		<div class="modal-content">

			<div class="clearfix">
				<button class="btn-close">X</button>
			</div>

			<p class="title">이미지등록 모달창</p>


			<form id="imgupload-form" action="${pageContext.request.contextPath}/gallery/upload" method="post" enctype="multipart/form-data">
				<div class="info-row">
					<label for="txt-content">글작성</label> <input id="txt-content" type="text" name="content" value="">
				</div>

				<div class="info-row">
					<label for="txt-file">이미지선택</label> <input type="file" name="file" value="">
				</div>
				<div class="btn-box">
					<button type="submit" class="btn-del btn btn-blue btn-md">등록</button>
				</div>
			</form>

		</div>

	</div>


	<!-- 이미지보기 모달창 -->
	<div id="modal-view" class="modal-bg">

		<div class="modal-content">

			<div class="clearfix">
				<button class="btn-close">X</button>
			</div>

			<p class="title">이미지보기 모달창</p>

			<div id="img-view">
				<img src="${pageContext.request.contextPath}/upload/${galleryVO.saveName}">


				<div class="img-content">
					${galleryVO.content}
				</div>

				<div class="btn-box">
					<button type="submit" class="btn-del btn btn-blue btn-md">삭제</button>
				</div>

			</div>


		</div>

	</div>


<!-- --------------------------------------------------------- -->
<script>
$(document).ready(function(){
	
	console.log('돔트리완료');
	
	//이미지업로드 모달창 열기
	$('#btnUpload').on('click', function(){
		console.log('이미지올리기 클릭');
		
		$('#modal-upload').addClass('active');
		
		
	});
	
	//이미지업로드 모달창 닫기
	$('#modal-upload .btn-close').on('click', function(){
		console.log('이미지업로드 닫기');
		
		$('#modal-upload').removeClass('active');
	});
	
	
	//이미지보기 모달창 열기
	$('#gallery-list .clearfix').on('click', function(){
		
		console.log('이미지보기');
		
		$('#modal-view').addClass('active');
		
	});
	
	//이미지보기 모달창 닫기
 	$('#modal-view .btn-close').on('click', function(){
		
		console.log('이미지보기 모달창 닫기');
		
		$('#modal-view').removeClass('active');
		
	}); 
	
	
	
});



</script>



</body>
</html>