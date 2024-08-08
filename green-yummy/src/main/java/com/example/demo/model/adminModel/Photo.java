package com.example.demo.model.adminModel;

import com.example.demo.model.userModel.Review;

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
@Table(name = "SHOP_PHOTOS")
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOP_PHOTOS_ID")
    private Integer photoId;

    @ManyToOne
    @JoinColumn(name = "REVIEW_ID")
    private Review review;

    private String photoPath;
}
