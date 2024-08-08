package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}