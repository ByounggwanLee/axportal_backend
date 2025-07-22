package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * FewShots 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FewShotsCreateRequest {

    /**
     * FewShot 이름
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
     * FewShot 아이템 목록
     */
    private List<FewShotsItem> items;

    /**
     * FewShot 태그 목록
     */
    private List<FewShotsTag> tags;

    /**
     * FewShot 아이템 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FewShotsItem {
        /**
         * 질문
         */
        @JsonProperty("item_query")
        private String itemQuery;

        /**
         * 답변
         */
        @JsonProperty("item_answer")
        private String itemAnswer;
    }

    /**
     * FewShot 태그 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FewShotsTag {
        /**
         * 태그명
         */
        private String tag;
    }
}
