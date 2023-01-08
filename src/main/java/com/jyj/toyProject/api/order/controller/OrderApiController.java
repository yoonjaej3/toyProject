package com.jyj.toyProject.api.order.controller;

import com.jyj.toyProject.api.member.dto.MemberBuyerDto;
import com.jyj.toyProject.api.member.enums.Type;
import com.jyj.toyProject.api.member.repository.impl.MemberQueryRepository;
import com.jyj.toyProject.api.order.dto.OrderDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderQueryRepository orderQueryRepository;

    private final OrderRepository orderRepository;

    private final MemberQueryRepository memberQueryRepository;
    //주문 전체 조회
    @GetMapping("/orders")
    public List<OrderDto> orderList(){

        List<OrderDto> orders = orderQueryRepository.findAllOrder();

        return orders;

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

//    @PostMapping("/orders/")
//    public String register(@RequestBody OrderDto orderDto){
//
//        Optional<Orders> orders = orderRepository.findById(orderDto.getId());
//
//        orderRepository.save(orderDto.toEntiity());
//
//        return "등록";
//    }
    //TODO : 수정

    //TODO : 삭제

}
