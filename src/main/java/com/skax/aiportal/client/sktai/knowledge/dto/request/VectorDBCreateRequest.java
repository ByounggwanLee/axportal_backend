package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Vector DB 생성 요청 DTO
 * 
 * <p>SKT AI Knowledge 플랫폼에서 벡터 데이터베이스를 생성하기 위한 요청 정보를 담는 객체입니다.
 * 문서 임베딩과 유사도 검색을 위한 벡터 DB 설정을 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Schema(
    title = "Vector DB 생성 요청",
    description = "SKT AI Knowledge 플랫폼에서 벡터 데이터베이스를 생성하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VectorDBCreateRequest {

    /**
     * 프로젝트 ID
     * 
     * <p>벡터 DB가 속할 프로젝트의 식별자입니다.</p>
     */
    @Schema(
        description = "프로젝트 ID",
        example = "project-12345",
        maxLength = 50
    )
    @JsonProperty("project_id")
    @Size(max = 50, message = "프로젝트 ID는 50자를 초과할 수 없습니다.")
    private String projectId;

    /**
     * Vector DB 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * Vector DB 타입 (Milvus, AzureAISearch, AzureAISearchShared, OpenSearch)
     */
    @JsonProperty("type")
    private String type;

    /**
     * 연결 정보
     */
    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;

    /**
     * 기본 설정 여부
     */
    @JsonProperty("is_default")
    private Boolean isDefault;

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
