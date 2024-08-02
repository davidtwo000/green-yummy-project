<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<link rel="stylesheet" type="text/css" href="/index/css/index.css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>

<div class="outContainer">
        <div class="innerContainer">
            <div class="searchContainer">
                <input type="text" placeholder="검색어를 입력하세요" class="searchBar">
                <div class="customSearchBtn"></div>
                <input type="button" value="OCR" class="OCRBtn" 
                onclick="function(){ window.location.href='/public/pictureOCR';}">
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
            </ul>
            
			
			<div class="eventImgCon">
			<div class="mainPrevBtn"></div>
			<div class="eventImgInnerCon">
			<ul class="eventImgList">
				<li><div class="mainImg"> 이미지 first </div></li>
				<li><div class="mainImg"> 이미지 </div></li>
				<li><div class="mainImg"> 이미지 </div></li>
				<li><div class="mainImg"> 이미지 </div></li>
				<li><div class="mainImg"> 이미지 last </div></li>
			</ul>
			</div>
				<div class="mainNextBtn"></div>
			</div>
			
			
            
 
            <div class="recommand">
            <div class="recPrevBtn"></div>
	           <div class="recommandInnerCon">
	           <div class="recommandTag"> 추천 맛집</div>
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
           	<div class="recNextBtn"></div>
            </div>
            
            
            
       
        
        
            
        </div>
    </div>
    
    <script src="/index/js/indexMainImgs.js"></script>
    <script src="/index/js/indexRecImgs.js"></script>
    
    <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>