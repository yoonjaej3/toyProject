package com.jyj.toyProject.api.store.service;

import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepository;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.store.dto.StoreRequestDto;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.interfaces.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreServiceTest {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    FestivalRepository festivalRepository;

    @Autowired
    StoreService storeService;

    @BeforeEach
    void clean() {
        storeRepository.deleteAll();
        festivalRepository.deleteAll();
    }

    @Test
    @DisplayName("가게 등록")
    public void  가게_등록() throws Exception{

        //given
        StoreRequestDto storeRequestDto = StoreRequestDto.builder()
                .storeId("SSSSSS1")
                .name("버거킹")
                .phone("15881012")
                .festivalId("FFFFFF1")
                .build();

        //when
        storeService.registerStroe(storeRequestDto);

//        //then
//        assertEquals(1L,storeRepository.count());
//        Store store = storeRepository.findAll().get(0);
//        assertEquals("SSSSSS1",store.getId());
//        assertEquals("버거킹",store.getName());
    }

//    @Test
//    @DisplayName("축제조회")
//    public void 축제조회() throws Exception{
//        private String storeId;
//        private Festival festival;
//        private String name;
//        private String phone;
//        //given
//        StoreRequestDto storeRequestDto = OrderReStoreRequestDtoquestDto.builder()
//                .storeId("OOOOOO1")
//                .request("요청사항10000")
//                .payType(PayType.Card)
//                .memberId("MMMMMM1")
//                .storeId("SSSSSS1")
//                .type(Status.COMPLETE)
//                .build();
//
//        //when
//        orderService.registerOrder(orderRequestDto);
//
//        //then
//        assertEquals(1L,orderRepository.count());
//        Orders order = orderRepository.findAll().get(0);
//        assertEquals("OOOOOO1",order.getId());
//        assertEquals("COMPLETE",order.getType().toString());
//
//    }

}