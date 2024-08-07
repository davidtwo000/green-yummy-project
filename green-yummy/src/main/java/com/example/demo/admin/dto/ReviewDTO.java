package com.example.demo.admin.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {
	
    private Integer reviewId;

    private String userId;

    private String shopName;

    private Byte reviewRating;
    private String reviewComment;
    private String reviewContent;

    private LocalDateTime reviewDate;
}
