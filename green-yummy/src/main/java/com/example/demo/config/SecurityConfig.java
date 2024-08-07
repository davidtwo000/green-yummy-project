// SecurityConfig.java
package com.example.demo.config;

import com.example.demo.service.userService.UserServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserServiceImpl userDetailsService;

    public SecurityConfig(UserServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeHttpRequests(authorizeRequests -> // 1. 경로 접근 권한 설정
		        authorizeRequests
		            .requestMatchers("/public/**").permitAll() // 2. /public/** 경로는 누구나 접근 가능
		            .requestMatchers("/user/**").hasRole("USER") // 3. /user/** 경로는 인증된 사용자만 접근 가능 .authenticated()
		            .anyRequest().permitAll() // 4. 나머지 모든 요청은 접근 가능
		    )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/user/userPage", true)
                    .permitAll()
            ).logout(logout ->
            	logout
	            	.logoutUrl("/logout") // 로그아웃 요청 URL
	            	.logoutSuccessUrl("/") // 로그아웃 성공 후 리다이렉트할 URL
	                .permitAll()
            ).csrf((csrf) -> 
        		csrf.disable()
        		//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            ).headers(headers -> headers
                    .frameOptions(frameOptions -> frameOptions
                            .sameOrigin()
                        )
                    );

        return http.build();
    }

    
}
