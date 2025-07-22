package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge Tool 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeToolUpdateRequest {

    /**
     * 도구 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 연결 정보
     */
    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;

    /**
     * 도구 타입 (AzureDocumentIntelligence, NaverOCR, Docling, SynapsoftDA, VLMOCR)
     */
    @JsonProperty("type")
    private String type;

    /**
     * 수정자
     */
    @JsonProperty("updated_by")
    private String updatedBy;
}
