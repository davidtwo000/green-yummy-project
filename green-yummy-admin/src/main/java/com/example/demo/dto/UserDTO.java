package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDTO {

	private Integer userUkId;
    private String id;
    private String nickname;
    private String name;
    private String email;
    private String phone;
    private String profile;
    private boolean isAdmin;
}
