<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디/비밀번호 찾기</title>
    <link href="/public/css/findIdPassword.css" rel="stylesheet" type="text/css">
</head>
<body>

    <!-- 유효성 검사 필요. 이메일 파트도. -->
    
    <jsp:include page="../public/header.jsp"/>

    <main>
    	<form method="Post" id="findForm">
        <div class="innerContainer">
        	
	        <div class="findIdPassCon">
	        	<ul>
	                <li class="findThis">아이디 찾기</li>
	                <li>비밀번호 찾기</li>
	            </ul>
	
	            <div class="findId">
	                전화번호를 입력해주세요.<br>
	                <input type="text" id="idPhone" name="idPhone" placeholder="전화번호를 입력해 주세요.">
	                <p>*-를 제외하고 입력해주세요.</p>
	    
	                <br>
	    
	                이메일을 입력해주세요.<br>
	                <input type="text" id="idEmail" name="idEmail" placeholder="이메일을 입력해주세요.">
	                
	            </div>
	
	            <div class="findPswd hidden">
	            	아이디를 입력해주세요.<br>
	            	<input type="text" id="useId" name="useId" placeholder = "아이디를 입렵해 주세요.">
	                <br>이메일을 입력해주세요.<br>
	                <input type="text" id="pswdEmail" name="pswdEmail" placeholder="이메일을 입력해 주세요.">
	                <p>*아이디와 이메일을 입력하면 임시 비밀번호가 발급됩니다. 
	                임시 비밀 번호를 확인하고 로그인하신 뒤 비밀번호 변경을 진행해 주세요.</p>
	                
	            </div>
	        </div>
	        
	        <div class="findBtns">
		        <input type="button" id="myId" value="아이디 찾기">
		        <input type="button" class="hidden" id="newPswd" value="비밀번호 찾기">
	        </div>
	        
        </div>
        </form>
    </main>
	
   <jsp:include page="../public/footer.jsp"/>
   
   <script src="/public/js/findIdPswd.js"></script>
    
</body>
</html>