package com.example.demo.controller.userController;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.UserFormDTO;
import com.example.demo.model.userModel.Bookmark;
import com.example.demo.model.userModel.User;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.BookmarkImpl;
import com.example.demo.service.userService.BookmarkService;
import com.example.demo.service.userService.ReviewService;
import com.example.demo.service.userService.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	

	
	@Autowired
	private ShopService shopservice;
	@Autowired
    private ReviewService reviewService;
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private BookmarkImpl bookmarkService;
	
	
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
	    return "user/userPage"; 
	}
    
	
	@GetMapping("user/userInfoChange")
	public String userInfoChange(Model model) {
		
		User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);	
		
		return "user/userInfoChange";
	}
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@PostMapping("/letsInfoChange")
	public String letsInfoChange(@ModelAttribute UserFormDTO form, HttpSession session) {
		
		User user = userService.getCurrentUser();
        
		if (user != null) {
            if (form.getNickname() != null && !form.getNickname().isEmpty() && !form.getNickname().equals(user.getNickname())) {
                user.setNickname(form.getNickname());
            }
            if (form.getPhone() != null && !form.getPhone().isEmpty() && !form.getPhone().equals(user.getPhone())) {
                user.setPhone(form.getPhone());
            }
            if (form.getEmail() != null && !form.getEmail().isEmpty() && !form.getEmail().equals(user.getEmail())) {
                user.setEmail(form.getEmail());
            }
            if (form.getPassword() != null && !form.getPassword().isEmpty()) {
                String hashedPassword = passwordEncoder.encode(form.getPassword());
                user.setPassword(hashedPassword);
            }
            
            userService.updateUser(user);

            return "redirect:/user/userPage";
        }
		
		return "redirect:/public/userLogin";
	}
	
	
}