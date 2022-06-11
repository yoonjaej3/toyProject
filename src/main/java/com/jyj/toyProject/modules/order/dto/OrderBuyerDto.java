package com.jyj.toyProject.modules.order.dto;

import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.order.enums.PayType;
import com.jyj.toyProject.modules.order.enums.Status;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderBuyerDto {
    private Member member;
    private String request;
    private Status type;
    private PayType payType;
    private LocalDateTime payDate;

    @QueryProjection
    public OrderBuyerDto(Member member, String request, Status type, PayType payType, LocalDateTime payDate) {
        this.member = member;
        this.request = request;
        this.type = type;
        this.payType = payType;
        this.payDate = payDate;
    }
}
