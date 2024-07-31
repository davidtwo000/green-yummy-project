let username = document.querySelector("#name");
let nickname = document.querySelector("#nickname");
let userId = document.querySelector("#userId");
let pswd = document.querySelector("#pswd");
let passCheck = document.querySelector("#pswdChk");
let phone = document.querySelector("#phone");
let email1 = document.querySelector("#emailone");
let email2 = document.querySelector("#emailtwo");

let emailChoose = document.querySelector("select");

let eventform = document.querySelector("form");

/*let passreg = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^])[A-Za-z\d@$!%*#?&]{8,20}$/
let idreg = /[]/
let phonereg = /[\d]{2,3}[\d]{3,4}[\d]{4}/*/


//셀렉터로 선택하면 emailtwo에 값이 입력된다. onchange
emailChoose.addEventListener("change", function(){
	let emailAddress = emailChoose.value;
	email2.textContent = emailAddress;
});

//유효성 체크
//정규식

eventform.addEventListener("submit", function(event){
	if(username.value==""){
			alert("이름을 입력해주세요.");
			event.preventDefault();
			username.focus();
			return false;
		}
		if(nickname.value==""){
			alert("사용할 닉네임을 입력해 주세요.");
			event.preventDefault();
			nickname.focus();
			return false;
		}
		/*if(){
			alert("닉네임 중복체크를 진행해주세요.");
			e.preventDefault();
			return false;
		}*/
		if(userId.value==""){
			alert("아이디를 입력해주세요");
			event.preventDefault();
			userId.focus();
			return false;
		}
		/*if(){
			alert("아이디 중복체크를 진행해주세요.");
			e.preventDefault();
			return false;
		}*/
		if(pswd.value==""){
			alert("비밀번호를 입력해주세요.");
			event.preventDefault();
			pswd.focus();
			return false;
		}
		if(pswd.length()<8 || pswd.length()>20){
			alert("비밀번호는 8자리 이상 20자리 이하여야 합니다.");
			event.preventDefault();
			pswd.focus();
			return false;
		}
		/*if(passreg.test(pswd.value)==false){
			alert("비밀번호는 영문자, 숫자, 기호가 하나씩 들어가 있어야 합니다.");
			e.preventDefault();
			return false;
		}*/
		if(passCheck.value==""){
			alert("비밀번호가 맞는지 확인해 주세요.");
			event.preventDefault();
			passCheck.focus();
			return false;
		}
		if(phone.value==""){
			alert("전화번호를 입력해주세요.");
			event.preventDefault();
			phone.focus();
			return false;
		}
		/*if(phonereg.test(phone.value)==false){
			alert("전화번호는 '-'를 제외하고 입력해 주세요.");
			e.preventDefault();
			return false;
		}*/
		if(email1.value=="" || email2.value==""){
			alert("이메일을 입력해주세요.");
			event.preventDefault();
			email1.focus();
			return false;
		}
});


//취소를 누르면 메인으로 간다
function gotomain(){
	window.location.href="/";
}

