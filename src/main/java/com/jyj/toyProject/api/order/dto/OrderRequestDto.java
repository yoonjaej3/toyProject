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
public class OrderRequestDto {

    private String orderId;
    private String request;
    private Status type;
    private PayType payType;
    private LocalDateTime payDate;
    private String memberId;
    private String storeId;


    @QueryProjection
    public OrderRequestDto(String orderId,String memberId, String storeId, String request,Status type, PayType payType, LocalDateTime payDate) {
        this.orderId=orderId;
        this.memberId = memberId;
        this.storeId=storeId;
        this.request = request;
        this.type = type;
        this.payType = payType;
        this.payDate = payDate;
    }

    public Orders toEntiity(Member member,Store store){

        return Orders.builder()
                .id(orderId)
                .member(member)
                .store(store)
                .request(request)
                .type(type)
                .payDate(payDate)
                .payType(payType)
                .build();
    }
}
