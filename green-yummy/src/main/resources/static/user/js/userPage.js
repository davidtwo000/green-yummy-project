let logoutBtn = document.querySelector(".modalContainer1");
let userOut = document.querySelector(".modalContainer2");
let modalCancel = document.querySelectorAll(".cancel");

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
