package com.jyj.toyProject.api.festival.controller;

import com.jyj.toyProject.api.festival.dto.FestivalRequestDto;
import com.jyj.toyProject.api.festival.dto.FestivalResponseDto;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepository;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepositoryCustom;
import com.jyj.toyProject.api.festival.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FestivalApiController {

    private final FestivalRepository festivalRepository;

    private final FestivalRepositoryCustom festivalRepositoryCustom;

    private final FestivalService festivalService;

    //페스티벌 전체 조회
    @GetMapping("/festival")
    public List<FestivalResponseDto> festivalList(){

        List<FestivalResponseDto> festival = festivalRepositoryCustom.findAllFestival();

        return festival;

    }

    //페스티벌 저장
    @PostMapping("/festival/register")
    public String registerFestival(@RequestBody FestivalRequestDto festivalRequestDto){

        festivalService.registerFestival(festivalRequestDto);

        return "등록";

    }

    //페스티벌삭제
    @DeleteMapping("/festival/{id}")
    public String deleteFestival(@PathVariable("id") String festivalId){

        festivalService.cancelFestival(festivalId);

        return "삭제";

    }

}
