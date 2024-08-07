package com.example.demo.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.admin.dto.AnnounceDTO;
import com.example.demo.admin.dto.RequestDTO;
import com.example.demo.admin.dto.ReviewDTO;
import com.example.demo.admin.dto.UserDTO;
import com.example.demo.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String index(Model model) {
        return "admin/index";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        return "admin/login";
    }

    // User
    @GetMapping("/userList")
    public String userList(Model model, @RequestParam(name="page", defaultValue="1") int page) {
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
    	model.addAttribute("userDTO", userDTO);
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
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
        return "redirect:/admin/userList";
    }

    // Announce
    @GetMapping("/announceList")
    public String announceList(Model model, @RequestParam(name="page", defaultValue="1") int page) {
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
    public String announceCreate(Model model) {
        return "admin/announce/announceCreate";
    }
    
    @PostMapping("/announceCreate")
    public String announceCreatePerform(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
    		Model model) {
    	
    	adminService.createAnnounce(title, content);
        return "redirect:/admin/announceList";
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
        return "redirect:/admin/announceDetail?id=" + id;
    }
    
    @PostMapping("/announceDelete")
    public String announceDelete(Model model, @RequestParam("id") Integer id) {
    	adminService.deleteAnnounce(id);
        return "redirect:/admin/announceList";
    }

    // Review
    @GetMapping("/reviewList")
    public String reviewList(Model model, @RequestParam(name="page", defaultValue="1") int page) {
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
        return "redirect:/admin/reviewList";
    }

    // Request
    @GetMapping("/requestList")
    public String requestList(Model model, @RequestParam(name="page", defaultValue="1") int page) {
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
    	model.addAttribute("page", page);
    	model.addAttribute("status", status);
    	model.addAttribute("requestDTO", requestDTO);
        return "admin/request/requestList";
    }
    
    @GetMapping("/requestDetail")
    public String requestDetail(Model model, @RequestParam("id") Integer id) {
    	RequestDTO requestDTO = adminService.getRequestById(id);
    	System.out.println("1");
    	System.out.println(requestDTO.getApplicationStatus());
        model.addAttribute("requestDTO", requestDTO);
        return "admin/request/requestDetail";
    }
    
    @PostMapping("/requestDelete")
    public String requestDelete(Model model, @RequestParam("id") Integer id) {
    	adminService.deleteRequest(id);
        return "redirect:/admin/requestList";
    }
}
