package com.skax.aiportal.client.sktai.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge Repository 업데이트 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoUpdateRequest {

    /**
     * 업데이트 모드 (append_modified_docs, add_new_collection)
     */
    @JsonProperty("update_mode")
    private String updateMode;
}
