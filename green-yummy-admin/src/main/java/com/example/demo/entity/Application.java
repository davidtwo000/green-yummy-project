package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "application_shop_name", length = 50)
    private String applicationShopName;

    @Column(name = "application_shop_type", length = 20)
    private String applicationShopType;

    @Column(name = "application_shop_location", length = 100)
    private String applicationShopLocation;

    @Column(name = "application_reason", length = 100)
    private String applicationReason;

    @Column(name = "application_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime applicationDate;
    
    @Column(name = "application_shop_phone", length = 20)
    private String applicationShopPhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status", length = 10)
    private ApplicationStatus applicationStatus;

    @ManyToOne
    @JoinColumn(name = "user_uk_id")
    private User user;
}
