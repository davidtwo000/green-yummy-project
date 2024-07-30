<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/static/createReview.css" rel="stylesheet" type="text/css">
</head>
<body>

    <main>
        <!-- 별이 하나 채워진 이미지에서 다섯개 채워진 이미지까지 총 다섯 개 준비
        그리고 무얼 클릭하느냐에 따라서 다른 이미지가 나오게 한다. -->
        <div class="reviewContainer">
            <div class="storeStars">
                <img src="/images/onestar.png">
                <img src="/images/twostar.png">
                <img src="/images/threestar.png">
                <img src="/images/fourstar.png">
                <img src="/images/fivestar.png">
            </div>
            <div class="scoreRadio">
                <input type="radio" name="score" value="1">1
                <input type="radio" name="score" value="2">2
                <input type="radio" name="score" value="3" checked>3
                <input type="radio" name="score" value="4">4
                <input type="radio" name="score" value="5">5
            </div>
            <div class="reviewKeyword">
                <input type="checkbox" name="keyword" value="food">
                음식이 맛있어요
                <input type="checkbox" name="keyword" value="waiter">
                직원이 친절해요
                <input type="checkbox" name="keyword" value="comfort">
                분위기가 좋아요
                <input type="checkbox" name="keyword" value="clean">
                가게 위생이 청결해요
    
                <input type="checkbox" name="keyword" value="price">
                가격이 저렴해요
                <input type="checkbox" name="keyword" value="much">
                양이 많아요
                <input type="checkbox" name="keyword" value="quality">
                음식의 품질이 좋아요
                <input type="checkbox" name="keyword" value="view">
                뷰가 좋아요
    
            </div>
            <div class="reviewContent">
                <textarea rows="10" cols="50"></textarea>
            </div>
            <div class="reviewPhotos">
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
                <div class="storePhoto"><input type="file"></div>
            </div>
            <!-- 사진 최대 게시 한도를 정해두면 어떨까 -->
            <div class="reviewBtn">
                <input type="submit" value="리뷰 수정하기">
            </div>
        </div>
        

    </main>
    
</body>
</html>