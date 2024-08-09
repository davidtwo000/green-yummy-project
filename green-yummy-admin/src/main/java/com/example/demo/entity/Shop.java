package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "SHOPS")
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopUkId;

    private String shopName;
    private String shopProfile;
    private String shopType;
    private String location;
    private String shopTel;
    private String openHours;
    private String closeHours;
    private String closedDays;
    private String etc;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @OneToMany(mappedBy = "shop")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "shop")
    private Set<Bookmark> bookmarks;
}
