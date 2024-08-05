package com.example.demo.dto.userDto;

public class LoginResponseDTO {

	private String token;

    public void LoginResponse(String token) {
        this.token = token;
    }

    // getter
    public String getToken() {
        return token;
    }
}
