package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Item;
public interface ItemRepository extends JpaRepository<Item, Long> {
	  List<Item> findByItemNm(String itemNm,String itemDetail);
}
