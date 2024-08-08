package com.example.demo.model.adminModel;

import java.time.LocalDateTime;

import com.example.demo.model.userModel.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status", length = 10)
    private ApplicationStatus applicationStatus;

    @ManyToOne
    @JoinColumn(name = "user_uk_id")
    private User user;
}
