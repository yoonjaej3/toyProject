package com.jyj.toyProject.api.item.service;

import com.jyj.toyProject.api.item.dto.ItemRequestDto;
import com.jyj.toyProject.api.item.dto.ItemRequestSearchDto;
import com.jyj.toyProject.api.item.dto.ItemResponseDto;
import com.jyj.toyProject.api.item.entity.Item;
import com.jyj.toyProject.api.item.repository.impl.ItemQueryRepository;
import com.jyj.toyProject.api.item.repository.interfaces.ItemRepository;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.interfaces.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemQueryRepository itemQueryRepository;

    private final StoreRepository storeRepository;

    private final ItemRepository itemRepository;

    /**
     * 아이템 조회
     */
    @Transactional
    public List<ItemResponseDto> findItem(ItemRequestSearchDto itemRequestSearchDto) {

        return itemQueryRepository.findStore(itemRequestSearchDto.getStoreName());

    }


    /**
     * 아이템 등록
     */
    @Transactional
    public void registerItem(ItemRequestDto itemRequestDto) {

        Store store = storeRepository.findSeqById(itemRequestDto.getStore().getId());

        Item item = itemRequestDto.toEntity(store);

        Optional.ofNullable(itemRequestDto.getStore()).orElseThrow(() -> new IllegalStateException("가게명은 필수 입력 값입니다."));

        itemRepository.save(item);

    }
    
}
