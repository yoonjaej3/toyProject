package com.jyj.toyProject.api.order.service;


import com.jyj.toyProject.api.item.entity.Item;
import com.jyj.toyProject.api.item.repository.interfaces.ItemRepository;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepositoryCoustom;
import com.jyj.toyProject.api.order.collection.Amount;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.dto.OrderRequestSearchDto;
import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final MemberRepository  memmberRepository;

    private final ItemRepository itemRepository;

    private final OrderRepositoryCustom OrderRepositoryCustom;

    private final MemberRepositoryCoustom  memberRepositoryCoustom;

    /**
     *  주문 조회
     */
    @Transactional
    public List<OrderResponeDto> findOrder(OrderRequestSearchDto orderRequestSearchDto) {

        return OrderRepositoryCustom.findOrder(orderRequestSearchDto.getMemberName(),orderRequestSearchDto.getItemName());

    }

    /**
     *  주문 조회(페이징 처리)
     */
    @Transactional
    public List<OrderResponeDto> findOrderByPaging(OrderRequestSearchDto orderRequestSearchDto, Pageable pageable) {

        return OrderRepositoryCustom.findOrderByPaging(pageable,orderRequestSearchDto.getMemberName(),orderRequestSearchDto.getItemName());

    }


    /**
     *  주문 등록
     */
    @Transactional
    public void registerOrder(OrderRequestDto orderRequestDto) {

        Member member = memberRepositoryCoustom.findMemberById(orderRequestDto.getMemberId());

        Item item = itemRepository.findItemById(orderRequestDto.getItemId());

        Orders order = createOrder(member, item, orderRequestDto);

        orderRepository.save(order);

    }

    private Orders createOrder(Member member, Item item, OrderRequestDto orderRequestDto) {

        Orders order = orderRequestDto.toEntity(member, item);

        checkRequiredFields(order);

        calculateCommission(order);

        return order;
    }

    private void checkRequiredFields(Orders order) {

        if (order.getItem() == null) {

            throw new IllegalStateException("메뉴명은 필수 입력 값입니다.");

        }

    }

    private void calculateCommission(Orders order) {

        Amount commission = new Amount(order);

        order.setCommission(commission.getOrder().getAmount());

    }


    /**
     *  주문 취소
     */
    @Transactional
    public void cancelOrder(String orderId) {

        Orders order =OrderRepositoryCustom.findOrderByOrderId(orderId);

        if(order.getType().equals(Status.COMPLETE)){

            throw new IllegalStateException("결제 완료된 주문은 취소하실 수 없습니다.");

        }

        order.changeStatus(Status.CANCEL);

    }

}
