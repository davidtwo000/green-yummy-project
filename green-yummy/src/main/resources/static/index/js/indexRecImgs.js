let recImgs = document.querySelectorAll('.recommandList > li');
let recImgNum = recImgs.length;
let recImgList = document.querySelector('.recommandList');
let recImgPrev = document.querySelector('.recPrevBtn');
let recImgNext = document.querySelector('.recNextBtn');

//메인 페이지 최상단 이벤트 이미지 슬라이드. 

//li 복제해서 앞 뒤로 붙인다.
let recCurIdx = 0;
let recImgWidth =380;
let recImgMargin = 40;

//li를 복제해서 앞뒤로 붙인다.
recCloneLi();

function recCloneLi(){
	
	for(let i=0;i<recImgNum;i++){
		let clone = recImgs[i].cloneNode(true);
		clone.classList.add("cloneNext");
		recImgList.appendChild(clone);//오른쪽에 붙였다
	}
	for(let j=recImgNum-1;j>=0;j--){
		let clone = recImgs[j].cloneNode(true);
		clone.classList.add("clonePrev");
		recImgList.prepend(clone);
	}
}

//클릭하면 앞뒤로 이동. 무한루프
recImgPrev.onclick = () => {
	if(recCurIdx===-recImgNum){
		recImgList.style.left = -2520 + "px";
		recImgList.style.transition = "none";
		recCurIdx = 0;
	}else{
		recCurIdx--;
		recImgList.style.left = recCurIdx*(recImgWidth + recImgMargin) + "px";
		recImgList.style.transition = "left 300ms ease-in-out";
	}
}

recImgNext.onclick = () => {
	if(recCurIdx===recImgNum*2){
		recImgList.style.left = -7560 + "px";
		recImgList.style.transition = "none";
		recCurIdx = 6;
	}else{
		recCurIdx++;
		recImgList.style.left = -recCurIdx*(recImgWidth + recImgMargin) + "px";
		recImgList.style.transition = "left 300ms ease-in-out"; 
	}
}




//let recFirstClone = recImgs[0].cloneNode(true);
//let recLastClone = recImgs[recImgNum-1].cloneNode(true);
//
//recImgList.insertBefore(recLastClone, recImgList.firstChild);
//recImgList.appendChild(recFirstClone)
//
//console.log(recFirstClone);
//console.log(recLastClone);


//앞으로 가는 버튼

//뒤로 가는 버튼