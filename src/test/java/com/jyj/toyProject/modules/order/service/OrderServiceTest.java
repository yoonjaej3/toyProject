package com.jyj.toyProject.modules.order.service;

import com.jyj.toyProject.dummy.DummyTest;
import com.jyj.toyProject.modules.festival.entity.Festival;
import com.jyj.toyProject.modules.festival.repository.interfaces.FestivalRepository;
import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.modules.order.entity.Orders;
import com.jyj.toyProject.modules.order.enums.PayType;
import com.jyj.toyProject.modules.order.enums.Status;
import com.jyj.toyProject.modules.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.modules.store.entity.Store;
import com.jyj.toyProject.modules.store.repository.interfaces.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    FestivalRepository festivalRepository;

    @Autowired
    DummyTest dummyTest;

    @Test
    @DisplayName("이미 존재한 주문이므로 실패")
    public void  주믄등록() throws Exception{
        //given
        dummyTest.setup();
        //when
        final Orders orderResult=orderRepository.findByType(Status.COMPLETE)
        //then
        assertEquals(orderResult.getType(),Status.COMPLETE);
    }
}