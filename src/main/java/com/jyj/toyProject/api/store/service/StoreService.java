package com.jyj.toyProject.api.store.service;

import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.festival.repository.impl.FestivalQueryRepository;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.dto.OrderRequestSearchDto;
import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import com.jyj.toyProject.api.store.dto.StoreRequestDto;
import com.jyj.toyProject.api.store.dto.StoreRequestSearchDto;
import com.jyj.toyProject.api.store.dto.StoreResponseDto;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.impl.StoreQueryRepository;
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
public class StoreService {

    private final StoreQueryRepository storeQueryRepository;

    private final FestivalQueryRepository festivalQueryRepository;

    private final StoreRepository storeRepository;

    /**
     *  가게 조회
     */
    @Transactional
    public List<StoreResponseDto> findStore(StoreRequestSearchDto storeRequestSearchDto) {

        return storeQueryRepository.findStore(storeRequestSearchDto.getFestivalName());

    }

    /**
     *  가게 등록
     */
    @Transactional
    public void registerStore(StoreRequestDto storeRequestDto) {

        Festival festival = festivalQueryRepository.findFestivalByFestivalId(storeRequestDto.getFestivalId());

        Store store = storeRequestDto.toEntity(festival);

        storeRepository.save(store);
    }
}
