<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

					<div id="guestbook-removeform">
						<form class="form-box" action="" method="">
							<table>
								<colgroup>
									<col style="width: 10%;">
									<col style="width: 50%;">
									<col style="width: 25%;">
									<col style="width: 15%;">
								</colgroup>
								<tbody>
									<tr>
										<th>비밀번호</th>
										<td>
											<input type="password" name="password" value="">
										</td>
										<td class="text-left">
											<button class="btn btn-blue btn-input" type="submit">삭제</button>
										</td>
										<td class="txt-center">
											<a id="btn-main" class="btn btn-gray btn-input" href="">메인으로 돌아가기</a>
										</td>
									</tr>
								</tbody>
							</table>
						</form>
						
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