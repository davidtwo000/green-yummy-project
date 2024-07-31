let logoutBtn = document.querySelector(".modalContainer1");
let userOut = document.querySelector(".modalContainer2");
let modalCancel = document.querySelectorAll(".cancel");

let storeTab = document.querySelctor(".storeTab");
let reviewTab = document.querySelector(".reviewTab");

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

function myTab(){
	if(storeTab.classList.contains('youHere')){
		reviewTab.onclick = () => {
			reviewTab.classList.add('youHere');
			storeTab.classList.remove('youHere');
		}
		storeTab.onclick = () => {
			return false;
		}
	}else if(reviewTab.classList.contains('youHere')){
		storeTab.onclick = () => {
			storeTab.classList.add('youHere');
			reviewTab.classList.remove('youHere');
		}
		reviewTab.onclick = () => {
			return false;
		}
	}
}
window.onload = () => myTab();


