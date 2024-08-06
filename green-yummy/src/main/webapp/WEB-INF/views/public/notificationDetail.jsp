<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공지사항 상세</title>

<script src="/public/js/notificationDetail.js"></script>

</head>
<body>

<jsp:include page="../public/header.jsp"/>

	
	<table>
		<tr>
			<th>제목</th>
			<td>${notice.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${notice.author}</td>
		</tr>
		<tr>
			<th>게시날짜</th>
			<td>${notice.postDate}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${notice.viewCount}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${notice.content}</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="목록으로 돌아가기" onclick="goNotificationList()"></td>
		</tr>
	</table>
   
    
   <jsp:include page="../public/footer.jsp"/>

</body>
</html>