<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="../../assets/css/reset.css">
        <link rel="stylesheet" href="../../assets/css/mysite.css">
        <link rel="stylesheet" href="../../assets/css/guestbook.css">
    </head>


	<body>
		  <div class="wrap">
            <header class="clearfix">
                <h1><a href="">MySite</a></h1>
              
                <!--
			    <ul class="clearfix">
				    <li><span class="user-welcome">황일영 님 안녕하세요^^</span></li>
				    <li>
                        <a class="btn btn-white btn-sm" href="">로그아웃</a>
                    </li>
                    <li>
                        <a class="btn btn-white btn-sm" href="">정보수정</a>
                    </li>
			    </ul>
                -->
                 	
               <ul class="clearfix">
                    <li>
                        <a class="btn btn-white btn-sm" href="">로그인</a>
                    </li>
                    <li>
                        <a class="btn btn-white btn-sm" href="">회원가입</a>
                    </li>
                </ul>
            </header>

 			<nav>
                <ul class="clearfix">
                    <li><a href="">입사지원서</a></li>
                    <li><a href="">게시판</a></li>
                    <li><a href="">갤러리</a></li>
                    <li><a href="">방명록</a></li>
                </ul>
            </nav>
		
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
						<form class="form-box" action="" method="">
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
						
						<c:forEach items="${requestScope.gList}" var="guestbookVO">
							<table class="guestbook-item">
								<colgroup>
									<col style="width: 10%;">
									<col style="width: 40%;">
									<col style="width: 40%;">
									<col style="width: 10%;">
								</colgroup>
								<tbody>
									<tr>
										<td>${guestbookVO.no}</td>
										<td>${guestbookVO.name}</td>
										<td>${guestbookVO.regDate}</td>
										<td class="txt-center">
											<a class="btn btn-gray btn-sm" href="">삭제</a>
										</td>
									</tr>
									<tr>
										<td colspan=4>${guestbookVO.content}</td>
									</tr>
								</tbody>
							</table>
						</c:forEach>
					</div>
			    
                </main>
            </div>
            
            <footer>
                <p>
                    Copyright ⓒ 2025 황일영. All right reserved  
                </p>
            </footer>

        </div>
     
    </body>
</html>