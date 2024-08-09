package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userUkId;

    @Column(unique = true, nullable = false)
    private String id;

    private String nickname;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String profile;
    private boolean isAdmin;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "user")
    private Set<Bookmark> bookmarks;

    @OneToMany(mappedBy = "user")
    private Set<ReviewLike> reviewLikes;
}
