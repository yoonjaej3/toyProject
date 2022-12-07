package com.jyj.toyProject.api.order.repository.impl;

import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepository;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.api.order.dto.OrderBuyerDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.interfaces.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

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