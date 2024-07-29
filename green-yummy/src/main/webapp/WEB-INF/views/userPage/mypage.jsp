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
    <div class="userPic">

    </div>
    ${nickname}님, 환영합니다!<br>
    <input type="button" value="회원정보 수정"><br>
    <input type="button" value="로그아웃"><br>
    <input type="button" value="회원탈퇴"><br>

    <div class="writeNumber">
        내가 쓴 리뷰: N개       내가 저장한 맛집: K개
    </div>

    <ul class="mypageTab">
        <li>나의 리뷰</li>
        <li>나의 맛집</li>
    </ul>

    <iframe src="storeCollection.html"></iframe>
    <iframe src="reviewList.html"></iframe>

    <div class="modalContainer">
        <div class="logoutModal">

        </div>
    </div>

    <div class="modalContainer">
        <div class="userOutModal">

        </div>
    </div>
</body>
</html>