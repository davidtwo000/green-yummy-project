package com.example.demo.model.userModel;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "REVIEW_ID")
    private Integer reviewId; // 리뷰 ID

    @Column(name = "USER_UK_ID")
    private Integer userUkId; // 사용자 ID

    @Column(name = "SHOP_UK_ID")
    private Integer shopUkId; // 식당 ID

    @Column(name = "REVIEW_RATE")
    private Byte reviewRate; // 리뷰 평점 (1~5 범위로 설정할 수 있음)

    @Column(name = "REVIEW_COMMENT", length = 50)
    private String reviewComment; // 리뷰 코멘트

    @Column(name = "REVIEW_CONTENT", columnDefinition = "TEXT")
    private String reviewContent; // 리뷰 내용

    @Column(name = "REVIEW_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime reviewDate; 
    
    @PrePersist
    protected void onCreate() {
        if (reviewDate == null) {
            reviewDate = LocalDateTime.now();
        }
    }
	
}
