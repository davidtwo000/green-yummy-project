package com.example.demo.dto.userDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Integer userUkId; // 사용자 식별자
    private String id; // ID
    private String nickname; // 닉네임
    private String password; // 비밀번호
    private String name; // 이름
    private String email; // 이메일
    private String phone; // 사용자 전화번호
    private String profile; // 프로필 사진
    private Boolean isAdmin; // 관리자 여부 (0: 일반 사용자, 1: 관리자)

}