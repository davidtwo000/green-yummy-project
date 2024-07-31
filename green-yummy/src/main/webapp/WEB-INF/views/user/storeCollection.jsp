<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 맛집</title>
    <link href="/user/css/storeCollection.css" rel="stylesheet" type="text/css">
    
</head>
<body>

	<main>
		<div class="innerContainer">
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
		            <option value="" checked>업종별</option>
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
		        
		        <select class="viewLook">
		        	<option value="바둑판 정렬">바둑판</option>
		        	<option value="">리스트</option>
		        	<option value="">간단히</option>
		        </select>
		    </div>
		
		    <div class="storeCollect">
		        <div class="storeAlbum">
		        
		        </div>
		        <div class="storeAlbum">
		        
		        </div>
		        <div class="storeAlbum">
		        
		        </div>
		        <div class="storeAlbum">
		        
		        </div>
		        <div class="storeAlbum">
		        
		        </div>
		        <div class="storeAlbum">
		        
		        </div>
		        <div class="storeAlbum">
		        
		        </div>
		        <div class="storeAlbum">
		        
		        </div>
		    </div>
			</div>
		    
		</div>
	</main>

    
    
</body>
</html>