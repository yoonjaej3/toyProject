package com.jyj.toyProject.dummy;

import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.order.entity.Orders;
import com.jyj.toyProject.modules.order.enums.PayType;
import com.jyj.toyProject.modules.order.enums.Status;
import com.jyj.toyProject.modules.order.repository.interfaces.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class OrderDummy {

    private final OrderRepository orderRepository;

    public static Orders createOrder(int index, Member member, Status status, PayType payType){
        return Orders.builder()
                .member(member)
                .request("요청사항"+index+"입니다.")
                .type(status)
                .payType(payType)
                .payDate(LocalDateTime.now())
                .build();
    }
}
