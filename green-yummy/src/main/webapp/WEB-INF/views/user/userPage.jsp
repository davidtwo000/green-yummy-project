<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link href="/css/mypage.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="/public/header.jsp"/>

    <main>
        <div class="userContainter">
            <div class="forUser">
                <div class="userPic">
    
                </div>
    
                <div class="userBtns">
                    <p>${nickname}님, 환영합니다!</p>
                    <input type="button" value="회원정보 수정"><br>
                    <input type="button" value="로그아웃"><br>
                    <input type="button" value="회원탈퇴"><br>
                </div>
            </div>
        
            
            
        
            <div class="writeNumber">
                내가 쓴 리뷰: N개       내가 저장한 맛집: K개
            </div>
        
            <ul class="mypageTab">
                <li>나의 리뷰</li>
                <li>나의 맛집</li>
            </ul>
        
            <iframe src="storeCollection.jsp"></iframe>
            <iframe src="reviewList.jsp"></iframe>
        
            <div class="modalContainer hidden">
                <div class="logoutModal">
                    <div class="xplace"></div>
                    로그아웃 하시겠습니까?
                    <div class="logoutBtns">
                        <input type="button" value="확인">
                        <input type="button" value="취소">
                    </div>
                    
                </div>
            </div>
        
            <div class="modalContainer hidden">
                <div class="userOutModal">
                    <div class="xplace"></div>
                    탈퇴하시겠습니까?
                    <div class="userOutBtns">
                        <input type="button" value="탈퇴">
                        <input type="button" value="취소">
                    </div>
                   
                </div>
            </div>
        </div>
        
    </main>
    
<jsp:include page="/public/footer.jsp"/>
    
</body>
</html>