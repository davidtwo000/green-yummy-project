package com.example.demo.restController.userRestController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userDto.LoginRequestDTO;
import com.example.demo.service.userService.UserFindService;
import com.example.demo.util.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserFindService userFindService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public void login(@RequestBody LoginRequestDTO loginRequest, HttpServletResponse response) throws IOException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtil.generateToken(loginRequest.getUsername());

        // 토큰을 응답 헤더에 추가
        response.addHeader("Authorization", "Bearer " + jwtToken);
        
        // 리다이렉트
        response.sendRedirect("/user/userpage");
    }
}
