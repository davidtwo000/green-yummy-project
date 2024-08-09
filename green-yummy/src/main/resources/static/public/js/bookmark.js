function bookmark() {
	var checkbox = document.getElementById('bookmarkCheck');
	const userUkId = document.getElementById('userUkId').value;
	const shopUkId = document.getElementById('shopUkId').value;


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
		bookmarkRemoveModal.style.display = "block";
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