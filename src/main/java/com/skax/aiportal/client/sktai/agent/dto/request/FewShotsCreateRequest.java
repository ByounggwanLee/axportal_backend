package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * FewShots 생성 요청 DTO
 * 
 * <p>SKT AI Agent 플랫폼에서 Few-shot 예시 데이터를 생성하기 위한 요청 정보를 담는 객체입니다.
 * Few-shot 학습을 위한 예시 데이터와 메타데이터를 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Schema(
    title = "FewShots 생성 요청",
    description = "SKT AI Agent 플랫폼에서 Few-shot 예시 데이터를 생성하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FewShotsCreateRequest {

    /**
     * FewShot 이름
     * 
     * <p>생성할 Few-shot 데이터의 이름입니다.</p>
     */
    @Schema(
        description = "FewShot 이름",
        example = "고객 상담 예시 데이터",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "FewShot 이름은 필수입니다.")
    @Size(max = 100, message = "FewShot 이름은 100자를 초과할 수 없습니다.")
    private String name;

    /**
     * 프로젝트 ID
     * 
     * <p>FewShot 데이터가 속할 프로젝트의 식별자입니다.</p>
     */
    @Schema(
        description = "프로젝트 ID",
        example = "project-12345",
        maxLength = 50
    )
    @JsonProperty("project_id")
    @Size(max = 50, message = "프로젝트 ID는 50자를 초과할 수 없습니다.")
    private String projectId;

    /**
     * 릴리즈 플래그
     * 
     * <p>생성 즉시 릴리즈할지 여부를 결정합니다.</p>
     */
    @Schema(
        description = "릴리즈 플래그",
        example = "false",
        defaultValue = "false"
    )
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
