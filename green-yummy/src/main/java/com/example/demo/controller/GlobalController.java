package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.userModel.User;
import com.example.demo.service.userService.UserServiceImpl;

@ControllerAdvice
public class GlobalController {

	@Autowired
    private UserServiceImpl userService;

    @ModelAttribute
    public void addAttributes(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("currentUser", user);
    }
}
