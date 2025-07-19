package com.skax.aiportal.entity.sample;

import com.skax.aiportal.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 샘플 엔티티
 * 
 * <p>샘플 도메인의 기본 엔티티입니다.
 * 프로젝트 구조와 코딩 패턴의 예시로 사용됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Entity
@Table(name = "samples")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Sample extends BaseEntity {

    /**
     * 샘플 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 샘플 제목
     */
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    /**
     * 샘플 내용
     */
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    /**
     * 활성화 상태
     */
    @Column(name = "active", nullable = false)
    @Builder.Default
    private Boolean active = true;

    /**
     * 샘플 상태
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    @Builder.Default
    private SampleStatus status = SampleStatus.DRAFT;

    /**
     * 조회수
     */
    @Column(name = "view_count")
    @Builder.Default
    private Long viewCount = 0L;

    /**
     * 제목을 업데이트합니다.
     * 
     * @param title 새로운 제목
     */
    public void updateTitle(String title) {
        this.title = title;
    }

    /**
     * 내용을 업데이트합니다.
     * 
     * @param content 새로운 내용
     */
    public void updateContent(String content) {
        this.content = content;
    }

    /**
     * 상태를 업데이트합니다.
     * 
     * @param status 새로운 상태
     */
    public void updateStatus(SampleStatus status) {
        this.status = status;
    }

    /**
     * 활성화 상태를 변경합니다.
     * 
     * @param active 활성화 여부
     */
    public void updateActive(Boolean active) {
        this.active = active;
    }

    /**
     * 조회수를 증가시킵니다.
     */
    public void incrementViewCount() {
        this.viewCount++;
    }

    /**
     * 샘플 상태 열거형
     */
    public enum SampleStatus {
        /**
         * 초안
         */
        DRAFT("초안"),
        
        /**
         * 발행됨
         */
        PUBLISHED("발행됨"),
        
        /**
         * 보관됨
         */
        ARCHIVED("보관됨");

        private final String description;

        SampleStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
