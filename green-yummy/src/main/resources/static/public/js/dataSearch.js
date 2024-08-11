let currentPage = 1;

const itemsPerPage = 6;

let shops = [];



// 아무것도 없을 때 전체 리스트 로드

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

			loadPage(currentPage);



			const coordinatesMap = shops.map(shop => ({

				shopUkId: shop.shopUkId,

				shopName: shop.shopName,

				latlng: new kakao.maps.LatLng(shop.latitude, shop.longitude)

			}));



			map(coordinatesMap);

		})

		.catch(error => console.error('Error fetching shop data:', error));

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

		return rating;

	} catch (error) {

		console.error('Error fetching rating:', error);

		return null;

	}

}



async function displayShops(shops) {

	const shopListElement = document.getElementById('shop-list');

	shopListElement.innerHTML = '';



	const ratingRequests = shops.map(shop => getShopRating(shop.shopUkId));



	try {

		const ratings = await Promise.all(ratingRequests);





		shops.forEach((shop, index) => {

			shop.rating = ratings[index];

		});



		// 정렬 옵션이 필요하다면 여기에 추가

		// 예: shops.sort((a, b) => b.rating - a.rating);



		const shopHtml = shops.map(shop => `

            <div class="shop-item">

                <a href="/public/dataSearchDetail/${shop.shopUkId}" style="all: unset;">

                    <div class="shop-profile">

                        <img src="/images/${shop.shopProfile}" alt="${shop.shopName} 프로필 이미지" />

                    </div>

                    <div class="shopInfos">

                        <div class="infoFirst">

                            <span class="shopName">${shop.shopName}</span> <br> 

                            <span>${shop.shopType}</span> | 

                            <span>${shop.location}</span>

                        </div>

                        <div class="infoSecond">

                            <span>${shop.openHours} ~ ${shop.closeHours}</span>

                            <span>휴무 ${shop.closedDays}</span>

                        </div>

                        <p>${shop.shopTel}</p>

                        <p>${shop.etc}</p>

                    </div>

                </a>

            </div>

        `).join('');



		shopListElement.innerHTML = shopHtml;



	} catch (error) {

		console.error('Error displaying shops:', error);

		shopListElement.innerHTML = '<p>가게 정보를 불러오는 데 오류가 발생했습니다.</p>';

	}

}



// 페이지 네비게이션 업데이트

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



console.log('Option:', option);

console.log('Content:', content);



function searchByIndex() {

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

			if (data.length === 0) {

				document.getElementById('shop-list').innerHTML = '검색된 가게가 없어요';

				document.getElementById('pagination').innerHTML = '';

				return;

			}



			shops = data;

			currentPage = 1;

			loadPage(currentPage);



			const coordinatesMap = shops.map(shop => ({

				shopUkId: shop.shopUkId,

				shopName: shop.shopName,

				latlng: new kakao.maps.LatLng(shop.latitude, shop.longitude)

			}));



			map(coordinatesMap);

		})

		.catch(error => {

			console.error('Error:', error);

		});

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

	for (var i = 0; i < coordinatesMap.length; i++) {

		var imageSize = new kakao.maps.Size(24, 35);

		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);



		var marker = new kakao.maps.Marker({

			map: map,

			position: coordinatesMap[i].latlng, // 마커의 위치 설정

			image: markerImage // 마커 이미지 설정

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



// 페이지 로드 시 함수 호출

window.addEventListener('load', function() {

	if (option || content) {

		searchByIndex();

	} else {

		shoplist();

	}

});