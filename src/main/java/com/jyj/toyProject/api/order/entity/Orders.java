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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id",nullable = false)
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
