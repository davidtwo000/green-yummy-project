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
            width: 80%;
            max-width: 1000px;
            height:560px;
            margin: 40px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            position:relative;
        }
        h1 {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }
        .details {
            width: 100%;
            border-collapse: collapse;
        }
        .details th, .details td {
            border: none;
            padding: 12px;
            text-align: left;
        }
        .details th {
            background-color: #f4f4f4;
            color: #555;
            width: 120px;
        }
        .details td {
            background-color: #fff;
            color: #333;
        }
        .details tr {
            border-bottom: 1px solid #ddd;
        }
        .details tr:last-child {
            border-bottom: none;
        }
        .content-text {
            margin-top: 20px;
            line-height: 1.6;
            height:190px;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        .back-link:hover {
            text-decoration: underline;
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
        input{
        	position:absolute;
        	bottom:40px;
        	width:800px;
        	left:100px;
        	height:60px;
        	font-size:1.5em;
        	cursor:pointer;
        }
    </style>
</head>
<body>
    <div class="header">
        <span>Welcome, Admin</span>
    </div>
    <div class="content">
        <h1>리뷰내역 세부 내용</h1>
    </div>
    <div class="header1">
        <span><a href="/admin/reviewList?page=1" id="a">Back to Dashboard</a></span>
    </div>
    <div class="container">
        <table class="details">
        	<tr>
                <th>상호명</th>
                <td>${reviewDTO.shopName }</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${reviewDTO.reviewComment }</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${reviewDTO.userId }</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td>${reviewDTO.reviewDate }</td>
            </tr>
            <tr>
                <th>평점</th>
                <td>${reviewDTO.reviewRate }</td>
            </tr>
            <tr>
                <th>내용</th>
                <td class="content-text">
                    ${reviewDTO.reviewContent }
                </td>
            </tr>
        </table>
        <div>
	        <form action="/admin/reviewDelete" method="post">
	        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	        	<input type="hidden" name="id" value="${reviewDTO.reviewId}">
	        	<input type="submit" value="Delete">
	        </form>
	    </div>
    </div>
</body>
</html>
