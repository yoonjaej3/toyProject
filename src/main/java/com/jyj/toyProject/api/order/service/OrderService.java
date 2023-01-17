package com.jyj.toyProject.api.order.service;


import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.interfaces.StoreRepository;
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

    private final MemberRepository  memmberRepository;

    private final StoreRepository storeRepository;

    private final OrderQueryRepository orderQueryRepository;
    /**
     *  주문 등록
     */
    @Transactional
    public void registerOrder(OrderRequestDto orderRequestDto) {

        Member member = memmberRepository.findSeqById(orderRequestDto.getMemberId());

        Store store = storeRepository.findSeqById(orderRequestDto.getStoreId());

        Orders order = orderRequestDto.toEntiity(member,store);


        Optional.ofNullable(order.getStore()).orElseThrow(() -> new IllegalStateException("가게명은 필수 입력 값입니다."));

        orderRepository.save(order);
    }

    /**
     *  주문 취소
     */
    @Transactional
    public void cancelOrder(String orderId) {

        Orders order =orderQueryRepository.findOrderByOrderId(orderId);

        if(order.getType().equals(Status.COMPLETE)){

            throw new IllegalStateException("결제 완료된 주문은 취소하실 수 없습니다.");

        }

        order.changeStatus(Status.CANCEL);

    }

}
