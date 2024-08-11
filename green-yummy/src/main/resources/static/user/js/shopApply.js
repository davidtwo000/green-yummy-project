let shopName = document.getElementById("shopName");
let shopLocation = document.getElementById("shopLocation");
let shopPhone = document.getElementById("shopPhone");
let shopReason = document.getElementById("shopReason");

let shopform = document.getElementById("shopApply");

let phonereg = /[\d]{2,3}[\d]{3,4}[\d]{4}/;

//내용을 적어야만 넘어가게 하는 함수. 불필요한 내용은 함수에서 삭제한다.
function applyCheck(){
	
	if(!shopName.value){
		alert("맛집 이름을 입력해 주세요.");
		shopName.focus();
		return false;
	}
	
	let foodTypeChecked = document.querySelector('input[name="foodType"]:checked');
	if (!foodTypeChecked) {
        alert("음식 유형을 선택해 주세요.");
        return false;
    }
    
	if(!shopLocation.value){
		alert("맛집 주소를 입력해 주세요.");
		shopLocation.focus();
		return false;
	}
	
	if(!shopPhone.value){
		alert("맛집 연락처를 입력해 주세요.");
		shopPhone.focus();
		return false;
	}else if(phonereg.test(shopPhone.value)==false){
		alert("전화번호는 '-'를 제외하고 숫자만 입력해 주세요.");
		shopPhone.focus();
		return false;
	}
	
	if(!shopReason.value){
		alert("신청 이유를 적어 주세요.");
		shopReason.focus();
		return false;
	}else if(shopReason.value.length > 300) {
        alert("신청 이유는 간단히 적어 주세요.");
        shopReason.focus();
        return false;
    }
	
	return true;
}





















/*
let label = document.querySelector("label");
let emptybox = document.getElementById("addPhoto");
let addfile = document.getElementById("file");

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


<tr>
	<th>기타사항</th>
	<td colspan="3"><input type="text" 
	placeholder="예약 가능, 테이크아웃 전문, 반려동물 동반 가능 등등"
	id="shopEtc"></td>
</tr>
<tr>
	<td colspan="4">
		<p>*사진 추가하기</p>
		<div class="photoPlace">
			<label for="file"><img src="/images/addPhoto.png" id="addPhoto"></label>
			<input type="file" id="file" class="hidden">
		</div>
	</td>
</tr>
*/
