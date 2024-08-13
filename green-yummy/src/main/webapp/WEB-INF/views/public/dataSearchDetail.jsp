<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataSearchDetail</title>
<link rel="stylesheet" href="/public/css/dataSearchDetail.css">
<link rel="stylesheet" href="/public/css/dataSearchDetail2.css">
<script src="/public/js/dataSearchDetail.js" defer></script>
<script src="/public/js/bookmark.js" defer></script>
</head>
<body>

	<jsp:include page="../public/header.jsp" />



	<div class="outContainer">

		<input type="hidden" id="userUkId" name="userUkId"
			value="${user.userUkId}"> <input type="hidden" id="shopUkId"
			name="shopUkId" value="${shop.shopUkId}">






		<div class="innerContainer">




			<div class="restaurantTitle">
				<div class="name">${shop.shopName}</div>
				<div class="typeNrate">

					<div class="rating">
						<div class="rateset">
							평점&nbsp;
							<div class="averageRating" id="averageRating"></div>
						</div>
						<div class="type">${shop.shopType}</div>
					</div>
				</div>

			</div>

			<div class="backBtn">
				<!-- 					<input type="button" id="backButton" value="목록으로" /> -->
				<img src="/images/letsback.png" id="backButton" title="검색창으로 돌아가기">
			</div>

			<div class="bookmarkBtn">

				<!-- 북마크 체크박스 -->
				<input type="checkbox" id="bookmarkCheck" onclick="bookmark()"><label for="bookmarkCheck"></label>
<!-- 				<img src="/images/bookmark.png" class="bookmarkIcon" -->
<!-- 					id="bookmarkCheck" onclick="bookmark()" title="북마크"> -->

				<!-- 북마크 해제 모달 -->
				<div class="bookmarkRemoveModal" id="bookmarkRemoveModal">
					<div class="messagePlace">
						<div class="xplace">
							<img src="/images/closeBtn.png" onclick="bookmarkCancel()">
						</div>
						북마크를 해제하겠습니까?
						<div class="bookmarkBtns">
							<input type="button" id="bookmarkRemoveBtn" value="제거"
								onclick="bookmarkRemove()"> <input type="button"
								id="cancelBtn" value="취소" onclick="bookmarkCancel()">
						</div>
					</div>
				</div>



			</div>

			<hr>




			<h3>가게 정보</h3>
			<hr>


			<div class="detail">
				<div class="imgAndTable">

					<div class="shopImg">
						<img src="/images/${shop.shopProfile}"
							alt="${shop.shopName} 프로필 이미지" />
					</div>


					<div class="tableNinfo">
						<table class="detailtable">
							<tr>
								<td>주소</td>
								<td>${shop.location}</td>
							</tr>
							<tr>
								<td>OPEN</td>
								<td>${shop.openHours}</td>
							</tr>
							<tr>
								<td>CLOSE</td>
								<td>${shop.closeHours}</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td>${shop.shopTel}</td>
							</tr>
							<tr>
								<td>기타사항</td>
								<td>${shop.etc}</td>
							</tr>
						</table>


					</div>



				</div>





				<div class="map" id="map">지도</div>
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349c2cb0976e7672467f9c85e9839ed5"></script>
				<script>
			    document.addEventListener('DOMContentLoaded', function() {
	                  var container = document.getElementById('map');
	                  var options = {
	                      center: new kakao.maps.LatLng(
	                          parseFloat('${shop.latitude}'),
	                          parseFloat('${shop.longitude}')
	                      ),
	                      level: 3
	                  };

	                  var map = new kakao.maps.Map(container, options);
	                  var markerPosition  = new kakao.maps.LatLng('${shop.latitude}','${shop.longitude}');
	                  
	                  var marker = new kakao.maps.Marker({
	                      position: markerPosition
	                  });

	                  marker.setMap(map);
	              });
	               var map = new kakao.maps.Map(container, options); 
			</script>
			</div>

			<div class="review">
				<hr>
				<div class="reviewTag">
					<h3>리뷰</h3>
				</div>
				<hr>

				<div class="reviewBtn" title="리뷰 작성하기"
					onclick="createReview(${shop.shopUkId})">
					<img src="/images/reviewWrite.png">
				</div>

				<div class="reviewsContainer" id="reviewsContainer"></div>


				<!-- 자세히 보기 창 -->
				<div id="modal" class="modal">
					<div class="modal-content">
						<img src="/images/closeBtn.png" id="closeBtn" class="close-btn">
						<!-- 						<span id="closeBtn" class="close-btn">&times;</span> -->
						<div id="modalBody" class="modalBody">
							<!-- Dynamic content will be inserted here -->
						</div>
					</div>
				</div>
			</div>

			<hr>
			<div class="reviewTag">
				<h3>이런 가게는 어때요?</h3>
			</div>
			<hr>

			<div class="random" id="random">
				<div class="randomRestaurant"></div>
				<div class="randomRestaurant"></div>
				<div class="randomRestaurant"></div>
				<div class="randomRestaurant"></div>
				<div class="randomRestaurant"></div>
			</div>
		</div>
	</div>

	<jsp:include page="../public/footer.jsp" />
</body>
</html>