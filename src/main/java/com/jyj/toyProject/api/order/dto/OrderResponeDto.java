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
    private String storeId;
    private String memberName;
    private String storeName;


    @QueryProjection
    public OrderResponeDto(String orderId, String memberId, String storeId, String request
            , Status type, PayType payType, LocalDateTime payDate
            , String memberName, String storeName) {
        this.orderId=orderId;
        this.memberId = memberId;
        this.storeId=storeId;
        this.request = request;
        this.type = type;
        this.payType = payType;
        this.payDate = payDate;
        this.memberName=memberName;
        this.storeName=storeName;
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
