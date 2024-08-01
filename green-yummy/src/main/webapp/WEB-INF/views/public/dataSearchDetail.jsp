<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataSearchDetail</title>
<link rel="stylesheet" href="/public/css/dataSearchDetail.css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>

<form>
    <input type="hidden" id="">
</form>

<div class="outContainer">
    <div class="innerContainer">
        <div class="restaurantTitle"> 
            <div class="name">${shop.shopName}</div>
            <div class="type">${shop.shopType} </div>
        </div>
        
        <div class="restaurantImgContainer">
            <div class="restaurantImg"> 
            	<img src="/images/${shop.shopProfile}" alt="${shop.shopName} 프로필 이미지" />
            </div>
            <div class="restaurantImg"> </div>
            <div class="restaurantImg"> </div>
        </div>
        
        <div class="rating"> 별점 ★★★★★ </div>

        <div class="detail">
            <table class="detailtable">
                <tr>
                    <td> 주소 </td> <td> ${shop.location} </td>
                </tr>
                <tr>
                    <td> OPEN </td> <td> ${shop.openHours}</td>
                </tr>
                <tr>
                    <td> CLOSE </td> <td>${shop.closeHours} </td>
                </tr>
                <tr>
                    <td> 전화번호 </td> <td>${shop.shopTel} </td>
                </tr>
                <tr>
                    <td> 기타사항 </td> <td> ${shop.etc}</td>
                </tr>
            </table>
            
            <div class="map">
            지도
            </div>
        </div>

        <div class="review">
            <div class="reviewTag"> 리뷰 </div>
            <input type="button" value="리뷰쓰기" class="reviewBtn">
            
            <ul>
                <c:forEach var="review" items="${reviews}">
                    <li>
   
                        Rate: ${review.reviewRate}, 
                        Comment: ${review.reviewComment}
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="random">
        
        	
            <div class="randomRestaurant"> </div>
            <div class="randomRestaurant"> </div>
            <div class="randomRestaurant"> </div>
            <div class="randomRestaurant"> </div>
            <div class="randomRestaurant"> </div>
        </div>
    </div>
</div>

<jsp:include page="../public/footer.jsp"/>   
</body>
</html>