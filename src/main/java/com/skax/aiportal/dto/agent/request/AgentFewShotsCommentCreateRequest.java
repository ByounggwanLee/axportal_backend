package com.skax.aiportal.dto.agent.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent FewShots 댓글 생성 요청 DTO
 * 
 * <p>Few-shot 예시 데이터에 댓글 추가를 위한 요청 데이터를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentFewShotsCommentCreateRequest {

    /**
     * 댓글 내용
     */
    @NotBlank(message = "댓글 내용은 필수입니다")
    private String content;

    /**
     * 부모 댓글 UUID (대댓글인 경우)
     */
    private String parentCommentUuid;

    /**
     * 댓글 타입 (general, feedback, suggestion 등)
     */
    @Builder.Default
    private String type = "general";

    /**
     * 우선순위 (1: 낮음, 2: 보통, 3: 높음)
     */
    @Builder.Default
    private Integer priority = 2;
}
