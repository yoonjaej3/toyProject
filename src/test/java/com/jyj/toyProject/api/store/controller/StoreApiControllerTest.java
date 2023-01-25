package com.jyj.toyProject.api.store.controller;

import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.order.service.OrderService;
import com.jyj.toyProject.api.store.dto.StoreRequestDto;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.interfaces.StoreRepository;
import com.jyj.toyProject.api.store.service.StoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StoreApiControllerTest {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    StoreService storeService;

    @Autowired
    OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void clean() {

        orderRepository.deleteAll();

        storeRepository.deleteAll();
    }

    @Test
    @DisplayName("/store/register 요청시 주문 등록")
    public void 주문등록() throws Exception{

        //given
        StoreRequestDto storeRequestDto = StoreRequestDto.builder()
                .storeId("SSSSSS1")
                .name("버거킹")
                .phone("15881012")
                .festivalId("FFFFFF1")
                .build();

        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .storeId("SSSSSS1")
                .type(Status.COMPLETE)
                .build();

        //when
        storeService.registerStore(storeRequestDto);

        orderService.registerOrder(orderRequestDto);

        Store store = storeRepository.findAll().get(0);

        //expected
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/store")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].storeId").value(store.getId()))
//                .andExpect(jsonPath("$[0].name").value(store.getName()))
                .andDo(print());


    }

}