<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="../public/header.jsp"/>

	<h1>공지사항 상세</h1>
    <p><strong>제목:</strong> ${notice.title}</p>
    <p><strong>작성자:</strong> ${notice.author}</p>
    <p><strong>게시 날짜:</strong> ${notice.postDate}</p>
    <p><strong>조회수:</strong> ${notice.viewCount}</p>
    <p><strong>내용:</strong></p>
    <p>${notice.content}</p>
    <a href="/notification">목록으로 돌아가기</a>
    
   <jsp:include page="../public/footer.jsp"/>

</body>
</html>