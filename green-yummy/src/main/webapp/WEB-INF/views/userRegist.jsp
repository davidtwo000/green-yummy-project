<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/public/css/userRegistChange.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="public/header.jsp"/>
    
<main>
   
        <form>
        모든 항목을 필수로 입력하셔야 합니다.
            <div class="tablecontainer">
                <table>
                    <tr>
                        <td>이름</td>
                        <td><input type="text" id="name"></td>
                    </tr>
                    <tr>
                        <td>닉네임</td>
                        <td><input type="text" id="nickname">
                        <input type="button" class="nickcheck" value="중복확인"></td>
                    </tr>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" id="userId">
                            <input type="button" class="idcheck" value="중복확인"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="text" id="pswd"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p class="passrequire">*비밀번호는 영문자, 숫자, 기호를 하나씩 써서 8자리 이상 20자리 이하로
                            설정해주세요.
                        </p></td>
                        
                    </tr>
                    <tr>
                        <td>비밀번호 확인</td>
                        <td><input type="text" id="pswdChk"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" id="phone"><br>
                        <span>'-'를 제외하고 입력해주세요.</span></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="text" id="emailone">@
                        <input type="text" id="emailtwo">
                            <select>
                                <option value="naver.com">naver.com</option>
                                <option value="daum.net">daum.net</option>
                                <option value="gmail.com">gmail.com</option>
                                <option value="nate.com">nate.com</option>
                                <option value="hanmail.net">hanmail.net</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
            
            <div class="joinbtncontainer">

            <div class="joinbtns">
                <input type="submit" value="회원가입" onclick="joincheck()">
                <input type="button" class="joincancel" value="취소">
            </div>
            </div>
            
        </form>
    
</main>

<jsp:include page="public/footer.jsp"/>

<script src="/public/js/userRegist.js"></script>

</body>
</html>