<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .header, .header1 {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: right;
        }
        .header span, .header1 span {
            margin-right: 15px;
        }
        .content {
            text-align: center;
            padding: 20px 0;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .content h1 {
            margin-bottom: 10px;
            font-size: 24px;
            color: #333;
        }
        .container {
        	position:relative;
            width: 80%;
            max-width: 1000px;
            height:450px;
            margin: 80px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
            align-items: flex-start;
            gap: 20px;
        }
        .profile-image {
            flex: 1;
            text-align: center;
        }
        .profile-image img {
        	margin-top:15px;
            width: 250px;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        .details {
            flex: 2;
            width: 100%;
            border-collapse: collapse;
        }
        .details th, .details td {
            border: 1px solid #ddd;
            padding: 12px 15px;
            text-align: left;
        }
        .details th {
            background-color: #f4f4f4;
        }
        .details td:nth-child(odd) {
            background-color: #fff;
            width:30%;
        }
        .details td:nth-child(even) {
            background-color: #fff;
            width:70%;
        }
        .details tr:nth-child(even) td {
            background-color: #f9f9f9;
        }
        .details strong {
            color: #333;
        }
        a#a {
            color: white;
        }
        a#b,input {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #fff;
            background-color: #333;
            padding: 10px 20px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            font-size:16px;
        }
        a#b:hover,input:hover {
            background-color: #444;
        }
        form:nth-child(1){
        	position:absolute;
        	bottom:30px;
        	left:150px;
        }
        form:nth-child(2){
        	position:absolute;
        	bottom:30px;
        	right:150px;
        }
        input{
        	width:350px;
        	height:60px;
        	font-size:1.5em;
        	cursor:pointer;
        }
    </style>
	<script>
	    function alarm(){
	    	let message = "<%= request.getParameter("message") %>";
	    	if(message == "modify")
	    		alert("정보가 수정되었습니다.");
	    }	
	</script>
</head>
<body onload="alarm()">
    <div class="header">
        <span>Welcome, Admin</span>
    </div>
    <div class="content">
        <h1>가게 상세 정보</h1>
    </div>
    <div class="header1">
        <span><a href="/admin/shopList?page=1" id="a">Back to Dashboard</a></span>
    </div>
    <div class="container">
        <div class="profile-image">
            <img src="/admin/images/${shopDTO.shopProfile}" alt="Shop Profile">
        </div>
        <table class="details">
            <tr>
                <th>항목</th>
                <th>내용</th>
            </tr>
            <tr>
                <td><strong>상호명:</strong></td>
                <td>${shopDTO.shopName}</td>
            </tr>
            <tr>
                <td><strong>업종:</strong></td>
                <td>${shopDTO.shopType}</td>
            </tr>
            <tr>
                <td><strong>위치:</strong></td>
                <td>${shopDTO.location}</td>
            </tr>
            <tr>
                <td><strong>전화번호:</strong></td>
                <td>${shopDTO.shopTel}</td>
            </tr>
            <tr>
                <td><strong>영업시간:</strong></td>
                <td>${shopDTO.openHours} ~ ${shopDTO.closeHours}</td>
            </tr>
            <tr>
                <td><strong>휴일:</strong></td>
                <td>${shopDTO.closedDays}</td>
            </tr>
        </table>
        <div>
	        <form action="/admin/shopModify" method="get">
			    <input type="hidden" name="id" value="${shopDTO.shopUkId}">
			    <input type="submit" value="Modify">
			</form>
	        <form action="/admin/shopDelete" method="post">
	        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	        	<input type="hidden" name="id" value="${shopDTO.shopUkId}">
	        	<input type="submit" value="Delete">
	        </form>
	    </div>
    </div>
</body>
</html>
