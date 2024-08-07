package com.example.demo.admin.dto;

import java.time.LocalDateTime;

import com.example.demo.admin.entity.ApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestDTO {

    private Integer applicationId;
    private String applicationShopName;
    private String applicationShopType;
    private String applicationShopLocation;
    private String applicationReason;
    private LocalDateTime applicationDate;
    private ApplicationStatus applicationStatus;
    private String userId;

}
