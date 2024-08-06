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
    reviewsContainer.innerHTML = '';
	
	console.log('Reviews:', reviews);

    if (!reviews || reviews.length === 0) {
        reviewsContainer.innerHTML = '<tr><td colspan="5">리뷰가 없습니다.</td></tr>';
        return;
    }

    reviews.forEach(review => {
        const reviewRow = document.createElement('tr');

        reviewRow.innerHTML = `
            <td>${review.user.id}</td>
            <td>${review.reviewRating}</td>
			<td>${formatCommentAsHashtags(review.reviewComment)}</td>
            <td>${review.reviewContent}</td>
			<td>${review.reviewImg}</td>
            <td>${new Date(review.reviewDate).toLocaleDateString()}</td>
        `;

        reviewsContainer.appendChild(reviewRow);
    });
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

//리뷰 이미 작성했으면 alert 뜨게
function checkReview() {
    const shopUkId = document.getElementById('shopUkId').value;
    const userUkId = document.getElementById('userUkId').value;

    console.log(shopUkId);
    console.log(userUkId);

    fetch('/reviews/check', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            shopUkId: shopUkId,
            userUkId: userUkId
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data) {
            alert('이미 리뷰를 작성하셨습니다.');
        } else {
            window.location.href=`/user/createReview/${shopUkId}`
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

document.addEventListener('DOMContentLoaded', function() {
    const shopUkId = document.getElementById('shopUkId').value;
	console.log(shopUkId);
    fetchReviews(shopUkId);
	averageRating(shopUkId);
});
//여기까지 sg가 기능 구현한 것