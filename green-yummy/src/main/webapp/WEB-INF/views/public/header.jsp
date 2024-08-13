<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상단 헤더</title>
    <link href = "/public/css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <div class="headcontainer">
			<a href="/"><img src="/images/강남맛집.png"></a>
			
			<div class="btnAndLogin">
				<div class="btnBox">
					<div class="shopApplyBtn" title="가게 등록하기">
						<a href="/user/shopApply">
							<img src="/images/storefront.png">
						</a>
					</div>
					<div class="myPageBtn" title="마이페이지">
						<a href="/user/userPage">
							<img src="/images/mypage.png">
						</a>
					</div>
				</div>
			
				<div class="loginplace">
					<c:choose>
						<c:when test= "${not empty currentUser }">
							<div class="iamUser">
								안녕하세요 <span>${currentUser.id }</span>
								<div class="logoutLogo">
									<form method="post" action="/logout" id="logoutForm">
								        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								        <input type="image" src="/images/logout.png" title="로그아웃">
								    </form>
								</div>
								
							</div>
							
						
						</c:when>
						<c:otherwise>
							<a href="/public/userLogin" class="hereLogin">로그인</a>
						</c:otherwise>
					
					</c:choose>
	                
	            </div>
			
			</div>

			
            
        </div>
        
        
         
        
        
    </header>
    

</body>
</html>