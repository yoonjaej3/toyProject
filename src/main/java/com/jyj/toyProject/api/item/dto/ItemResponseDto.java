package com.jyj.toyProject.api.item.dto;

import com.jyj.toyProject.api.item.entity.Item;
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
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {

    private String itemId;
    private String storeName;
    private String name;
    private Long price;

    @QueryProjection
    public ItemResponseDto(String itemId,String name,Long price,String storeName) {

        this.itemId=itemId;
        this.name = name;
        this.price=price;
        this.storeName = storeName;
        
    }

    public Item toEntiity(){
        return Item.builder()
                .id(itemId)
                .name(name)
                .price(price)
                .build();
    }
}
