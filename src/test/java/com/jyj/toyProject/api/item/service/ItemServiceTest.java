package com.jyj.toyProject.api.item.service;

import com.jyj.toyProject.api.item.dto.ItemRequestDto;
import com.jyj.toyProject.api.item.entity.Item;
import com.jyj.toyProject.api.item.repository.impl.ItemQueryRepository;
import com.jyj.toyProject.api.item.repository.interfaces.ItemRepository;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemQueryRepository itemQueryRepository;


    @BeforeEach
    void clean() {
        itemRepository.deleteAll();
    }

    @Test
    @DisplayName("아이템 등록")
    public void  아이템_등록() throws Exception{

        //given
        ItemRequestDto itemRequestDto = ItemRequestDto.builder()
                .itemId("IIIIII1")
                .storeId("SSSSSS1")
                .name("와퍼")
                .price(10000L)
                .build();

        //when
        itemService.registerItem(itemRequestDto);

        //then
        assertEquals(1L,itemRepository.count());
        Item item = itemRepository.findAll().get(0);
        assertEquals("IIIIII1",item.getId());
    }

}