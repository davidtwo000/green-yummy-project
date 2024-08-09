<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<link rel="stylesheet" type="text/css" href="/index/css/index.css">
<link rel="stylesheet" type="text/css" href="/index/css/indexRecommand.css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>

<div class="outContainer">

			<div class="searchContainer">
                <input type="text" placeholder="검색어를 입력하세요" class="searchBar">
                <div class="customSearchBtn"><img src="/images/search.png"></div>
                <div class="ocricon">
	                <img src="/images/picture.png" title="OCR. 사진으로 검색하기." 
	                onclick="location.href='/public/pictureOCR'">
                </div>
                
            </div>
            
            <ul class="category">
                <li>
                    지역별
                </li>
                <li>
                    업종별
                </li>
				<li>
					평점별
				</li>
            </ul>
            
            <div class="areaSublist submenus hide">
            	<ul>
            	<li>강남 전체</li>
            	<li>논현동</li>
            	<li>신사동</li>
            	<li>압구정동</li>
            	<li>역삼동</li>
            	<li>청담동</li>
            	</ul>
            </div>
            <div class="typeSublist submenus hide">
            	<ul>
            	<li>한식</li>
            	<li>분식</li>
            	<li>일식</li>
            	<li>중식</li>
            	<li>양식</li>
            	</ul>
            	<ul>
            	<li>레스토랑</li>
            	<li>카페</li>
            	<li>술집</li>
            	<li>치킨/피자/햄버거</li>
            	<li>기타</li>
            	</ul>
            </div>
            <div class="starSublist submenus hide">
            	<ul>
            	<li>5점대</li>
            	<li>4점대</li>
            	<li>3점대</li>
            	<li>2점대</li>
            	<li>1점대</li>
            	</ul>
            </div>


        <div class="innerContainer">
        
        
        	


				<div class="mainPrevBtn">
				<img src="/images/prevBtn2.png"></div>
				<div class="eventImgCon">
				<ul class="eventImgList">
					<li><div class="mainImg">
						<img src="images/pasta.jpg"> 이미지 first </div></li>
					<li><div class="mainImg"> 
					<img src="/images/profile1.jpg">이미지 </div></li>
					<li><div class="mainImg">
					<img src="/images/profile2.jpg"> 이미지 </div></li>
					<li><div class="mainImg">
					<img src="/images/profile3.jpg"> 이미지 </div></li>
					<li><div class="mainImg">
						<img src="images/steak.jpg"> 이미지 last </div></li>
				</ul>
				</div>
					<div class="mainNextBtn">
					<img src="/images/nextBtn2.png"></div>



 
            <div class="recPrevBtn">
            <img src="/images/prevBtn2.png"></div>
	           <div class="recommandCon">
	           <div class="recommandTag"> 추천 맛집</div>
	           <hr>
	                <div class="lookMoreRec">자세히 보기</div>
	                <ul class="recommandList">
	                    <li>
	                        <div class="recommandImg"> </div>
	                        <div class="recommandDetail"> (first)가게 이름 / 평점 </div>
	                    </li>
	                    <li>
	                        <div class="recommandImg"> </div>
	                        <div class="recommandDetail"> 가게 이름 / 평점 </div>
	                    </li>
	                    <li>
	                        <div class="recommandImg"> </div>
	                        <div class="recommandDetail"> 가게 이름 / 평점 </div>
	                    </li>
	                    <li>
	                        <div class="recommandImg"> </div>
	                        <div class="recommandDetail"> 가게 이름 / 평점 </div>
	                    </li>
	                    <li>
	                        <div class="recommandImg"> </div>
	                        <div class="recommandDetail"> 가게 이름 / 평점 </div>
	                    </li>
	                    <li>
	                        <div class="recommandImg"> </div>
	                        <div class="recommandDetail"> (last)가게 이름 / 평점 </div>
	                    </li>
	                </ul>
	           </div>
           	<div class="recNextBtn">
           	<img src="/images/nextBtn2.png"></div>
            
            
            
       
        
        
            
        </div>
    </div>
    
    <script src="/index/js/indexMainImgs.js"></script>
    <script src="/index/js/indexRecImgs.js"></script>
    <script src="/index/js/indexMenubar.js"></script>
    
    <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>