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