package com.jyj.toyProject.api.item.dto;

import com.jyj.toyProject.api.item.entity.Item;
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

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDto {

    private String itemId;
    private Store store;
    private String name;
    private Long price;

    @QueryProjection
    public ItemRequestDto(String itemId,String name, Long price) {
        this.itemId=itemId;
        this.name = name;
        this.price = price;
    }

    public Item toEntity(Store store){

        return Item.builder()
                .id(itemId)
                .store(store)
                .name(name)
                .price(price)
                .build();
    }
}
