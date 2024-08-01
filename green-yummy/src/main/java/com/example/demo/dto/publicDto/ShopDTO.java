package com.example.demo.dto.publicDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopDTO {
	private Integer shopUkId;          // 식당 식별자 (Primary Key)
    private String shopName;           // 식당 이름
    private String shopProfile;        // 식당 프로필 사진
    private String shopType;           // 식당 타입 (한식, 중식, 양식 등)
    private String location;           // 식당 위치
    private String shopTel;            // 식당 전화번호
    private String openHours;          // 식당 오픈 시간
    private String closeHours;         // 식당 닫는 시간
    private String closedDays;         // 식당 휴무일
    private String etc;                // 기타 사항
    private Double latitude;           // 위도
    private Double longitude;          // 경도
}
