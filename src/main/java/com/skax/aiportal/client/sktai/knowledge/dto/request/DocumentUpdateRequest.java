package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Document 업데이트 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentUpdateRequest {

    /**
     * 업데이트할 문서 목록
     */
    @JsonProperty("documents")
    private List<DocumentUpdate> documents;

    /**
     * 문서 업데이트 정보 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DocumentUpdate {

        /**
         * 문서 ID
         */
        @JsonProperty("id")
        private String id;

        /**
         * 로더 타입
         */
        @JsonProperty("loader")
        private String loader;

        /**
         * 프로세서 ID 목록
         */
        @JsonProperty("processor_ids")
        private List<String> processorIds;

        /**
         * 스플리터 타입
         */
        @JsonProperty("splitter")
        private String splitter;

        /**
         * 청크 크기
         */
        @JsonProperty("chunk_size")
        private Integer chunkSize;

        /**
         * 청크 중복 크기
         */
        @JsonProperty("chunk_overlap")
        private Integer chunkOverlap;

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
         * 커스텀 스플리터 ID
         */
        @JsonProperty("custom_splitter_id")
        private String customSplitterId;

        /**
         * 도구 ID
         */
        @JsonProperty("tool_id")
        private String toolId;
    }
}
