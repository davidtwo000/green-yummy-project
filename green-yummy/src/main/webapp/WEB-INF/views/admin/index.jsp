<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
        }
        .sidebar {
            width: 250px;
            height: 100%;
            background-color: #333;
            position: fixed;
            left: 0;
            top: 0;
            color: #fff;
            padding-top: 20px;
            box-sizing: border-box;
        }
        .sidebar h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        .sidebar ul {
            list-style: none;
            padding: 0;
        }
        .sidebar ul li {
            padding: 15px;
            text-align: center;
        }
        .sidebar ul li:hover, .sidebar div:hover {
            background-color: #575757;
            cursor: pointer;
        }
        .sidebar #div1{
        	position:relative;
        	padding: 15px;
        	left:0;
        	right:0;
        	top:50px;
        	text-align:center;
        }
        .sidebar #div2{
        	position:relative;
        	top:100px;
        	height:51px;
        	text-align:center;
        }
        .sidebar #div2 form, .sidebar #div2 input{
       	    width:100%;
       	    height:100%;
        }
        .sidebar #div2 input{
        	background:none;
        	font-size:16px;
        	border:none;
        	outline:none;
        	color:white;
        	cursor:pointer;
        	width:100%;
        	height:100%;
        }
        .main-content {
            position: absolute;
            left: 270px; /* 사이드바 너비(250px) + 마진(20px) */
            top: 20px;
            width: calc(100% - 270px); /* 전체 너비에서 사이드바 너비와 마진을 뺌 */
            height: calc(100% - 20px); ;
            border: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    	$(function(){
    		let iframe = $('.main-content');
    		$('#user').click(function(){
    			iframe.attr('src','/admin/userList');
    		});
    		$('#announce').click(function(){
    			iframe.attr('src','/admin/announceList');
    		});
    		$('#review').click(function(){
    			iframe.attr('src','/admin/reviewList');
    		});
    		$('#request').click(function(){
    			iframe.attr('src','/admin/requestList');
    		});
    		$('#div1').click(function(){
				iframe.attr('src','/admin/announceCreate');    			
    		});
    	});
    </script>
</head>
<body>
    <div class="sidebar">
        <h2>관리자</h2>
        <ul>
            <li id='user'>사용자</li>
            <li id='announce'>공지사항</li>
            <li id='review'>리뷰내역</li>
            <li id='request'>신청내역</li>
        </ul>
        <div id="div1">공지사항 작성</div>
        <div id="div2">
        	<form action="/logout" method="post">
        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        		<input type="submit" value="로그아웃" id="logout">
        	</form>
        </div>
    </div>
    <iframe class="main-content" src="/admin/userList"></iframe>
</body>
</html>
