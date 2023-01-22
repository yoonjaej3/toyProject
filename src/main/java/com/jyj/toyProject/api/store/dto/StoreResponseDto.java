package com.jyj.toyProject.api.store.dto;
import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreResponseDto {

    private String storeId;
    private String festivalId;
    private String name;
    private String phone;
    String festivalName;

    @QueryProjection
    public StoreResponseDto(String storeId, String festivalId, String name,String phone,String festivalName){

        this.storeId = storeId;
        this.festivalId = festivalId;
        this.name = name;
        this.phone = phone;
        this.festivalName = festivalName;

    }

}
