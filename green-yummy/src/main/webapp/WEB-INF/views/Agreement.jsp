<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>약관 동의</title>
    <link href="public/css/Agreement.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="public/header.jsp"/>

    <main>
        <div class="innerContainer">

           <!--  유효성 체크. 필수 항목은 자세히보기를 눌러서 확인을 해야만 한다. 
             버튼을 눌렀다면 회색에서 붉은 색으로 바뀐다.-->

            <h3>이용약관</h3>

            <label><input type="checkbox" name="agreement">전체 동의</label>
            <ul class="agreeCheck">
                
                <li><input type="checkbox" name="agreement">
                    (필수)만 14세 이상입니다.</li>
                <li><input type="checkbox" name="agreement">
                    (필수)개인정보 수집 약관에 동의합니다. 
                    <input type="button" value="자세히보기"></li>
                <li><input type="checkbox" name="agreement">
                    (필수)이용약관에 동의합니다. 
                    <input type="button" value="자세히보기"></li>
                <li><input type="checkbox" name="agreement">
                    (선택)광고성 메일 수신에 동의합니다. 
                    <input type="button" value="자세히 보기"></li>
            </ul>
                
            
            
        
            <div class="agreeBtns">
                <input type="button" value="다음">
                <input type="button" value="뒤로">
            </div>
            
        </div>
    </main>

<jsp:include page="public/footer.jsp"/>
    
</body>
</html>