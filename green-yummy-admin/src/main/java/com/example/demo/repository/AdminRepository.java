package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {
	
    Optional<User> findById(String username);
    
    List<User> findByIdContaining(String id);

    List<User> findByNameContaining(String name);

    List<User> findByPhoneContaining(String phone);
    
    List<User> findByIsAdmin(boolean role);

    @Query("SELECT u FROM User u WHERE u.id LIKE %:keyword% OR u.name LIKE %:keyword% OR u.phone LIKE %:keyword%")
    List<User> searchByKeyword(@Param("keyword") String keyword);
}
