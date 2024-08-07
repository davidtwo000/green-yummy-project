//게시일 타입 변경
function reviewList() {
    console.log("형식 변경");
    const dateCells = document.querySelectorAll('#reviewDate');
    
    dateCells.forEach(cell => {
        const dateStr = cell.textContent || cell.innerText;
        const date = new Date(dateStr);
        const day = String(date.getDate()).padStart(2, '0');
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const year = String(date.getFullYear()).slice(2); 

        const formattedDate = `${year} / ${month} / ${day}`;

        cell.textContent = formattedDate;
    });
}

window.onload = reviewList;


let reviewIdToDelete = null;

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

//리뷰 수정 창 띄우기 
//리뷰 update로 이동

//여기까지 sg가