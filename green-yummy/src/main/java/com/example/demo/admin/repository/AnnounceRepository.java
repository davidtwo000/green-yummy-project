package com.example.demo.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.publicModel.Notification;

@Repository
public interface AnnounceRepository extends JpaRepository<Notification, Integer> {
	
}
