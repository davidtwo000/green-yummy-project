package com.example.demo.service.publicService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.model.publicModel.Shop;
import com.example.demo.repository.publicRepository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<ShopDTO> getAllShops() {
        return shopRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShopDTO getShopByUkId(Integer shopUkId) {
        return shopRepository.findById(shopUkId)
            .map(this::convertToDto)
            .orElse(null);
    }
    //가게 이름
    @Override
	public List<ShopDTO> findByShopName(String shopName) {
		List<Shop> shops = shopRepository.findByShopNameContaining(shopName);
		return shops.stream().map(this::convertToDto).collect(Collectors.toList());
	}
 
    //유형별
    @Override
    public List<ShopDTO> findByType(String shopType) {
        List<Shop> shops = shopRepository.findByShopType(shopType);
        return shops.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    //위치별
    @Override
    public List<ShopDTO> findByLocation(String location) {
    	List<Shop> shops = shopRepository.findByLocationContaining(location);
    	return shops.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private ShopDTO convertToDto(Shop shop) {
        ShopDTO dto = new ShopDTO();
        dto.setShopUkId(shop.getShopUkId());
        dto.setShopName(shop.getShopName());
        dto.setShopProfile(shop.getShopProfile());
        dto.setShopType(shop.getShopType());
        dto.setLocation(shop.getLocation());
        dto.setShopTel(shop.getShopTel());
        dto.setOpenHours(shop.getOpenHours());
        dto.setCloseHours(shop.getCloseHours());
        dto.setClosedDays(shop.getClosedDays());
        dto.setEtc(shop.getEtc());
        dto.setLatitude(shop.getLatitude());
        dto.setLongitude(shop.getLongitude());
        return dto;
    }

	
}