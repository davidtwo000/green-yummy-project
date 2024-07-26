package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index/index";
	}
	
	@GetMapping("/NewFile")
	public String newFile() {
		return "public/NewFile";
	}
	
}
