package com.jyj.toyProject.api.order.service;

import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     *  주문 등록
     */
    @Transactional
    public Long registerOrder(Orders order) {

        Optional.ofNullable(order.getStore()).orElseThrow(() -> new IllegalStateException("가게명은 필수 입력 값입니다."));

        return orderRepository.save(order).getId();
    }

    /**
     *  주문 취소
     */
    @Transactional
    public void cancelOrder(Orders order) {

        if(order.getType().equals(Status.COMPLETE)){

            throw new IllegalStateException("결제 완료된 주문은 취소하실 수 없습니다.");

        }

        order.changeStatus(Status.CANCEL);

    }

}
