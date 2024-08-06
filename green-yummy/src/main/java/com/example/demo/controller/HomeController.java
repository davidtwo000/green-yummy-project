package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.userModel.User;
import com.example.demo.service.userService.UserServiceImpl;

@Controller
public class HomeController {

	@GetMapping("/public/home")
    public String publicHome(Model model) {
		User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "public/home";
    }

	@Autowired 
	private UserServiceImpl userService;
	
    @GetMapping("/user/home")
    public String userHome(Model model) {
    	User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "user/home";
    }

    @GetMapping("/login")
    public String login() {
        return "public/userLogin";
    }
        
    @PostMapping("/userJoin")
    public String userJoin() {
    	return "public/userRegist";
    }
}
