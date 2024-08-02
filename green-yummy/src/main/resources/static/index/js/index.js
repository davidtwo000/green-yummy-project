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
window.addEventListener("load", function(){
	//한 칸 이동하고, 1초 동안 멈췄다가 또 한 칸 움직인다. 이걸 i=4가 될때까지 반복한다.
	for(let i=0;i<5;i++){
		setTimeout(() => {
			eventImgList.style.left = -1280(i+1) + "px";
			eventImgList.style.transition = "left 300ms ease-in-out";
			curIdx++;
		}, 1000);
		//마지막 사진에 도달하면 아주 빠르게 복제해둔 맨 앞의 슬라이드로 이동한다.
		if(curIdx==4){
			setTimeout(() => {
				eventImgList.style.left = -1280 + "px";
				eventImgList.style.transition = "none";
				curIdx = 0;
			}, 100);
		}
	}
});


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
