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
		
		<form id="shopapply" onsubmit="applyCheck(event)">
		
		<table>
		<tr>
			<th>가게명</th>
			<td><input type="text" id="shopName"></td>
			<td colspan="2"><input type="radio" name="foodType" value="중식">중식
			<input type="radio" name="foodType" value="양식">양식
			<input type="radio" name="foodType" value="일식">일식
			<input type="radio" name="foodType" value="한식">한식</td>
		</tr>
		<tr>
			<th>주소</th>
			<td colspan="3"><input type="text" id="shopLoc" class="shopLocation"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td colspan="3"><input type="text" id="shopTel"></td>
		</tr>
		<tr>
			<th>OPEN</th>
			<td><input type="text" id="shopOpen"></td>
			<th>CLOSE</th>
			<td><input type="text" id="shopClose"></td>
		</tr>
		<tr>
			<th>휴무일</th>
			<td colspan="3"><input type="text" id="shopRest"></td>
		</tr>
		<tr>
			<th>기타사항</th>
			<td colspan="3"><input type="text" 
			placeholder="예약 가능, 테이크아웃 전문, 반려동물 동반 가능 등등"
			id="shopEtc"></td>
		</tr>
		<tr>
			<td colspan="4">
				<p>*사진 추가하기</p>
				<div class="photoPlace">
					<label for="file"><img src="/images/addPhoto.png" id="addPhoto"></label>
					<input type="file" id="file" class="hidden">
				</div>
			</td>
		</tr>
		
		
		
		</table>
<!-- 			<div> -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 						<th>식당 이름</th> -->
<!-- 						<td><input type="text"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>식당 프로필 사진</th> -->
<!-- 						<td></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>식당 타입</th> -->
<!-- 						<td><input type="radio" name="foodType" value="중식">중식<input type="radio" name="foodType" value="양식">양식<input type="radio" name="foodType" value="일식">일식<input type="radio" name="foodType" value="한식">한식</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>식당 위치</th> -->
<!-- 						<td><input type="text"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>식당 전화번호</th> -->
<!-- 						<td><input type="text"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>식당 오픈 시간</th> -->
<!-- 						<td><input type="text"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>식당 닫는 시간</th> -->
<!-- 						<td><input type="text"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>식당 휴무일</th> -->
<!-- 						<td><input type="text"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>기타 사항</th> -->
<!-- 						<td><input type="text" placeholder="예약 가능, 반려동물 동반 가능, 테이크 아웃 전문 등등"></td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<!-- 			</div> -->
			
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