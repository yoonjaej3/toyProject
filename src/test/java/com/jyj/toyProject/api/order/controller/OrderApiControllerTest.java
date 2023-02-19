package com.jyj.toyProject.api.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.dto.OrderRequestSearchDto;
import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.order.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    private OrderQueryRepository orderQueryRepository;

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
                .itemId("IIIIII1")
                .type(Status.COMPLETE)
                .build();

        String json = objectMapper.writeValueAsString(orderRequestDto);

       mockMvc.perform(post("/orders/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());

        //when
        Orders order = orderRepository.findAll().get(0);

        //expected
        Assertions.assertEquals("OOOOOO1",order.getId());

    }

    @Test
    @DisplayName("/orders 요청시 조회(검색어 조건 : 회원명,가게명)")
    public void 주문전체조회() throws Exception{

        //given
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .itemId("IIIIII1")
                .type(Status.COMPLETE)
                .build();

        orderService.registerOrder(orderRequestDto);

        OrderRequestSearchDto orderRequestSearchDto = OrderRequestSearchDto.builder()
                .memberName("주윤재")
                .build();

        //when
        OrderResponeDto orderResponeDto = orderQueryRepository.findOrder(orderRequestSearchDto.getMemberName(),orderRequestSearchDto.getItemName()).get(0);

        String json = objectMapper.writeValueAsString(orderRequestSearchDto);

        //expected
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/orders")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].orderId").value(orderResponeDto.getOrderId()))
                .andExpect(jsonPath("$[0].memberName").value(orderResponeDto.getMemberName()))
                .andDo(print());

    }
}