package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.ApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestDTO {

    private Integer applicationId;
    private String applicationShopName;
    private String applicationShopType;
    private String applicationShopLocation;
    private String applicationReason;
    private String applicationShopPhone;
    private LocalDateTime applicationDate;
    private ApplicationStatus applicationStatus;
    private String userId;

}
