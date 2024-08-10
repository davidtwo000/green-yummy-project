<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<link rel="stylesheet" type="text/css" href="/index/css/index.css">
<link rel="stylesheet" type="text/css"
	href="/index/css/indexRecommand.css">
</head>
<body>

	<jsp:include page="../public/header.jsp" />

	<div class="outContainer">

		

		<div class="searchContainer">
			<input type="text" placeholder="검색어를 입력하세요" class="searchBar">
			<div class="customSearchBtn">
				<img src="/images/search.png">
			</div>
			<div class="ocricon">
				<img src="/images/picture.png" title="OCR. 사진으로 검색하기."
					onclick="location.href='/public/pictureOCR'">
			</div>

		</div>
		<!-- 여기 카테고리 클릭부분 건들지 마세요 -->
		<div class="list-container">
			<ul class="search-list" id="search-list">
				<li onclick="search('area')">지역별</li>
				<li onclick="search('type')">업종별</li>
				<li onclick="search('rating')">평점별</li>
			</ul>

			<div class="list-show">
				<ul class="searchByArea" id="searchByArea">
					<li onclick="check('all')">전체</li>
					<li onclick="check('논현동')">논현동</li>
					<li onclick="check('대치동')">대치동</li>
					<li onclick="check('삼성동')">삼성동</li>
					<li onclick="check('신사동')">신사동</li>
					<li onclick="check('역삼동')">역삼동</li>
					<li onclick="check('청담동')">청담동</li>
				</ul>

				<ul class="searchByType" id="searchByType">
					<li onclick="check('all')">전체</li>
					<li onclick="check('한식')">한식</li>
					<li onclick="check('양식')">양식</li>
					<li onclick="check('중식')">양식</li>
					<li onclick="check('일식')">양식</li>
					<li onclick="check('햄버거/치킨/피자')">햄버거/치킨/피자</li>
					<li onclick="check('분식')">분식</li>
					<li onclick="check('카페')">카페</li>
					<li onclick="check('기타')">기타</li>
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


		<!-- 여기까지 카테고리 클릭부분 건들지 마세요 -->



		<div class="innerContainer">
			




			<div class="mainPrevBtn">
				<img src="/images/prevBtn2.png">
			</div>
			<div class="eventImgCon">
				<ul class="eventImgList">
					<li><div class="mainImg">
							<img src="images/pasta.jpg"> 이미지 first
						</div></li>
					<li><div class="mainImg">
							<img src="/images/mainimg1.jpg">이미지
						</div></li>
					<li><div class="mainImg">
							<img src="/images/profile2.jpg"> 이미지
						</div></li>
					<li><div class="mainImg">
							<img src="/images/profile3.jpg"> 이미지
						</div></li>
					<li><div class="mainImg">
							<img src="images/steak.jpg"> 이미지 last
						</div></li>
				</ul>
			</div>
			<div class="mainNextBtn">
				<img src="/images/nextBtn2.png">
			</div>




			<div class="recPrevBtn">
	            <img src="/images/prevBtn2.png">
	         </div>
	         <div class="recommandCon">
	            <div class="recommandTag">추천 맛집</div>
	            <hr>
	            <div class="lookMoreRec">자세히 보기</div>
	            <ul class="recommandList" id="recommandList">
	               <li>
	                  <div class="recommandImg"></div>
	                  <div class="recommandDetail">(first)가게 이름 / 평점</div>
	               </li>
	               <li>
	                  <div class="recommandImg"></div>
	                  <div class="recommandDetail">가게 이름 / 평점</div>
	               </li>
	               <li>
	                  <div class="recommandImg"></div>
	                  <div class="recommandDetail">가게 이름 / 평점</div>
	               </li>
	               <li>
	                  <div class="recommandImg"></div>
	                  <div class="recommandDetail">가게 이름 / 평점</div>
	               </li>
	               <li>
	                  <div class="recommandImg"></div>
	                  <div class="recommandDetail">가게 이름 / 평점</div>
	               </li>
	               <li>
	                  <div class="recommandImg"></div>
	                  <div class="recommandDetail">(last)가게 이름 / 평점</div>
	               </li>
	            </ul>
	         </div>
	         <div class="recNextBtn">
	            <img src="/images/nextBtn2.png">
	         </div>








		</div>
	</div>

	<script src="/index/js/indexMainImgs.js"></script>
	<script src="/index/js/indexRecImgs.js"></script>
	<script src="/index/js/indexMenubar.js"></script>

	<jsp:include page="../public/footer.jsp" />

</body>
</html>