package com.jyj.toyProject.modules.member.entity;

import com.jyj.toyProject.modules.member.enums.Type;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable=false,unique=true)
    private String phone;

    @Column(nullable=false,unique = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

}
