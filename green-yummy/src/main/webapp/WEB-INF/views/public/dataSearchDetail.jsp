<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataSearchDetail</title>

<link rel="stylesheet" href="/public/css/dataSearchDetail.css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>

<form>
	<input type="hidden" id="">

</form>


 <div class="outContainer">
        <div class="innerContainer">
            <div class="restaurantTitle"> 
                <div class="name"> 가게 이름</div>
                <div class="type"> 업종 / 메뉴 </div>

            </div>
            
            <div class="restaurantImgContainer">
                <div class="restaurantImg"> </div>
                <div class="restaurantImg"> </div>
                <div class="restaurantImg"> </div>
            </div>
            
            <div class="rating"> 별점 ★★★★★ </div>

            <div class="detail">
                <table class="detailtable">
                    <tr>
                        <td> 주소 </td> <td> </td>
                    </tr>
                    <tr>
                        <td> OPEN </td> <td> </td>
                    </tr>
                    <tr>
                        <td> CLOSE </td> <td> </td>
                    </tr>
                    <tr>
                        <td> 전화번호 </td> <td> </td>
                    </tr>
                    <tr>
                        <td> 기타사항 </td> <td> </td>
                    </tr>
                </table>
                
                <div class="map">
                지도
                </div>

                
            </div>

            <div class="review">
                <div class="reviewTag"> 리뷰 </div>
                <input type="button" value="리뷰쓰기" class="reviewBtn">
            </div>

            <div class="random">
                <div class="randomRestaurant"> </div>
                <div class="randomRestaurant"> </div>
                <div class="randomRestaurant"> </div>
                <div class="randomRestaurant"> </div>
                <div class="randomRestaurant"> </div>
            </div>

            
        </div>
    </div>
    
 <jsp:include page="../public/footer.jsp"/>   
</body>
</html>