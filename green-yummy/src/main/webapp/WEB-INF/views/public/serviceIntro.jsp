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
		<div class="introBox">
			<p>야미 1000% 활용 방법</p>
		</div>
		<div class="threeWays">
			<div class="introBox">
				<div class="imgPlace"></div>
				<div class="introText">
					<p>맛집 검색</p>
					<hr>
					음식? 가게 이름? 그 외에도 원하시는 조건으로 검색을 해보세요.
				</div>
			</div>
			<div class="introBox">
				<div class="imgPlace"></div>
				<div class="introText">
					<p>리뷰 작성</p>
					<hr>
					마음에 들었다면 호평, 마음에 들지 않았다면 혹평을 남겨보세요.
				</div>
			</div>
			<div class="introBox">
				<div class="imgPlace"></div>
				<div class="introText">
					<p>맛집 저장</p>
					<hr>
					마음에 드는 맛집을 골라서 나만의 리스트에 저장해보세요.
				</div>
			</div>
		</div>
		
	</div>

</main>

<jsp:include page="../public/footer.jsp"/>

</body>
</html>