document.addEventListener('DOMContentLoaded', function() {
	selectLimit();
	getReview();
	
    const form = document.getElementById('updateReviewForm');
	
	//review id찾기
    const currentUrl = window.location.href;
    const urlParts = currentUrl.split('/');
    const reviewId = parseInt(urlParts[urlParts.length - 1], 10);

    document.querySelector('input[name="reviewId"]').value = reviewId;

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // 기본 폼 제출 동작 방지

        const form = document.getElementById('updateReviewForm');
		
		const formData = new FormData(form);
		//코멘트 check박스 형식 변경
		
		const checkboxes = form.querySelectorAll('fieldset.keywordSelect input[type="checkbox"]:checked');
		const keywords = [];
		checkboxes.forEach(checkbox => {
			const label = checkbox.closest('label');
			const textContent = label ? label.textContent.trim() : '';
				keywords.push(textContent);
			});

			const keywordsString = keywords.join(',');
			formData.set('reviewComment', keywordsString);

        // 폼 데이터를 객체로 변환
        const reviewData = {
            reviewId: formData.get('reviewId'),
            reviewRating: formData.get('reviewRating'),
            reviewComment: formData.get('reviewComment'),
            reviewContent: formData.get('reviewContent')
        };

        // 콘솔에 데이터 출력
        console.log('Form Data:', reviewData);

        // fetch를 사용하여 PUT 요청 보내기
        fetch(`/reviews/update/${reviewData.reviewId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                reviewRating: reviewData.reviewRating,
                reviewComment: reviewData.reviewComment,
                reviewContent: reviewData.reviewContent
            })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            alert('리뷰가 성공적으로 수정되었습니다.');
             window.location.href = `/user/userPage`;
        })
        .catch(error => {
            alert('리뷰 수정에 실패했습니다: ' + error.message);
            console.error('Error:', error);
        });
    });
	
});

function selectLimit() {
    console.log("selectLimit function called");
    const checkboxes = document.querySelectorAll('fieldset.keywordSelect input[type="checkbox"]');
    
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            const checkedCount = document.querySelectorAll('fieldset.keywordSelect input[type="checkbox"]:checked').length;
            
            if (checkedCount > 3) {
                alert('최대 3개의 선택만 가능합니다.');
                checkbox.checked = false;
            }
        });
    });
}

function getReview() {
    // 현재 URL에서 리뷰 ID를 추출
    const currentUrl = window.location.href;
    const urlParts = currentUrl.split('/');
    const reviewId = parseInt(urlParts[urlParts.length - 1], 10);

    console.log(`Review ID: ${reviewId}`);

    // API 호출
    fetch(`/reviews/${reviewId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        return response.json(); // JSON 데이터로 변환
    })
    .then(data => {
        console.log('Review Data:', data); 
		
		//내용
		console.log(data.reviewContent);
		const reviewContentField = document.getElementById('reviewContent');
		reviewContentField.value = data.reviewContent;
		
		// 평점
		const reviewRate = data.reviewRate;
		const rateButtons = document.querySelectorAll('fieldset.rateSelect input[type="radio"]');
		rateButtons.forEach(button => {
			if (button.value === reviewRate.toString()) {
				button.checked = true;
			}
    	})
		
		// 코멘트 체크박스
		const reviewComments = data.reviewComment.split(',');
		console.log(reviewComments);
		const checkboxes = document.querySelectorAll('fieldset.keywordSelect input[type="checkbox"]');
		console.log(checkboxes);
		
		checkboxes.forEach(checkbox => {
			const label = checkbox.closest('label');
			const labelText = label ? label.textContent.trim() : '';
				if (reviewComments.includes(labelText)) {
					checkbox.checked = true;
				}
			});
			
	})
    .catch(error => {
        console.error('Fetch error:', error);
    });
}