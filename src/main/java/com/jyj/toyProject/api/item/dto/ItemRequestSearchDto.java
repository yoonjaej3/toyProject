package com.jyj.toyProject.api.item.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ItemRequestSearchDto {

    private String storeName;

    @QueryProjection
    public ItemRequestSearchDto(String storeName) {

        this.storeName = storeName;
    }

}
