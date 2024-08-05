package com.example.demo.model.userModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_UK_ID")
    private Integer userUkId; // 사용자 식별자

    @Column(name = "ID", unique = true, nullable = false)
    private String id; // ID

    @Column(name = "NICKNAME")
    private String nickname; // 닉네임

    @Column(name = "PASSWORD", nullable = false)
    private String password; // 비밀번호

    @Column(name = "NAME")
    private String name; // 이름

    @Column(name = "EMAIL", unique = true)
    private String email; // 이메일

    @Column(name = "PHONE")
    private String phone; // 사용자 전화번호

    @Column(name = "PROFILE")
    private String profile; // 프로필 사진

    @Column(name = "IS_ADMIN", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isAdmin; // 관리자 여부 (0: 일반 사용자, 1: 관리자)
}
