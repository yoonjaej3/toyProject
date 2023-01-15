package com.jyj.toyProject.api.festival.controller;

import com.jyj.toyProject.api.festival.dto.FestivalResponseDto;
import com.jyj.toyProject.api.festival.repository.impl.FestivalQueryRepository;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FestivalApiController {

    private final FestivalRepository festivalRepository;

    private final FestivalQueryRepository festivalQueryRepository;

    //페스티 전체 조회
    @GetMapping("/festival")
    public List<FestivalResponseDto> festivalList(){

        List<FestivalResponseDto> festival = festivalQueryRepository.findAllFestival();

        return festival;

    }
}
