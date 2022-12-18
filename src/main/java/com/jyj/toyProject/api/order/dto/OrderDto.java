package com.jyj.toyProject.api.order.dto;

import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Member member;
    private Store store;
    private String request;
    private Status type;
    private PayType payType;
    private LocalDateTime payDate;

    @QueryProjection
    public OrderDto(Long id , Member member, Store store, String request, Status type, PayType payType, LocalDateTime payDate) {
        this.id = id;
        this.member = member;
        this.store=store;
        this.request = request;
        this.type = type;
        this.payType = payType;
        this.payDate = payDate;
    }

    public Orders toEntiity(){
        return Orders.builder()
                .member(member)
                .store(store)
                .request(request)
                .type(type)
                .payDate(payDate)
                .payType(payType)
                .build();
    }
}
