let currentPage = 1;
const itemsPerPage = 6;
let shops = [];

// 아무것도 없을 때 전체 리스트 로드
async function shoplist() {
	try {
		// 상점 목록을 가져옵니다
		const response = await fetch('/shops/shopList');
		if (!response.ok) {
			throw new Error('Network response was not ok ' + response.statusText);
		}
		const data = await response.json();
		shops = data;

		// 상점의 평점을 가져오기 위한 요청을 생성합니다
		const ratingRequests = shops.map(shop => getShopRating(shop.shopUkId));
		const ratings = await Promise.all(ratingRequests);

		// 상점 객체에 평점을 추가합니다
		shops.forEach((shop, index) => {
			shop.rating = ratings[index] !== undefined ? ratings[index] : 0; // 평점 기본값 설정
		});

		// 평점 정렬 수행
		await sortShopsByRating();

		// 현재 페이지에 맞는 상점 표시
		loadPage(currentPage);

		// 지도 업데이트
		const coordinatesMap = shops.map(shop => ({
			shopUkId: shop.shopUkId,
			shopName: shop.shopName,
			latlng: new kakao.maps.LatLng(shop.latitude, shop.longitude)
		}));
		map(coordinatesMap);

	} catch (error) {
		console.error('Error fetching shop data:', error);
	}
}

async function sortShopsByRating() {
	const ratingRequests = shops.map(shop => getShopRating(shop.shopUkId));

	try {
		const ratings = await Promise.all(ratingRequests);

		shops.forEach((shop, index) => {
			shop.rating = ratings[index] !== null ? ratings[index] : 0; // 평점을 0으로 기본 설정
		});

		const selectedValue = reviewSort();
		if (selectedValue === 'ratingAsc' || selectedValue === null) {
			shops.sort((a, b) => a.rating - b.rating); // 오름차순
		} else if (selectedValue === 'ratingDesc') {
			shops.sort((a, b) => b.rating - a.rating); // 내림차순
		}
	} catch (error) {
		console.error('Error sorting shops by rating:', error);
	}
}

function loadPage(page) {
	const startIndex = (page - 1) * itemsPerPage;
	const endIndex = startIndex + itemsPerPage;
	const currentShops = shops.slice(startIndex, endIndex);

	displayShops(currentShops);
	updatePagination();
}

async function getShopRating(shopId) {
	try {
		const response = await fetch(`/reviews/rating/${shopId}`);
		if (!response.ok) {
			throw new Error('Network response was not ok ' + response.statusText);
		}
		const rating = await response.json();
		return rating !== null ? rating : 0;
	} catch (error) {
		return 0;
	}
}

function reviewSort() {
	const selectedOption = document.querySelector('input[name="sort"]:checked');
	console.log('Selected option value:', selectedOption ? selectedOption.value : 'None');
	return selectedOption ? selectedOption.value : null;
}

document.getElementById('sortOptions').addEventListener('change', function() {
	// 상점 목록을 다시 로드하면서 현재 페이지 유지
	sortShopsByRating().then(() => loadPage(currentPage));
});

async function sortShopsByRating() {
	// 모든 상점의 평점 요청을 생성
	const ratingRequests = shops.map(shop => getShopRating(shop.shopUkId));

	try {
		// 모든 평점 데이터를 가져오기
		const ratings = await Promise.all(ratingRequests);

		// 평점을 상점 객체에 설정
		shops.forEach((shop, index) => {
			shop.rating = ratings[index] !== undefined ? ratings[index] : 0; // 평점을 0으로 기본 설정
		});

		// 선택된 정렬 옵션 가져오기
		const selectedValue = reviewSort();
		if (selectedValue === 'ratingAsc' || selectedValue === null) {
			shops.sort((a, b) => a.rating - b.rating); // 오름차순
		} else if (selectedValue === 'ratingDesc') {
			shops.sort((a, b) => b.rating - a.rating); // 내림차순
		}
	} catch (error) {
		console.error('Error sorting shops by rating:', error);
	}
}

function loadPage(page) {
	const startIndex = (page - 1) * itemsPerPage;
	const endIndex = startIndex + itemsPerPage;
	const currentShops = shops.slice(startIndex, endIndex);

	displayShops(currentShops);
	updatePagination();
}

async function getShopRating(shopId) {
	try {
		const response = await fetch(`/reviews/rating/${shopId}`);
		if (!response.ok) {
			throw new Error('Network response was not ok ' + response.statusText);
		}
		const rating = await response.json();
		return rating !== null ? rating : 0;
	} catch (error) {
		return 0;
	}
}

function reviewSort() {
	const selectedOption = document.querySelector('input[name="sort"]:checked');
	return selectedOption ? selectedOption.value : null;
}

document.getElementById('sortOptions').addEventListener('change', function() {
	// 상점 목록을 다시 로드하면서 현재 페이지 유지
	sortShopsByRating().then(() => loadPage(currentPage));
});

async function displayShops(shops) {
	const shopListElement = document.getElementById('shop-list');
	shopListElement.innerHTML = '';  // 기존 콘텐츠 초기화

	try {
		// HTML 생성
		const shopHtml = shops.map(shop => `
            <div class="shop-item">
                <a href="/public/dataSearchDetail/${shop.shopUkId}" style="all: unset;">
                    <div class="shop-profile">
                        <img src="/images/${shop.shopProfile}" alt="${shop.shopName} 프로필 이미지" />
                    </div>
                    <div class="shopInfos">
                        <div class="infoFirst">
                            <span class="shopName">${shop.shopName}</span>
							<span>${shop.rating}</span> <br> 
							
                            <span>${shop.shopType}</span> | 
                            <span>${shop.location}</span>
                            
                        </div>
                        <div class="infoSecond">
                            <span>${shop.openHours} ~ ${shop.closeHours}</span><br>
                            <span>휴무일: ${shop.closedDays}</span>
                        </div>
                        <p>${shop.shopTel}</p>
                        <p>${shop.etc}</p>
                    </div>
                </a>
            </div>
        `).join('');

		// HTML 업데이트
		shopListElement.innerHTML = shopHtml;
	} catch (error) {
		console.error('Error displaying shops:', error);
		shopListElement.innerHTML = '<p>가게 정보를 불러오는 데 오류가 발생했습니다.</p>';
	}
}

function updatePagination() {
	const paginationElement = document.getElementById('pagination');
	paginationElement.innerHTML = '';

	const totalPages = Math.ceil(shops.length / itemsPerPage);

	for (let i = 1; i <= totalPages; i++) {
		const pageSpan = document.createElement('span');
		pageSpan.textContent = i;
		pageSpan.className = i === currentPage ? 'current' : '';
		pageSpan.addEventListener('click', () => {
			if (i !== currentPage) {
				currentPage = i;
				loadPage(currentPage);
			}
		});
		paginationElement.appendChild(pageSpan);
	}
}

// 쿼리 파라미터 추출
const params = new URLSearchParams(window.location.search);
const option = params.get('option');
const content = params.get('content');
const by = params.get('by');

console.log('Option:', option);
console.log('Content:', content);
console.log('by:', by);

//이거 검색할때랑 클릭할때 인데 검색창에 기록 남아 있게 하는건데 클릭했을때는 아직 안함
function searchBy() {
	if (by === 'search') {
		const selectBox = document.getElementById('selectBox');
		const findByOption = document.getElementById('findByOption');

		if (option) {
			selectBox.value = option;
		}
		if (content) {
			findByOption.value = content;
		}
	}
}

async function searchByIndex() {
	let url = '';
	if (!option && !content) {
		url = '/shops/shopList';
	} else if (option === 'name' && content) {
		url = '/shops/findByShopName/' + encodeURIComponent(content); // URL 인코딩
	} else if (option === 'area') {
		url = '/shops/findByLocation/' + encodeURIComponent(content); // URL 인코딩
	} else if (option === 'type') {
		url = '/shops/findByType/' + encodeURIComponent(content); // URL 인코딩
	}

	console.log(url);

	try {
		const response = await fetch(url, { method: 'GET' });
		if (!response.ok) {
			throw new Error('Network response was not ok ' + response.statusText);
		}
		const data = await response.json();

		if (data.length === 0) {
			document.getElementById('shop-list').innerHTML = '검색된 가게가 없어요';
			document.getElementById('pagination').innerHTML = '';
			return;
		}

		// 상점 데이터와 평점 데이터를 병합합니다
		shops = data;

		// 상점의 평점을 가져오기 위한 요청을 생성합니다
		const ratingRequests = shops.map(shop => getShopRating(shop.shopUkId));
		const ratings = await Promise.all(ratingRequests);

		// 상점 객체에 평점을 추가합니다
		shops.forEach((shop, index) => {
			shop.rating = ratings[index] !== undefined ? ratings[index] : 0; // 평점 기본값 설정
		});

		currentPage = 1;
		loadPage(currentPage);

		const coordinatesMap = shops.map(shop => ({
			shopUkId: shop.shopUkId,
			shopName: shop.shopName,
			latlng: new kakao.maps.LatLng(shop.latitude, shop.longitude)
		}));

		map(coordinatesMap);

	} catch (error) {
		console.error('Error:', error);
	}
}

// 지도 표시 함수
function map(coordinatesMap) {
	var mapContainer = document.getElementById('map');
	var centerLatLng = coordinatesMap.length > 0 ? coordinatesMap[0].latlng : new kakao.maps.LatLng(37.514575, 127.0495556);

	var mapOption = {
		center: centerLatLng,
		level: 6
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

	coordinatesMap.forEach(coord => {
		var imageSize = new kakao.maps.Size(24, 35);
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
		var marker = new kakao.maps.Marker({
			map: map,
			position: coord.latlng,
			image: markerImage
		});

		var iwContent = `<div style="padding:5px;">${coord.shopName || 'No info available'}</div>`;
		var infowindow = new kakao.maps.InfoWindow({
			content: iwContent,
		});

		kakao.maps.event.addListener(marker, 'mouseover', () => infowindow.open(map, marker));
		kakao.maps.event.addListener(marker, 'mouseout', () => infowindow.close());
	});
}

// 페이지 로드 시 함수 호출
window.addEventListener('load', function() {
	if (option || content || by) {
		searchByIndex();
		searchBy();
	} else {
		shoplist();
	}
});