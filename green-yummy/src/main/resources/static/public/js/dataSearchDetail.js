//가게 해당 리뷰 가져오기
function fetchReviews(shopUkId) {
	fetch(`/reviews/shop/${shopUkId}`)
		.then(response => {
			if (!response.ok) {
				throw new Error('네트워크 오류');
			}
			return response.json();
		})
		.then(data => {
			console.log(data);
			displayReviews(data);
		})
		.catch(error => {
			console.error('리뷰 가져오기 실패:', error);
		});
}

//날짜 형식 바꾸기
function formatDate(dateStr) {
	const date = new Date(dateStr);
	const day = String(date.getDate()).padStart(2, '0');
	const month = String(date.getMonth() + 1).padStart(2, '0');
	const year = String(date.getFullYear()).slice(-2); // Get last 2 digits of the year
	return `${year}/${month}/${day}`;
}


function displayReviews(reviews) {
	const reviewsContainer = document.getElementById('reviewsContainer');
	const modal = document.getElementById('modal');
	const modalBody = document.getElementById('modalBody');
	const closeBtn = document.getElementById('closeBtn');

	// Create table structure
	const table = document.createElement('table');
	table.classList.add('reviews-table');

	const thead = document.createElement('thead');
	thead.innerHTML = `
	    <tr>
	        <th>사진</th>
	        <th>아이디</th>
	        <th>평점</th>
	        <th>코멘트</th>
	        <th>내용</th>
	        <th>날짜</th>
	        <th>좋아요</th>
	    </tr>
	`;
	table.appendChild(thead);

	reviews.forEach(review => {
		const row = document.createElement('tr');

		// Convert reviewComment to formatted text with # separator
		const formattedComment = review.reviewComment
			.split(', ')
			.map(comment => `#${comment}`)
			.join(' ');

		row.innerHTML = `
            <td class="review-img-container">${review.reviewImg ? `<img src="/upload/${review.reviewImg}" alt="Review Image" class="review-img" />` : ''}</td>
            <td>${review.user.id}</td>
            <td>${review.reviewRating}</td>
            <td>${formattedComment}</td>
            <td>${review.reviewContent}</td>
			<td>${formatDate(review.reviewDate)}</td>
			<td><input type="checkbox" class="review-checkbox" data-review-id="${review.reviewId}" /> 좋아요 버튼</td>
        `;

		// Add click event to open modal
		row.addEventListener('click', (event) => {
			if (!event.target.classList.contains('review-checkbox')) {
				modalBody.innerHTML = `
					${review.reviewImg ? `<img src="/upload/${review.reviewImg}" alt="Review Image" class="review-detail-img" />` : ''}
					<div> 작성자 ${review.user.id}</div>
					<div>${review.reviewRating}</div>
					<div>${formattedComment}</div>
					<div>${review.reviewContent}</div>
				`;
				modal.style.display = 'block';
			}
		});


		table.appendChild(row);
	});

	reviewsContainer.innerHTML = '';
	reviewsContainer.appendChild(table);


	closeBtn.addEventListener('click', () => {
		modal.style.display = 'none';
	});

	window.addEventListener('click', (event) => {
		if (event.target === modal) {
			modal.style.display = 'none';
		}
	});

	// Event delegation for checkbox clicks
	reviewsContainer.addEventListener('change', (event) => {
		if (event.target.classList.contains('review-checkbox')) {
			handleCheckboxChange(event.target);
		}
	});
}
//코멘트 #표시
function formatCommentAsHashtags(comment) {
	const comments = comment.split(',');
	return comments.map(c => `#${c.trim()}`).join(' ');
}


//좋아요체크
function handleCheckboxChange(checkbox) {
	const reviewId = checkbox.getAttribute('data-review-id');
	const isChecked = checkbox.checked;

	console.log(`Review ID: ${reviewId}, Checked: ${isChecked}`);

}




function averageRating(shopUkId) {
	fetch(`/reviews/rating/${shopUkId}`)
		.then(response => response.json())
		.then(averageRating => {
			let formattedRating = averageRating.toFixed(1);
			document.getElementById('averageRating').textContent = `${formattedRating}`;
		})
		.catch(error => {
			console.error('Failed to fetch average rating:', error);
			document.getElementById('averageRating').textContent = '평균 평점: 정보를 불러올 수 없습니다.';
		});
}


function createReview(shopUkId) {
	window.location.href = `/user/createReview/${shopUkId}`;
}

//북마크 저장
function addBookmark() {
	const userUkId = document.getElementById('userUkId').value;
	const shopUkId = document.getElementById('shopUkId').value;

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
}

//북마크 해제
function removeBookmark() {
    const userUkId = document.getElementById('userUkId').value;
    const shopUkId = document.getElementById('shopUkId').value;

    fetch(`/bookmark/remove/${userUkId}/${shopUkId}`, {
        method: 'DELETE',  // 메서드를 대문자로 수정
        headers: {
            'Content-Type': 'application/json'
        }
        // DELETE 요청에서는 body를 포함하지 않습니다
    })
    .then(response => {
        if (response.ok) {
            return response.text();  // 응답을 텍스트로 변환
        } else {
            throw new Error('북마크 제거에 실패했습니다.');
        }
    })
    .then(message => {
        alert(message);  // 응답 메시지 표시
    })
    .catch(error => {
        console.error('Error:', error);
        alert('북마크 제거 중 오류가 발생했습니다.');
    });
}

document.addEventListener('DOMContentLoaded', (event) => {
	//돌아가기
	const backButton = document.getElementById('backButton');

	backButton.addEventListener('click', () => {
		window.location.href = '/public/dataSearch'; // URL을 원하는 경로로 변경
	});

	const shopUkId = document.getElementById('shopUkId').value;
	console.log(shopUkId);

	const userUkId = document.getElementById('userUkId').value;
	console.log(userUkId);

	averageRating(shopUkId);
	fetchReviews(shopUkId);
});
//여기까지 sg가 기능 구현한 것