let gridBtn = document.querySelector(".gridview");
let listBtn = document.querySelector(".listview");
let gridPlace = document.querySelector(".storeCollectGrid");
let listPlace = document.querySelector(".storeCollectList");

//맨 오른쪽의 버튼을 누르면 바둑판/리스트 형식으로 정렬방식을 바꿀 수 있다.
//classList로 영역을 숨기고 드러내는 정도.
gridBtn.onclick = () => {
		gridPlace.classList.remove('invisible');
		listPlace.classList.add('invisible');
}
listBtn.onclick = () => {
		listPlace.classList.remove('invisible');
		gridPlace.classList.add('invisible');
}