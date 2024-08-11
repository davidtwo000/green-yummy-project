<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사진으로 검색하기</title>
    <link href="/public/css/pictureOCR.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>
    <main>
        <div class="innerContainer">
        
        <div class="searchContainer">
        <div class="OCRhelp">
        <span>OCR 사진 검색 사용법</span>
        <img src="/images/roundQ.png">
        </div>
			<input type="text" class="searchBar"
			 placeholder="이미지를 삽입해서 검색어를 입력하세요" readonly>
			<div class="customSearchBtn">
				<img src="/images/search.png">
			</div>
		</div>
        

            
            <div class="OCRexplain invisible">
	           <h4>사진을 넣어서 맛집을 검색해 보세요!</h4>
	                <ol>
	                    <li>네모 박스를 눌러 찍어둔 맛집 간판 사진을 삽입합니다.</li>
	                    <li>사진을 삽입하면 검색어에 간판에 적힌 가게명이 입력됩니다.</li>
	                    <li>맛집 검색 버튼을 누르면 검색 결과가 나옵니다.</li>
	                </ol>
            </div>

            <div class="OCRsearch">
                    
                    <!-- 사진을 찾으면 forpicture 안에 사진이 들어간다. -->
                    <img src="/images/picture.png">
                     <span>이 곳을 눌러 사진을 삽입하세요.</span>
   				<input type="file" id="storeSign" value="사진 찾기">
            </div>
            
            
               

           
            <!-- 검색 버튼은 사진을 넣고 ocr 결과까지 나왔을 때 활성화된다. -->
        </div>
    </main>
    
    <script src="/public/js/pictureOCR.js"></script>
    
    <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>