package com.jyj.toyProject.api.order.controller;

import com.jyj.toyProject.api.order.dto.OrderDto;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderQueryRepository orderQueryRepository;

    //주문 전체 조회
    @GetMapping("/orders")
    public List<OrderDto> orderList(){

        return orderQueryRepository.findAllOrder();

    }

    //가게별 주문 조회
    @GetMapping("/orders/{id}")
    public List<OrderDto> orderListByStore(@PathVariable("id") Long id){

        return orderQueryRepository.findOrderByStoreId(id);

    }

    //회원별 주문 조회
    @GetMapping("/orders/Buyer/{id}")
    public List<OrderDto> orderBuyerDtoList(@PathVariable("id") Long id){

        return orderQueryRepository.findOrderByStoreId(id);

    }

    //TODO : 등록

    //TODO : 수정

    //TODO : 삭제

}
