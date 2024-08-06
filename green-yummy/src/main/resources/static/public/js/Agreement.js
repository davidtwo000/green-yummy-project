
let policyChk= document.querySelectorAll(".policyBtn");
let pleaseCheck = document.querySelectorAll("input[name='agreement']");
pleaseCheck = [...pleaseCheck];

//맨 위의 전체 동의 버튼을 누르면 체크박스가 전부 체크된다.
function allAgree(){
	if(pleaseCheck[0].checked){
		pleaseCheck.forEach(comp => comp.checked=pleaseCheck[0].checked);
	}else if(!pleaseCheck[0].checked){
		pleaseCheck.forEach(comp => comp.checked=pleaseCheck[0].checked);
	}
	
}

//클릭하고 나면 버튼에 색이 들어온다.
//버튼을 누르면 팝업창이 뜬다.
function policyPop1(){
	window.open("../public/usePolicyCheckPage", "이용약관 확인", "width=400, height=400, top=50, left=50");
	policyChk[0].classList.add("checkComplete");
	
}
function policyPop2(){
	window.open("../public/privacyPolicyCheckPage", "이용약관 확인", "width=400, height=400, top=50, left=50");
	policyChk[1].classList.add("checkComplete");
}
function adPop(){
	window.open("../public/advertisementCheckPage", "광고성 메일 수신 확인", "width=400, height=400, top=50, left=50");
	policyChk[2].classList.add("checkComplete");
}

//유효성 체크. 필수항목 중 체크가 안 된 항목이 있거나, '자세히 보기'를 눌러 확인하지 않았다면 넘어가지 않는다.
function requireCheck(){
	for(let i=0;i<3;i++){
		if(pleaseCheck[i+1].checked==false){
			alert("필수항목은 반드시 동의하셔야 합니다.");
			break;
		}
		if(policyChk[i].classList.contains("checkComplete")==false){
			alert("약관을 확인해주세요.");
			break;
		}
		if((pleaseCheck[i+1].checked==true)&&(policyChk[i].classList.contains("checkComplete")==true)){
			window.location.href="/public/userRegist";
		}
	}
	
}