let shopname = document.getElementById("shopName");
let shoploc = document.getElementById("shopLoc");
let shoptel = document.getElementById("shopTel");
let shopopen = document.getElementById("shopOpen");
let shopclose = document.getElementById("shopClose");
let shoprest = document.getElementById("shopRest");
let shopetc = document.getElementById("shopEtc");

let label = document.querySelector("label");
let shopform = document.getElementById("shopapply");
let emptybox = document.getElementById("addPhoto");
let addfile = document.getElementById("file");

//내용을 적어야만 넘어가게 하는 함수. 불필요한 내용은 함수에서 삭제한다.
function applyCheck(event){
	if(!shopname.value){
		alert("가게명을 입력해 주세요.");
		event.preventDefault();
		shopname.focus();
		return false;
	}
	if(!shoploc.value){
		alert("주소를 입력해 주세요.");
		event.preventDefault();
		shoploc.focus();
		return false;
	}
	if(!shoptel.value){
		alert("연락처를 입력해 주세요.");
		event.preventDefault();
		shoptel.focus();
		return false;
	}
	if(!shopopen.value){
		alert("개장 시간을 입력해 주세요.");
		event.preventDefault();
		shopopen.focus();
		return false;
	}
	if(!shopclose.value){
		alert("폐장 시간을 입력해 주세요.");
		event.preventDefault();
		shopclose.focus();
		return false;
	}
	if(!shoprest.value){
		alert("휴무일을 입력해 주세요.");
		event.preventDefault();
		shoprest.focus();
		return false;
	}
	if(!shopetc.value){
		alert("기타사항을 입력해 주세요.");
		event.preventDefault();
		shopetc.focus();
		return false;
	}
	
	return true;
}

//회색 빈 박스 이미지가 삽입한 이미지로 바뀌는 함수
addfile.addEventListener("change", shopPhotos);

function shopPhotos(){
	let myShopPhoto = addfile.files[0];
	let reader = new FileReader();
	
//	let filename = addfile.value;
	
	reader.onload = function(event){
		let imgurl = event.target.result;
		let thumbnail = document.createElement("img");
		emptybox.classList.add("hidden");
		label.appendChild(thumbnail);
		thumbnail.src = imgurl;
		thumbnail.style.opacity = "1";
				
		console.log(imgurl);
	};
	
	reader.readAsDataURL(myShopPhoto);
	
}

