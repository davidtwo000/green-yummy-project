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
            displayReviews(data);
        })
        .catch(error => {
            console.error('리뷰 가져오기 실패:', error);
        });
}

//코멘트 #표시
function formatCommentAsHashtags(comment) {
    const comments = comment.split(',');
    return comments.map(c => `#${c.trim()}`).join(' ');
}

//리뷰 표시
function displayReviews(reviews) {
    const reviewsContainer = document.getElementById('reviewsContainer');
    reviewsContainer.innerHTML = ''; // Clear existing reviews

    if (!reviews || reviews.length === 0) {
        reviewsContainer.innerHTML = '<tr><td colspan="5">리뷰가 없습니다.</td></tr>';
        return;
    }

    reviews.forEach(review => {
        const reviewRow = document.createElement('tr');

        reviewRow.innerHTML = `
            <td>${review.user.id}</td>
            <td>${review.reviewRate}</td>
			<td>${formatCommentAsHashtags(review.reviewComment)}</td>
            <td>${review.reviewContent}</td>
            <td>${new Date(review.reviewDate).toLocaleDateString()}</td>
        `;

        reviewsContainer.appendChild(reviewRow);
    });
}

// 리뷰 평점 계산
function displayAverageRating(shopUkId) {
    fetch(`/reviews/shop/${shopUkId}/averageRating`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); 
        })
        .then(averageRating => {
            const averageRatingElement = document.getElementById('averageRating');
            if (averageRating !== null && averageRating !== undefined) {
                averageRatingElement.textContent = `평균 평점: ${averageRating.toFixed(1)}`;
            } else {
                averageRatingElement.textContent = '평점 정보가 없습니다.';
            }
        })
        .catch(error => {
            console.error('평점 데이터 처리 오류:', error);
            const averageRatingElement = document.getElementById('averageRating');
            averageRatingElement.textContent = '평점 정보를 가져오는 중 오류가 발생했습니다.';
        });
}
document.addEventListener('DOMContentLoaded', function() {
    const shopUkId = document.getElementById('shopUkId').value;
	console.log(shopUkId);
    fetchReviews(shopUkId);
	displayAverageRating(shopUkId)
});
//여기까지 sg가 기능 구현한 것