let currentPage = 1;

//보여지는 개수
const itemsPerPage = 5;
let shops = [];

//아무것도 없을때 전체
function shoplist() {
	fetch('/shops/shopList')
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok ' + response.statusText);
			}
			return response.json();
		})
		.then(data => {
			shops = data;
			console.log(data);
			loadPage(currentPage);

			const coordinatesMap = shops.map(shop => ({
				shopUkId: shop.shopUkId,
				shopName: shop.shopName,
				latlng: new kakao.maps.LatLng(shop.latitude, shop.longitude)
			}));

			console.log('Coordinates Map:', coordinatesMap);
			map(coordinatesMap);
		})
		.catch(error => console.error('Error fetching shop data:', error));
}

// 현재 페이지에 맞는 가게 목록을 로드하는 함수
function loadPage(page) {
	const startIndex = (page - 1) * itemsPerPage;
	const endIndex = startIndex + itemsPerPage;
	const currentShops = shops.slice(startIndex, endIndex);

	displayShops(currentShops); // 현재 페이지의 가게 목록을 표시
	updatePagination(); // 페이지 네비게이션 업데이트
}

async function getShopRating(shopId) {
	try {
		const response = await fetch(`/reviews/rating/${shopId}`);
		if (!response.ok) {
			throw new Error('Network response was not ok ' + response.statusText);
		}
		const rating = await response.json();
		return rating;
	} catch (error) {
		console.error('Error fetching rating:', error);
		return null;
	}
}

// 가게 목록을 HTML로 변환하여 표시하는 함수
async function displayShops(shops) {
	const shopListElement = document.getElementById('shop-list');
	shopListElement.innerHTML = '';

	// 평점 요청을 위한 배열
	const ratingRequests = shops.map(shop => getShopRating(shop.shopUkId));

	try {
		// 모든 평점 요청을 병렬로 실행
		const ratings = await Promise.all(ratingRequests);

		// 평점을 shops 배열에 추가
		shops.forEach((shop, index) => {
			shop.rating = ratings[index];
		});

		const shopHtml = shops.map(shop => `
            <div class="shop-item">
                <div class="shop-profile">
                    <img src="/images/${shop.shopProfile}" alt="${shop.shopName} 프로필 이미지" />
                </div>
                <table class="shopdetail">
                    <tr class="shop-row" data-shop-id="${shop.shopUkId}">
                        <td class="shop-name">${shop.shopName}</td>
                        <td>${shop.shopType}</td>
                    </tr>
                    <tr>
                        <td>평점</td>
                        <td>${shop.rating ? shop.rating.toFixed(1) : ''}</td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td>${shop.location}</td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td>${shop.shopTel}</td>
                    </tr>
                    <tr>
                        <td>오픈 시간</td>
                        <td>${shop.openHours}</td>
                    </tr>
                    <tr>
                        <td>닫는 시간</td>
                        <td>${shop.closeHours}</td>
                    </tr>
                    <tr>
                        <td>휴무일</td>
                        <td>${shop.closedDays}</td>
                    </tr>
                    <tr>
                        <td>기타 사항</td>
                        <td>${shop.etc}</td>
                    </tr>
                </table>
            </div>
        `).join('');

		shopListElement.innerHTML = shopHtml;

		// 클릭 이벤트 리스너 추가
		document.querySelectorAll('.shop-row').forEach(row => {
			row.addEventListener('click', function() {
				const shopId = this.getAttribute('data-shop-id');
				window.location.href = `/public/dataSearchDetail/${shopId}`;
			});
		});

	} catch (error) {
		console.error('Error displaying shops:', error);
		shopListElement.innerHTML = '<p>가게 정보를 불러오는 데 오류가 발생했습니다.</p>';
	}
}

// 페이지 네비게이션을 업데이트하는 함수
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


// 가게 검색하기
function findShop() {
	const findByOption = document.getElementById("findByOption");
	const selectBox = document.getElementById('selectBox');

	let url = '';
	if (!findByOption.value && selectBox.value === '') {
		url = '/shops/shopList';
	} else if (selectBox.value === '' && findByOption.value) {
		url = '/shops/findByShopName/' + encodeURIComponent(findByOption.value);
	} else if (selectBox.value === 'area') {
		url = '/shops/findByLocation/' + encodeURIComponent(findByOption.value);
	} else if (selectBox.value === 'type') {
		url = '/shops/findByType/' + encodeURIComponent(findByOption.value);
	}

	fetch(url, {
		method: 'GET',
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok ' + response.statusText);
			}
			return response.json();
		})
		.then(data => {
			shops = data;
			currentPage = 1; // 페이지를 1로 리셋하여 첫 페이지부터 로드
			loadPage(currentPage);

			const coordinatesMap = shops.map(shop => ({
				shopUkId: shop.shopUkId,
				shopName: shop.shopName,
				latlng: new kakao.maps.LatLng(shop.latitude, shop.longitude)
			}));

			console.log('Coordinates Map:', coordinatesMap);
			map(coordinatesMap);


		})
		.catch(error => {
			console.error('Error:', error);
		});
}


//지도 표시
function map(coordinatesMap) {
    var mapContainer = document.getElementById('map'); // Get the map container
    var mapOption = { 
        center: new kakao.maps.LatLng(37.514034, 127.10567), // Map center coordinate
        level: 3 // Map zoom level
    };

    var map = new kakao.maps.Map(mapContainer, mapOption); // Create the map
    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

    for (var i = 0; i < coordinatesMap.length; i++) {
        var imageSize = new kakao.maps.Size(24, 35);  
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 

        var marker = new kakao.maps.Marker({
            map: map,
            position: coordinatesMap[i].latlng, 
            image: markerImage // Marker image
        });

        var iwContent = `<div style="padding:5px;">${coordinatesMap[i].shopName || 'No info available'}</div>`;
        var infowindow = new kakao.maps.InfoWindow({
            content: iwContent,
        });


        kakao.maps.event.addListener(marker, 'mouseover', (function(marker, infowindow) {
            return function() {
                infowindow.open(map, marker);
            };
        })(marker, infowindow));

        kakao.maps.event.addListener(marker, 'mouseout', (function(infowindow) {
            return function() {
                infowindow.close();
            };
        })(infowindow));
    }
}

document.addEventListener('scroll', function() {
    // 스크롤 이벤트 핸들러 코드
}, { passive: true });


document.addEventListener('DOMContentLoaded', function() {
	shoplist();
	map();
});

//여기까지 sg