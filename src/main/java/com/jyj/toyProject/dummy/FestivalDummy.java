package com.jyj.toyProject.dummy;

import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class FestivalDummy {

    private final FestivalRepository festivalRepository;

    public Festival createFestival(String name,String startDate,String endDate){
        Festival festival=Festival.builder()
                .name(name)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        Festival savedFestival=festivalRepository.save(festival);
        return savedFestival;
    }
}
