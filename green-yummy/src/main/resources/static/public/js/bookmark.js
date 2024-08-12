
//hm추가
const checkboxBtn = document.getElementById("bookmarkCheck");

//function bookmarkonoff(){
//	const checkboxBtn = document.getElementById("bookmarkCheck");
//	const bookmarkIcon = document.querySelector(".bookmarkIcon");
//	const bookmarkIconOff = document.querySelector(".bookmarkIconOff");
//	
//	if(checkboxBtn.checked){
//		bookmarkIcon.classList.add("hidein");
//		bookmarkIconOff.classList.remove("hidein");
//	}else if(!checkboxBtn.checked){
//		bookmarkIcon.classList.remove("hidein");
//		bookmarkIconOff.classList.add("hidein");
//	}
//	
//	let bookmarkIconClass = [...bookmarkIcon.classList];
//	let bookmarkIconOffClass = [...bookmarkIconOff.classList];
//	let bookmarkData = JSON.stringify(bookmarkIconClass);
//	let bookmarkOffData = JSON.stringify(bookmarkIconOffClass);
//	
//	localStorage.setItem("on", bookmarkIconClass);
//	localStorage.setItem("off", bookmarkIconOffClass);
//}
//
//function callClassList(){
//	const markClass = localStorage.getItem("on");
//	const unmarkClass = localStorage.getItem("off");
//	
//	const checkboxBtn = document.getElementById("bookmarkCheck");
//	const bookmarkIcon = document.querySelector(".bookmarkIcon");
//	const bookmarkIconOff = document.querySelector(".bookmarkIconOff");
//	
//	let markClassList = JSON.parse(markClass);
//	let unmarkClassList = JSON.parse(unmarkClass);
//	
//	markClassList.forEach(comp => bookmarkIcon.classList.add(comp));
//	unmarkClassList.forEach(comp => bookmarkIconOff.classList.add(comp));
//}
//
//checkboxBtn.onchange = bookmarkonoff;


//hm추가








function bookmark() {
	var checkbox = document.getElementById('bookmarkCheck');
	const userUkId = document.getElementById('userUkId').value;
	const shopUkId = document.getElementById('shopUkId').value;
	
	if (!userUkId) {
	        alert('로그인 하셔야 합니다!');
	        return; 
	    }

	if (checkbox.checked) {
		fetch(`/bookmark/add/${userUkId}/${shopUkId}`, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ userUkId, shopUkId })
		})
			.then(response => {
				if (response.ok) {
					alert('북마크가 저장되었습니다.');
				} else {
					alert('이미 저장되어 있습니다!');
				}
			})
			.catch(error => {
				console.error('Error:', error);
				alert('북마크 저장 중 오류가 발생했습니다.');
			});
	} else {
		const bookmarkRemoveModal = document.getElementById("bookmarkRemoveModal");
		bookmarkRemoveModal.style.display = "flex";
	}
	
	
}

function bookmarkRemove() {
	const userUkId = document.getElementById('userUkId').value;
	const shopUkId = document.getElementById('shopUkId').value;

	const bookmarkRemoveModal = document.getElementById("bookmarkRemoveModal");


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
			bookmarkRemoveModal.style.display = "none";
		})
		.catch(error => {
			console.error('Error:', error);
			alert('북마크 제거 중 오류가 발생했습니다.');
		});
}

function bookmarkCancel() {
	const bookmarkRemoveModal = document.getElementById("bookmarkRemoveModal");
	bookmarkRemoveModal.style.display = "none";

	var checkbox = document.getElementById('bookmarkCheck');
	checkbox.checked = true;
}

// 북마크 존재 여부 
function checkBookmark() {
	const checkbox = document.getElementById('bookmarkCheck');
	
	const userUkId = document.getElementById('userUkId').value;
	const shopUkId = document.getElementById('shopUkId').value;
	
	const url = `/bookmark/exists/${userUkId}/${shopUkId}`;
	
	

	fetch(url)
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(data => {
			//이미 있으면 체크된 상태
			if(data) {
				checkbox.checked = true;
			} else {
				//없으면 체크 안된 상태
				checkbox.checked = false;
			}
		})
		.catch(error => {
			console.error('Error fetching bookmark existence:', error);
		});
}


document.addEventListener('DOMContentLoaded', (event) => {
	checkBookmark();
});
//여기까지 sg가 기능 구현