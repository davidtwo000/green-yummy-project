//가게 해당 리뷰 가져오기
function fetchReviews(shopUkId, page = 1) {
	fetch(`/reviews/shop/${shopUkId}`)
		.then(response => {
			if (!response.ok) {
				throw new Error('네트워크 오류');
			}
			return response.json();
		})
		.then(data => {
			console.log(data);
			displayReviews(data, page); // 페이지 번호와 함께 데이터 전달
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


function displayReviews(reviews, page = 1) {
	const reviewsContainer = document.getElementById('reviewsContainer');
	const modal = document.getElementById('modal');
	const modalBody = document.getElementById('modalBody');
	const closeBtn = document.getElementById('closeBtn');
	const pagination = document.getElementById('pagination');

	const reviewsPerPage = 5;
	let currentPage = page;

	// Create table structure
	const table = document.createElement('table');
	table.classList.add('reviews-table');

	const thead = document.createElement('thead');
	thead.innerHTML = `
        <tr>
            <th>사진</th>
            <th>아이디</th>
            <th>평점</th>
            <th>내용</th>
            <th>날짜</th>
        </tr>
    `;
	table.appendChild(thead);

	const start = (currentPage - 1) * reviewsPerPage;
	const end = start + reviewsPerPage;
	const paginatedReviews = reviews.slice(start, end);

	const tbody = document.createElement('tbody');

	paginatedReviews.forEach(review => {
		const row = document.createElement('tr');

		// Convert reviewComment to formatted text with # separator
		const formattedComment = review.reviewComment
			.split(',')
			.map(comment => `#${comment}`)
			.join(' ');

		row.innerHTML = `
			    <td class="review-img-container">
			        <img src="${review.reviewImg ? `/upload/${review.reviewImg}` : '/upload/logo.png'}" 
			             alt="Review Image" 
			             class="review-img" />
			    </td>
			    <td>${review.user.id}</td>
			    <td>${review.reviewRating}</td>
			    <td>
			        <p>${formattedComment}</p>
			        ${review.reviewContent}
			    </td>
			    <td>${formatDate(review.reviewDate)}</td>
			`;
		// Add click event to open modal
		row.addEventListener('click', (event) => {
			if (!event.target.classList.contains('review-checkbox')) {
				modalBody.innerHTML = `
                    ${review.reviewImg ? `<img src="/upload/${review.reviewImg}" alt="Review Image" class="review-detail-img" />` : ''}
                    <div class="reviewUser"><span> ${review.user.id}</span>
                    <span>${review.reviewRating}</span>
                    <span>${review.reviewDate.substr(2, 8)}</span></div>
                    <div class="userComment"><p>${formattedComment}</p>
                    ${review.reviewContent}</div>
                `;
				modal.style.display = 'block';
			}
		});

		tbody.appendChild(row);
	});

	table.appendChild(tbody);
	reviewsContainer.innerHTML = '';
	reviewsContainer.appendChild(table);

	const totalPages = Math.ceil(reviews.length / reviewsPerPage);
	pagination.innerHTML = '';

	for (let i = 1; i <= totalPages; i++) {
		const span = document.createElement('span');
		span.textContent = i;
		span.classList.add('pagination-button');
		if (i === currentPage) {
			span.classList.add('current'); // 현재 페이지에 'current' 클래스 추가
		}
		span.addEventListener('click', () => {
			displayReviews(reviews, i); // 페이지 번호를 인자로 전달
		});
		pagination.appendChild(span);
	}

	closeBtn.addEventListener('click', () => {
		modal.style.display = 'none';
	});

	window.addEventListener('click', (event) => {
		if (event.target === modal) {
			modal.style.display = 'none';
		}
	});

	reviewsContainer.addEventListener('change', (event) => {
		if (event.target.classList.contains('review-checkbox')) {
			handleCheckboxChange(event.target);
		}
	});
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
			document.getElementById('averageRating').textContent = '';
		});
}


function createReview(shopUkId) {
	const userUkId = document.getElementById('userUkId').value;

	if (!userUkId) {
		alert('로그인 후 리뷰를 작성해주세요.');
		return;
	}


	fetch(`/reviews/hasReviewed/${shopUkId}/${userUkId}`)
		.then(response => response.json())
		.then(hasReviewed => {
			if (hasReviewed) {
				alert('리뷰를 이미 작성했습니다.');
			} else {
				// 리뷰 작성 페이지로 이동
				window.location.href = `/user/createReview/${shopUkId}`;
			}
		})
		.catch(error => {
			console.error('Error checking review status:', error);
			alert('An error occurred while checking your review status.');
		});
}


function random() {
	fetch('/shops/random', { // 6개의 랜덤 데이터를 요청
		method: 'GET'
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok ' + response.statusText);
			}
			return response.json();
		})
		.then(data => {
			console.log(data);
			const filteredData = data.slice(0, 5);

			const random = document.getElementById('random');
			random.innerHTML = '';

			filteredData.forEach(item => {
				console.log(item);

				const div = document.createElement('div');
				div.className = 'randomRestaurant';

				const imgContainer = document.createElement('div');
				imgContainer.className = 'recommandImgContainer';
				const img = document.createElement('img');

				img.src = '/images/' + item.shopProfile;
				img.setAttribute('title', `${item.shopName}` + "(" + `${item.shopType}` + ")");
				img.className = 'recommandImg';
				imgContainer.appendChild(img);

				const detail = document.createElement('div');
				const detailShop = document.createElement('span');
				const detailType = document.createElement('span');
				detailShop.textContent = `${item.shopName}`; // 상점 이름과 타입
				detail.appendChild(detailShop);
				detailShop.setAttribute('title', `${item.shopName}` + "(" + `${item.shopType}` + ")");
				detailType.textContent = `${item.shopType}`;
				detail.appendChild(detailType);
				detailType.setAttribute('title', `${item.shopName}` + "(" + `${item.shopType}` + ")");
				detail.className = 'recommandDetail'; // 스타일링 클래스
				detailShop.className = 'detailShop';
				detailType.className = 'detailType';

				div.appendChild(imgContainer);
				div.appendChild(detail);

				div.addEventListener('click', () => {
					window.location.href = `/public/dataSearchDetail/${item.shopUkId}`;
				});

				random.appendChild(div);
			});
		})
		.catch(error => {
			console.error('There was a problem with the fetch operation:', error);
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
	fetchReviews(shopUkId, 1);

	random();
});