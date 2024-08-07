<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 쓰기</title>
    <link href="/user/css/createReview.css" rel="stylesheet" type="text/css">
    
    <script src="/user/js/createReview.js"></script>
</head>
<body>

<jsp:include page="../public/header.jsp"/>

    <main>
       
        
        <div class="reviewContainer">
<%--         	<div> 유저 아이디 ${user.id}</div> --%>
        	
<!--         	<div class="visitShop"> -->
<%--         	 	<img src="/images/${shop.shopProfile}"> --%>
<!--         	 	<div class="visitShopInfo"> -->
<%--         	 	<span>${shop.shopName}</span> --%>
<%--         	 	<p>${shop.shopType}</p> --%>
<%--         	 	<p>${shop.location }</p> --%>
<!--         	 	</div> -->
        	 	
<%--         	 	<p>${user.id}님! ${shop.shopName}(${shop.location })에 대한 소감을 남겨주세요!</p> --%>
        	 	
<!--         	 	</div> -->
        	 	
        	 	
        
        	 <form id="createReview" method="post">
        	 	
        	 	<p>${user.id}님! ${shop.shopName}(${shop.location })에 대한 소감을 남겨주세요!</p>
        	 
        	 
        	 
		        <input type="hidden" name="shopUkId" value="${shop.shopUkId}">
		        
		        <!-- 임시 유저 아이디 -->
		        <input type="hidden" name="userUkId" value="1">
	        <fieldset class="rateSelect">
	            <legend>평점</legend>
	            
	            
	            <div class="radioBtns">
		            <label><input type="radio" name="reviewRating" value="1" required> 1</label>
		            <label><input type="radio" name="reviewRating" value="2"> 2</label>
		            <label><input type="radio" name="reviewRating" value="3" checked> 3</label>
		            <label><input type="radio" name="reviewRating" value="4"> 4</label>
		            <label><input type="radio" name="reviewRating" value="5"> 5</label>
	            </div>
	            
	        </fieldset>
	        
	        <fieldset class="keywordSelect">
	            <legend>Keywords</legend>
	            <div class="checkDiv1">
		            <label><input type="checkbox" name="keywords" value="food"> 음식이 맛있어요</label>
		            <label><input type="checkbox" name="keywords" value="waiter"> 직원이 친절해요</label>
		            <label><input type="checkbox" name="keywords" value="comfort"> 분위기가 좋아요</label>
		            <label><input type="checkbox" name="keywords" value="clean"> 가게 위생이 청결해요</label>
	            </div>
	            <div class="checkDiv2">
		            <label><input type="checkbox" name="keywords" value="price"> 가격이 저렴해요</label>
		            <label><input type="checkbox" name="keywords" value="much"> 양이 많아요</label>
		            <label><input type="checkbox" name="keywords" value="quality"> 음식의 품질이 좋아요</label>
		            <label><input type="checkbox" name="keywords" value="view"> 뷰가 좋아요</label>
	            </div>
	        </fieldset>
	
<!-- 	        <input type="text" name="reviewContent" required placeholder="Enter detailed content" class="reviewContent"> -->
	        <textarea rows="15" name="reviewContent" required placeholder="Enter detailed content" class="reviewContent"></textarea>
	       
	       <div class="reviewBtn">
	       		<div class="storePhoto">
	       		<label for="photo"><img src="/images/addPhoto.png"></label>
	       		<input type="file" name="reviewImg" id="photo"></div>
	       
                
            </div>
            <input type="submit" value="리뷰 작성하기">
	    </form>
            <!-- <div class="reviewPhotos">
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
            </div>
            <!-- 사진 최대 게시 한도를 정해두면 어떨까 -->
            
        </div>
    </main>
    
    <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>