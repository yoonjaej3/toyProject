package com.jyj.toyProject.api.order.dto;

import com.jyj.toyProject.api.item.entity.Item;
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
public class OrderRequestDto {

    private String orderId;
    private String request;
    private Status type;
    private PayType payType;
    private LocalDateTime payDate;
    private String memberId;
    private String itemId;


    @QueryProjection
    public OrderRequestDto(String orderId,String memberId, String itemId, String request,Status type, PayType payType, LocalDateTime payDate) {
        this.orderId=orderId;
        this.memberId = memberId;
        this.itemId=itemId;
        this.request = request;
        this.type = type;
        this.payType = payType;
        this.payDate = payDate;
    }

    public Orders toEntity(Member member, Item item){

        return Orders.builder()
                .id(orderId)
                .member(member)
                .item(item)
                .request(request)
                .type(type)
                .payDate(payDate)
                .payType(payType)
                .build();
    }
}
