package com.example.demo.controller.userController;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.UserFormDTO;
import com.example.demo.model.adminModel.Application;
import com.example.demo.model.adminModel.ApplicationStatus;
import com.example.demo.model.userModel.Bookmark;
import com.example.demo.model.userModel.User;
import com.example.demo.repository.userRepository.UserFindRepository;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.BookmarkImpl;
import com.example.demo.service.userService.BookmarkService;
import com.example.demo.service.userService.ReviewService;
import com.example.demo.service.userService.ShopApplyService;
import com.example.demo.service.userService.UserServiceImpl;
import com.example.demo.util.FileUploadService;

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
	public String shopApply(Model model) {
		
		User user = userService.getCurrentUser();
        model.addAttribute("user", user); 
        
		return "user/shopApply";
	}
	
	@Autowired
	private ShopApplyService shopApplyService;
	
	@PostMapping("/applyShop")
	public String applyShop(@RequestParam("shopName") String shopName,
            @RequestParam("foodType") String foodType,
            @RequestParam("shopLocation") String shopLocation,
            @RequestParam("shopPhone") String shopPhone,
            @RequestParam("shopReason") String shopReason, 
            @RequestParam("userUkId") int userUkId) {
		
		User user = new User();
        user.setUserUkId(userUkId);
        
		Application application = new Application();
        application.setApplicationShopName(shopName);
        application.setApplicationShopType(foodType);
        application.setApplicationShopLocation(shopLocation);
        application.setApplicationReason(shopReason);
        application.setApplicationDate(LocalDateTime.now());
        application.setApplicationStatus(ApplicationStatus.PENDING);
        application.setUser(user);
		
        shopApplyService.saveApplication(application);
        
		return "redirect:/user/userPage";
	}
	
	
	@GetMapping("user/userPage")
	public String review(Model model) {
		User user = userService.getCurrentUser();
        model.addAttribute("user", user);        
	    return "user/userPage"; 
	}
    
	@Autowired
    private UserFindRepository userFindRepository;
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") String userId, RedirectAttributes redirectAttributes) {
		
		Optional<User> user = userFindRepository.findById(userId);
		
		if (user.isPresent()) {
            userFindRepository.delete(user.get());
            redirectAttributes.addFlashAttribute("message", "회원탈퇴가 완료되었습니다.");
            return "redirect:/logout";  
        } else {
            redirectAttributes.addFlashAttribute("message", "회원탈퇴에 실패했습니다. 다시 시도해 주세요.");
            return "redirect:/user/userPage";  
        }
	}
	
	@GetMapping("user/userInfoChange")
	public String userInfoChange(Model model) {
		
		User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);	
		
		return "user/userInfoChange";
	}
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private FileUploadService fileUploadService;
	
	@PostMapping("/letsInfoChange")
	public String letsInfoChange(@ModelAttribute UserFormDTO form, @RequestParam(value = "userImg", required = false) MultipartFile userImg, HttpSession session) throws IOException {
		
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
            
            if (userImg != null && !userImg.isEmpty()) {
            	String currentProfile = user.getProfile();
            	String newProfile = userImg.getOriginalFilename();
            	            	
            	System.out.println("current : "+ currentProfile);
            	System.out.println("new : " +newProfile);
            	
            	if(currentProfile == null && newProfile != null) {
            		String fileName = fileUploadService.saveFile(userImg);
            		user.setProfile(fileName);
            	}else if(currentProfile != null && newProfile != null) {
            		String currentOrigin = currentProfile.substring(currentProfile.indexOf("-") + 1);
            		System.out.println("cur-orig : " +currentOrigin);
            		if(!currentOrigin.equals(newProfile)) {
            			String fileName = fileUploadService.saveFile(userImg);
                   	 	user.setProfile(fileName);
            		}
            		
            	}
            }
            	
            
            userService.updateUser(user);

            return "redirect:/user/userPage";
        }
		
		return "redirect:/public/userLogin";
	}
	
	
}