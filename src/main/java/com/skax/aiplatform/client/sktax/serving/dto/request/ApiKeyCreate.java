package com.skax.aiplatform.client.sktax.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.serving.dto.PolicyPayload;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * API Key 생성 요청 DTO
 * 새로운 API 키를 생성하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyCreate {

    /**
     * 서빙 ID 목록
     */
    @JsonProperty("serving_id")
    private List<String> servingId;

    /**
     * 시작 날짜
     */
    @JsonProperty("started_at")
    private String startedAt;

    /**
     * 만료 날짜
     */
    @JsonProperty("expires_at")
    private String expiresAt;

    /**
     * 태그 목록
     */
    @JsonProperty("tag")
    @NotEmpty(message = "태그는 필수입니다")
    private List<String> tag;

    /**
     * 허용된 호스트 목록
     */
    @JsonProperty("allowed_host")
    private List<String> allowedHost;

    /**
     * 마스터 키 여부
     */
    @JsonProperty("is_master")
    @Builder.Default
    private Boolean isMaster = false;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 활성화 여부
     */
    @JsonProperty("is_active")
    @Builder.Default
    private Boolean isActive = true;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;

    /**
     * 게이트웨이 타입
     */
    @JsonProperty("gateway_type")
    @Builder.Default
    private String gatewayType = "model";
}
