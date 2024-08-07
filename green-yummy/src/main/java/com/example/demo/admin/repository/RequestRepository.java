package com.example.demo.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.admin.dto.RequestDTO;
import com.example.demo.admin.entity.Application;

@Repository
public interface RequestRepository extends JpaRepository<Application, Integer> {
	
	@Query("SELECT new com.example.demo.admin.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationDate, a.applicationStatus, u.id) " +
	           "FROM Application a JOIN a.user u")
	    List<RequestDTO> findAllApplicationsWithUserId();
	
	@Query("SELECT new com.example.demo.admin.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationDate, a.applicationStatus, u.id) " +
	           "FROM Application a JOIN a.user u WHERE a.applicationId = :id")
	    RequestDTO findRequestById(@Param("id") Integer id);
}

