<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link href="/public/css/notification.css" rel="stylesheet" type="text/css">
</head>
<body>

	<jsp:include page="header.jsp"/>
    
    <main>
        <div class="notiContainer">
            <div class="notifyTitle">공지사항</div>
            <table>
                <tr>
                    <td>번호</td>
                    <td>게시자</td>
                    <td>제목</td>
                    <td>게시일</td>
                    <td>조회수</td>
                </tr>
    
                <tr>
                    <td></td>
                    <td></td>
                    <td>공지사항이 없습니다.</td>
                    <td></td>
                    <td></td>
                </tr>
    <!-- 예시로 넣어둔 것. 이 부분은 백엔드와 jsp foreach 사용 -->
    			<c:forEach items ="${notices}" var="notice">
    			<tr onclick="window.location.href='/public/notificationDetail/${notice.noticeId}'">
                    <td>${notice.noticeId}</td>
                    <td>${notice.author}</td>
                    <td>${notice.title}</td>
                    <td>${notice.postDate}</td>
                    <td>${notice.viewCount}</td>
                </tr>
                <tr>
                	<td><a href="/notificationUpdate/${notice.noticeId}">공지 수정 예시</a></td>
                </tr>
    			</c:forEach>
               
            </table>
        </div>
        
        <a href="/public/notification/new">새 공지사항</a>
        
    </main>
    
    <jsp:include page="footer.jsp"/>
    
</body>
</html>