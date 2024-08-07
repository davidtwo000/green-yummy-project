package com.example.demo.model.userModel;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Integer reviewId; // 리뷰 ID

    @ManyToOne
    @JoinColumn(name = "USER_UK_ID", insertable = false, updatable = false)
    private User user; // 사용자

    @Column(name = "USER_UK_ID")
    private Integer userUkId; // 사용자 ID

    @Column(name = "SHOP_UK_ID")
    private Integer shopUkId; // 식당 ID

    @Column(name = "REVIEW_RATING")
    private Byte reviewRating; // 리뷰 평점 (1~5 범위로 설정할 수 있음)

    @Column(name = "REVIEW_COMMENT", length = 50)
    private String reviewComment; // 리뷰 코멘트

    @Column(name = "REVIEW_CONTENT", columnDefinition = "TEXT")
    private String reviewContent; // 리뷰 내용

    @Column(name = "REVIEW_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime reviewDate;

    @Column(name = "REVIEW_IMG")
    private String reviewImg;

    @PrePersist
    protected void onCreate() {
        if (reviewDate == null) {
            reviewDate = LocalDateTime.now();
        }
    }
}
