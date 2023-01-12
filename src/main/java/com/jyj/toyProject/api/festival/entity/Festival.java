package com.jyj.toyProject.api.festival.entity;

import com.jyj.toyProject.api.utils.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)

public class Festival extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="festival_seq")
    private Long seq;

    @Column(name="festival_id",nullable=false,unique=true)
    private String id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(name="start_date",nullable=false,unique=true)
    private LocalDate startDate;

    @Column(name="end_date",nullable=false,unique=true)
    private LocalDate endDate;
}
