package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.service.publicService.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopRestController {

	@Autowired
	private ShopService shopService;

	@GetMapping("/shopList")
	public List<ShopDTO> getAllShops() {
		return shopService.getAllShops();
	}
	
	//가게 이름으로 찾기
	@GetMapping("/findByShopName/{shopName}")
	public ResponseEntity<List<ShopDTO>> findByShopName(@PathVariable("shopName") String shopName) {
		List<ShopDTO> shops = shopService.findByShopName(shopName);
		return ResponseEntity.ok().body(shops);
	}

	// 가게 업종별로 찾기
	@GetMapping("/findByType/{shopType}")
	public ResponseEntity<List<ShopDTO>> findByType(@PathVariable("shopType") String shopType) {
		List<ShopDTO> shops = shopService.findByType(shopType);
		return ResponseEntity.ok().body(shops);
	}
	
	//가게 주소별로 찾기
	@GetMapping("/findByLocation/{location}")
	public ResponseEntity<List<ShopDTO>> findByLocation(@PathVariable("location") String location) {
		List<ShopDTO> shops = shopService.findByLocation(location);
		return ResponseEntity.ok().body(shops);
	}
}