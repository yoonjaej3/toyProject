package com.jyj.toyProject.modules.order.repository.impl;

import com.jyj.toyProject.dummy.MemberDummy;
import com.jyj.toyProject.dummy.OrderDummy;
import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.modules.order.dto.OrderBuyerDto;
import com.jyj.toyProject.modules.order.entity.Orders;
import com.jyj.toyProject.modules.order.enums.PayType;
import com.jyj.toyProject.modules.order.enums.Status;
import com.jyj.toyProject.modules.order.repository.interfaces.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderQueryRepositoryTest {

    @Autowired
    OrderQueryRepository orderQueryRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("구매자 주문 정보 조회")
    void findBuyerByMember() {


        //given
        Member member1= Member.builder()
                .name("test1")
                .phone("01000000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        Orders order1=Orders.builder()
                .member(member1)
                .request("요청사항1입니다.")
                .type(Status.COMPLETE)
                .payType(PayType.Card)
                .payDate(LocalDateTime.now())
                .build();

        Member member= MemberDummy.createMember(1,Type.Buyer,null,null);
        memberRepository.save(member);
        Orders order= OrderDummy.createOrder(1,member,Status.COMPLETE,PayType.Card);
        orderRepository.save(order);

        //when
        OrderBuyerDto myOrderBuyer=orderQueryRepository.findBuyerByMember(member).get(0);

        //then
        assertEquals(order.getMember(),myOrderBuyer.getMember());
    }
}