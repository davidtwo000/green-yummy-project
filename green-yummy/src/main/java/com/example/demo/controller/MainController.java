package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index/TMP2";
	}
	
	@GetMapping("/notification")
	public String notification() {
		return "/notification";
	}
	
	//실험용
	@GetMapping("/newsfile")
	public String newFile() {
		return "public/TMP1";
	}
	
}
