//let recImgs = document.querySelectorAll('.recommandList > li');
////let recImgs = document.querySelecorAll('.recommandDetail > li');
//let recImgNum = recImgs.length;
let recImgList = document.querySelector('.recommandList');

//recCloneLi();

let recImgPrev = document.querySelector('.recPrevBtn');
let recImgNext = document.querySelector('.recNextBtn');

//메인 페이지 최상단 이벤트 이미지 슬라이드. 

//li 복제해서 앞 뒤로 붙인다.
let recCurIdx = 0;
let recImgWidth =380;
let recImgMargin = 40;
let maxIdx = 3;
let minIdx = 0;

//li를 복제해서 앞뒤로 붙인다.


//function recCloneLi(){
//	
//	for(let i=0;i<recImgNum/2;i++){
//		let clone = recImgs[i].cloneNode(true);
//		clone.classList.add("cloneNext");
//		recImgList.appendChild(clone);//오른쪽에 붙였다
//	}
//	for(let j=5;j>=3;j--){
//		let clone = recImgs[j].cloneNode(true);
//		clone.classList.add("clonePrev");
//		recImgList.prepend(clone);
//	}
//
//
//}

//클릭하면 앞뒤로 이동. 무한루프


recImgNext.onclick = () => {
	if(recCurIdx<maxIdx){
		recCurIdx++;
		recImgList.style.left = -recCurIdx*(recImgWidth + recImgMargin) + "px";
		recImgList.style.transition = "left 300ms ease-in-out"; 
	}
}

recImgPrev.onclick = () => {
	if(recCurIdx>minIdx){
		recCurIdx--;
		recImgList.style.left = -(recCurIdx)*(recImgWidth + recImgMargin) + "px";
		recImgList.style.transition = "left 300ms ease-in-out";
	}
}


// 평점을 가져오는 함수
//async function getShopRating(shopId) {
//   try {
//      const response = await fetch(`/reviews/rating/${shopId}`);
//      if (!response.ok) {
//         throw new Error('Network response was not ok ' + response.statusText);
//      }
//      const rating = await response.json();
//      return rating !== null ? rating : 0;
//   } catch (error) {
//      console.error('There was a problem with the fetch operation:', error);
//      return 0;
//   }
//}

async function getShopRating(shopId) {
    try {
        const response = await fetch(`/reviews/rating/${shopId}`);
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        const rating = await response.json();
        return rating !== null ? parseFloat(rating).toFixed(1) : '0.0';
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
        return 0;
    }
}


// 랜덤 상점 데이터를 가져오는 함수
async function random() {
    try {
        const response = await fetch('/shops/random', {
            method: 'GET'
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const data = await response.json();
        console.log(data);

        // <ul> 요소 선택
        const recommandList = document.getElementById('recommandList');
        
        // 기존 <li> 요소를 모두 제거
        recommandList.innerHTML = '';

        // 데이터 배열을 순회하며 리스트 아이템 생성
        for (const item of data) {
            const li = document.createElement('li');

            // 상점 이미지 부분
            const imgContainer = document.createElement('div');
            imgContainer.className = 'recommandImgCon';
            
            const img = document.createElement('img');
            img.src = '/images/' + item.shopProfile;
            img.className = 'recommandImg';
            imgContainer.appendChild(img);
            
            // 상점 상세 정보 부분
			const detailOut = document.createElement('div');
			detailOut.className = 'outRecommand';
            const detailInner = document.createElement('div');
            detailInner.className = 'recommandDetail'; // 스타일링 클래스
			
						detailOut.appendChild(detailInner);
			
			//span 안에 타입이랑 평점 넣어서 따로 스타일 주기
			const detailType = document.createElement('span');
			detailType.className = 'detailType';
			const detailRate = document.createElement('span');
			detailRate.className = 'detailRate';
			const detailLoc = document.createElement('span');
			const brplace = document.createElement('br');
			detailLoc.className = 'detailLoc';

            // 상점 평점 가져오기
            const rating = await getShopRating(item.shopUkId);
			console.log(rating);

            // 상세 정보에 평점 추가
            detailInner.textContent = `${item.shopName} `;
			detailRate.textContent = `${rating}`
			detailType.textContent = `${item.shopType}`;
			detailLoc.textContent = `${item.location}`;
			
			
			
			detailInner.appendChild(detailRate);
			detailInner.appendChild(detailType);
			detailInner.appendChild(brplace);
			detailInner.appendChild(detailLoc);
			
			
			
            
            // <li>에 이미지와 상세 정보를 추가
            li.appendChild(imgContainer);
            li.appendChild(detailOut);

            li.addEventListener('click', () => {
                window.location.href = `/public/dataSearchDetail/${item.shopUkId}`;
            });
            
            // <ul>에 <li> 추가
            recommandList.appendChild(li);
        }
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

window.onload = () => {
    random();
};




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