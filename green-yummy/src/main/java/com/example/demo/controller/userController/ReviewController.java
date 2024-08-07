package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.model.userModel.User;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.ReviewService;
import com.example.demo.service.userService.UserServiceImpl;

@Controller
public class ReviewController {
	@Autowired
    private ReviewService reviewService;
	
	@Autowired
	private ShopService shopService;
    
	@Autowired 
	private UserServiceImpl userService;
	
  //식당 정보 가져와서 createReview 창 띄우기
    @GetMapping("user/createReview/{shopUkId}")
    public String showCreateReviewForm(@PathVariable("shopUkId") Integer shopUkId, Model model) {
        ShopDTO shop = shopService.getShopByUkId(shopUkId);
        model.addAttribute("shop", shop); 
        
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
   
        return "user/createReview"; 
    }
    
    // 리뷰 수정 창 띄우기
    @GetMapping("user/updateReview/{reviewId}")
    public String showUpdateReviewForm(@PathVariable("reviewId") Integer reviewId, Model model) {
        List<ReviewDTO> review = reviewService.getReviewsByReviewId(reviewId); // 단일 리뷰 조회
        model.addAttribute("review", review); // 모델에 리뷰 데이터 추가
        
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        
        return "user/updateReview"; // 수정 폼을 보여주는 뷰 이름
    }
 
}