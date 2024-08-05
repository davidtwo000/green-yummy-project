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

    <script src="/user/js/reviewList.js"></script>
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
             
                <c:forEach items="${reviews}" var="review" varStatus="status">
				    <tr>
				        <td>${status.index + 1}</td>
				        <td>${review.shop.shopName}</td>
				        <td>${review.reviewContent}</td>
				        <td>${review.reviewRate}</td>
				        <td id="reviewDate">${review.reviewDate}</td>
				        <td><input type="button" value="수정" onclick="updateReview(${review.reviewId})"></td>
				        <td><input type="button" value="삭제" onclick="showDeleteModal(${review.reviewId})" /></td>
				    </tr>
				</c:forEach>
            </table>
        
            <div class="modalContainer hidden" id="deleteModalContainer">
                <div class="deleteModal">
                    <div class="xplace"></div>
                    삭제하시겠습니까?
                    <input type="button" value="삭제" onclick="confirmDelete()" />
        			<input type="button" value="취소" onclick="hideDeleteModal()" />
                </div>
            </div>
        </div>
    </main>

   <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>