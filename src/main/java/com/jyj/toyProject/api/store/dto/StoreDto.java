package com.jyj.toyProject.api.store.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreDto {

    private String festivalName;
    private String name;
    private String phone;

    @QueryProjection
    public StoreDto(String festivalName, String name,String phone) {
        this.festivalName = festivalName;
        this.name=name;
        this.phone = phone;
    }

}
