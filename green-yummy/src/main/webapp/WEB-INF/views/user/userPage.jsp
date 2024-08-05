<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link href="/user/css/userPage.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>

    <main>
        <div class="userContainer">
            <div class="forUser">
                <div class="userPic">
    
                </div>
    
                <div class="userBtns">
                    <p>${nickname}님, 환영합니다!</p>
                    <input type="button" value="회원정보 수정" onclick="infoChange()"><br>
                    <input type="button" value="로그아웃" onclick="logout()"><br>
                    <input type="button" value="회원탈퇴" onclick="userBye()"><br>
                </div>
            </div>
        
        
            <ul class="mypageTab">
                <li class="storeTab youHere">나의 맛집(0개)</li>
                <li class="reviewTab">나의 리뷰(0개)</li>
            </ul>
        
        	
            <iframe src="../user/storeCollection" class="stores"></iframe>
            <iframe src="../user/reviewList" class="reviews hidden"></iframe>
        
            <div class="modalContainer1 hidden">
                <div class="logoutModal">
                    <div class="xplace cancel" onclick="logout()"></div>
                    로그아웃 하시겠습니까?
                    <div class="logoutBtns">
                        <input type="button" value="확인">
                        <input type="button" value="취소" class="cancle" onclick="logout()">
                    </div>
                    
                </div>
            </div>
        
            <div class="modalContainer2 hidden">
                <div class="userOutModal">
                    <div class="xplace cancel" onclick="userBye()"></div>
                    탈퇴하시겠습니까?
                    <div class="userOutBtns">
                        <input type="button" value="탈퇴">
                        <input type="button" value="취소" class="cancel" onclick="userBye()">
                    </div>
                   
                </div>
            </div>
        </div>
        
    </main>
    
    <script src="/user/js/userPage.js"></script>
    
<jsp:include page="../public/footer.jsp"/>


    
</body>
</html>