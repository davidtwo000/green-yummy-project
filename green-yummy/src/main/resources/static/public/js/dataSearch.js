function shoplist() {
    fetch('/shops/shopList')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(shops => {
            const shopListElement = document.getElementById('shop-list');
            shopListElement.innerHTML = '';

            // 상점의 평점을 가져오기 위해 모든 상점에 대해 요청을 보냄
            const ratingRequests = shops.map(shop => {
                return fetch(`/reviews/rating/${shop.shopUkId}`)
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok ' + response.statusText);
                        }
                        return response.json();
                    })
                    .then(ratingData => {
                        // 평점 정보를 상점 객체에 추가
                        shop.rating = ratingData;
						console.log(ratingData);
                    });
            });

            // 모든 평점 요청이 완료되면 상점 목록을 업데이트
            Promise.all(ratingRequests)
                .then(() => {
                    shops.forEach(shop => {
                        const shopHtml = `
                            <div class="shop-item" onclick="window.location.href='/public/dataSearchDetail/${shop.shopUkId}'">
                                <div class="shop-profile">
                                    <img src="/images/${shop.shopProfile}" alt="${shop.shopName} 프로필 이미지" />
                                </div>
                                <table class="shopdetail">
                                    <tr> 
                                        <td class="shop-name">${shop.shopName}</td>
                                        <td>${shop.shopType}</td>
                                    </tr>
                                    <tr>
                                        <td>평점</td>
                                        <td class="shop-rating" data-shop-id="${shop.shopUkId}">${shop.rating || '정보 없음'}</td>
                                    </tr>
                                    <tr>
                                        <td>주소</td>
                                        <td>${shop.location}</td>
                                    </tr>
                                    <tr>
                                        <td>전화번호</td>
                                        <td>${shop.shopTel}</td>
                                    </tr>
                                </table>
                            </div>
                        `;
                        shopListElement.innerHTML += shopHtml;
                    });
                })
                .catch(error => console.error('Error fetching ratings:', error));
        })
        .catch(error => console.error('Error fetching shop data:', error));
}

document.addEventListener('DOMContentLoaded', function() {
    console.log("가게 리스트");
    shoplist();
});