package com.jyj.toyProject.api.festival.repository.interfaces;

import com.jyj.toyProject.api.festival.dto.FestivalResponseDto;
import com.jyj.toyProject.api.festival.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivalRepositoryCustom {

    List<FestivalResponseDto> findAllFestival();

    Festival findFestivalByFestivalId(String festivalId);

}
