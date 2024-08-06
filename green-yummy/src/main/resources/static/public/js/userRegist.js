let username = document.querySelector("#name");
let nickname = document.querySelector("#nickname");
let userId = document.querySelector("#userId");
let pswd = document.querySelector("#pswd");
let passCheck = document.querySelector("#pswdChk");
let phone = document.querySelector("#phone");
let email1 = document.querySelector("#emailone");
let email2 = document.getElementById("emailtwo");

let emailChoose = document.getElementById("selEmail");


let passreg = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^])(?!.*[가-힣])[A-Za-z\d@$!%*#?&]{8,20}$/;
/*let idreg = /[]/*/
let phonereg = /[\d]{2,3}[\d]{3,4}[\d]{4}/;
let emailreg = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

//셀렉터로 선택하면 emailtwo에 값이 입력된다. onchange
emailChoose.addEventListener("change", function () {
	
	let emailAddress = emailChoose.value;
	email2.value = emailAddress;
	
	console.log(email2.textContent);
});
	
/*중복체크
async function checkDuplicate(field, value) {
    try {
        let response = await fetch(`/check-duplicate?field=${field}&value=${value}`);
        let result = await response.json();
        return result.isDuplicate;
    } catch (error) {
        console.error('Error checking duplicate:', error);
        return true;
    }
}

let nicknameChecked = false;
let userIdChecked = false;

document.querySelector(".nickcheck").addEventListener("click", async function () {
    let isDuplicate = await checkDuplicate('nickname', nickname.value);
    if (isDuplicate) {
        alert("닉네임이 중복되었습니다.");
        nicknameChecked = false;
    } else {
        alert("닉네임을 사용할 수 있습니다.");
        nicknameChecked = true;
    }
});

document.querySelector(".idcheck").addEventListener("click", async function () {
    let isDuplicate = await checkDuplicate('id', userId.value);
    if (isDuplicate) {
        alert("아이디가 중복되었습니다.");
        userIdChecked = false;
    } else {
        alert("아이디를 사용할 수 있습니다.");
        userIdChecked = true;
    }
});*/

//유효성 체크
//정규식
function userJoin(){
	if(username.value==""){
		alert("이름을 입력해주세요.");
		username.focus();
		return false;
	}
	
	if(nickname.value==""){
		alert("사용할 닉네임을 입력해 주세요.");
		nickname.focus();
		return false;
	}
	/*if (!nicknameChecked) {
        alert("닉네임 중복 확인을 진행해주세요.");
        nickname.focus();
        return false;
    }*/
	
	if(userId.value==""){
		alert("아이디를 입력해주세요");
		userId.focus();
		return false;
	}
	/*if (!userIdChecked) {
        alert("아이디 중복 확인을 진행해주세요.");
        userId.focus();
        return false;
    }*/
	
	if(pswd.value==""){
		alert("비밀번호를 입력해주세요.");
		pswd.focus();
		return false;
	}
	if(pswd.value.length < 8 || pswd.value.length > 20){
		alert("비밀번호는 8자리 이상 20자리 이하여야 합니다.");
		pswd.focus();
		return false;
	}
	if(passreg.test(pswd.value)==false){
		alert("비밀번호는 영문자, 숫자, 기호가 하나씩 들어가 있어야 합니다. (한글 사용 불가)");
		return false;
	}
	if(passCheck.value!=pswd.value || !passCheck.value){
		alert("비밀번호가 일치하는지 확인해 주세요.");
		passCheck.focus();
		return false;
	}
	
	if(phone.value==""){
		alert("전화번호를 입력해주세요.");
		phone.focus();
		return false;
	}if(phonereg.test(phone.value)==false){
		alert("전화번호는 '-'를 제외하고 입력해 주세요.");
		return false;
	}
	
	if(email1.value=="" || email2.value==""){
		alert("이메일을 입력해주세요.");
		email1.focus();
		return false;
	}
	
	let email0 = `${email1.value}@${email2.value}`;
	
	if(!emailreg.test(email0)){
		alert("유효한 이메일 주소를 입력해주세요.");
        email1.focus();
		return false;
	}
	    
	return true;
}


//취소를 누르면 메인으로 간다 - 로그인 화면으로 변경해둠
function gotomain(){
	window.location.href="/public/userLogin";
}

