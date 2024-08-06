
function showErrorMessage() {
            // 현재 URL의 쿼리 파라미터를 가져옵니다.
            const urlParams = new URLSearchParams(window.location.search);
            // 'error' 파라미터가 있는지 확인합니다.
            if (urlParams.has('error')) {
                // 오류 메시지를 표시합니다.
                alert("아이디 또는 비밀번호가 일치하지 않습니다.");
                // 파라미터를 제거하여 재방문 시 메시지가 다시 표시되지 않도록 합니다.
                window.history.replaceState({}, document.title, window.location.pathname);
            }
        }
 
//        
window.onload = showErrorMessage;

function validateForm() {
	console.log("validateForm 함수가 호출되었습니다.");
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username === "") {
        alert("아이디를 입력해주세요.");
        return false;
    }
    if (password === "") {
        alert("비밀번호를 입력해주세요.");
        return false;
    }
    return true;
}

function userJoin(){
	window.location.href='/public/Agreement';
}

function findIDPW(){
	window.location.href='/public/findIdPassword';
}