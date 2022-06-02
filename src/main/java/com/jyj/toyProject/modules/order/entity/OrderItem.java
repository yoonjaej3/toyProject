package com.jyj.toyProject.modules.order.entity;

import com.jyj.toyProject.modules.order.dto.entity.Item;

import javax.persistence.*;

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id",nullable = false)
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id",nullable = false)
    private Item item;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long count;

}
