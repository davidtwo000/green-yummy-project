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
        <div class="innerContainer">
            <ul>
                <li>아이디 찾기</li>
                <li>비밀번호 찾기</li>
            </ul>

            <div class="findId">
                전화번호로 찾기
                <input type="text">
                <p>*-를 제외하고 입력해주세요.</p>
    
                <br>
    
                이메일로 찾기
                <input type="text">
                
            </div>

            <div class="findPswd">
                이메일을 입력해주세요.
                <input type="text">
                
            </div>
            
        </div>
    </main>

   <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>