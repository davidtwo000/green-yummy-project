<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>공지사항 작성</h1>
    
    <!-- 폼 시작 -->
    <form action="/newNotification" method="post">
        <input type="hidden" name="id" value="${notice.noticeId}"/>

        <label for="author">작성자:</label>
        <input type="text" id="author" name="author" value="${notice.author}" required/><br/>

        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${notice.title}" required/><br/>

        <label for="content">내용:</label>
        <textarea id="content" name="content" required>${notice.content}</textarea><br/>

        <label for="postDate">게시 날짜:</label>
        <input type="date" id="postDate" name="postDate" value="${notice.postDate}" required/><br/>

        <label for="viewCount">조회수:</label>
        <input type="number" id="viewCount" name="viewCount" value="${notice.viewCount}"/><br/>

        <input type="submit" value="저장"/>
    </form>

    <a href="/public/notification">목록으로 돌아가기</a>
    
</body>
</html>