function createReview() {
    const form = document.getElementById('createReview');
    const shopUkId = form.querySelector('input[name="shopUkId"]').value;

    form.addEventListener('submit', function(event) {
        event.preventDefault();
        const formData = new FormData(form);
        const checkboxes = form.querySelectorAll('fieldset.keywordSelect input[type="checkbox"]:checked');
        const keywords = [];
        checkboxes.forEach(checkbox => {
            const label = checkbox.closest('label');
            const textContent = label ? label.textContent.trim() : '';
            keywords.push(textContent);
        });

        const keywordsString = keywords.join(',');
        formData.set('reviewComment', keywordsString);

        fetch(`/reviews/createReview/${shopUkId}`, {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('서버 오류 발생');
            }
        })
        .then(data => {
            alert('리뷰가 성공적으로 생성되었습니다.');
            window.location.href = `/public/dataSearchDetail/${shopUkId}`;
        })
        .catch(error => {
            alert('리뷰 생성 실패: ' + error.message);
        });
    });
}

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


document.addEventListener('DOMContentLoaded', function() {
    createReview();
	selectLimit();
});