package com.skax.aiplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 기본 엔티티 클래스
 * 
 * <p>모든 엔티티가 공통으로 가져야 하는 필드들을 정의합니다.
 * 생성일시, 수정일시, 생성자, 수정자 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    /**
     * 생성일시
     */
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
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
     * 생성자 설정
     * 
     * @param createdBy 생성자
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 수정자 설정
     * 
     * @param updatedBy 수정자
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 엔티티 생성 전 처리
     */
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        
        // TODO: Spring Security Context에서 현재 사용자 정보 가져와서 설정
        if (this.createdBy == null) {
            this.createdBy = "system";
        }
        if (this.updatedBy == null) {
            this.updatedBy = "system";
        }
    }

    /**
     * 엔티티 수정 전 처리
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        
        // TODO: Spring Security Context에서 현재 사용자 정보 가져와서 설정
        if (this.updatedBy == null) {
            this.updatedBy = "system";
        }
    }
}
