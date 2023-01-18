package com.jyj.toyProject.dummy;

import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepository;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.interfaces.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DummyTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    FestivalRepository festivalRepository;

    public void setup() {
        Member member1 = Member.builder()
                .name("test1")
                .phone("01000000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();


        memberRepository.save(member1);

        Member member2 = Member.builder()
                .name("test2")
                .phone("01000000002")
                .email("test2@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        memberRepository.save(member2);

        Festival festival = Festival.builder()
                .name("여의도 불꽃놀이 축제")
                .startDate("20220601")
                .endDate("20220701")
                .build();

        festivalRepository.save(festival);

        Store store = Store.builder()
                .festival(festival)
                .name("가게A")
                .phone("01011112222")
                .build();

        storeRepository.save(store);
        Orders order1 = Orders.builder()
                .member(member1)
                .store(store)
                .request("요청사항1입니다.")
                .type(Status.COMPLETE)
                .payType(PayType.Card)
                .payDate(LocalDateTime.now())
                .build();

        orderRepository.save(order1);

        Orders order2 = Orders.builder()
                .member(member1)
                .store(store)
                .request("요청사항1입니다.")
                .type(Status.COMPLETE)
                .payType(PayType.Card)
                .payDate(LocalDateTime.now())
                .build();

        orderRepository.save(order2);
    }
}