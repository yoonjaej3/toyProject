package com.jyj.toyProject.modules.item.entity;

import com.jyj.toyProject.modules.store.entity.Store;
import com.jyj.toyProject.modules.utils.base.BaseEntity;
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
    @Column(name="item_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id",nullable = false)
    private Store store;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false,unique = true)
    private Long price;

    @Column(name="image_file_name", nullable = false,unique = true)
    private String imageFileName;

    @Column(name="image_file_url", nullable = false,unique = true)
    private String imageFileUrl;
}
