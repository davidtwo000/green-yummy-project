package com.example.demo.model.adminModel;

import com.example.demo.model.userModel.Review;
import com.example.demo.model.userModel.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "REVIEWLIKES")
@Data
public class ReviewLike {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEWLIKE_ID")
    private Integer reviewLike;
	 
    @Id
    @ManyToOne
    @JoinColumn(name = "USER_UK_ID")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "REVIEW_ID")
    private Review review;
}
