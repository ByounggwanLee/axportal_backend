package com.skax.aiplatform.client.sktax.safetyfilter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.PolicyPayload;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.ValidTagTypeEnum;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Safety Filter 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SafetyFilterUpdate {

    /**
     * 금지어
     * 키워드라고 하며, 공백을 포함할 수 있고, 술어 및 형태소 원형을 사용할 수 있습니다.
     * (Update에서는 nullable)
     */
    @JsonProperty("stopword")
    @Size(max = 255, message = "금지어는 255자를 초과할 수 없습니다")
    private String stopword;

    /**
     * 라벨
     * 시스템에 정의된 라벨만 사용할 수 있으며, 하나의 라벨만 등록할 수 있습니다.
     * (Update에서는 nullable)
     */
    @JsonProperty("label")
    @Size(max = 255, message = "라벨은 255자를 초과할 수 없습니다")
    private String label;

    /**
     * 카테고리
     * famous(인물명), brand(브랜드), culture(콘텐츠명)만 등록 가능하며, 필요시에만 사용합니다.
     * (Update에서는 nullable)
     */
    @JsonProperty("category")
    @Size(max = 255, message = "카테고리는 255자를 초과할 수 없습니다")
    private String category;

    /**
     * 예외 소스
     * STOPWORD에 반영되지 않아야 하는 소스명 목록을 쉼표로 구분한 문자열로 등록합니다.
     * (Update에서는 nullable)
     */
    @JsonProperty("except_sources")
    @Size(max = 255, message = "예외 소스는 255자를 초과할 수 없습니다")
    private String exceptSources;

    /**
     * 유효 태그
     * ALL(모든 형태소 매칭), NN(명사만 매칭) 두 가지 타입만 등록 가능합니다.
     * (Update에서는 nullable)
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
     * 정책 설정
     * (Update에서는 nullable)
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
