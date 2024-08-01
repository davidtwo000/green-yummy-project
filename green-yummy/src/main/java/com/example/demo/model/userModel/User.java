package com.example.demo.model.userModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_uk_id")
    private Long userUkId;

    @Column(name = "id", unique = true, nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String userPassword;
    
}
