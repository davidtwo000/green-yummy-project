<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>맛집 신청</title>

<link rel="stylesheet" type="text/css" href="/user/css/shopApply.css">

</head>

<body>

<jsp:include page="../public/header.jsp"/>

<main>
	<div class="mainContainer">
		
		<form id="shopApply" method="post" action="/applyShop" onsubmit="return applyCheck()">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="userUkId" value="${user.userUkId}">
		
		<table>
		<tr>
			<th>맛집 이름</th>
			<td><input type="text" id="shopName" name="shopName"></td>
		</tr>
		<tr>
			<th>음식 유형</th>			
			<td>
				<input type="radio" name="foodType" value="중식">중식
				<input type="radio" name="foodType" value="양식">양식
				<input type="radio" name="foodType" value="일식">일식
				<input type="radio" name="foodType" value="한식">한식
			</td>
		</tr>
		<tr>
			<th>맛집 주소</th>
			<td><input type="text" id="shopLocation" class="shopLocation" name="shopLocation"></td>
		</tr>
		<tr>
			<th>맛집 연락처</th>
			<td><input type="text" id="shopPhone" name="shopPhone"></td>
		</tr>
		<tr>
			<th>신청 이유</th>
			<td><textarea id="shopReason" name="shopReason" placeholder="신청 이유를 간략하게 적어주세요" rows="6" cols="100" style="resize: none; font-size: 14px;"></textarea></td>
		</tr>
		</table>

		<div class="shopApplyBtns">
			<input type="submit" value="제출">
			<input type="reset">
		</div>
			
		</form>
		
	</div>

</main>

<jsp:include page="../public/footer.jsp"/>

<script src="/user/js/shopApply.js"></script>

</body>
</html>