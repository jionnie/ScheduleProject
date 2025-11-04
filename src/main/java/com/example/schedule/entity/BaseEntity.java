package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 모든 엔티티에 대한 공통 속성을 관리하는 추상 클래스
 * 일정 생성 시각(createdAt)과 마지막 수정 시각(modifiedAt)을 자동으로 관리한다.
 *
 * @author jiwon jung
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    //    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;        // 일정 생성 시각

    @LastModifiedDate
    private LocalDateTime modifiedAt;       // 마지막 일정 수정 시각
}