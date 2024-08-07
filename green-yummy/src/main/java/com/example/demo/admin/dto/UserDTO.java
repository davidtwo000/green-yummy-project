package com.example.demo.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
