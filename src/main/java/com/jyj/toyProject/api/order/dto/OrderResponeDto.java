package com.jyj.toyProject.api.order.dto;

import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponeDto {

    private String orderId;
    private String request;
    private Status type;
    private PayType payType;
    private LocalDateTime payDate;
    private String memberId;
    private String itemId;
    private String memberName;
    private String itemName;


    @QueryProjection
    public OrderResponeDto(String orderId, String memberId, String itemId, String request
            , Status type, PayType payType, LocalDateTime payDate
            , String memberName, String itemName) {
        this.orderId=orderId;
        this.memberId = memberId;
        this.itemId=itemId;
        this.request = request;
        this.type = type;
        this.payType = payType;
        this.payDate = payDate;
        this.memberName=memberName;
        this.itemName=itemName;
    }

    public Orders toEntiity(){
        return Orders.builder()
                .id(orderId)
                .request(request)
                .type(type)
                .payDate(payDate)
                .payType(payType)
                .build();
    }
}
