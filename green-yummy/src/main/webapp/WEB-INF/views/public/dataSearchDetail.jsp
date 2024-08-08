<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>dataSearchDetail</title>
    <link rel="stylesheet" href="/public/css/dataSearchDetail.css">
    <script src="/public/js/dataSearchDetail.js" defer></script>
</head>
<body>

<jsp:include page="../public/header.jsp"/>



<div class="outContainer">	

		<input type="hidden" id="userUkId" name="userUkId" value="${user.userUkId}">
		<input type="hidden" id="shopUkId" name="shopUkId" value="${shop.shopUkId}">
 		
 		
	
    <div class="innerContainer">
    	
    	
    
    
        <div class="restaurantTitle"> 
            <div class="name">${shop.shopName}</div>
            <div class="typeNrate">
	            <div class="type">${shop.shopType}</div>
	            <div class="rating">
		            <div class="rateset">
			             평점 <div class="averageRating" id="averageRating"> 
			            </div>
		            </div>
	            </div>
        	</div>
        	
        </div>
        
        <div class="bookmarkBtn">
        	
			    <input type="button" onclick="addBookmark()" value="북마크 저장">
			    <input type="button" onclick="removeBookmark()" value="북마크 해제">

			<div class="backBtn">
		    <input type="button" id="backButton" value="목록으로" />
		</div>
        </div>
        
        <hr>
        
        <div class="restaurantImgContainer">
            <div class="restaurantImg"> 
                <img src="/images/${shop.shopProfile}" alt="${shop.shopName} 프로필 이미지" />
            </div>
            <div class="restaurantImg"> </div>
            <div class="restaurantImg"> </div>
        </div>
        
        <hr>
        <h3>가게 정보</h3>
        <hr>
       

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
            
            <div class="map" id="map">
            지도
            </div>
            <script type="text/javascript" 
			    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349c2cb0976e7672467f9c85e9839ed5"></script>
			    <script>
					var container = document.getElementById('map');
					var options = {
						center: new kakao.maps.LatLng(33.450701, 126.570667),
						level: 3
					};
			
					var map = new kakao.maps.Map(container, options);
			</script>
        </div>

        <div class="review">
        	<hr>
            <div class="reviewTag"> <h3>리뷰</h3> </div>
            <hr>
            
		        <input type="button" value="리뷰쓰기" class="reviewBtn" onclick="createReview(${shop.shopUkId})">
            <div class="reviewsContainer" id="reviewsContainer"></div>
            
            <!-- 자세히 보기 창 -->
            <div id="modal" class="modal">
		        <div class="modal-content">
		            <span id="closeBtn" class="close-btn">&times;</span>
		            <div id="modalBody">
		                <!-- Dynamic content will be inserted here -->
		            </div>
		        </div>
		    </div>
            
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