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
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FestivalRepository festivalRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    DummyTest dummyTest;

    @Test
    @DisplayName("이미완성된 주문조회")
    public void  이미완성된_주문조회() throws Exception{
        //given
        dummyTest.setup();
        //when
        final List<Orders> orderResult=orderRepository.findByType(Status.COMPLETE);
        //then
        assertEquals(orderResult.size(),2);
    }

    @Test
    @DisplayName("결제대기중인 주문조회")
    public void  결제대기중인_주문조회() throws Exception{
        //given
        dummyTest.setup();
        //when
        final List<Orders> orderResult=orderRepository.findByType(Status.WAIT);
        //then
        assertEquals(orderResult.size(),0);
    }

    @Test
    @DisplayName("결제대기중인 주문취소")
    public void  결제대기중인_주문취소() throws Exception{

        //given
        Member member = Member.builder()
                .name("test1")
                .phone("01000000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        memberRepository.save(member);

        Festival festival = Festival.builder()
                .name("여의도 불꽃놀이 축제")
                .startDate(LocalDate.of(2022, 06, 01))
                .endDate(LocalDate.of(2022, 07, 01))
                .build();

        festivalRepository.save(festival);

        Store store = Store.builder()
                .festival(festival)
                .name("가게A")
                .phone("01011112222")
                .build();

        storeRepository.save(store);

        Orders order = Orders.builder()
                .member(member)
                .store(store)
                .request("요청사항1입니다.")
                .type(Status.WAIT)
                .payType(PayType.Card)
                .payDate(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        //when
        orderService.cancelOrder(order);

        //then
        assertEquals(order.getType(),Status.CANCEL);
    }

    @Test
    @DisplayName("이미결제된 주문취소")
    public void  이미결제된_주문취소() throws Exception{

        //given
        Member member = Member.builder()
                .name("test1")
                .phone("01000000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        memberRepository.save(member);

        Festival festival = Festival.builder()
                .name("여의도 불꽃놀이 축제")
                .startDate(LocalDate.of(2022, 06, 01))
                .endDate(LocalDate.of(2022, 07, 01))
                .build();

        festivalRepository.save(festival);

        Store store = Store.builder()
                .festival(festival)
                .name("가게A")
                .phone("01011112222")
                .build();

        storeRepository.save(store);

        Orders order = Orders.builder()
                .member(member)
                .store(store)
                .request("요청사항1입니다.")
                .type(Status.COMPLETE)
                .payType(PayType.Card)
                .payDate(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        //when
        Throwable exception = catchThrowable(() -> {
            orderService.cancelOrder(order);
        });


        //then

        assertThat(exception).isInstanceOf(IllegalStateException.class);
        assertThat(exception).hasMessage("결제 완료된 주문은 취소하실 수 없습니다.");

//        assertThatThrownBy(() -> {throw new Exception("결제 완료된 주문은 취소하실 수 없습니다.");})
//                .isInstanceOf(Exception.class)
//                .hasMessageContaining("결제 완료된 주문");
    }
}