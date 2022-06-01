package com.jyj.toyProject.modules.store.entity;

import com.jyj.toyProject.modules.festival.entity.Festival;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.utils.base.BaseEntity;

import javax.persistence.*;

public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="festival_id",nullable = false)
    private Festival festival;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable=false,unique=true)
    private String phone;

}
