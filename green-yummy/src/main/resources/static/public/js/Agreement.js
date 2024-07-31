
let policyCheck= document.querySelctorAll(".policyBtn");
let policyChk = Array.from(policyCheck);

//클릭하고 나면 버튼에 색이 들어온다.
//버튼을 누르면 팝업창이 뜬다.

function policyPop1(){
	window.open("../public/usePolicyCheckPage", "이용약관 확인", "width=400, height=400, top=50, left=50");
	policyChk[0].style.backgroundColor = "red";
}
function policyPop2(){
	window.open("../public/privacyPolicyCheckPage", "이용약관 확인", "width=400, height=400, top=50, left=50");
}
function adPop(){
	window.open("../public/advertisementPolicyCheckPage", "광고성 메일 수신 확인", "width=400, height=400, top=50, left=50")
}