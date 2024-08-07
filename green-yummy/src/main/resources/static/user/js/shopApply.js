let shopname = document.getElementById("shopName");
let shoploc = document.getElementById("shopLoc");
let shoptel = document.getElementById("shopTel");
let shopopen = document.getElementById("shopOpen");
let shopclose = document.getElementById("shopClose");
let shoprest = document.getElementById("shopRest");
let shopetc = document.getElementById("shopEtc");

let shopform = document.getElementById("shopapply");


function applyCheck(e){
	if(!shopname.value){
		alert("가게명을 입력해 주세요.");
		e.preventDefault();
		shopname.focus();
		return false;
	}
	if(!shoploc.value){
		alert("주소를 입력해 주세요.");
		e.preventDefault();
		shoploc.focus();
		return false;
	}
	if(!shoptel.value){
		alert("연락처를 입력해 주세요.");
		e.preventDefault();
		shoptel.focus();
		return false;
	}
	if(!shopopen.value){
		alert("개장 시간을 입력해 주세요.");
		e.preventDefault();
		shopopen.focus();
		return false;
	}
	if(!shopclose.value){
		alert("폐장 시간을 입력해 주세요.");
		e.preventDefault();
		shopclose.focus();
		return false;
	}
	if(!shoprest.value){
		alert("휴무일을 입력해 주세요.");
		e.preventDefault();
		shoprest.focus();
		return false;
	}
	if(!shopetc.value){
		alert("기타사항을 입력해 주세요.");
		e.preventDefault();
		shopetc.focus();
		return false;
	}
	
	return true;
}

