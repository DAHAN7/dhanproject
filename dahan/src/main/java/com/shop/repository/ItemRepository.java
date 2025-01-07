package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByItemNm(String itemNm);

	// 상품명을 기준으로 상세 설명도 함께 검색 (AND 조건)
	List<Item> findByItemNmAndItemDetail(String itemNm, String itemDetail);

	// 상품명을 기준으로 상세 설명을 포함한 검색 (OR 조건)
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

	// 특정 가격 이하 상품 조회
	List<Item> findByPriceLessThan(Integer price);

	// 특정 가격 이하 상품을 가격 내림차순으로 조회
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

	// JPQL을 사용한 상세 설명 검색 (내림차순 정렬)
	@Query("SELECT i FROM Item i WHERE i.itemDetail LIKE %:itemDetail% ORDER BY i.price DESC")
	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

	// 네이티브 SQL을 사용한 상세 설명 검색 (내림차순 정렬)
	@Query(value = "SELECT * FROM item i WHERE i.item_detail LIKE %:itemDetail% ORDER BY i.price DESC", nativeQuery = true)
	List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}