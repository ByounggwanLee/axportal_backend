package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Few-Shot 코멘트 생성 요청 DTO
 * 
 * <p>Few-Shot에 대한 코멘트를 생성하기 위한 요청 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Few-Shot 코멘트 생성 요청")
public class FewShotCommentCreateRequest {

    /**
     * 코멘트 내용
     */
    @NotBlank(message = "코멘트는 필수입니다")
    @JsonProperty("comment")
    @Schema(description = "코멘트 내용", example = "도움 챗봇 프롬프트.")
    private String comment;
}
