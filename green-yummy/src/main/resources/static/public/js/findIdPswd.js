let findTab = document.querySelectorAll(".findIdPassCon > ul > li");
let findId = document.querySelector(".findId");
let findPswd = document.querySelector(".findPswd");
let findIdBtn = document.getElementById("myId");
let findPswdBtn = document.getElementById("newPswd");

let findByPhone = document.getElementById("idPhone");
let findByIdEmail = document.getElementById("idEmail");
let findPswdByEmail = document.getElementById("pswdEmail");

let phonereg = /^[\d]{2,3}[\d]{3,4}[\d]{4}/
let emailreg = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/

//아이디 찾기 탭을 누르면 아이디 찾기 창이, 비밀번호 찾기 탭을 누르면 비밀번호 찾기 창이 나타난다.
//비밀번호 탭을 눌렀다.
findTab[1].onclick = () => {
	if(!findTab[1].classList.contains("findThis")){
		findTab[0].classList.remove("findThis");
		findTab[1].classList.add("findThis");
		findId.classList.add("hidden");
		findPswd.classList.remove("hidden");
		
		findPswdBtn.classList.remove("hidden");
		findIdBtn.classList.add("hidden");
	}else{
		findTab[1].classList.contains("findThis");
	}
}
//아이디 탭을 눌렀다.
findTab[0].onclick = () => {
	if(!findTab[0].classList.contains("findThis")){
		findTab[1].classList.remove("findThis");
		findTab[0].classList.add("findThis");
		findId.classList.remove("hidden");
		findPswd.classList.add("hidden");
		
		findPswdBtn.classList.add("hidden");
		findIdBtn.classList.remove("hidden");
	}else{
		findTab[0].classList.contains("findThis");
	}
}

//전화번호 유효성 체크. 전화번호를 입력하지 않았을 때는 이메일 유효성 체크가,
//이메일을 입력하지 않았을 때는 전화번호 유효성 체크가 나타난다.
findIdBtn.onclick = () => {
	if(!findByIdEmail.value && findByPhone.value){
		if(findByPhone.value.length < 9){
			alert("전화번호 또는 이메일 주소를 입력해주세요.");
		}
		if(!phonereg.test(findByPhone.value)){
			alert("전화번호를 '-'를 제외하고 입력해주세요.");
		}
	}else if(findByIdEmail.value && !findByPhone.value){
		if(findByIdEmail.value.length < 13 || 
			!emailreg.test(findByIdEmail.value)){
			alert("이메일을 입력해주세요.");	
		}
	}else{
		alert("아이디를 찾으시려면 전화번호 또는 이메일을 입력해야 합니다.");
	}
	
}
findPswdBtn.onclick = () => {
	if(findPswdByEmail.value.length < 13 || 
		!emailreg.test(findPswdByEmail.value)){
		alert("이메일을 입력해주세요.");	
	}
}


