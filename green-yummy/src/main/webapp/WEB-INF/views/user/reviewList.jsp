<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/user/css/reviewList.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>
    
    <main>
        <div class="innerContainer">
        	
            <table>
                <tr>
                    <td>번호</td>
                    <td>가게명</td>
                    <td>제목</td>
                    <td>평점</td>
                    <td>게시일</td>
                    <td>수정</td>
                    <td>삭제</td>
                </tr>
        
                <tr>
                    <td colspan="7">작성한 리뷰가 없습니다.</td>
                    
                </tr>
        
               <!--  아래는 예시로 만든 것들. jsp foreach와 백엔드로 구현해야 함 -->
        
                <tr>
                    <td>1</td>
                    <td>투썸</td>
                    <td>케익이 맛있어요</td>
                    <td>4.0</td>
                    <td>24 / 07 / 30</td>
                    <td><input type="button" value="수정"></td>
                    <td><input type="button" value="삭제"></td>
                </tr>
        
                <tr>
                    <td>1</td>
                    <td>투썸</td>
                    <td>케익이 맛있어요</td>
                    <td>4.0</td>
                    <td>24 / 07 / 30</td>
                    <td><input type="button" value="수정"></td>
                    <td><input type="button" value="삭제"></td>
                </tr>
        
                <tr>
                    <td>1</td>
                    <td>투썸</td>
                    <td>케익이 맛있어요</td>
                    <td>4.0</td>
                    <td>24 / 07 / 30</td>
                    <td><input type="button" value="수정"></td>
                    <td><input type="button" value="삭제"></td>
                </tr>
        
                <tr>
                    <td>1</td>
                    <td>투썸</td>
                    <td>케익이 맛있어요</td>
                    <td>4.0</td>
                    <td>24 / 07 / 30</td>
                    <td><input type="button" value="수정"></td>
                    <td><input type="button" value="삭제"></td>
                </tr>
        
                <tr>
                    <td>1</td>
                    <td>투썸</td>
                    <td>케익이 맛있어요</td>
                    <td>4.0</td>
                    <td>24 / 07 / 30</td>
                    <td><input type="button" value="수정"></td>
                    <td><input type="button" value="삭제"></td>
                </tr>
                <c:forEach items="${reviews}" var="review">
          		<tr>
                   <td>${review.reviewId}</td>
                    <td>${review.userUkId}</td>
                    <td>${review.shopUkId}</td>
                    <td>${review.reviewRate}</td>
                    <td>${review.reviewComment}</td>
                    <td>${review.reviewDate}</td>
                 
                </tr>
            </c:forEach>
            </table>
        
            <div class="modalContainer hidden">
                <div class="deleteModal">
                    <div class="xplace"></div>
                    삭제하시겠습니까?
                    <input type="button" value="삭제">
                    <input type="button" value="취소">
                </div>
            </div>
        </div>
    </main>

   <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>