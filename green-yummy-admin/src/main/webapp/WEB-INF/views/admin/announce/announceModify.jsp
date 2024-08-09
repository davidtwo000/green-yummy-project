<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modify Notification</title>
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
            max-width: 1000px;
            height:560px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .container h1 {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input, textarea {
            width: 980px;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        textarea{
        	height:330px;
        	resize:none;
        }
        a#a {
            color: white;
        }
        input[type="submit"]{
        	position:absolute;
        	bottom:10px;
        	width:800px;
        	left:100px;
        	height:60px;
        	font-size:1.5em;
        	background:#333;
        	color:white;
        	cursor:pointer;
        }
    </style>
</head>
<body>
	<div class="header">
        <span>Welcome, Admin</span>
    </div>
    <div class="content">
        <h1>공지사항 수정</h1>
    </div>
    <div class="header1">
        <span><a href="/admin/announceDetail?id='${announceDTO.noticeId }'" id="a">Back to Details</a></span>
    </div>
    <div class="container">
        <form action="/admin/announceModify" method="post">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        	<input type="hidden" name="id" value="${announceDTO.noticeId}">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" value="${announceDTO.title }">
            <label for="content">Content</label>
            <textarea id="content" name="content" rows="5">${announceDTO.content }</textarea>
            <input type="submit" value="Modify Notification">
        </form>
    </div>
</body>
</html>
