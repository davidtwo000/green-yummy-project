package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AnnounceDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.ReviewDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }

    @GetMapping("/main")
    public String index(Model model) {
        return "admin/index";
    }
    
    // User
    @GetMapping("/userList")
    public String userList(Model model, @RequestParam(name="page", defaultValue="1") int page, @RequestParam(name="order", defaultValue="asc") String order) {
    	List<UserDTO> allUsers = adminService.getUserInfo();
    	List<UserDTO> userDTO = new ArrayList<>();
        if (allUsers.size() > 10) {
        	if(10*page > allUsers.size()) {
        		userDTO = allUsers.subList(10*(page-1), allUsers.size());
        	}else {
        		userDTO = allUsers.subList(10*(page-1), 10*page);
        	}
        } else {
            userDTO = allUsers;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allUsers.size())
        	status = 1;
        else
        	status = 0;
        if(allUsers.size() <= 10)
        	status = 2;
        if(order.equals("desc"))
        	Collections.reverse(userDTO);
        model.addAttribute("order", order);
    	model.addAttribute("userDTO", userDTO);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
        return "admin/user/userList";
    }
    
    @PostMapping("/searchUser")
    public String searchUser(Model model, @RequestParam("search") String search, @RequestParam("searchType") String searchType, @RequestParam(name="page", defaultValue="1") int page) {
    	List<UserDTO> allUsers = adminService.searchUser(search, searchType);
    	List<UserDTO> userDTO = new ArrayList<>();
        if (allUsers.size() > 10) {
        	if(10*page > allUsers.size()) {
        		userDTO = allUsers.subList(10*(page-1), allUsers.size());
        	}else {
        		userDTO = allUsers.subList(10*(page-1), 10*page);
        	}
        } else {
            userDTO = allUsers;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allUsers.size())
        	status = 1;
        else
        	status = 0;
        if(allUsers.size() <= 10)
        	status = 2;
    	model.addAttribute("userDTO", userDTO);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
        return "admin/user/userList";
    }
    
    @PostMapping("/sortUser")
    public String sortUser(Model model, @RequestParam("role") String role, @RequestParam(name="page", defaultValue="1") int page) {
    	List<UserDTO> allUsers = adminService.sortUser(role);
    	List<UserDTO> userDTO = new ArrayList<>();
        if (allUsers.size() > 10) {
        	if(10*page > allUsers.size()) {
        		userDTO = allUsers.subList(10*(page-1), allUsers.size());
        	}else {
        		userDTO = allUsers.subList(10*(page-1), 10*page);
        	}
        } else {
        	userDTO = allUsers;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allUsers.size())
        	status = 1;
        else
        	status = 0;
        if(allUsers.size() <= 10)
        	status = 2;
        
        String condition = "USER";
        switch(role) {
        case "USER":
        	condition = "USER";
        	break;
        case "ADMIN":
        	condition = "ADMIN";
        	break;
        }
        model.addAttribute("condition", condition);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("userDTO", userDTO);
        return "admin/user/userList";
    }
    
    @GetMapping("/userDetail")
    public String userDetail(Model model, @RequestParam("id") Integer id) {
        UserDTO userDTO = adminService.getUserById(id);
        model.addAttribute("userDTO", userDTO);
        return "admin/user/userDetail";
    }
    
    @PostMapping("/userDelete")
    public String userDelete(Model model, @RequestParam("id") Integer id) {
    	adminService.deleteUser(id);
        return "redirect:/admin/userList?message=delete";
    }

    // Announce
    @GetMapping("/announceList")
    public String announceList(Model model, @RequestParam(name="page", defaultValue="1") int page, @RequestParam(name="order", defaultValue="asc") String order) {
    	List<AnnounceDTO> allAnnounce = adminService.getAnnounceInfo();
    	List<AnnounceDTO> announceDTO = new ArrayList<>();
        if (allAnnounce.size() > 10) {
        	if(10*page > allAnnounce.size()) {
        		announceDTO = allAnnounce.subList(10*(page-1), allAnnounce.size());
        	}else {
        		announceDTO = allAnnounce.subList(10*(page-1), 10*page);
        	}
        } else {
        	announceDTO = allAnnounce;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allAnnounce.size())
        	status = 1;
        else
        	status = 0;
        
        if(allAnnounce.size() <= 10)
        	status = 2;
        if(order.equals("desc"))
        	Collections.reverse(announceDTO);
        model.addAttribute("order", order);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("announceDTO", announceDTO);
        return "admin/announce/announceList";
    }
    
    @PostMapping("/searchAnnounce")
    public String searchAnnounce(Model model, @RequestParam("search") String search, @RequestParam("searchType") String searchType, @RequestParam(name="page", defaultValue="1") int page) {
    	List<AnnounceDTO> allAnnounce = adminService.searchAnnounce(search, searchType);
    	List<AnnounceDTO> announceDTO = new ArrayList<>();
        if (allAnnounce.size() > 10) {
        	if(10*page > allAnnounce.size()) {
        		announceDTO = allAnnounce.subList(10*(page-1), allAnnounce.size());
        	}else {
        		announceDTO = allAnnounce.subList(10*(page-1), 10*page);
        	}
        } else {
        	announceDTO = allAnnounce;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allAnnounce.size())
        	status = 1;
        else
        	status = 0;
        
        if(allAnnounce.size() <= 10)
        	status = 2;
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("announceDTO", announceDTO);
    	return "admin/announce/announceList";
    }
    
    @GetMapping("/announceDetail")
    public String announceDetail(Model model, @RequestParam("id") Integer id) {
    	AnnounceDTO announceDTO = adminService.getAnnounceById(id);
        model.addAttribute("announceDTO", announceDTO);
        return "admin/announce/announceDetail";
    }

    @GetMapping("/announceCreate")
    public String announceCreate() {
        return "admin/announce/announceCreate";
    }
    
    @PostMapping("/announceCreate")
    public String announceCreatePerform(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
    		Model model) {
    	
    	adminService.createAnnounce(title, content);
        return "redirect:/admin/announceList?message=create";
    }
    
    @GetMapping("/announceModify")
    public String announceModify(Model model, @RequestParam("id") Integer id) {
    	AnnounceDTO announceDTO = adminService.getAnnounceById(id);
        model.addAttribute("announceDTO", announceDTO);
        return "admin/announce/announceModify";
    }
    
    @PostMapping("/announceModify")
    public String announceModifyPerform(
    		@RequestParam("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            Model model) {
    	adminService.updateAnnounce(id,title,content);
        return "redirect:/admin/announceDetail?id=" + id + "&message=modify";
    }
    
    @PostMapping("/announceDelete")
    public String announceDelete(Model model, @RequestParam("id") Integer id) {
    	adminService.deleteAnnounce(id);
        return "redirect:/admin/announceList?message=delete";
    }

    // Review
    @GetMapping("/reviewList")
    public String reviewList(Model model, @RequestParam(name="page", defaultValue="1") int page, @RequestParam(name="order", defaultValue="asc") String order) {
    	List<ReviewDTO> allReview = adminService.getReviewInfo();
    	List<ReviewDTO> reviewDTO = new ArrayList<>();
        if (allReview.size() > 10) {
        	if(10*page > allReview.size()) {
        		reviewDTO = allReview.subList(10*(page-1), allReview.size());
        	}else {
        		reviewDTO = allReview.subList(10*(page-1), 10*page);
        	}
        } else {
        	reviewDTO = allReview;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allReview.size())
        	status = 1;
        else
        	status = 0;
        if(allReview.size() <= 10)
        	status = 2;
        if(order.equals("desc"))
        	Collections.reverse(reviewDTO);
        model.addAttribute("order", order);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("reviewDTO", reviewDTO);
        return "admin/review/reviewList";
    }
    
    @PostMapping("/searchReview")
    public String searchReview(Model model, @RequestParam("search") String search, @RequestParam("searchType") String searchType, @RequestParam(name="page", defaultValue="1") int page) {
    	List<ReviewDTO> allReview = adminService.searchReview(search, searchType);
    	List<ReviewDTO> reviewDTO = new ArrayList<>();
        if (allReview.size() > 10) {
        	if(10*page > allReview.size()) {
        		reviewDTO = allReview.subList(10*(page-1), allReview.size());
        	}else {
        		reviewDTO = allReview.subList(10*(page-1), 10*page);
        	}
        } else {
        	reviewDTO = allReview;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allReview.size())
        	status = 1;
        else
        	status = 0;
        if(allReview.size() <= 10)
        	status = 2;
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("reviewDTO", reviewDTO);
        return "admin/review/reviewList";
    }
    
    @GetMapping("/reviewDetail")
    public String reviewDetail(Model model, @RequestParam("id") Integer id) {
    	ReviewDTO reviewDTO = adminService.getReviewById(id);
        model.addAttribute("reviewDTO", reviewDTO);
        return "admin/review/reviewDetail";
    }
    
    @PostMapping("/reviewDelete")
    public String reviewDelete(Model model, @RequestParam("id") Integer id) {
    	adminService.deleteReview(id);
        return "redirect:/admin/reviewList?message=delete";
    }

    // Request
    @GetMapping("/requestList")
    public String requestList(Model model, @RequestParam(name="page", defaultValue="1") int page, @RequestParam(name="order", defaultValue="asc") String order) {
    	List<RequestDTO> allRequest = adminService.getRequestInfo();
    	List<RequestDTO> requestDTO = new ArrayList<>();
        if (allRequest.size() > 10) {
        	if(10*page > allRequest.size()) {
        		requestDTO = allRequest.subList(10*(page-1), allRequest.size());
        	}else {
        		requestDTO = allRequest.subList(10*(page-1), 10*page);
        	}
        } else {
        	requestDTO = allRequest;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allRequest.size())
        	status = 1;
        else
        	status = 0;
        if(allRequest.size() <= 10)
        	status = 2;
        if(order.equals("desc"))
        	Collections.reverse(requestDTO);
        model.addAttribute("order", order);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("requestDTO", requestDTO);
        return "admin/request/requestList";
    }
    
    @PostMapping("/searchRequest")
    public String searchRequest(Model model, @RequestParam("search") String search, @RequestParam("searchType") String searchType, @RequestParam(name="page", defaultValue="1") int page) {
    	List<RequestDTO> allRequest = adminService.searchRequest(search, searchType);
    	List<RequestDTO> requestDTO = new ArrayList<>();
        if (allRequest.size() > 10) {
        	if(10*page > allRequest.size()) {
        		requestDTO = allRequest.subList(10*(page-1), allRequest.size());
        	}else {
        		requestDTO = allRequest.subList(10*(page-1), 10*page);
        	}
        } else {
        	requestDTO = allRequest;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allRequest.size())
        	status = 1;
        else
        	status = 0;
        if(allRequest.size() <= 10)
        	status = 2;
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("requestDTO", requestDTO);
        return "admin/request/requestList";
    }
    
    @PostMapping("/sortRequest")
    public String sortRequest(Model model, @RequestParam("status") String sort, @RequestParam(name="page", defaultValue="1") int page) {
    	List<RequestDTO> allRequest = adminService.sortRequest(sort);
    	List<RequestDTO> requestDTO = new ArrayList<>();
        if (allRequest.size() > 10) {
        	if(10*page > allRequest.size()) {
        		requestDTO = allRequest.subList(10*(page-1), allRequest.size());
        	}else {
        		requestDTO = allRequest.subList(10*(page-1), 10*page);
        	}
        } else {
        	requestDTO = allRequest;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allRequest.size())
        	status = 1;
        else
        	status = 0;
        if(allRequest.size() <= 10)
        	status = 2;
        
        String condition = "PENDING";
        switch(sort) {
        case "PENDING":
        	condition = "PENDING";
        	break;
        case "APPROVED":
        	condition = "APPROVED";
        	break;
        case "REJECTED":
        	condition = "REJECTED";
        	break;
        }
        model.addAttribute("condition", condition);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("requestDTO", requestDTO);
        return "admin/request/requestList";
    }
    
    @GetMapping("/requestDetail")
    public String requestDetail(Model model, @RequestParam("id") Integer id) {
    	RequestDTO requestDTO = adminService.getRequestById(id);
        model.addAttribute("requestDTO", requestDTO);
        return "admin/request/requestDetail";
    }
    
    @PostMapping("/requestStatus")
    public String requestStatus(Model model, @RequestParam("id") Integer id, @RequestParam("status") String status) {
    	adminService.updateRequest(id, status);
        return "redirect:/admin/requestList?message=modify";
    }
    
    @PostMapping("/requestDelete")
    public String requestDelete(Model model, @RequestParam("id") Integer id) {
    	adminService.deleteRequest(id);
        return "redirect:/admin/requestList?message=delete";
    }
    
    // Shop
    @GetMapping("/shopList")
    public String shopList(Model model, @RequestParam(name="page", defaultValue="1") int page, @RequestParam(name="order", defaultValue="asc") String order) {
    	List<ShopDTO> allShop = adminService.getShopInfo();
    	List<ShopDTO> shopDTO = new ArrayList<>();
        if (allShop.size() > 10) {
        	if(10*page > allShop.size()) {
        		shopDTO = allShop.subList(10*(page-1), allShop.size());
        	}else {
        		shopDTO = allShop.subList(10*(page-1), 10*page);
        	}
        } else {
        	shopDTO = allShop;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allShop.size())
        	status = 1;
        else
        	status = 0;
        if(allShop.size() <= 10)
        	status = 2;
        if(order.equals("desc"))
        	Collections.reverse(shopDTO);
        model.addAttribute("order", order);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("shopDTO", shopDTO);
        return "admin/shop/shopList";
    }
    
    @PostMapping("/searchShop")
    public String searchShop(Model model, @RequestParam("search") String search, @RequestParam("searchType") String searchType, @RequestParam(name="page", defaultValue="1") int page) {
    	List<ShopDTO> allShop = adminService.searchShop(search, searchType);
    	List<ShopDTO> shopDTO = new ArrayList<>();
        if (allShop.size() > 10) {
        	if(10*page > allShop.size()) {
        		shopDTO = allShop.subList(10*(page-1), allShop.size());
        	}else {
        		shopDTO = allShop.subList(10*(page-1), 10*page);
        	}
        } else {
        	shopDTO = allShop;
        }
        int status;
        if(page == 1)
        	status = -1;
        else if(10*page > allShop.size())
        	status = 1;
        else
        	status = 0;
        if(allShop.size() <= 10)
        	status = 2;
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("shopDTO", shopDTO);
        return "admin/shop/shopList";
    }
    
    @GetMapping("shopDetail")
    public String shopDetail(Model model, @RequestParam("id") Integer id) {
    	ShopDTO shopDTO = adminService.getShopById(id);
        model.addAttribute("shopDTO", shopDTO);
        return "admin/shop/shopDetail";
    }
    
    @GetMapping("/shopCreate")
    public String shopCreate() {
        return "admin/shop/shopCreate";
    }
    
    @PostMapping("/shopCreate")
    public String shopCreatePerform(
    		@RequestParam("shopProfileFile") MultipartFile shopProfileFile,
            @RequestParam("shopName") String shopName,
            @RequestParam("shopType") String shopType,
            @RequestParam("location") String location,
            @RequestParam("shopTel") String shopTel,
            @RequestParam("openHours") String openHours,
            @RequestParam("closeHours") String closeHours,
            @RequestParam("closedDays") String closedDays,
    		Model model) {
    	
    	adminService.createShop(shopProfileFile,shopName,shopType,location,shopTel,openHours,closeHours,closedDays);
        return "redirect:/admin/shopList?message=create";
    }
    
    @GetMapping("/shopModify")
    public String shopModify(Model model, @RequestParam("id") Integer id) {
    	ShopDTO shopDTO = adminService.getShopById(id);
        model.addAttribute("shopDTO", shopDTO);
        return "admin/shop/shopModify";
    }
    
    @PostMapping("/shopModify")
    public String shopModifyPerform(
    		@RequestParam("shopProfileFile") MultipartFile shopProfileFile,
    		@RequestParam("id") Integer id,
            @RequestParam("shopName") String shopName,
            @RequestParam("shopProfile") String shopProfile,
            @RequestParam("shopType") String shopType,
            @RequestParam("location") String location,
            @RequestParam("shopTel") String shopTel,
            @RequestParam("openHours") String openHours,
            @RequestParam("closeHours") String closeHours,
            @RequestParam("closedDays") String closedDays,
            Model model) {
    	adminService.updateShop(id,shopName,shopType,location,shopTel,openHours,closeHours,closedDays,shopProfileFile,shopProfile);
        return "redirect:/admin/shopDetail?id=" + id + "&message=modify";
    }
    
    @PostMapping("/shopDelete")
    public String shopDelete(Model model, @RequestParam("id") Integer id) {
    	adminService.deleteShop(id);
        return "redirect:/admin/shopList?message=delete";
    }
}
