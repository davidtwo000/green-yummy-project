package com.example.demo.dto;

import lombok.Data;

@Data
public class ShopDTO {
	
    private int shopUkId;
    private String shopName;
    private String shopProfile;
    private String shopType;
    private String location;
    private String shopTel;
    private String openHours;
    private String closeHours;
    private String closedDays;
    private String etc;
    private double latitude;
    private double longitude;
}
