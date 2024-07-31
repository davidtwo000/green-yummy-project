<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link href="/public/css/userLogin.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="public/header.jsp"/>

    <main>
        <div class="loginContainer">
            <form class="loginbox">
                <div class="loginforms">
                    <table>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" placeholder="아이디를 입력하세요."></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="text" placeholder="아이디를 입력하세요."></td>
                        </tr>
                       
                    </table>
                    
                    <div>
                        <input type="button" value="로그인" onclick="window.location.href='user/userPage'">
                    </div>
                    
                </div>
                <div class="loginbuttonetc">
                    <input type="button" value="회원가입" onclick="window.location.href='/Agreement'">
                    <input type="button" value="아이디/비밀번호 찾기" onclick="window.location.href='user/findIdPassword'">
                </div>

                
            </form>
        </div>

    </main>
    
    <jsp:include page="public/footer.jsp"/>
    
</body>
</html>