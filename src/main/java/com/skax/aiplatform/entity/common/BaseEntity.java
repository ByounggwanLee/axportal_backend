package com.skax.aiplatform.entity.common;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 기본 엔티티 클래스
 * 
 * <p>모든 엔티티가 공통으로 가져야 할 필드들을 정의합니다.
 * 생성일시, 수정일시, 생성자, 수정자 등의 감사(Audit) 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", length = 50, updatable = false)
    private String createdBy;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    /**
     * 엔티티 생성 전 호출
     */
    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
        // TODO: 실제 사용자 정보로 설정 (현재는 기본값)
        if (createdBy == null) {
            createdBy = "system";
        }
        if (updatedBy == null) {
            updatedBy = "system";
        }
    }

    /**
     * 엔티티 업데이트 전 호출
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
        // TODO: 실제 사용자 정보로 설정 (현재는 기본값)
        if (updatedBy == null) {
            updatedBy = "system";
        }
    }

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
}
