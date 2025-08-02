package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * SKTAX Agent Prompt 댓글 생성 요청 DTO
 * 
 * <p>Prompt 댓글 생성 요청 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 댓글 생성 요청")
public class PromptCommentCreateRequest {

    /**
     * 댓글 내용
     */
    @Schema(description = "Prompt comment", example = "도움 챗봇 프롬프트.", required = true)
    @JsonProperty("comment")
    @NotBlank(message = "댓글 내용은 필수입니다")
    private String comment;
}
