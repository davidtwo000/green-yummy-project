<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>서비스 인트로</title>

<link rel="stylesheet" type="text/css" href="/public/css/serviceIntro.css">

</head>

<body>

<jsp:include page="../public/header.jsp"/>


<main class="serviceMain">

	<div class="MainContainer">
	<h1>야미 1000% 활용 방법</h1>
			
		<div class="threeWays">
			<div class="introBox">
				<div class="imgPlace">
				<img src="/images/intro_search.png"></div>
				<div class="introText">
					<p>맛집 검색</p>
					<hr>
					가게 위치가 어디인지 알고 싶을 때,<br>
					놀러간 곳에서 유명한 맛집이 어디인지 알고 싶을 때,<br>
					갑자기 한식이 끌리는 날,<br>
					여러 이름, 지역, 업종 등 다양한 방법으로 검색해보세요! 
					<div class="letgo">
					<a href="/public/dataSearch">검색하러 가기
					<img src="/images/letsgo.png"></a>
					</div>
				</div>
			</div>
			<div class="introBox">
				<div class="imgPlace">
				<img src="/images/intro_review.png"></div>
				<div class="introText">
					<p>리뷰 작성</p>
					<hr>
					좋았던 부분이 있다면 칭찬을,<br>
					부족한 부분이 있다면 피드백을 해주세요.<br>
					별점과 리뷰는 사장님에게 위로가 되기도 하고<br>
					자신을 돌아볼 기회가 되기도 합니다!
					
					<div class="letgo">
					<a href="/user/userPage">리뷰쓰러 가기
					<img src="/images/letsgo.png">
					</a>
					</div>
					
				</div>
			</div>
			<div class="introBox">
				<div class="imgPlace">
				<img src="/images/intro_bookmark.png"></div>
				<div class="introText">
					<p>맛집 저장</p>
					<hr>
					회원이 되어서 나만의 계정에 나만의 맛집을 저장해보세요.<br>
					마음에 드는 가게의 정보를 더 쉽고 빠르게 볼 수 있습니다.
					
					
					
					<div class="letgoMark">
					<a href="/user/userPage">나의 북마크 보기
					<img src="/images/letsgo.png">
					</a>
					</div>
					
				</div>
			</div>
		</div>
		
	</div>

</main>

<jsp:include page="../public/footer.jsp"/>

</body>
</html>