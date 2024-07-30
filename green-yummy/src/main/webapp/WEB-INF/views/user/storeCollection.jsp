<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 맛집</title>
</head>
<body>

    <div id="map" class="map">

    </div>

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
    </div>

    <div class="storeCollect">
        
    </div>
    
</body>
</html>