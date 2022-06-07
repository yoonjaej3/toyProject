package com.jyj.toyProject.modules.festival.repository.interfaces;

import com.jyj.toyProject.modules.festival.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository  extends JpaRepository<Festival,Long> {
}
