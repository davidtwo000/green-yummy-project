<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataSearch</title>

<link rel="stylesheet" href="/public/css/dataSearch.css">

</head>
<body>

<jsp:include page="../public/header.jsp"/>
	<div class="outContainer">
        <div class="innerContainer">
            
            <div class="searchBar">
                <select class="selectBox">
                    <option value="" disabled selected>선택없음</option>
                    <option value="area">지역별</option>
                    <option value="category">업종별</option>
                    <option value="menu">메뉴별</option>
                    <option value="rating">평점별</option>
                </select>

                <input type="text" placeholder="검색어를 입력하세요" class="searchText">
            </div>
            
            <div class="map"> 지도 </div>

            <div class="sortOptions">
                <label>
                    <input type="radio" name="sort" value="ratingAsc"> 평점 낮은 순
                </label>
                <label>
                    <input type="radio" name="sort" value="ratingDesc"> 평점 높은 순
                </label>
                <label>
                    <input type="radio" name="sort" value="alphabetical"> 리뷰 많은 순
                </label>
                <label>
                    <input type="radio" name="sort" value="proximity"> 위치에 가까운 순
                </label>
                
            </div>
            
            <div class="shop-list">
			    <c:forEach items="${shops}" var="shop" varStatus="status">
			        <div class="shop-item" onclick="window.location.href='/public/dataSearchDetail/${shop.shopUkId}'" >
				        <div class="shop-profile">
				              <img src="/images/${shop.shopProfile}" alt="${shop.shopName} 프로필 이미지" />
				        </div>
				        <table class="shopdetail">
				   
				        	<tr> 
				        		<td class="shop-name">${shop.shopName} </td><td>${shop.shopType} </td>
					        </tr>
					        <tr> 
					        	<td >평점</td><td>★★★★★</td>
					        </tr>
					        <tr> 
					        	<td >주소</td><td>${shop.location}</td>
					        </tr>
					        <tr> 
					        	<td >전화번호</td><td>${shop.shopTel}</td>
					        </tr>
					        
				        </table>
			        
			        </div>
			    </c:forEach>
			</div>
            
    
<jsp:include page="../public/footer.jsp"/>  
</body>
</html>