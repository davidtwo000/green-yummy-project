package com.example.demo.service.publicService;

import java.util.List;

import com.example.demo.dto.publicDto.ShopDTO;


public interface ShopService {
	//모든 가게 리스트
	List<ShopDTO> getAllShops();

	ShopDTO getShopByUkId(Integer shopUkId);
}
