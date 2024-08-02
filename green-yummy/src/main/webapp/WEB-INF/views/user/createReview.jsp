<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/user/css/createReview.css" rel="stylesheet" type="text/css">
    
    <script src="/user/js/createReview.js"></script>
</head>
<body>

<jsp:include page="../public/header.jsp"/>

    <main>
       
        
        <div class="reviewContainer">
        	 <form id="createReview" method="post">
		        <input type="hidden" name="shopUkId" value="${shop.shopUkId}">
		        
		        <!-- 임시 유저 아이디 -->
		        <input type="hidden" name="userUkId" value="1">
	        
	        <fieldset class="rateSelect">
	            <legend>평점</legend>
	            <label><input type="radio" name="reviewRate" value="1" required> 1</label>
	            <label><input type="radio" name="reviewRate" value="2"> 2</label>
	            <label><input type="radio" name="reviewRate" value="3"> 3</label>
	            <label><input type="radio" name="reviewRate" value="4"> 4</label>
	            <label><input type="radio" name="reviewRate" value="5"> 5</label>
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
	
	        <input type="text" name="reviewContent" required placeholder="Enter detailed content" class="reviewContent">
	       <div class="reviewBtn">
                <input type="submit" value="리뷰 작성하기">
            </div>
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