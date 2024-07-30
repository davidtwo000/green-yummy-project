<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="/updateNotification" method="post">
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" value="${notice.author}" required /><br/>

    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${notice.title}" required /><br/>

    <label for="viewCount">View Count:</label>
    <input type="number" id="viewCount" name="viewCount" value="${notice.viewCount}" required /><br/>

    <input type="hidden" name="id" value="${notice.noticeId}" />
    <input type="submit" value="Save" />
</form>
    
</body>
</html>