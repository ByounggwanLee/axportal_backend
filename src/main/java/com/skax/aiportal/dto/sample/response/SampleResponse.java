package com.skax.aiportal.dto.sample.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skax.aiportal.entity.sample.Sample;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 샘플 응답 DTO
 * 
 * <p>샘플 데이터를 클라이언트에게 응답할 때 사용되는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "샘플 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleResponse {

    /**
     * 샘플 ID
     */
    @Schema(description = "샘플 ID", example = "1")
    private Long id;

    /**
     * 샘플 제목
     */
    @Schema(description = "샘플 제목", example = "샘플 제목입니다")
    private String title;

    /**
     * 샘플 내용
     */
    @Schema(description = "샘플 내용", example = "샘플 내용입니다")
    private String content;

    /**
     * 활성화 상태
     */
    @Schema(description = "활성화 상태", example = "true")
    private Boolean active;

    /**
     * 샘플 상태
     */
    @Schema(description = "샘플 상태", example = "PUBLISHED")
    private Sample.SampleStatus status;

    /**
     * 샘플 상태 설명
     */
    @Schema(description = "샘플 상태 설명", example = "발행됨")
    private String statusDescription;

    /**
     * 조회수
     */
    @Schema(description = "조회수", example = "100")
    private Long viewCount;

    /**
     * 생성일시
     */
    @Schema(description = "생성일시", example = "2025-07-19 12:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @Schema(description = "수정일시", example = "2025-07-19 12:30:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    /**
     * 생성자
     */
    @Schema(description = "생성자", example = "admin")
    private String createdBy;

    /**
     * 수정자
     */
    @Schema(description = "수정자", example = "admin")
    private String updatedBy;

    /**
     * Sample 엔티티로부터 SampleResponse를 생성합니다.
     * 
     * @param sample Sample 엔티티
     * @return SampleResponse
     */
    public static SampleResponse from(Sample sample) {
        return SampleResponse.builder()
                .id(sample.getId())
                .title(sample.getTitle())
                .content(sample.getContent())
                .active(sample.getActive())
                .status(sample.getStatus())
                .statusDescription(sample.getStatus().getDescription())
                .viewCount(sample.getViewCount())
                .createdAt(sample.getCreatedAt())
                .updatedAt(sample.getUpdatedAt())
                .createdBy(sample.getCreatedBy())
                .updatedBy(sample.getUpdatedBy())
                .build();
    }

    /**
     * Sample 엔티티로부터 간단한 SampleResponse를 생성합니다. (목록용)
     * 
     * @param sample Sample 엔티티
     * @return SampleResponse (간단 버전)
     */
    public static SampleResponse summaryFrom(Sample sample) {
        return SampleResponse.builder()
                .id(sample.getId())
                .title(sample.getTitle())
                .active(sample.getActive())
                .status(sample.getStatus())
                .statusDescription(sample.getStatus().getDescription())
                .viewCount(sample.getViewCount())
                .createdAt(sample.getCreatedAt())
                .createdBy(sample.getCreatedBy())
                .build();
    }
}
