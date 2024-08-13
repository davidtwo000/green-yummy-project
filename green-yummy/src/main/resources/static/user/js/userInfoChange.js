let username = document.querySelector("#name");
let nickname = document.querySelector("#nickname");
let userId = document.querySelector("#userId");
let pswd = document.querySelector("#pswd");
let passCheck = document.querySelector("#pswdChk");
let phone = document.querySelector("#phone");
let email1 = document.querySelector("#emailone");
let email2 = document.getElementById("emailtwo");

let emailChoose = document.getElementById("selEmail");

let currentNick = document.querySelector("#currentNickname");
let currentEmail = document.querySelector("#currentEmail");

let passreg = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^])(?!.*[가-힣])[A-Za-z\d@$!%*#?&]{8,20}$/;
let phonereg = /[\d]{2,3}[\d]{3,4}[\d]{4}/;
let emailreg = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

//셀렉터로 선택하면 emailtwo에 값이 입력된다. onchange
emailChoose.addEventListener("change", function () {
	
	let emailAddress = emailChoose.value;
	email2.value = emailAddress;
	
	console.log(email2.textContent);
});
	
	
function addUserPhoto(){
	let photolabel = document.querySelector(".userPhoto label");
	let addPhoto = document.getElementById("addPhoto");
	let inputfile = document.getElementById("file");

	
	let myUserPhoto = inputfile.files[0];
	let fr = new FileReader();
		
	fr.onload = function(event){
		let pictureUrl = event.target.result;
		let imgtag = document.createElement("img");
		
		addPhoto.classList.add("hidden");
		
		photolabel.appendChild(imgtag);
		imgtag.src = pictureUrl;
		imgtag.style.opacity = "1";
				
		console.log(pictureUrl);
	};
	
	fr.readAsDataURL(myUserPhoto);
}
	

let isNicknameAvailable = false;
let isEmailAvailable = false;

function checkNickname() {
    fetch(`/checkNickname?nickname=${nickname.value}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        if (data) {
            alert("사용 가능한 닉네임입니다.");
            isNicknameAvailable = true;
        } else {
            alert("이미 사용 중인 닉네임입니다.");
            nickname.focus();
            isNicknameAvailable = false;
        }
    })
    .catch(error => {
        console.error("Error checking nickname:", error);
        isNicknameAvailable = false;
    });
}

function checkEmail(){
	
	let email = `${email1.value}@${email2.value}`;
	
	if (!emailreg.test(email)) {
        alert("유효하지 않은 이메일 형식입니다. 다시 입력해주세요.");
        return;
    }
    
	fetch(`/checkEmail?email=${email}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        if (data) {
            alert("사용 가능한 이메일입니다.");
            isEmailAvailable = true;
        } else {
            alert("이미 등록된 이메일입니다.");
            userId.focus();
            isEmailAvailable = false;
        }
    })
    .catch(error => {
        console.error("Error checking email:", error);
        isEmailAvailable = false;
    });
	
	
}


//유효성 체크
//정규식
function userJoin(){
	
	if(nickname.value!="" && nickname.value!=currentNick.value){	
		if(!isNicknameAvailable){
	        alert("닉네임 중복 확인을 해주세요.");
	        nickname.focus();
	        return false;
        }
    }
    
    if(pswd.value!=""||passCheck.value!=""){
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
	}
	
	if(phone.value!=""){
		if(phonereg.test(phone.value)==false){
		alert("전화번호는 '-'를 제외하고 숫자만 입력해 주세요.");
		return false;
		}
	}
	
	
	if(email1.value!="" || email2.value !=""){		
		let email0 = `${email1.value}@${email2.value}`;
		document.getElementById("fullEmail").value = email0;
		if(!emailreg.test(email0)){
			alert("유효한 이메일 주소를 입력해주세요.");
	        email1.focus();
			return false;
		}
		if (!isEmailAvailable) {
	        alert("이메일 중복 확인을 해주세요.");
	        email1.focus();
	        return false;
	    }  
	}
	
	return true;     
}


// 중복 체크 버튼 이벤트 리스너
document.querySelector(".nickcheck").addEventListener("click", checkNickname);
document.querySelector(".emailcheck").addEventListener("click", checkEmail);

// form submit 이벤트에서 userJoin을 호출하여 유효성 검사를 기다립니다.
document.querySelector("form").addEventListener("submit", function (event) {
    if (!userJoin()) {
        event.preventDefault();
    }else{
		alert("정보 수정이 완료되었습니다.");
	}
});



//취소를 누르면 메인으로 간다 - 로그인 화면으로 변경해둠
function gotomain(){
	window.location.href="/user/userPage";
}

