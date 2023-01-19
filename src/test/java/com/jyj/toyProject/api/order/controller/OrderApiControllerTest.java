package com.jyj.toyProject.api.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.order.service.OrderService;
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
class OrderApiControllerTest    {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @BeforeEach
    void clean() {
        orderRepository.deleteAll();
    }


    @Test
    @DisplayName("/orders/register 요청시 주문 등록")
    public void 주문등록() throws Exception{

        //given
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .storeId("SSSSSS1")
                .type(Status.COMPLETE)
                .build();



        //when
        orderService.registerOrder(orderRequestDto);

        Orders order = orderRepository.findAll().get(0);

        //expected
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/orders")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].orderId").value(order.getId()))
                .andExpect(jsonPath("$[0].request").value(order.getRequest()))
                .andDo(print());


    }

    @Test
    @DisplayName("/orders 요청시 주문 전체 조회")
    public void 주문전체조회() throws Exception{

        //given
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .storeId("SSSSSS1")
                .type(Status.COMPLETE)
                .build();

        orderService.registerOrder(orderRequestDto);

        //when
        Orders order = orderRepository.findAll().get(0);

        //expected
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/orders")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].orderId").value(order.getId()))
                .andExpect(jsonPath("$[0].request").value(order.getRequest()))
                .andDo(print());


    }
}