package com.example.demo.dto.userDto;

import com.example.demo.dto.publicDto.ShopDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkDTO {
	private Integer bookmarkId;
	private Integer userUkId; // 사용자 ID
    private Integer shopUkId;
    
    private ShopDTO shop;
    private UserDTO user;
}
