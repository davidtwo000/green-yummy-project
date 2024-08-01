package com.example.demo.model.publicModel;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOP_UK_ID")
    private Integer shopUkId; // 식당 식별자

    @Column(name = "SHOP_NAME", nullable = false)
    private String shopName; // 식당 이름

    @Column(name = "SHOP_PROFILE")
    private String shopProfile; // 식당 프로필 사진

    @Column(name = "SHOP_TYPE")
    private String shopType; // 식당 타입 (한식, 중식, 양식 등)

    @Column(name = "LOCATION")
    private String location; // 식당 위치

    @Column(name = "SHOP_TEL")
    private String shopTel; // 식당 전화번호

    @Column(name = "OPEN_HOURS")
    private String openHours; // 식당 오픈 시간

    @Column(name = "CLOSE_HOURS")
    private String closeHours; // 식당 닫는 시간

    @Column(name = "CLOSED_DAYS")
    private String closedDays; // 식당 휴무일

    @Column(name = "ETC")
    private String etc; // 기타 사항

    @Column(name = "LATITUDE")
    private Double latitude; // 위도

    @Column(name = "LONGITUDE")
    private Double longitude; // 경도

    // 기본 생성자
    public Shop() {}

    // 전체 필드를 매개변수로 하는 생성자 (선택 사항)
    public Shop(Integer shopUkId, String shopName, String shopProfile, String shopType, String location,
                String shopTel, String openHours, String closeHours, String closedDays, String etc,
                Double latitude, Double longitude) {
        this.shopUkId = shopUkId;
        this.shopName = shopName;
        this.shopProfile = shopProfile;
        this.shopType = shopType;
        this.location = location;
        this.shopTel = shopTel;
        this.openHours = openHours;
        this.closeHours = closeHours;
        this.closedDays = closedDays;
        this.etc = etc;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}