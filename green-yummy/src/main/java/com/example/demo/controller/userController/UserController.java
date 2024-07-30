package com.example.demo.controller.userController;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
*/

@Controller
public class UserController {
	
	@GetMapping("/shopApply")
	public String shopApply() {
		return "user/shopApply";
	}
	
	@GetMapping("/createReview")
	public String createReview() {
		return "user/createReview";
	}
	
}