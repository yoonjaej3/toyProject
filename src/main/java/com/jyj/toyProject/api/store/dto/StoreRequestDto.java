package com.jyj.toyProject.api.store.dto;
import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreRequestDto {

    private String storeId;
    private Festival festival;
    private String name;
    private String phone;

    @QueryProjection
    public StoreRequestDto(String storeId, Festival festival, String name, String phone){

        this.storeId = storeId;
        this.festival = festival;
        this.name = name;
        this.phone = phone;

    }

    public Store toEntity(){

        return Store.builder()
                .id(storeId)
                .festival(festival)
                .name(name)
                .phone(phone)
                .build();
    }
}
