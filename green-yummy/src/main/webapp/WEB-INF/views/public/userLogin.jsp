<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link href="/public/css/userLogin.css" rel="stylesheet" type="text/css">
    <script src="/public/js/userLogin.js"></script>
    
</head>
<body>

<jsp:include page="../public/header.jsp"/>

    <main>
        <div class="loginContainer">
            
                <div class="loginforms">
                	<form action="/login" method="post" class="loginbox">
                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <table>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name="username" placeholder="아이디를 입력하세요."></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="password" ></td>
                        </tr>
                       
                    </table>
                    <div>
                        <input type="submit" value="로그인">
                    </div>
                    </form>
                </div>
                <div class="loginbuttonetc">
                    <input type="button" value="회원가입" onclick="userJoin()">
                    <input type="button" value="아이디/비밀번호 찾기" onclick="findIDPW()">
                </div>
            
        </div>

    </main>
    
    <jsp:include page="../public/footer.jsp"/>
    
</body>
</html>