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
        
     
    <script>
    function goFirst(){
    	window.location.href = "/public/notification?page=" + (1) + 
						        "&searchType=" + encodeURIComponent("${param.searchType}") + 
						        "&searchKeyword=" + encodeURIComponent("${param.searchKeyword}");
    }
    
    function goLast(){
    	window.location.href = "/public/notification?page=" + (${totalPages}) + 
						        "&searchType=" + encodeURIComponent("${param.searchType}") + 
						        "&searchKeyword=" + encodeURIComponent("${param.searchKeyword}");
    }
    
    function goPrevious() {
        window.location.href = "/public/notification?page=" + (${currentPage} - 1) + 
                                "&searchType=" + encodeURIComponent("${param.searchType}") + 
                                "&searchKeyword=" + encodeURIComponent("${param.searchKeyword}");
    }
    
    function goNext() {
        window.location.href = "/public/notification?page=" + (${currentPage} + 1) + 
                                "&searchType=" + encodeURIComponent("${param.searchType}") + 
                                "&searchKeyword=" + encodeURIComponent("${param.searchKeyword}");
    }
    
    function goNumPage(page) {
        window.location.href = "/public/notification?page=" + page + 
                                "&searchType=" + encodeURIComponent("${param.searchType}") + 
                                "&searchKeyword=" + encodeURIComponent("${param.searchKeyword}");
    }
    //분리 복잡해져서 그냥 놔뒀어요
	</script>
	
</head>
<body>

<jsp:include page="header.jsp"/>

<main>
    <div class="notiContainer">
        <div class="SearchBar">
           	<form method="get" action="/public/notification">
           	<table class="SearchTab">
           	<tr>
           		<th class="SearchTot">
           			총 페이지 : ${totalPages}
           		</th>
           		<th class="SearchTyp">
           			<select name="searchType">
	                    <option value="titleContent" <c:if test="${param.searchType == 'titleContent'}">selected</c:if>>제목과 본문</option>
	                    <option value="title" <c:if test="${param.searchType == 'title'}">selected</c:if>>제목</option>
	                    <option value="content" <c:if test="${param.searchType == 'content'}">selected</c:if>>본문</option>
	                </select>
	                <input type="text" placeholder="검색어를 입력하세요" name="searchKeyword" value="${param.searchKeyword}">
	                <input type="submit" value="검색">
           		</th>
           	</tr>           	
           	</table>
            </form>
        </div>
    
<!--         <div class="notifyTitle">공지사항</div> -->
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
                        <td colspan="5" style="cursor: default">공지사항이 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${notices}" var="notice">
                        <tr onclick="window.location.href='/public/notificationDetail/${notice.noticeId}'">
                            <td>${notice.noticeId}</td>
                            <td>${notice.author}</td>
                            <td style="cursor: pointer">${notice.title}</td>
                            <td>${notice.postDate}</td>
                            <td>${notice.viewCount}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>

        <div class="pagination">
        	<c:if test="${currentPage > 1 && totalPages > 5}">
		        <input type="button" onclick="goFirst()" value="<<">
		    </c:if>
		    <c:if test="${currentPage > 1}">
		        <input type="button" onclick="goPrevious()" value="<">
		    </c:if>
		    
		    <c:forEach begin="${startPage}" end="${endPage}" var="i">
		        <c:if test="${i == currentPage}">
		            <input type="button" value="${i}" class="disButt" disabled>
		        </c:if>
		        <c:if test="${i != currentPage}">
		            <input type="button" value="${i}" onclick="goNumPage(${i})">
		        </c:if>
		    </c:forEach>
		    
		    <c:if test="${currentPage < totalPages}">
		        <input type="button" onclick="goNext()" value=">">
		    </c:if>
		    <c:if test="${currentPage < totalPages && totalPages > 5}">
		        <input type="button" onclick="goLast()" value=">>">
		    </c:if>
		</div>
    </div>
</main>

<jsp:include page="footer.jsp"/>
    
</body>
</html>