package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.VectorDatabaseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Map;

/**
 * Vector DB 정보 신규 등록 요청 DTO
 * 
 * <p>Knowledge에 사용할 vector db를 등록하기 위한 요청 정보를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VectorDBCreateRequest {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * Vector DB 이름
     */
    @JsonProperty("name")
    @NotBlank(message = "Vector DB 이름은 필수입니다")
    @Size(max = 200, message = "Vector DB 이름은 200자를 초과할 수 없습니다")
    private String name;

    /**
     * Vector DB 타입
     */
    @JsonProperty("type")
    @NotNull(message = "Vector DB 타입은 필수입니다")
    private VectorDatabaseType type;

    /**
     * 연결 정보
     */
    @JsonProperty("connection_info")
    @NotNull(message = "연결 정보는 필수입니다")
    private Map<String, Object> connectionInfo;

    /**
     * 기본 설정 여부
     */
    @JsonProperty("is_default")
    @Builder.Default
    private Boolean isDefault = false;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private Object policy;
}
