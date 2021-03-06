package com.jyj.toyProject.dummy;

import com.jyj.toyProject.modules.festival.entity.Festival;
import com.jyj.toyProject.modules.festival.repository.interfaces.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class FestivalDummy {

    private final FestivalRepository festivalRepository;

    public Festival createFestival(String name,LocalDate startDate,LocalDate endDate){
        Festival festival=Festival.builder()
                .name(name)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        Festival savedFestival=festivalRepository.save(festival);
        return savedFestival;
    }
}
