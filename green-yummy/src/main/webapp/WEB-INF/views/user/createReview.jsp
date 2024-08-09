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
    <script src="/user/js/reviewRate.js"></script>
</head>
<body>

<jsp:include page="../public/header.jsp"/>

    <main>
       
        
        <div class="reviewContainer">

       
       
        	 <form id="createReview" method="post">
        	 	
        	 	<p>${user.id}님! ${shop.shopName}(${shop.location })에 대한 소감을 남겨주세요!</p>
        	 
        	 
        	 
		        <input type="hidden" name="shopUkId" value="${shop.shopUkId}">

		        <input type="hidden" name="userUkId" value="${user.userUkId}">
		       

	        <fieldset class="rateSelect">
	            <legend>평점</legend>
	            
	            <img src="/images/onestar.png">
	            <img src="/images/twostar.png">
	            <img src="/images/threestar.png">	
	            <img src="/images/fourstar.png">
	            <img src="/images/fivestar.png">
	            
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
	
	        <textarea rows="15" name="reviewContent" required placeholder="Enter detailed content" class="reviewContent"></textarea>
	       
	       <div class="reviewBtn">
	       		<div class="storePhoto">
	       		<label for="file"><img src="/images/addPhoto.png" id="addPhoto"></label>
	       		<input type="file" name="reviewImg" id="file" onchange="addReviewPhoto()"></div>

                
            </div>
            <input type="submit" value="리뷰 작성하기">
	    </form>
            
            
        </div>
    </main>
    
    <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>