package com.skax.aiplatform.client.sktax.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * API Key Response DTO
 * API 키 정보를 반환하는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey {

    /**
     * API 키
     */
    @JsonProperty("api_key")
    @NotNull(message = "API 키는 필수입니다")
    private String apiKey;

    /**
     * 서빙 ID 목록
     */
    @JsonProperty("serving_id")
    @NotNull(message = "서빙 ID는 필수입니다")
    private List<String> servingId;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 시작일
     */
    @JsonProperty("started_at")
    @NotNull(message = "시작일은 필수입니다")
    private LocalDate startedAt;

    /**
     * 만료일
     */
    @JsonProperty("expires_at")
    @NotNull(message = "만료일은 필수입니다")
    private LocalDate expiresAt;

    /**
     * 태그 목록
     */
    @JsonProperty("tag")
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
    private Boolean isActive;

    /**
     * 게이트웨이 타입
     */
    @JsonProperty("gateway_type")
    private String gatewayType;

    /**
     * API 키 ID
     */
    @JsonProperty("api_key_id")
    private UUID apiKeyId;
}
