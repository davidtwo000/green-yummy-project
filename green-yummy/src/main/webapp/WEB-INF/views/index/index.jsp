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
                    메뉴별
                </li>
				<li>
					평점별
				</li>
            </ul>
            
            <div class="areaSublist submenus hide">
            	<ul>
            	<li>강남 전체</li>
            	<li>개포동</li>
            	<li>논현동</li>
            	<li>대치동</li>
            	<li>도곡동</li>
            	</ul>
            	<ul>
            	<li>삼성동</li>
            	<li>세곡동</li>
            	<li>수서동</li>
            	<li>신사동</li>
            	<li>압구정동</li>
            	</ul>
            	<ul>
            	<li>역삼동</li>
            	<li>율현동</li>
            	<li>일원동</li>
            	<li>자곡동</li>
            	<li>청담동</li>
            	</ul>
            </div>
            <div class="typeSublist submenus hide">
            	<ul>
            	<li>한식</li>
            	<li>일식</li>
            	<li>중식</li>
            	<li>양식</li>
            	<li>기타(멕시코, 베트남, 인도)</li>
            	</ul>
            	<ul>
            	<li>레스토랑</li>
            	<li>카페</li>
            	<li>술(이자카야, 호프, 바)</li>
            	<li>패스트푸드(치킨, 피자, 햄버거)</li>
            	<li>이색음식점</li>
            	</ul>
            </div>
            <div class="menuSublist submenus hide">
            	<ul>
            	<li>고기</li>
            	<li>탕, 찌개</li>
            	<li>회, 해산물</li>
            	<li>면, 국수</li>
            	<li>백반</li>
            	</ul>
            	<ul>
            	<li>디저트</li>
            	<li>빵</li>
            	<li>음료</li>
            	<li>샌드위치</li>
            	<li>비건, 샐러드</li>
            	</ul>
            	<ul>
            	<li>막걸리집</li>
            	<li>호프집</li>
            	<li>포차</li>
            	<li>이자카야</li>
            	<li>바</li>
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