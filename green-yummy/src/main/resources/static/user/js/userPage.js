let logoutBtn = document.querySelector(".modalContainer1");
let userOut = document.querySelector(".modalContainer2");
let modalCancel = document.querySelectorAll(".cancel");

let storeTab = document.querySelector(".storeTab");
let storePage = document.querySelector("#tab1");
let reviewTab = document.querySelector(".reviewTab");
let reviewPage = document.querySelector("#tab2");


//회원 정보란의 버튼들. 각각 회원정보수정, 로그아웃, 회원탈퇴 버튼.
function infoChange() {
	window.location.href = "/user/userInfoChange";
}
function logout() {
	if (logoutBtn.classList.contains("hidden")) {
		logoutBtn.classList.remove("hidden");
	} else {
		logoutBtn.classList.add("hidden");
	}
}
function userBye() {
	if (userOut.classList.contains("hidden")) {
		userOut.classList.remove("hidden");
	} else {
		userOut.classList.add("hidden");
	}
}


//탭 메뉴. 나의 맛집, 나의 리뷰.
//클릭을 한 쪽에 클래스를 주려면?


reviewTab.onclick = (e) => {
	if (!reviewTab.classList.contains('youHere')) {
		e.preventDefault();
		reviewTab.classList.add('youHere');
		reviewPage.classList.remove('hidden');
		storeTab.classList.remove('youHere');
		storePage.classList.add('hidden');
	} else {
		return true;
	}
}
storeTab.onclick = (e) => {
	if (!storeTab.classList.contains('youHere')) {
		e.preventDefault();
		storeTab.classList.add('youHere');
		storePage.classList.remove('hidden');
		reviewTab.classList.remove('youHere');
		reviewPage.classList.add('hidden');
	} else {
		return true;
	}
}



///여기서부터 sg가
function myreviewList() {
	const userUkId = document.getElementById('userUkId').value;

	fetch(`/reviews/myreview/${userUkId}`, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(data => {
			console.log('Reviews fetched successfully:', data);
			populateReviews(data);
		})
		.catch(error => {
			console.error('There was a problem with the fetch operation:', error);
		});
}

function populateReviews(reviews) {
	const table = document.querySelector('#tab2 table');

	const rows = table.querySelectorAll('tr:not(:first-child)');
	rows.forEach(row => row.remove());

	reviews.forEach((review, index) => {
		const row = document.createElement('tr');

		row.innerHTML = `
            <td>${index + 1}</td>
            <td>
			<a href="/public/dataSearchDetail/${review.shop.shopUkId}">
			${review.shop.shopName}
			</a>
			</td>
            <td>${review.reviewContent}</td>
            <td>${review.reviewRating}</td>
            <td>${new Date(review.reviewDate).toLocaleDateString()}</td>
            <td><button onclick="updateReview(${review.reviewId})" class="updateBtn">수정</button></td>
            <td><button onclick="showDeleteModal(${review.reviewId})" class="deleteBtn">삭제</button></td>
        `;

		table.appendChild(row);
	});

	const reviewTabLink = document.getElementById('reviewTabLink');
	reviewTabLink.textContent = `나의 리뷰(${reviews.length}개)`;
}

function showDeleteModal(reviewId) {
	reviewIdToDelete = reviewId;
	document.getElementById('deleteModalContainer').classList.remove('hidden');
}

function hideDeleteModal() {
	document.getElementById('deleteModalContainer').classList.add('hidden');
	reviewIdToDelete = null;
}

//리뷰 삭제
function confirmDelete() {
	fetch(`/reviews/delete/${reviewIdToDelete}`, {
		method: 'DELETE'
	})
		.then(response => {
			if (response.ok) {
				window.location.reload();
			} else {
				alert('리뷰 삭제에 실패했습니다.');
			}
		})
		.catch(error => {
			console.error('Error:', error);
			alert('리뷰 삭제에 실패했습니다.');
		})
		.finally(() => {
			hideDeleteModal();
		});
}

function updateReview(reviewId) {
	console.log("Navigating to review edit page with ID:", reviewId);
	window.location.href = `/user/updateReview/${reviewId}`; // PathVariable을 사용한 URL로 수정
}



document.addEventListener('DOMContentLoaded', (event) => {
	myreviewList();
});

document.addEventListener('DOMContentLoaded', function() {

	var userProfile = document.getElementById('userProfile').value;
	var profileImage = document.getElementById('profileImage');

	if (userProfile) {
		profileImage.src = '/upload/' + userProfile;
	} else {
		profileImage.src = '/images/person.png';
	}
});



/*
<input type="button" value="탈퇴">

function userDel(){
	const userId = document.getElementById('userDelId').value;
    
	// AJAX 요청을 통해 유저 삭제 요청 전송
	fetch(`/deleteUser/${userId}`, {
		method: 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		}
	})
	.then(response => {
		if (response.ok) {
			alert("회원탈퇴가 완료되었습니다.");
			window.location.href = '/logout';  // 탈퇴 후 로그아웃 및 메인 페이지로 리다이렉트
		} else {
			alert("회원탈퇴에 실패했습니다. 다시 시도해 주세요.");
		}
	})
	.catch(error => console.error('Error:', error));
}
*/
