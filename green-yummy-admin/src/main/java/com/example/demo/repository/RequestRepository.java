package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.RequestDTO;
import com.example.demo.entity.Application;
import com.example.demo.entity.ApplicationStatus;

@Repository
public interface RequestRepository extends JpaRepository<Application, Integer> {

	@Query("SELECT new com.example.demo.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationShopPhone, a.applicationDate, a.applicationStatus, u.id) "
			+ "FROM Application a JOIN a.user u")
	List<RequestDTO> findAllApplicationsWithUserId();

	@Query("SELECT new com.example.demo.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationShopPhone, a.applicationDate, a.applicationStatus, u.id) "
			+ "FROM Application a JOIN a.user u where a.applicationId = :id")
	RequestDTO findRequestById(@Param("id") Integer id);

	@Query("SELECT new com.example.demo.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationShopPhone, a.applicationDate, a.applicationStatus, u.id) "
			+ "FROM Application a JOIN a.user u " + "WHERE u.id LIKE %:userId%")
	List<RequestDTO> findApplicationsByUserId(@Param("userId") String userId);

	@Query("SELECT new com.example.demo.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationShopPhone, a.applicationDate, a.applicationStatus, u.id) "
			+ "FROM Application a JOIN a.user u " + "WHERE a.applicationShopName LIKE %:shopName%")
	List<RequestDTO> findApplicationsByShopName(@Param("shopName") String shopName);

	@Query("SELECT new com.example.demo.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationShopPhone, a.applicationDate, a.applicationStatus, u.id) "
			+ "FROM Application a JOIN a.user u " + "WHERE a.applicationShopType LIKE %:shopType%")
	List<RequestDTO> findApplicationsByShopType(@Param("shopType") String shopType);

	@Query("SELECT new com.example.demo.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, a.applicationShopLocation, a.applicationReason, a.applicationShopPhone, a.applicationDate, a.applicationStatus, u.id) "
			+ "FROM Application a JOIN a.user u " + "WHERE (u.id LIKE %:keyword% "
			+ "OR a.applicationShopName LIKE %:keyword% " + "OR a.applicationShopType LIKE %:keyword% "
			+ "OR CONCAT(a.applicationStatus) LIKE %:keyword%)")
	List<RequestDTO> searchByKeyword(@Param("keyword") String keyword);

	@Query("SELECT new com.example.demo.dto.RequestDTO(a.applicationId, a.applicationShopName, a.applicationShopType, "
			+ "a.applicationShopLocation, a.applicationReason, a.applicationShopPhone, a.applicationDate, a.applicationStatus, u.id) "
			+ "FROM Application a JOIN a.user u WHERE a.applicationStatus = :status")
	List<RequestDTO> findApplicationsByStatus(@Param("status") ApplicationStatus status);
}
