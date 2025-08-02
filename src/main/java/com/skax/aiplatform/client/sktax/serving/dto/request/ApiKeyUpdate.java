package com.skax.aiplatform.client.sktax.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.serving.dto.PolicyPayload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * API Key 수정 요청 DTO
 * 기존 API 키를 수정하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyUpdate {

    /**
     * 서빙 ID 목록
     */
    @JsonProperty("serving_id")
    @NotNull(message = "서빙 ID는 필수입니다")
    private List<String> servingId;

    /**
     * 시작 날짜
     */
    @JsonProperty("started_at")
    @NotNull(message = "시작 날짜는 필수입니다")
    private String startedAt;

    /**
     * 만료 날짜
     */
    @JsonProperty("expires_at")
    @NotNull(message = "만료 날짜는 필수입니다")
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
    @NotNull(message = "허용된 호스트는 필수입니다")
    private List<String> allowedHost;

    /**
     * 마스터 키 여부
     */
    @JsonProperty("is_master")
    @NotNull(message = "마스터 키 여부는 필수입니다")
    private Boolean isMaster;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 활성화 여부
     */
    @JsonProperty("is_active")
    @NotNull(message = "활성화 여부는 필수입니다")
    private Boolean isActive;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;

    /**
     * 게이트웨이 타입
     */
    @JsonProperty("gateway_type")
    private String gatewayType;
}
