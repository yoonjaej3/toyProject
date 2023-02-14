package com.jyj.toyProject.api.item.controller;

import com.jyj.toyProject.api.item.dto.ItemRequestDto;
import com.jyj.toyProject.api.item.dto.ItemRequestSearchDto;
import com.jyj.toyProject.api.item.dto.ItemResponseDto;
import com.jyj.toyProject.api.item.service.ItemService;
import com.jyj.toyProject.api.store.dto.StoreRequestDto;
import com.jyj.toyProject.api.store.dto.StoreRequestSearchDto;
import com.jyj.toyProject.api.store.dto.StoreResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemApiController {


    private final ItemService itemService;

    //주문 전체 조회
    @GetMapping("/item")
    public List<ItemResponseDto> storeList(ItemRequestSearchDto itemRequestSearchDto){

        List<ItemResponseDto> item = itemService.findItem(itemRequestSearchDto);

        return item;

    }

    //
    @PostMapping("/item/register")
    public String registerStore(@RequestBody ItemRequestDto itemRequestDto){

        itemService.registerItem(itemRequestDto);

        return "등록";
    }


}
