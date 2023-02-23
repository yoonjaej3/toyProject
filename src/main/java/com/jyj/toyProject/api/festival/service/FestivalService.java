package com.jyj.toyProject.api.festival.service;

import com.jyj.toyProject.api.festival.dto.FestivalRequestDto;
import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.festival.repository.impl.FestivalQueryRepository;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepository;
import com.jyj.toyProject.api.festival.repository.interfaces.FestivalRepositoryCustom;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.store.entity.Store;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FestivalService {

    private final FestivalRepository festivalRepository;

    private final FestivalRepositoryCustom festivalRepositoryCustom;

    /**
     *  페스티벌등록
     */
    @Transactional
    public void registerFestival(FestivalRequestDto festivalRequestDto) {

        Festival festival = festivalRequestDto.toEntity();

        festivalRepository.save(festival);

    }

    /**
     *  페스티벌삭제
     */
    @Transactional
    public void  cancelFestival(String festivalId) {

       Festival festival = festivalRepositoryCustom.findFestivalByFestivalId(festivalId);

       festivalRepository.delete(festival);

    }

}
