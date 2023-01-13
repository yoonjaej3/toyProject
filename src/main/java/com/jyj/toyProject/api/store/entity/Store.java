package com.jyj.toyProject.api.store.entity;

import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.utils.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_seq")
    private Long seq;

    @Column(name="store_id",nullable=false,unique=true)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="festival_seq",nullable = false)
    private Festival festival;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable=false,unique=true)
    private String phone;

}
