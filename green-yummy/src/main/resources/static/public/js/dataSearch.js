let currentPage = 1;



//보여지는 개수

const itemsPerPage = 6;

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

		// 모든 평점 요청을 병렬로 실행

		const ratings = await Promise.all(ratingRequests);



		// 평점을 shops 배열에 추가

		shops.forEach((shop, index) => {

			shop.rating = ratings[index];

		});



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

                            <span>${shop.closedDays} 휴무</span>

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





//카테고리 클릭시

function check(data) {
   console.log(data);

   let url = '';
   if (data === 'all') {
      url = '/shops/shopList';
   } else if (data.startsWith('area')) {
      const location = data.replace('area', ''); // 'area'를 제거하여 지역만 남기기
      url = '/shops/findByLocation/' + encodeURIComponent(location);
   } else if (data.startsWith('type')) {
      const location = data.replace('type', ''); // 'type'을 제거하여 타입만 남기기
      url = '/shops/findByType/' + encodeURIComponent(location);
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
         if (data.length === 0) {
            document.getElementById('shop-list').innerHTML = '검색된 가게가 없어요';
            document.getElementById('pagination').innerHTML = ''
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







// 가게 검색하기

function findShop(data) {
   const findByOption = document.getElementById("findByOption");
   const selectBox = document.getElementById('selectBox');


   let url = '';
   if (!findByOption.value && selectBox.value === '') {
      url = '/shops/shopList';
   } else if (selectBox.value === 'name' && findByOption.value) {
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
         if (data.length === 0) {
            document.getElementById('shop-list').innerHTML = '검색된 가게가 없어요';
            document.getElementById('pagination').innerHTML = ''
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





document.addEventListener('scroll', function() {



}, { passive: true });



document.querySelectorAll('.pagination span').forEach(page => {

	page.addEventListener('click', function() {

		document.querySelector('.pagination .page-number.active')?.classList.remove('active');



		this.classList.add('active');

	});

});





window.addEventListener('load', function() {

	console.log("오픈");

	shoplist();

	map();

});

//여기까지 sg