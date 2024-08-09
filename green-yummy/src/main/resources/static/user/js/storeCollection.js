let gridBtn = document.querySelector(".gridview");
let listBtn = document.querySelector(".listview");
let gridPlace = document.querySelector(".storeCollectGrid");
let listPlace = document.querySelector(".storeCollectList");

//맨 오른쪽의 버튼을 누르면 바둑판/리스트 형식으로 정렬방식을 바꿀 수 있다.
//classList로 영역을 숨기고 드러내는 정도.
gridBtn.onclick = () => {
	if (gridPlace.classList.contains("invisible")) {
		gridPlace.classList.remove('invisible');
		gridPlace.style.display = "grid";
		listPlace.classList.add('invisible');

		console.log(gridPlace.classList);
	}
}

listBtn.onclick = () => {
	if (!gridPlace.classList.contains("invisible")) {
		listPlace.classList.remove('invisible');
		gridPlace.classList.add('invisible');
		gridPlace.style.display = "none";
	} else {
		return true;
	}

}

function bookmarkremove(userUkId, shopUkId) {
	console.log(userUkId);
	console.log(shopUkId);

	fetch(`/bookmark/remove/${userUkId}/${shopUkId}`, {
		method: 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		}

	})
		.then(response => {
			if (response.ok) {
				return response.text();
			} else {
				throw new Error('북마크 제거에 실패했습니다.');
			}
		})
		.then(message => {
			alert(message);
			
			//제거되고 로드
			setTimeout(() => {
				window.location.reload();
			}, 300); 
		})
		.catch(error => {
			console.error('Error:', error);
			alert('북마크 제거 중 오류가 발생했습니다.');
		});
}