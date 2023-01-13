package com.jyj.toyProject.api.order.entity;

import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.utils.base.BaseEntity;
import com.jyj.toyProject.api.order.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="order_seq")
    private Long seq;

    @Column(name="order_id",nullable=false,unique=true)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq",nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_seq",nullable = false)
    private Store store;

    @Column
    private String request;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PayType payType;

    @Column(name= "pay_date")
    private LocalDateTime payDate;

    public void changeStatus(Status type){

        this.type = type;

    }



}
