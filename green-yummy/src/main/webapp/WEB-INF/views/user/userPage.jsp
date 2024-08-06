<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link href="/user/css/userPage.css" rel="stylesheet" type="text/css">
    <link href="/user/css/storeCollection.css" rel="stylesheet" type="text/css">
    <link href="/user/css/reviewList.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>

    <main>
        <div class="userContainer">
            <div class="forUser">
                <div class="userPic">
    				<img src="/images/person.png">
                </div>
                
                <div class="helloUser">
	                <p>${users.id}님, 환영합니다!
	                <img src="/images/pencil.png" onclick="infoChange()"></p>
	                <input type="button" value="회원정보 수정" onclick="infoChange()">
                </div>
                
    
                <div class="userBtns">
                    
                    <input type="button" value="로그아웃" onclick="logout()"><br>
                    <input type="button" value="회원탈퇴" onclick="userBye()"><br>
                </div>
            </div>
        
        
            <ul class="mypageTab">
                <li>
                <a href="#tab1" class="storeTab youHere">나의 맛집(${fn:length(shop)}개)</a></li>
                <li><a href="#tab2" class="reviewTab">나의 리뷰(${fn:length(reviews)}개)</a></li>
            </ul>
            
<!--             storecollection 페이지 -->
            <div class="collectContainer" id="tab1">
			<div id="map" class="map">

		    </div>
		    <script type="text/javascript" 
			    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349c2cb0976e7672467f9c85e9839ed5"></script>
			    <script>
					var container = document.getElementById('map');
					var options = {
						center: new kakao.maps.LatLng(33.450701, 126.570667),
						level: 3
					};
			
					var map = new kakao.maps.Map(container, options);
			</script>
		
			<div class="userContentCon">
			<div class="filterContainer">
		        <select class="order">
		            <option value="">가게명</option>
		            <option value="">가게명 역순</option>
		            <option value="">먼저 추가한 날짜 순서</option>
		            <option value="">나중에 추가한 날짜 순서</option>
		            <option value="">평점 낮은 순</option>
		            <option value="">평점 높은 순</option>
		        </select>
		
		        <select class="filterOne">
		            <option value="0">지역별</option>
		            <option value="">신사동</option>
		            <option value="">압구정동</option>
		            <option value="">논현동</option>
		            <option value="">청담동</option>
		            <option value="">삼성동</option>
		            <option value="">역삼동</option>
		            <option value="">대치동</option>
		            <option value="">개포동</option>
		            <option value="">도곡동</option>
		            <option value="">일원동</option>
		        </select>
		
		        <select class="filterTwo">
		            <option value="">업종별</option>
		            <option value="">레스토랑</option>
		            <option value="">카페</option>
		            <option value="">이자카야</option>
		            <option value="">바</option>
		            <option value=""></option>
		        </select>
		
		        <select class="filterThree">
		            <option value="">종류별</option>
		            <option value="">한식</option>
		            <option value="">일식</option>
		            <option value="">중식</option>
		            <option value="">양식</option>
		            <option value="">그 외</option>
		        </select>
		        
		        <img src="/images/gridview.png" class="gridview">
		        <img src="/images/orderByList.png" class="listview">
		        
		        <select class="viewLook">
		        	<option value="바둑판 정렬">바둑판</option>
		        	<option value="">리스트</option>
		        	<option value="">간단히</option>
		        </select>
		    </div>
		    
		    <c:set var="allShops" value="${fn:length(shop)}"/>
		    <c:set var="rowEnd" value="${(allShops+2)/3}"/>
		    
		    
		    	
		
<!-- 		바둑판 정렬 -->
		    <div class="storeCollectGrid">
		        <c:forEach var="rowLength" begin="0" end="${rowEnd}">
			    	<div class="outer">
			    		<c:forEach var="columnLength" begin="0" end="2">
			    			<div class="storeAlbum">
			    			<c:forEach var="index" begin="0" end="${allShops}">
			    			${shop[0].shopName}
			    			</c:forEach>
			        			
			        		</div>
			    		</c:forEach>
			    	</div>
		    	</c:forEach>
		    </div>
		    
		    
<!-- 		리스트 정렬     -->
		    <div class="storeCollectList invisible">
		    <c:forEach var="index" begin="0" end="${allShops}">
		    	<div class="storeList">
		    		<img src="/images/${shop[index].shopProfile}">
		    		<table>
		    		<tr>
		    			<td>${shop[index].shopName}</td>
		    			<td><img src="/images/fourstar.png">4.0</td>
		    		</tr>
		    		<tr>
		    			<td>${shop[index].shopType}</td>
		    			<td>${shop[index].location}</td>
		    		</tr>
		    		<tr>
		    			<td>${shop[index].shopTel}</td>
		    		</tr>
		    		
		    		</table>
		    	</div>
		    </c:forEach>
		    </div>
		    
			</div>
		    
		</div>
		
		
<!-- 		리뷰리스트 페이지 -->
<div class="reviewContainer hidden" id="tab2">
        	
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
        
        	
<!--             <iframe src="../user/storeCollection" class="stores"></iframe> -->
<!--             <iframe src="../user/reviewList" class="reviews hidden"></iframe> -->
        
            <div class="modalContainer1 hidden">
                <div class="logoutModal">
                    <div class="xplace cancel" onclick="logout()"></div>
                    로그아웃 하시겠습니까?
                    <div class="logoutBtns">
                        <input type="button" value="확인">
                        <input type="button" value="취소" class="cancle" onclick="logout()">
                    </div>
                    
                </div>
            </div>
        
            <div class="modalContainer2 hidden">
                <div class="userOutModal">
                    <div class="xplace cancel" onclick="userBye()"></div>
                    탈퇴하시겠습니까?
                    <div class="userOutBtns">
                        <input type="button" value="탈퇴">
                        <input type="button" value="취소" class="cancel" onclick="userBye()">
                    </div>
                   
                </div>
            </div>
        </div>
        
    </main>
    
    <script src="/user/js/userPage.js"></script>
    <script src="/user/js/storeCollection.js"></script>
    <script src="/user/js/reviewList.js"></script>
    
<jsp:include page="../public/footer.jsp"/>


    
</body>
</html>