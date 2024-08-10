<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataSearch</title>

<link rel="stylesheet" href="/public/css/dataSearch.css">
<script src="/public/js/dataSearch.js" defer></script>
<script src="/index/js/indexMenubar.js"></script>

</head>
<body>

	<jsp:include page="../public/header.jsp" />
	<div class="outContainer">

		<div class="innerContainer">
			<!-- 		<div class="box"> -->

			<!-- 			</div> -->

			<div class="searchContainer">

				<select class="selectBox" id="selectBox">
	               <option value="name" selected>가게 이름</option>
	               <option value="area">지역별</option>
	               <option value="type">업종별</option>
	            </select> <input type="text" id="findByOption" class="searchBar"
	               name="findByOption" placeholder="검색어를 입력하세요">
	            <div class="customSearchBtn">
	               <img src="/images/search.png" id="seachBtn" onclick="findShop()">
	            </div>
	            <div class="ocricon">
	               <img src="/images/picture.png" title="OCR. 사진으로 검색하기."
	                  onclick="location.href='/public/pictureOCR'">
	            </div>

			</div>

			<div class="list-container">
				<ul class="search-list" id="search-list">
					<li onclick="search('area')">지역별</li>
					<li onclick="search('type')">업종별</li>
					<li onclick="search('rating')">평점별</li>
				</ul>

				<div class="list-show">
					<ul class="searchByArea" id="searchByArea">
						<li onclick="check('all')">전체</li>
						<li onclick="check('area논현동')">논현동</li>
						<li onclick="check('area대치동')">대치동</li>
						<li onclick="check('area삼성동')">삼성동</li>
						<li onclick="check('area신사동')">신사동</li>
						<li onclick="check('area역삼동')">역삼동</li>
						<li onclick="check('area청담동')">청담동</li>
					</ul>

					<ul class="searchByType" id="searchByType">
	                  <li onclick="check('all')">전체</li>
	                  <li onclick="check('type한식')">한식</li>
	                  <li onclick="check('type양식')">양식</li>
	                  <li onclick="check('type중식')">중식</li>
	                  <li onclick="check('type일식')">일식</li>
	                  <li onclick="check('type햄버거/치킨/피자')">햄버거/치킨/피자</li>
	                  <li onclick="check('type분식')">분식</li>
	                  <li onclick="check('type카페')">카페</li>
	                  <li onclick="check('type기타')">기타</li>
	               </ul>

					<ul class="searchByRating" id="searchByRating">
						<li onclick="check('5')">5점</li>
						<li onclick="check('4')">4점</li>
						<li onclick="check('3')">3점</li>
						<li onclick="check('2')">2점</li>
						<li onclick="check('1')">1점</li>
					</ul>
				</div>


			</div>



			<div class="map" id="map">지도</div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349c2cb0976e7672467f9c85e9839ed5"></script>

			<div class="sortOptions">
				<label> <input type="radio" name="sort" value="ratingAsc">
					평점 낮은 순
				</label> <label> <input type="radio" name="sort" value="ratingDesc">
					평점 높은 순
				</label> <label> <input type="radio" name="sort"
					value="alphabetical"> 리뷰 많은 순
				</label>


			</div>
		</div>
	</div>


	<div id="shop-list"></div>
	<div id="pagination" class="pagination"></div>

	<jsp:include page="../public/footer.jsp" />



</body>
</html>