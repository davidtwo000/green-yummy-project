async function getShopRating(shopId) {
	try {
		const response = await fetch(`/reviews/rating/${shopId}`);
		if (!response.ok) {
			throw new Error('Network response was not ok ' + response.statusText);
		}
		const rating = await response.json();
		return rating !== null ? rating : 0;
	} catch (error) {
		console.error('There was a problem with fetching the rating:', error);
		return 0;
	}
}

//가게명, 평점으로 정렬
async function getorder() {
	const order = document.getElementById("order").value;
	console.log('Order value:', order);

	const orderelement = document.getElementById("order")
	orderelement.style.color = "#BB2929";

	//나머지는 선택 안되게
	const filterOne = document.querySelector('.filterOne');
	const filterTwo = document.querySelector('.filterTwo');


	if (order) {
		filterOne.value = '';
		filterTwo.value = '';
		filterOne.style.color = ''; // 'filterOne'의 배경색을 기본값으로 복원합니다.
		filterTwo.style.color = '';
	} else {
		filterOne.value = '';
		filterTwo.value = '';
		filterOne.style.color = ''; // 'filterOne'의 배경색을 기본값으로 복원합니다.
		filterTwo.style.color = '';
	}

	const userUkId = document.getElementById('userUkId').value;
	try {
		const response = await fetch(`/bookmark/mybookmark/${userUkId}`, {
			method: 'GET'
		});

		if (!response.ok) {
			throw new Error('네트워크 응답이 좋지 않습니다: ' + response.statusText);
		}

		const data = await response.json();


		const shopRatingsPromises = data.map(async (item) => {
			const rating = await getShopRating(item.shopUkId);
			return { ...item, rating };
		});

		const dataWithRatings = await Promise.all(shopRatingsPromises);
		console.log('Data with ratings:', dataWithRatings);

		const sortedData = dataWithRatings.sort((a, b) => {
			if (order === 'ratingAsc') {
				return a.rating - b.rating; // 평점을 기준으로 오름차순 정렬
			} else if (order === 'ratingDesc') {
				return b.rating - a.rating; // 평점을 기준으로 내림차순 정렬
			} else if (order === 'nameAsc') {
				return a.shopName.localeCompare(b.shopName); // 상점 이름을 기준으로 오름차순 정렬
			} else if (order === 'nameDesc') {
				return b.shopName.localeCompare(a.shopName); // 상점 이름을 기준으로 내림차순 정렬
			} else {
				console.warn('Unrecognized order value:', order);
				return 0; // 정렬 기준이 잘못된 경우 원래 순서 유지
			}
		});

		await myBookmarkList(sortedData);
	} catch (error) {
		console.error('fetch 작업에 문제가 발생했습니다:', error);
	}
}

// 지역별 필터링
async function filterlocation() {
	const selectedLocation = document.querySelector('.filterOne').value;

	const userUkId = document.getElementById('userUkId').value;

	const orderelement = document.getElementById("filterOne")
	orderelement.style.color = "#BB2929";

	//나머지는 선택 안되게
	const filterTwo = document.querySelector('.filterTwo');
	const order = document.querySelector('.order');

	if (selectedLocation) {
		filterTwo.value = '';
		order.value = '';
		filterTwo.style.color = ''; // 'filterOne'의 배경색을 기본값으로 복원합니다.
		order.style.color = '';
	} else {
		filterTwo.value = '';
		order.value = '';
		filterTwo.style.color = ''; // 'filterOne'의 배경색을 기본값으로 복원합니다.
		order.style.color = '';
	}

	try {
		const response = await fetch(`/bookmark/mybookmark/${userUkId}`, {
			method: 'GET'
		});

		if (!response.ok) {
			throw new Error('네트워크 응답이 좋지 않습니다: ' + response.statusText);
		}

		const data = await response.json();


		const shopRatingsPromises = data.map(async (item) => {
			const rating = await getShopRating(item.shopUkId);
			return { ...item, rating };
		});

		const dataWithRatings = await Promise.all(shopRatingsPromises);


		const filteredData = dataWithRatings.filter(item => {
			return item.location === selectedLocation || !selectedLocation;
		});
		await myBookmarkList(filteredData);

	} catch (error) {
		console.error('fetch 작업에 문제가 발생했습니다:', error);
	}
}

//업종별
async function filtertype() {
	const selectedType = document.querySelector('.filterTwo').value;
	console.log('Selected type:', selectedType);

	const orderelement = document.getElementById("filterTwo")
	orderelement.style.color = "#BB2929";


	//나머지는 선택 안되게
	const filterOne = document.querySelector('.filterOne');
	const order = document.querySelector('.order');

	if (selectedType) {
		filterOne.value = '';
		order.value = '';
		filterOne.style.color = ''; // 'filterOne'의 배경색을 기본값으로 복원합니다.
		order.style.color = '';
	} else {
		filterOne.value = '';
		order.value = '';
		filterOne.style.color = ''; // 'filterOne'의 배경색을 기본값으로 복원합니다.
		order.style.color = '';
	}

	const userUkId = document.getElementById('userUkId').value;

	try {
		const response = await fetch(`/bookmark/mybookmark/${userUkId}`, {
			method: 'GET'
		});

		if (!response.ok) {
			throw new Error('네트워크 응답이 좋지 않습니다: ' + response.statusText);
		}

		const data = await response.json();


		// 상점 평점 가져오기
		const shopRatingsPromises = data.map(async (item) => {
			const rating = await getShopRating(item.shopUkId);
			return { ...item, rating };
		});

		const dataWithRatings = await Promise.all(shopRatingsPromises);
		console.log('Data with ratings:', dataWithRatings);

		// 데이터 필터링
		const filteredData = dataWithRatings.filter(item => {
			return item.shopType === selectedType || !selectedType;
		});

		console.log('Filtered data:', filteredData);

		// 필터링된 데이터로 목록 업데이트
		await myBookmarkList(filteredData);

	} catch (error) {
		console.error('fetch 작업에 문제가 발생했습니다:', error);
	}
}


//아무것도 없을때 
async function mybookmark() {

	const userUkId = document.getElementById('userUkId').value;
	try {
		const response = await fetch(`/bookmark/mybookmark/${userUkId}`, {
			method: 'GET'
		});

		if (!response.ok) {
			throw new Error('네트워크 응답이 좋지 않습니다: ' + response.statusText);
		}

		const data = await response.json();

		const bookmarkTabLink = document.getElementById('bookmarkTabLink');
		bookmarkTabLink.textContent = `나의 맛집(${data.length}개)`;

		const shopRatingsPromises = data.map(async (item) => {
			const rating = await getShopRating(item.shopUkId);
			return { ...item, rating };
		});

		const dataWithRatings = await Promise.all(shopRatingsPromises);

		await myBookmarkList(dataWithRatings);
	} catch (error) {
		console.error('There was a problem with the fetch operation:', error);
	}


}

let currentPage = 1;
const itemsPerPage = 8;



async function myBookmarkList(data) {
	const myBookmarkList = document.getElementById('myBookmarkList');
	const pagination = document.getElementById("pagination");
	// 데이터가 비어있을 경우
	if (data.length === 0) {
		myBookmarkList.innerHTML = '<li>북마크가 없습니다.</li>';

		return;
	}

	// 총 페이지 수 계산
	const totalPages = Math.ceil(data.length / itemsPerPage);

	function renderPage(page) {
		const start = (page - 1) * itemsPerPage;
		const end = start + itemsPerPage;
		const pageData = data.slice(start, end);

		// HTML 문자열 초기화
		let html = '';

		// 각 항목에 대해 HTML을 생성
		pageData.forEach(({ shopUkId, shopName, shopProfile, location, rating }) => {
			html += `
                <li>
                    <a href="/public/dataSearchDetail/${shopUkId}">
                        <img src="/images/${shopProfile}" alt="${shopName}">
                        <div class="bookShopInfo">
                            <span>${shopName}</span>
                            <span>${rating}</span>
                            <span>${location}</span>
                        </div>
                    </a>
                    <div class="bookmarkBtn">
                        <img src="/images/bookmark.png" onclick="bookmarkremove(${shopUkId})" alt="Remove bookmark">
                    </div>
                </li>
            `;
		});

		myBookmarkList.innerHTML = html;
		updatePagination(page);
	}

	function updatePagination(page) {
		pagination.innerHTML = '';

		for (let i = 1; i <= totalPages; i++) {
			const button = document.createElement('span');
			button.textContent = i;
			button.classList.add('page-btn');
			button.disabled = (i === page);

			// 현재 페이지 버튼에 'current' 클래스를 추가합니다.
			if (i === page) {
				button.classList.add('current');
			} else {
				button.classList.remove('current');
			}

			button.addEventListener('click', () => {
				currentPage = i;
				renderPage(currentPage);
			});

			pagination.appendChild(button);
		}
	}

	// 초기 페이지 렌더링
	renderPage(currentPage);
}

function bookmarkremove(shopUkId) {
	const userUkId = document.getElementById('userUkId').value;
	console.log("유저 아이디: " + userUkId);
	console.log("가게 아이디: " + shopUkId);

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

			//제거되고 로드
			setTimeout(() => {
				window.location.reload();
			}, 300);
		})
		.catch(error => {
			console.error('Error:', error);
			alert('북마크 제거 중 오류가 발생했습니다.');
		});
}



window.onload = function() {
	mybookmark();
};