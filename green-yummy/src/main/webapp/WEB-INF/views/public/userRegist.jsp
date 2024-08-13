<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link href="/public/css/userRegistChange.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="../public/header.jsp"/>
    
<main>
    <form method="post" action="/userJoin" enctype="multipart/form-data">
    <p class="upperComment">모든 항목을 필수로 입력하셔야 합니다.</p>
        <div class="tablecontainer">
            <table>
                <tr>
                    <th>이름</th>
                    <td><input type="text" id="name" name="name"></td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" id="userId" name="id">
                        <input type="button" class="idcheck" value="중복확인">
                    </td>
                </tr>
                <tr>
                    <th>닉네임</th>
                    <td>
                        <input type="text" id="nickname" name="nickname">
                        <input type="button" class="nickcheck" value="중복확인">
                    </td>
                </tr>
                
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" id="pswd" name="password">
                    <p class="passrequire">*비밀번호는 영문자, 숫자, 기호(!,@,#,$,%,^)를 하나씩 써서 8자리 이상 20자리 이하로 설정해주세요.</p></td>
                </tr>
<!--                 <tr> -->
<!--                     <td colspan="2"> -->
                        
<!--                     </td> -->
<!--                 </tr> -->
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" id="pswdChk" name="pswdChk"></td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td>
                        <input type="text" id="phone" name="phone"><br>
                        <span>'-'를 제외하고 입력해주세요.</span>
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>
                        <input type="text" id="emailone" name="emailone">@
                        <input type="text" id="emailtwo" name="emailtwo">
                        <select id="selEmail">
                            <option value="">이메일 선택</option>
                            <option value="naver.com">naver.com</option>
                            <option value="daum.net">daum.net</option>
                            <option value="gmail.com">gmail.com</option>
                            <option value="nate.com">nate.com</option>
                            <option value="hanmail.net">hanmail.net</option>
                        </select>
                        <input type="button" class="emailcheck" value="중복확인">
                    </td>
                </tr>
                <tr>
                	<th>프로필 사진</th>
                	<td>
                		<div class="userPhoto">
			       			<label for="file"><img src="/images/addPhoto.png" id="addPhoto"></label>
			       			<input type="file" name="userImg" id="file" onchange="addUserPhoto()">
			       		</div>
                	</td>
                </tr>
            </table>
        </div>
        
        <div class="joinbtncontainer">
            <div class="joinbtns">
                <input type="submit" value="회원가입">
                <input type="button" class="joincancel" value="취소" onclick="gotomain()">
            </div>
        </div>
    </form>
</main>

<jsp:include page="../public/footer.jsp"/>

<script src="/public/js/userRegist.js"></script>

</body>
</html>