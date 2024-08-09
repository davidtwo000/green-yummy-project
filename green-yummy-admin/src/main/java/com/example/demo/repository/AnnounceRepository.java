package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Notification;

@Repository
public interface AnnounceRepository extends JpaRepository<Notification, Integer> {
	
	List<Notification> findByAuthorContaining(String author);

    List<Notification> findByTitleContaining(String title);

    @Query(value = "SELECT * FROM Notifications n WHERE DATE_FORMAT(n.post_Date, '%Y-%m-%d') LIKE CONCAT('%', :postDate, '%')", nativeQuery = true)
    List<Notification> findByFormattedPostDateContaining(@Param("postDate") String postDate);

    @Query(value = "SELECT * FROM NOTIFICATIONS n WHERE n.author LIKE %:keyword% OR n.title LIKE %:keyword% OR DATE_FORMAT(n.post_date, '%Y-%m-%d') LIKE CONCAT('%', :keyword, '%')", nativeQuery = true)
    List<Notification> searchByKeyword(@Param("keyword") String keyword);

}
