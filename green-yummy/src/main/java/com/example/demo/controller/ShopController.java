package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.model.userModel.User;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.UserServiceImpl;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@Autowired 
	private UserServiceImpl userService;
	
	@GetMapping("public/dataSearch")
	public String shop(Model model) {
		List<ShopDTO> shops = shopService.getAllShops();
		model.addAttribute("shops",shops);
		return "public/dataSearch";
	}
	
	@GetMapping("public/dataSearchDetail/{shopUkId}")
    public String getShopDetail(@PathVariable("shopUkId") Integer shopUkId, Model model) {
        ShopDTO shop = shopService.getShopByUkId(shopUkId);
        
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        
        if (shop != null) {
            model.addAttribute("shop", shop);
            return "public/dataSearchDetail"; // 상점 정보를 표시할 JSP 파일 이름
        } else {
            return "error"; // 상점을 찾을 수 없는 경우 에러 페이지로 이동
        }
        
       
    }
}