package com.jyj.toyProject.api.order.controller;

import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderQueryRepository orderQueryRepository;

    private final OrderRepository orderRepository;

    private final OrderService orderService;

    //주문 전체 조회
    @GetMapping("/orders")
    public List<OrderResponeDto> orderList(){

        List<OrderResponeDto> orders = orderQueryRepository.findAllOrder();

        return orders;

    }

    //가게별 주문 조회
    @GetMapping("/orders/{id}")
    public List<OrderResponeDto> orderListByStore(@PathVariable("id") Long id){

        return orderQueryRepository.findOrderByStoreId(id);

    }

    //회원별 주문 조회
    @GetMapping("/orders/Buyer/{id}")
    public List<OrderResponeDto> orderBuyerDtoList(@PathVariable("id") Long id){

        return orderQueryRepository.findOrderByMemberId(id);

    }

    @PostMapping("/orders/register")
    public String registerOrder(@RequestBody OrderRequestDto orderRequestDto){

        orderService.registerOrder(orderRequestDto);

        return "등록";
    }

    @Transactional
    @PostMapping("/orders/cancel/{id}")
    public String delete(@PathVariable("id") Long orderId){

        Orders orders = orderRepository.getById(orderId);

        orderService.cancelOrder(orders);

        return "주문취소";

    }

}
