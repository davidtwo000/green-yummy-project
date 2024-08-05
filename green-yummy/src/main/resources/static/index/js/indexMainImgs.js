let eventImgs = document.querySelectorAll('.eventImgList > li');
let eventImgList = document.querySelector('.eventImgList');
let eventImgPrev = document.querySelector('.mainPrevBtn');
let eventImgNext = document.querySelector('.mainNextBtn');

//메인 페이지 최상단 이벤트 이미지 슬라이드. 

//li 복제해서 앞 뒤로 붙인다.
let curIdx = 0;

let firstClone = eventImgs[0].cloneNode(true);
let lastClone = eventImgs[4].cloneNode(true);

eventImgList.insertBefore(lastClone, eventImgList.firstChild);
eventImgList.appendChild(firstClone)

console.log(firstClone);
console.log(lastClone);

//앞으로 가는 함수
function goNext(){
	if(curIdx===4){
		curIdx++;
		eventImgList.style.left = -7680 + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
		
		setTimeout(() => {
					eventImgList.style.left = -1280 + "px";
					eventImgList.style.transition = "none";
					curIdx = 0;
				}, 300);
	}else{
		curIdx++;
		eventImgList.style.left = -1280*(curIdx+1) + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
	}
}

//이건 자동 슬라이드
let autoSlide = setInterval(goNext, 4000);

//setInterval 시간을 리셋시키는 함수
function intervalTimeReset(){
	clearInterval(autoSlide);
	autoSlide = setInterval(goNext, 4000);

	console.log("hello");
}

//앞으로 가는 버튼, 자동 슬라이드 시간 리셋
eventImgNext.onclick = () => {
	goNext();
	intervalTimeReset();
}


//뒤로 가는 버튼, 자동 슬라이드 시간 리셋
eventImgPrev.onclick = () => {
	if(curIdx===0){
		curIdx++;
		eventImgList.style.left = 0 + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
		
		setTimeout(() => {
						eventImgList.style.left = -6400 + "px";
						eventImgList.style.transition = "none";
						curIdx = 4;
					}, 300);
	}else{
		curIdx--;
		eventImgList.style.left = -1280*(curIdx+1) + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
	}

	intervalTimeReset();
}



