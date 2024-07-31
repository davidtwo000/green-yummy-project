package com.example.demo.controller.userController;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.service.userService.ReviewService;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
*/

@Controller
public class UserController {
	
//	@GetMapping("user/")
//	public String () {
//		return "user/";
//	}
	
	@GetMapping("user/findIdPassword")
	public String findIdPassword() {
		return "user/findIdPassword";
	}
	
	@GetMapping("user/userPage")
	public String userPage() {
		return "user/userPage";
	}
	@GetMapping("user/storeCollection")
	public String storeCollection() {
		return "user/storeCollection";
	}
	@GetMapping("user/reviewList")
	public String reviewList() {
		return "user/reviewList";
	}
	
	@GetMapping("user/userInfoChange")
	public String userInfoChange() {
		return "user/userInfoChange";
	}
	
	@GetMapping("user/createReview")
	public String createReview() {
		return "user/createReview";
	}
	
	@GetMapping("user/changeReview")
	public String changeReview() {
		return "user/changeReview";
	}
	
	@GetMapping("user/shopApply")
	public String shopApply() {
		return "user/shopApply";
	}
	
	//sg가 추가
	@Autowired
	private ReviewService reviewservice;
	
	@GetMapping("/review")
	public String review(Model model) {
		List<ReviewDTO> reviews = reviewservice.getAllReviews();
		model.addAttribute("reviews",reviews);
		return "user/reviewList";
	}
	
	
	
}