<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataSearch</title>

<link rel="stylesheet" href="/public/css/dataSearch.css">
<script src="/public/js/dataSearch.js" defer></script>

</head>
<body>

	<jsp:include page="../public/header.jsp" />
	<div class="outContainer">

		<div class="innerContainer">
<!-- 		<div class="box"> -->
			
<!-- 			</div> -->

			<div class="searchContainer">
        
        		<select class="selectBox" id="selectBox">
                    <option value="" disabled selected>선택없음</option>
                    <option value="area">지역별</option>
                    <option value="category">업종별</option>
                </select>
        
                <input type="text" id="findByOption" class="searchBar" name="findByOption"
                 placeholder="검색어를 입력하세요">
                <div class="customSearchBtn">
                <img src="/images/search.png" id="seachBtn" onclick="findShop()">
                </div>
                <div class="ocricon">
	                <img src="/images/picture.png" title="OCR. 사진으로 검색하기." 
	                onclick="location.href='/public/pictureOCR'">
                </div>
                
            </div>


<!-- 			<div class="searchBar"> -->
<!-- 				<select class="selectBox" id="selectBox"> -->
<!-- 					아무것도 없을때는 가게 이름 -->
<!-- 					<option value="" disabled selected>가게 이름</option> -->
<!-- 					<option value="area">지역별</option> -->
<!-- 					<option value="type">업종별</option> -->
<!-- 				</select>  -->
<!-- 				<input type="text" id="findByOption" name="findByOption">  -->
<!-- 				<input type="button" id="seachBtn" onclick="findShop()" value="검색"> -->
<!-- 			</div> -->
			
			

			<div class="map" id="map">
            지도
            </div>
            <script type="text/javascript" 
			    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349c2cb0976e7672467f9c85e9839ed5"></script>

			<div class="sortOptions">
				<label> <input type="radio" name="sort" value="ratingAsc">
					평점 낮은 순
				</label> <label> <input type="radio" name="sort" value="ratingDesc">
					평점 높은 순
				</label> <label> <input type="radio" name="sort"
					value="alphabetical"> 리뷰 많은 순
				</label>


			</div>
		</div>
	</div>	


			<div id="shop-list"></div>
			<div id="pagination"></div>

			<jsp:include page="../public/footer.jsp" />

</body>
</html>
