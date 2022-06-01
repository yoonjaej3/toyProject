package com.jyj.toyProject.modules.order.entity;

import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.order.enums.Status;
import com.jyj.toyProject.modules.store.entity.Store;
import com.jyj.toyProject.modules.utils.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",nullable = false)
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="store_id",nullable = false)
    private Store store;

    @Column
    private String request;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status type;

    //TODO 결제종류
    //TODO 주문시간
    //TODO 결제시간

}
