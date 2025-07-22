package com.skax.aiportal.client.sktai.agent.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * FewShot Comment 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FewShotCommentCreateRequest {

    /**
     * 댓글 내용
     */
    private String comment;
}
