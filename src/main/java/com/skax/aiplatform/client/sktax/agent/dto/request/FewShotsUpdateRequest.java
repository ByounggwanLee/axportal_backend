package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Few-Shot 수정 요청 DTO
 * 
 * <p>기존 Few-Shot 예제를 수정하기 위한 요청 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Few-Shot 수정 요청")
public class FewShotsUpdateRequest {

    /**
     * 새로운 Few-Shot 이름
     */
    @NotBlank(message = "새로운 Few-Shot 이름은 필수입니다")
    @JsonProperty("new_name")
    @Schema(description = "새로운 Few-Shot 이름", example = "Insurance Consultation Updated")
    private String newName;

    /**
     * 릴리즈 여부
     */
    @JsonProperty("release")
    @Builder.Default
    @Schema(description = "릴리즈 여부", example = "false")
    private Boolean release = false;

    /**
     * Few-Shot 항목들
     */
    @NotEmpty(message = "Few-Shot 항목은 최소 하나 이상 필요합니다")
    @Valid
    @JsonProperty("items")
    @Schema(description = "Few-Shot 항목들")
    private List<FewShotsItem> items;

    /**
     * 태그들
     */
    @NotEmpty(message = "태그는 최소 하나 이상 필요합니다")
    @Valid
    @JsonProperty("tags")
    @Schema(description = "태그들")
    private List<FewShotsTag> tags;

    /**
     * Few-Shot 항목
     */
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Few-Shot 항목")
    public static class FewShotsItem {
        
        @NotBlank(message = "질문은 필수입니다")
        @JsonProperty("item_query")
        @Schema(description = "질문", example = "Who lived longer, Muhammad Ali or Alan Turing?")
        private String itemQuery;

        @NotBlank(message = "답변은 필수입니다")
        @JsonProperty("item_answer")
        @Schema(description = "답변", example = "Muhammad Ali lived longer.")
        private String itemAnswer;
    }

    /**
     * Few-Shot 태그
     */
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Few-Shot 태그")
    public static class FewShotsTag {
        
        @NotBlank(message = "태그는 필수입니다")
        @JsonProperty("tag")
        @Schema(description = "태그", example = "QA")
        private String tag;
    }
}
