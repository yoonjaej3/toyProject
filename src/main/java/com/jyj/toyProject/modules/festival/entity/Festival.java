package com.jyj.toyProject.modules.festival.entity;

import com.jyj.toyProject.modules.utils.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)

public class Festival extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="festival_id")
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(name="start_date",nullable=false,unique=true)
    private LocalDate startDate;

    @Column(name="end_date",nullable=false,unique=true)
    private LocalDate endDate;
}
