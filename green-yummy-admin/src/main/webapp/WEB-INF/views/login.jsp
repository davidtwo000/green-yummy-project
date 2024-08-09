<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #333;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .login-container {
            width: 300px;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .login-container label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .login-container button:hover {
            background-color: #575757;
        }
    </style>
    <script>
    function alarm(){
    	let message = "<%= request.getParameter("message") %>";
    	if(message == "loginFail")
    		alert("회원정보가 일치하지 않습니다.");
    	else if(message == "noSession")
    		alert("인증이 필요합니다.");
    	else if(message == "logoutSuccess")
    		alert("로그아웃 되었습니다.")
    }	
    </script>
</head>
<body onload="alarm()">
    <div class="login-container">
        <h1>Admin Login</h1>
        <form action="/admin/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <label for="username">Username</label>
            <input type="text" id="username" name="id" placeholder="Enter your username" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="pw" placeholder="Enter your password" required>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
