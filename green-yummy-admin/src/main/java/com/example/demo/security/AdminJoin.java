package com.example.demo.security;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AdminJoin {
    
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(AdminJoin.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        Scanner scanner = new Scanner(System.in);
        
        logger.info("\n아이디를 입력해주세요 : ");
        String adminId = scanner.nextLine();
        
        logger.info("\n관리자 이름을 입력해주세요 : ");
        String adminName = scanner.nextLine();
        
        logger.info("\n비밀번호를 입력해주세요 : ");
        String rawPassword = scanner.nextLine();
        
        logger.info("\n이메일을 입력해주세요 : ");
        String adminEmail = scanner.nextLine();
        
        logger.info("\n전화번호를 입력해주세요 : ");
        String phone = scanner.nextLine();
        
        logger.info("\n닉네임을 입력해주세요 : ");
        String nickname = scanner.nextLine();
        
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        scanner.close();
        
        String sql = "INSERT INTO users " +
                "(id, name, password, email, phone, profile, nickname, IS_ADMIN) " +
                "VALUES ('" + adminId + "', '" + adminName + "', '" + encodedPassword + "', '" + adminEmail + "', '" + phone + "', '" + "'프로필.png'" + "', '" + nickname + "', " + 1 + ")";
   
        logger.info("\n보안에 주의하십시오.\n " + sql + ";");
    }
}
