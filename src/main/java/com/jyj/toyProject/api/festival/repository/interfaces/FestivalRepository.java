package com.jyj.toyProject.api.festival.repository.interfaces;

import com.jyj.toyProject.api.festival.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository  extends JpaRepository<Festival,Long> {
}
