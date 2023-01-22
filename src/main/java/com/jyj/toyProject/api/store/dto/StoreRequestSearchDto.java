package com.jyj.toyProject.api.store.dto;
import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreRequestSearchDto {

    private String festivalName;

    @QueryProjection
    public StoreRequestSearchDto(String festivalName){

        this.festivalName = festivalName;

    }

}
