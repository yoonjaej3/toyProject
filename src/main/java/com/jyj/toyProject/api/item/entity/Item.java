package com.jyj.toyProject.api.item.entity;

import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.utils.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_seq")
    private Long seq;

    @Column(name="item_id",nullable=false,unique=true)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_seq",nullable = false)
    private Store store;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false,unique = true)
    private Long price;

    @Column(name="image_file_name")
    private String imageFileName;

    @Column(name="image_file_url")
    private String imageFileUrl;
}
