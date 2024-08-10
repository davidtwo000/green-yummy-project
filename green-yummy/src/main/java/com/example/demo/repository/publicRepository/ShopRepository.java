package com.example.demo.repository.publicRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.model.publicModel.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	//타입으로 찾기
	List<Shop> findByShopType(String shopType);
	
	//위치로 찾기
	@Query("SELECT s FROM Shop s WHERE s.location LIKE %:location%")
    List<Shop> findByLocationContaining(@Param("location") String location);
	
	//가게 이름으로 찾기
	@Query("select s from Shop s where s.shopName like %:name%")
	List<Shop> findByShopNameContaining(@Param("name") String name);
	
	@Query(value = "SELECT * FROM shops ORDER BY RAND() LIMIT 6", nativeQuery = true)
	List<Shop> findRandomShops();

}