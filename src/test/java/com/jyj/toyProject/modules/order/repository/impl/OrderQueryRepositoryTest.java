package com.jyj.toyProject.modules.order.repository.impl;

import com.jyj.toyProject.dummy.MemberDummy;
import com.jyj.toyProject.dummy.OrderDummy;
import com.jyj.toyProject.modules.festival.entity.Festival;
import com.jyj.toyProject.modules.festival.repository.interfaces.FestivalRepository;
import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.modules.order.dto.OrderBuyerDto;
import com.jyj.toyProject.modules.order.entity.Orders;
import com.jyj.toyProject.modules.order.enums.PayType;
import com.jyj.toyProject.modules.order.enums.Status;
import com.jyj.toyProject.modules.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.modules.store.entity.Store;
import com.jyj.toyProject.modules.store.repository.interfaces.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    FestivalRepository festivalRepository;

    @Test
    @DisplayName("구매자 주문 정보 조회")
    void findBuyerByMember() {


        //given
        Member member= Member.builder()
                .name("test1")
                .phone("01000000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        memberRepository.save(member);

        Festival festival=Festival.builder()
                .name("여의도 불꽃놀이 축제")
                .startDate(LocalDate.of(2022,06,01))
                .endDate(LocalDate.of(2022,07,01))
                .build();

        festivalRepository.save(festival);

        Store store=Store.builder()
                .id(1L)
                .festival(festival)
                .name("가게A")
                .phone("01011112222")
                .build();

        storeRepository.save(store);

        Orders order=Orders.builder()
                .member(member)
                .store(store)
                .request("요청사항1입니다.")
                .type(Status.COMPLETE)
                .payType(PayType.Card)
                .payDate(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        //when
        OrderBuyerDto result=orderQueryRepository.findBuyerByStoreId(1L).get(0);

        //then
        assertAll(
                ()->assertEquals(result.getMember().getType(),Type.Buyer),
                ()->assertEquals(result.getStore().getId(),1L)

        );
    }
}