let logoutBtn = document.querySelector(".modalContainer1");
let userOut = document.querySelector(".modalContainer2");
let modalCancel = document.querySelectorAll(".cancel");

let storeTab = document.querySelector(".storeTab");
let storePage = document.querySelector(".stores");
let reviewTab = document.querySelector(".reviewTab");
let reviewPage = document.querySelector(".reviews");


//회원 정보란의 버튼들. 각각 회원정보수정, 로그아웃, 회원탈퇴 버튼.
function infoChange(){
	window.location.href="/user/userInfoChange";
}
function logout(){
	if(logoutBtn.classList.contains("hidden")){
		logoutBtn.classList.remove("hidden");
	}else{
		logoutBtn.classList.add("hidden");
	}
}
function userBye(){
	if(userOut.classList.contains("hidden")){
		userOut.classList.remove("hidden");
	}else{
		userOut.classList.add("hidden");
	}
}

//탭 메뉴. 나의 맛집, 나의 리뷰.
//클릭을 한 쪽에 클래스를 주려면?

reviewTab.onclick = () => {
	if(!reviewTab.classList.contains('youHere')){
		reviewTab.classList.add('youHere');
		reviewPage.classList.remove('hidden');
		storeTab.classList.remove('youHere');
		storePage.classList.add('hidden');
	}else{
		return true;
	}
}
storeTab.onclick = () => {
	if(!storeTab.classList.contains('youHere')){
		storeTab.classList.add('youHere');
		storePage.classList.remove('hidden');
		reviewTab.classList.remove('youHere');
		reviewPage.classList.add('hidden');
	}else{
		return true;
	}
}



