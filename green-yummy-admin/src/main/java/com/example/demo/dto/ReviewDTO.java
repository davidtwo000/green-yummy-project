package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {
	
    private Integer reviewId;
    private String userId;
    private String shopName;
    private Byte reviewRate;
    private String reviewComment;
    private String reviewContent;
    private LocalDateTime reviewDate;
}
