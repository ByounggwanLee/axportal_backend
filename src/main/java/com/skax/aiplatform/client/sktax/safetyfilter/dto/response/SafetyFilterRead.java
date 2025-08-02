package com.skax.aiplatform.client.sktax.safetyfilter.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.ValidTagTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Safety Filter 조회 응답 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SafetyFilterRead {

    /**
     * 금지어
     * 키워드라고 하며, 공백을 포함할 수 있고, 술어 및 형태소 원형을 사용할 수 있습니다.
     */
    @JsonProperty("stopword")
    private String stopword;

    /**
     * 라벨
     * 시스템에 정의된 라벨만 사용할 수 있으며, 하나의 라벨만 등록할 수 있습니다.
     */
    @JsonProperty("label")
    private String label;

    /**
     * 카테고리
     * famous(인물명), brand(브랜드), culture(콘텐츠명)만 등록 가능하며, 필요시에만 사용합니다.
     */
    @JsonProperty("category")
    private String category;

    /**
     * 예외 소스
     * STOPWORD에 반영되지 않아야 하는 소스명 목록을 쉼표로 구분한 문자열로 등록합니다.
     */
    @JsonProperty("except_sources")
    private String exceptSources;

    /**
     * 유효 태그
     * ALL(모든 형태소 매칭), NN(명사만 매칭) 두 가지 타입만 등록 가능합니다.
     */
    @JsonProperty("valid_tags")
    private ValidTagTypeEnum validTags;

    /**
     * 프로젝트 ID
     * 프로젝트 ID를 직접 지정할 수 있습니다. 지정하지 않으면 인증 토큰에 포함된 프로젝트 ID로 설정됩니다.
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * ID
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
