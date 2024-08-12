package com.example.demo.service.publicService;

import java.util.List;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.model.publicModel.Shop;

public interface ShopService {
	// 모든 가게 리스트
	List<ShopDTO> getAllShops();

	ShopDTO getShopByUkId(Integer shopUkId);

	List<ShopDTO> findByType(String shopType);

	List<ShopDTO> findByLocation(String location);

	List<ShopDTO> findByShopName(String shopName); 

	List<Shop> getRandomShops();

}
