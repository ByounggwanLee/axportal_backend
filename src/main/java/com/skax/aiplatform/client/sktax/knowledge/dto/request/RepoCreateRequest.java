package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.ChunkMode;
import com.skax.aiplatform.client.sktax.knowledge.dto.LoaderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * Knowledge Repo 신규 생성 요청 DTO
 * 
 * <p>DataSource에 등록된 파일로 신규 Knowledge Repo를 생성하기 위한 요청 정보를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepoCreateRequest {

    /**
     * Knowledge 이름
     */
    @JsonProperty("name")
    @NotBlank(message = "Knowledge 이름은 필수입니다")
    @Size(max = 200, message = "Knowledge 이름은 200자를 초과할 수 없습니다")
    private String name;

    /**
     * Knowledge 설명
     */
    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    /**
     * 데이터소스 ID
     */
    @JsonProperty("datasource_id")
    @NotNull(message = "데이터소스 ID는 필수입니다")
    private String datasourceId;

    /**
     * 임베딩 모델 ID
     */
    @JsonProperty("embedding_model_id")
    private String embeddingModelId;

    /**
     * 임베딩 모델 이름
     */
    @JsonProperty("embedding_model_name")
    private String embeddingModelName;

    /**
     * Vector DB ID
     */
    @JsonProperty("vector_db_id")
    @NotNull(message = "Vector DB ID는 필수입니다")
    private String vectorDbId;

    /**
     * 로더 타입
     */
    @JsonProperty("loader")
    @NotNull(message = "로더 타입은 필수입니다")
    private LoaderType loader;

    /**
     * 분할기 타입
     */
    @JsonProperty("splitter")
    @NotNull(message = "분할기 타입은 필수입니다")
    private ChunkMode splitter;

    /**
     * 청크 크기
     */
    @JsonProperty("chunk_size")
    @Builder.Default
    private Integer chunkSize = 1000;

    /**
     * 청크 오버랩
     */
    @JsonProperty("chunk_overlap")
    @Builder.Default
    private Integer chunkOverlap = 0;

    /**
     * 구분자
     */
    @JsonProperty("separator")
    private String separator;

    /**
     * 커스텀 로더 ID
     */
    @JsonProperty("custom_loader_id")
    private String customLoaderId;

    /**
     * 커스텀 분할기 ID
     */
    @JsonProperty("custom_splitter_id")
    private String customSplitterId;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 프로세서 ID 목록
     */
    @JsonProperty("processor_ids")
    private List<String> processorIds;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 도구 ID
     */
    @JsonProperty("tool_id")
    private String toolId;

    /**
     * 범위
     */
    @JsonProperty("scope")
    private String scope;

    /**
     * 인덱싱 설정
     */
    @JsonProperty("indexing_config")
    private Object indexingConfig;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private Object policy;
}
