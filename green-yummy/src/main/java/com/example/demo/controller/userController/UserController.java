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
	

	
	@GetMapping("user/userPage")
	public String userPage() {
		return "user/userPage";
	}
	@GetMapping("user/storeCollection")
	public String storeCollection() {
		return "user/storeCollection";
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
	
	
}