package com.jyj.toyProject.api.festival.dto;
import com.jyj.toyProject.api.festival.entity.Festival;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FestivalRequestDto {

    private String festivalId;
    private String name;
    private String startDate;
    private String endDate;

    @QueryProjection
    public FestivalRequestDto(String festivalId, String name, String startDate, String endDate){

        this.festivalId = festivalId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Festival toEntity(){

        return Festival.builder()
                .id(festivalId)
                .name(name)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
