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
    
                <c:choose>
		            <c:when test="${empty notices}">
		                <tr>
		                    <td colspan="5">공지사항이 없습니다.</td>
		                </tr>
		            </c:when>
		            <c:otherwise>
		                <c:forEach items="${notices}" var="notice">
		                    <tr onclick="window.location.href='/public/notificationDetail/${notice.noticeId}'">
		                        <td>${notice.noticeId}</td>
		                        <td>${notice.author}</td>
		                        <td>${notice.title}</td>
		                        <td>${notice.postDate}</td>
		                        <td>${notice.viewCount}</td>
		                    </tr>
		                </c:forEach>
		            </c:otherwise>
		        </c:choose>
               
            </table>
        </div>
        
        
        
    </main>
    
    <jsp:include page="footer.jsp"/>
    
</body>
</html>