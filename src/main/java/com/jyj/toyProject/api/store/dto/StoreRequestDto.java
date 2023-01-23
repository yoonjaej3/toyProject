package com.jyj.toyProject.api.store.dto;
import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class StoreRequestDto {

    private String storeId;
    private String festivalId;
    private String name;
    private String phone;

    @QueryProjection
    public StoreRequestDto(String storeId, String festivalId, String name, String phone){

        this.storeId = storeId;
        this.festivalId = festivalId;
        this.name = name;
        this.phone = phone;

    }

    public Store toEntity(Festival festival){

        return Store.builder()
                .id(storeId)
                .festival(festival)
                .name(name)
                .phone(phone)
                .build();
    }
}
