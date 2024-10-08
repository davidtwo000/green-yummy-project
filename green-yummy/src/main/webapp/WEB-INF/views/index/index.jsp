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

			<select class="selectBox" id="selectBox">
				<option value="name" selected>가게 이름</option>
				<option value="area">지역별</option>
				<option value="type">업종별</option>
			</select> <input type="text" id="findByOption" class="searchBar"
				name="findByOption" placeholder="검색어를 입력하세요" onkeydown="pressEnter(event)">
			<div class="customSearchBtn">
				<img src="/images/search.png" id="seachBtn" onclick="searchBytext()">
			</div>
			<div class="ocricon">
				<img src="/images/colorPhoto.png" title="OCR. 사진으로 검색하기."
					onclick="location.href='/public/pictureOCR'">
			</div>

		</div>
		<!-- 여기 카테고리 클릭부분 건들지 마세요 -->
		<div class="list-container">
			<ul class="search-list" id="search-list">
				<li onclick="search('area')">지역별</li>
				<li onclick="search('type')">업종별</li>
<!-- 				<li onclick="search('rating')">평점별</li> -->
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
					<li onclick="check('type패스트푸드')">패스트푸드</li>
					<li onclick="check('type분식')">분식</li>
					<li onclick="check('type카페')">카페</li>
					<li onclick="check('type기타')">기타</li>
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
							<img src="/images/mainimg1.jpg">
						</div></li>
					<li><div class="mainImg">
						<a href="/public/dataSearch">
						<img src="/images/heySearch.jpg">
						</a>
						</div></li>
					<li><div class="mainImg">
							<a href="/public/dataSearchDetail/23">
							<img src="/images/dookki.jpg">
							</a>
						</div></li>
					<li><div class="mainImg">
							<a href="/user/shopApply">
							<img src="/images/heyApply.jpg"></a>
							
						</div></li>
					<li><div class="mainImg">
							<a href="http://localhost:8085/public/dataSearch?option=area&content=%EC%97%AD%EC%82%BC%EB%8F%99&by=click">
							<img src="images/메인이미지.png">
							</a>
							
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
				<div class="recommandTag"><span>추천 맛집</span>
					<div class="lookMore">
						<a href="/public/dataSearch">
						<img src="/images/lookmore.png"></a>
					</div>
				</div>
				<hr>
				<ul class="recommandList" id="recommandList">

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
	<script src="/index/js/search.js"></script>

	<jsp:include page="../public/footer.jsp" />

</body>
</html>