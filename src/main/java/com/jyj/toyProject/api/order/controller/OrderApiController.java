package com.jyj.toyProject.api.order.controller;

import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.dto.OrderRequestSearchDto;
import com.jyj.toyProject.api.order.dto.OrderResponeDto;
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

    //주문 조회
    @PostMapping("/orders")
    public List<OrderResponeDto> orderList(@RequestBody OrderRequestSearchDto orderRequestSearchDto){

        List<OrderResponeDto> orders =  orderService.findOrder(orderRequestSearchDto);

        return orders;

    }

    @PostMapping("/orders/register")
    public String registerOrder(@RequestBody OrderRequestDto orderRequestDto){

        orderService.registerOrder(orderRequestDto);

        return "등록";
    }

    @Transactional
    @PostMapping("/orders/cancel/{id}")
    public String delete(@PathVariable("id") String orderId){

        orderService.cancelOrder(orderId);

        return "주문취소";

    }

}
