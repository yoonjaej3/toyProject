package com.jyj.toyProject.api.store.controller;

import com.jyj.toyProject.api.festival.dto.FestivalResponseDto;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.store.dto.StoreRequestDto;
import com.jyj.toyProject.api.store.dto.StoreRequestSearchDto;
import com.jyj.toyProject.api.store.dto.StoreResponseDto;
import com.jyj.toyProject.api.store.repository.impl.StoreQueryRepository;
import com.jyj.toyProject.api.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreApiController {

    private static StoreQueryRepository storeQueryRepository;

    private static StoreService storeService;

    //가게 전체 조회
    @GetMapping("/store")
    public List<StoreResponseDto> storeList(StoreRequestSearchDto storeRequestSearchDto){

        List<StoreResponseDto> store = storeService.findStore(storeRequestSearchDto);

        return store;

    }

    //가게 등록
    @PostMapping("/store/register")
    public String registerStore(@RequestBody StoreRequestDto storeRequestDto){

        storeService.registerStore(storeRequestDto);

        return "등록";
    }

}
