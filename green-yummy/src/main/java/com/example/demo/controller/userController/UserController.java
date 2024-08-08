package com.example.demo.controller.userController;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.model.userModel.User;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.ReviewService;
import com.example.demo.service.userService.UserServiceImpl;

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
	
	@GetMapping("user/changeReview")
	public String changeReview() {
		return "user/changeReview";
	}
	
	@GetMapping("user/shopApply")
	public String shopApply() {
		return "user/shopApply";
	}
	
	@GetMapping("user/userPage")
	public String review(Model model) {
		User user = userService.getCurrentUser();
        model.addAttribute("user", user);
	    return "user/userPage"; // 리뷰를 표시할 뷰 이름
	}
    
	
	
	@GetMapping("user/userInfoChange")
	public String userInfoChange(Model model) {
		
		User userJin = userService.getCurrentUser();
        model.addAttribute("user", userJin);	
		
		return "user/userInfoChange";
	}
	
	@PostMapping("/letsInfoChange")
	public String letsInfoChange() {
		return "user/userPage";
	}
	
	
}