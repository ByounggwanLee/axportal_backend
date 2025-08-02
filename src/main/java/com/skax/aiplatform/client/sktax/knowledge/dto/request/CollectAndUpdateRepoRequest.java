package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.KnowledgeAction;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * S3로부터 변경 문서 수집 후 Knowledge Repo 업데이트 요청 DTO
 * OpenAPI 스키마: CollectAndUpdateRepo
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectAndUpdateRepoRequest {

    @JsonProperty("repo_id")
    private String repoId;

    @NotNull(message = "s3_config는 필수입니다")
    @Valid
    @JsonProperty("s3_config")
    private S3ConfigRequest s3Config;

    @NotNull(message = "update_mode는 필수입니다")
    @JsonProperty("update_mode")
    private KnowledgeUpdateMode updateMode;

    @JsonProperty("target_step")
    @Builder.Default
    private KnowledgeAction targetStep = KnowledgeAction.CHUNKING_DOCS;

    /**
     * S3 설정 DTO
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class S3ConfigRequest {
        @JsonProperty("bucket_name")
        private String bucketName;

        @JsonProperty("access_key")
        private String accessKey;

        @JsonProperty("secret_key")
        private String secretKey;

        @JsonProperty("region")
        private String region;

        @JsonProperty("prefix")
        private String prefix;
    }

    /**
     * Knowledge 업데이트 모드 Enum
     */
    public enum KnowledgeUpdateMode {
        @JsonProperty("append_modified_docs")
        APPEND_MODIFIED_DOCS,

        @JsonProperty("add_new_collection")
        ADD_NEW_COLLECTION
    }
}
