package com.jyj.toyProject.api.utils.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime inputDate;

    @LastModifiedDate
    private LocalDateTime chgDate;
}
