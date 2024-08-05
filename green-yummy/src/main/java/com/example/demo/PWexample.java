package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PWexample {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "12345"; // 평문 비밀번호
        String encodedPassword = encoder.encode(rawPassword); // 해시화된 비밀번호
        
        System.out.println("Encoded Password: " + encodedPassword);

	}

}
