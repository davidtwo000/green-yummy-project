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
function bookmark() {
    const userUkId = document.getElementById('userUkId').value;
    const shopUkId = document.getElementById('shopUkId').value;

    fetch(`/bookmark/add/${userUkId}/${shopUkId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        // 서버 응답이 JSON 형식인지 확인
        if (!response.ok) {
            throw new Error('Network response was not ok.');
        }
        return response.json(); // JSON 응답을 반환
    })
    .then(data => {
        // 응답 데이터에서 메시지를 추출하고 알림으로 표시
        if (data.message) {
            alert(data.message); // 서버에서 반환한 메시지
        } else {
            alert("북마크가 저장되었습니다."); // 기본 메시지
        }
    })
    .catch(error => {
        console.error('Error:', error); // 오류 메시지를 콘솔에 출력
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