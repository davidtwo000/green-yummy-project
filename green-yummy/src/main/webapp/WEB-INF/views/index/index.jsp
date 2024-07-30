<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<link href="/index/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="outContainer">
        <div class="innerContainer">
            <div class="searchContainer">
                <input type="text" placeholder="검색어를 입력하세요" class="searchBar">
                <input type="button" value="검색" class="searchBtn">
                <input type="button" value="OCR" class="OCRBtn">
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

            <div class="mainImg"> 이미지 </div>

            <div class="recommand">
                <div class="recommandTag"> 추천 맛집</div>
                <ul class="recommandList">
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
                </ul>
            </div>
        </div>
    </div>
</body>
</html>