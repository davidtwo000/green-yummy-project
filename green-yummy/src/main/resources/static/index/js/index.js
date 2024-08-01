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

//자동 슬라이드


//뒤로 가는 버튼
eventImgPrev.onclick = () => {
		if(curIdx==0){
			curIdx++;
			eventImgList.style.left = 0 + "px";
			eventImgList.style.transition = "left 300ms ease-in-out";
			
			setTimeout(() => {
							eventImgList.style.left = -6400 + "px";
							eventImgList.style.transition = "none";
							curIdx = 4;
						}, 100);
		}else if(curIdx==1){
			curIdx--;
			eventImgList.style.left = -1280 + "px";
			eventImgList.style.transition = "left 300ms ease-in-out";
		}else if(curIdx==2){
			curIdx--;
			eventImgList.style.left = -2560 + "px";
			eventImgList.style.transition = "left 300ms ease-in-out";
		}else if(curIdx==3){
			curIdx--;
			eventImgList.style.left = -3840 + "px";
			eventImgList.style.transition = "left 300ms ease-in-out";
		}else if(curIdx==4){
			curIdx--;
			eventImgList.style.left = -5120 + "px";
			eventImgList.style.transition = "left 300ms ease-in-out";
		}
}

//앞으로 가는 버튼
eventImgNext.onclick = () => {
	if(curIdx==0){
		curIdx++;
		eventImgList.style.left = -2560 + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
	}else if(curIdx==1){
		curIdx++;
		eventImgList.style.left = -3840 + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
	}else if(curIdx==2){
		curIdx++;
		eventImgList.style.left = -5120 + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
	}else if(curIdx==3){
		curIdx++;
		eventImgList.style.left = -6400 + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
	}else if(curIdx==4){
		curIdx++;
		eventImgList.style.left = -7680 + "px";
		eventImgList.style.transition = "left 300ms ease-in-out";
		
		setTimeout(() => {
					eventImgList.style.left = -1280 + "px";
					eventImgList.style.transition = "none";
					curIdx = 0;
				}, 100);
	}
}
