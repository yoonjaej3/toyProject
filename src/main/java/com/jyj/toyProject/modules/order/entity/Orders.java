package com.jyj.toyProject.modules.order.entity;

import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.order.enums.PayType;
import com.jyj.toyProject.modules.utils.base.BaseEntity;
import com.jyj.toyProject.modules.order.enums.Status;
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

}
