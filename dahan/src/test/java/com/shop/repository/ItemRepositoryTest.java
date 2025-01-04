package com.shop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired 
    ItemRepository itemRepository;

    // 상품 저장 테스트
    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        // 상품 객체 생성
        Item item = new Item();
        item.setItemNm("테스트 상품"); // 상품명
        item.setPrice(10000); // 가격
        item.setItemDetail("테스트 상품 상세 설명"); // 상세 설명
        item.setItemSellStatus(ItemSellStatus.SELL); // 판매 상태
        item.setStockNumber(100); // 재고 수량
        item.setRegTime(LocalDateTime.now()); // 등록 시간
        item.setUpdateTime(LocalDateTime.now()); // 수정 시간
        
        // 상품 저장
        Item savedItem = itemRepository.save(item);
        
        // 저장된 아이템 출력
        System.out.println("저장된 Item: " + savedItem.toString());
    }

    // 여러 아이템 저장을 위한 메서드
    public void createItemList() {
        for (int i = 1; i <= 10; i++) {
            // 상품 객체 생성
            Item item = new Item();
            item.setItemNm("테스트 상품" + i); // 상품명
            item.setPrice(10000 + i); // 가격
            item.setItemDetail("테스트 상품 상세 설명" + i); // 상세 설명
            item.setItemSellStatus(ItemSellStatus.SELL); // 판매 상태
            item.setStockNumber(100); // 재고 수량
            item.setRegTime(LocalDateTime.now()); // 등록 시간
            item.setUpdateTime(LocalDateTime.now()); // 수정 시간
            
            // 상품 저장
            itemRepository.save(item);
        }
    }

    // 상품명 조회 테스트
    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {
        this.createItemList(); // 여러 아이템 저장
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1"); // 상품명 조회

        for (Item item : itemList) {
            System.out.println(item.toString()); // 조회된 아이템 출력
        }
    }

    // 상품명 또는 상세 설명 조회 테스트
    @Test
    @DisplayName("상품명 또는 상세 설명 조회 테스트")
    public void findByItemNmOrItemDetailTest() {
        this.createItemList(); // 여러 아이템 저장
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");

        for (Item item : itemList) {
            System.out.println(item.toString()); // 조회된 아이템 출력
        }
    }
    @Test
    @DisplayName("가격 LessThan 테스트")
    public void findByPriceLessThanTest() {
    	this.createItemList();
    	List<Item>itemList = itemRepository.findByPriceLessThan(10005);
    	for(Item item:itemList) {
    		System.out.println(item.toString());
    	}
    }
    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    public void findByPriceLessThanOrderByPriceDesc() {
    	this.createItemList();
    	List<Item> itemList=
    			itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
    	for (Item item : itemList) {
    	    System.out.println(item.toString());
    	}

    }
   @DisplayName("@Query를 이용한 상품조회테스트")
   public void findByItemDetailTest() {
	   this.createItemList();
	   List<Item>itemList=itemRepository.findByItemDetail("테스트 상품 상세설명");
			   for(Item item:itemList) {
				   System.out.println(item.toString());
			   }
   }
   @Test
   @DisplayName("nativeQuery 속성을 이용한 상품 조회 테스트")
   public void findByItemDetailByNative() {
	   this.createItemList();
	   List<Item>itemList=
			   itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");
	   for(Item item: itemList) {
		   System.out.println(item.toString());
	   }
   }
}
