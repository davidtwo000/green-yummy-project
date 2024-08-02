let recImgs = document.querySelectorAll('.recommandList > li');
let recImgList = document.querySelector('.recommandList');
let recImgPrev = document.querySelector('.recPrevBtn');
let recImgNext = document.querySelector('.recNextBtn');

//메인 페이지 최상단 이벤트 이미지 슬라이드. 

//li 복제해서 앞 뒤로 붙인다.
let recCurIdx = 0;

let recFirstClone = recImgs[0].cloneNode(true);
let recLastClone = recImgs[recImgs.length-1].cloneNode(true);

recImgList.insertBefore(recLastClone, recImgList.firstChild);
recImgList.appendChild(recFirstClone)

console.log(recFirstClone);
console.log(recLastClone);


//뒤로 가는 버튼
recImgPrev.onclick = () => {
	if(recCurIdx===0){
		recCurIdx++;
		recImgList.style.left = 0 + "px";
		recImgList.style.transition = "left 300ms ease-in-out";
		
		setTimeout(() => {
						recImgList.style.left = -6400 + "px";
						recImgList.style.transition = "none";
						recCurIdx = recImgs.length-1;
					}, 300);
	}else{
		recCurIdx--;
		recImgList.style.left = -300*(recCurIdx+1) + "px";
		recImgList.style.transition = "left 300ms ease-in-out";
	}
}

//앞으로 가는 버튼
recImgNext.onclick = () => {
	if(recCurIdx===recImgs.length-1){
		recCurIdx++;
		recImgList.style.left = -300(recImgs.length) + "px";
		recImgList.style.transition = "left 300ms ease-in-out";
		
		setTimeout(() => {
					recImgList.style.left = -1280 + "px";
					recImgList.style.transition = "none";
					recCurIdx = 0;
				}, 300);
	}else{
		recCurIdx++;
		recImgList.style.left = -300*(recCurIdx+1) + "px";
		recImgList.style.transition = "left 300ms ease-in-out";
	}
}
