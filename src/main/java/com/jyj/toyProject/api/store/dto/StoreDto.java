package com.jyj.toyProject.api.store.dto;

import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreDto {


    private Long seq;
    private String id;
    private String festivalName;
    private String name;
    private String phone;

    @QueryProjection
    public StoreDto(Store store) {
        this.id = store.getId();
        this.festivalName = store.getFestival().getName();
        this.name=store.getName();
        this.phone = store.getPhone();
    }

}
