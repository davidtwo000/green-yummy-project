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
		
		<form>
			<div>
				<table>
					<tr>
						<th>식당 이름</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>식당 프로필 사진</th>
						<td></td>
					</tr>
					<tr>
						<th>식당 타입</th>
						<td><input type="radio" name="foodType" value="중식">중식<input type="radio" name="foodType" value="양식">양식<input type="radio" name="foodType" value="일식">일식<input type="radio" name="foodType" value="한식">한식</td>
					</tr>
					<tr>
						<th>식당 위치</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>식당 전화번호</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>식당 오픈 시간</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>식당 닫는 시간</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>식당 휴무일</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>기타 사항</th>
						<td><input type="text"></td>
					</tr>
				</table>
			</div>
			
			<div class="shopApplyBtns">
				<input type="submit" value="제출">
				<input type="reset">
			</div>
		</form>
	</div>

</main>

<jsp:include page="../public/footer.jsp"/>

</body>
</html>