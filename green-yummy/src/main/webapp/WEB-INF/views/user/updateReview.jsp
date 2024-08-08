<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/user/css/updateReview.css" rel="stylesheet" type="text/css">
   	<script src="/user/js/updateReview.js"></script>
</head>
<body>

<jsp:include page="../public/header.jsp"/>

    <main>
       
        
        <div class="reviewContainer">
        	 <form id="updateReviewForm">
			    <input type="hidden" name="reviewId" value="">
			    <input type="hidden" name="shopUkId" value="${shop.shopUkId}">
		        <input type="hidden" name="userUkId" value="${user.userUkId}">
			
			    <fieldset class="rateSelect">
			        <legend>평점</legend>
			        <label><input type="radio" name="reviewRating" value="1" required> 1</label>
			        <label><input type="radio" name="reviewRating" value="2"> 2</label>
			        <label><input type="radio" name="reviewRating" value="3"> 3</label>
			        <label><input type="radio" name="reviewRating" value="4"> 4</label>
			        <label><input type="radio" name="reviewRating" value="5"> 5</label>
			    </fieldset>
			
			    <fieldset class="keywordSelect">
		            <legend>Keywords</legend>
		            <label><input type="checkbox" name="keywords" value="food"> 음식이 맛있어요</label>
		            <label><input type="checkbox" name="keywords" value="waiter"> 직원이 친절해요</label>
		            <label><input type="checkbox" name="keywords" value="comfort"> 분위기가 좋아요</label>
		            <label><input type="checkbox" name="keywords" value="clean"> 가게 위생이 청결해요</label>
		            <label><input type="checkbox" name="keywords" value="price"> 가격이 저렴해요</label>
		            <label><input type="checkbox" name="keywords" value="much"> 양이 많아요</label>
		            <label><input type="checkbox" name="keywords" value="quality"> 음식의 품질이 좋아요</label>
		            <label><input type="checkbox" name="keywords" value="view"> 뷰가 좋아요</label>
		        </fieldset>
			
			    <input type="text" id="reviewContent" name="reviewContent" required placeholder="Enter detailed content" class="reviewContent">
			   	<div class="storePhoto"><input type="file" name="reviewImg"></div>  
			    <input type="submit" value="리뷰 수정하기">
			</form>
        	 
            
        </div>
    </main>
    
    <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>