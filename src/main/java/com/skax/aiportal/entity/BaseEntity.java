package com.skax.aiportal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 기본 엔티티 클래스
 * 
 * <p>모든 엔티티에서 공통으로 사용하는 필드들을 정의합니다.
 * 생성일시, 수정일시, 생성자, 수정자 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    /**
     * 생성일시
     */
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성자
     */
    @Column(name = "created_by", length = 50, updatable = false)
    private String createdBy;

    /**
     * 수정자
     */
    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    /**
     * 생성자를 설정합니다.
     * 
     * @param createdBy 생성자
     */
    protected void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 수정자를 설정합니다.
     * 
     * @param updatedBy 수정자
     */
    protected void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
