package com.skax.aiportal.client.sktai.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Graph 댓글 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GraphCommentCreateRequest {

    /**
     * 댓글 내용
     */
    @JsonProperty("content")
    private String content;

    /**
     * 부모 댓글 ID (대댓글인 경우)
     */
    @JsonProperty("parent_id")
    private String parentId;
}
