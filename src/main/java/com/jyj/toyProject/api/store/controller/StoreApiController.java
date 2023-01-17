package com.jyj.toyProject.api.store.controller;

import com.jyj.toyProject.api.festival.dto.FestivalResponseDto;
import com.jyj.toyProject.api.store.dto.StoreResponseDto;
import com.jyj.toyProject.api.store.repository.impl.StoreQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreApiController {

    private static StoreQueryRepository storeQueryRepository;

    //가게 전체 조회
    @GetMapping("/store")
    public List<StoreResponseDto> storeList(){

        List<StoreResponseDto> store = storeQueryRepository.findAllStore();

        return store;

    }

}
