package com.jyj.toyProject.api.order.dto;

import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
public class OrderRequestSearchDto {

    private String memberName;
    private String storeName;
    private int pageSize;
    private int page;


    @QueryProjection
    public OrderRequestSearchDto(String memberName, String storeName,int pageSize,int page) {
        this.memberName = memberName;
        this.storeName=storeName;
        this.pageSize = pageSize;
        this.page = page;

    }

}
