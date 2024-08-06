package com.example.demo.controller.userController;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.dto.userDto.UserDTO;
import com.example.demo.model.userModel.User;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.ReviewService;
import com.example.demo.service.userService.UserServiceImpl;






/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
*/

@Controller
public class UserController {
	

	
	@Autowired
	private ShopService shopservice;
	@Autowired
    private ReviewService reviewService;
	@Autowired
	private UserServiceImpl userService;
	
	
	@GetMapping("user/storeCollection")//이혜민, 추가한 부분
	public String storeCollection(Model model) {
		List<ShopDTO> shop = shopservice.getAllShops();
		model.addAttribute("shop", shop);
		return "user/storeCollection";
	}
	
	
	@GetMapping("user/userInfoChange")
	public String userInfoChange() {
		return "user/userInfoChange";
	}
	
	
	@GetMapping("user/changeReview")
	public String changeReview() {
		return "user/changeReview";
	}
	
	@GetMapping("user/shopApply")
	public String shopApply() {
		return "user/shopApply";
	}
	
	
}