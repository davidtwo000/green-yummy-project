let eventImgs = document.querySelectorAll('.mainImg');
let eventImgList = document.querySelector('.eventImgList');
let eventImgPrev = document.querySelector('.mainPrevBtn');
let eventImgNext = document.querySelector('.mainNextBtn');

//메인 페이지 최상단 이벤트 이미지 슬라이드.

let curIdx = 0;

let firstEimgClone = eventImgs[0].cloneNode(true);
let lastEimgClone = eventImgs[4].cloneNode(true);
eventImgList.insertBefore(lastEimgClone, eventImgs[0]);
eventImgList.appendChild(firstEimgClone);

eventImgPrev.onclick = () => {
	if(curIdx==0){
		curIdx++;
		eventImgs.style.left = -1280 + "px";
	}
}
eventImgNext.onclick = () => {
	
}
