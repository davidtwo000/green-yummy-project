package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "REVIEWLIKES")
@Data
public class ReviewLike {
    @Id
    @ManyToOne
    @JoinColumn(name = "USER_UK_ID")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "REVIEW_ID")
    private Review review;
}
