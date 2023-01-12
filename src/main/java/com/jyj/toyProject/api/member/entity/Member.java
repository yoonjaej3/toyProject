package com.jyj.toyProject.api.member.entity;

import com.jyj.toyProject.api.member.enums.Type;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_seq")
    private Long seq;

    @Column(name="member_id",nullable=false,unique=true)
    private String id;


    @Column(nullable = false)
    private String name;

    @Column(nullable=false)
    private String phone;

    @Column(nullable=false)
    private String email;

    @Column(unique = false)
    private String companyNumber;

    @Column(unique = false)
    private String organizerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

}
