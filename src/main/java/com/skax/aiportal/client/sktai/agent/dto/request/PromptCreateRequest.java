package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Prompt 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromptCreateRequest {

    /**
     * Prompt 이름
     */
    private String name;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 릴리즈 플래그
     */
    @Builder.Default
    private Boolean release = false;

    /**
     * Prompt 메시지 목록
     */
    private List<PromptMessage> messages;

    /**
     * Prompt 변수 목록
     */
    private List<PromptVariable> variables;

    /**
     * Prompt 태그 목록
     */
    private List<PromptTag> tags;

    /**
     * Prompt 메시지 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PromptMessage {
        /**
         * 메시지 타입 (0: text, 1: system, 2: user, 3: assistant)
         */
        @Builder.Default
        private Integer mtype = 0;

        /**
         * 메시지 내용
         */
        private String message;
    }

    /**
     * Prompt 변수 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PromptVariable {
        /**
         * 변수명
         */
        private String variable;

        /**
         * 검증 플래그
         */
        @JsonProperty("validation_flag")
        @Builder.Default
        private Boolean validationFlag = false;

        /**
         * 검증 정규식
         */
        private String validation;

        /**
         * 토큰 제한 플래그
         */
        @JsonProperty("token_limit_flag")
        @Builder.Default
        private Boolean tokenLimitFlag = false;

        /**
         * 토큰 제한 크기
         */
        @JsonProperty("token_limit")
        @Builder.Default
        private Integer tokenLimit = 0;
    }

    /**
     * Prompt 태그 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PromptTag {
        /**
         * 태그명
         */
        private String tag;
    }
}
