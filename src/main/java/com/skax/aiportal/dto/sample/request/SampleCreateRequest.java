package com.skax.aiportal.dto.sample.request;

import com.skax.aiportal.entity.sample.Sample;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 샘플 생성 요청 DTO
 * 
 * <p>새로운 샘플을 생성할 때 사용되는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "샘플 생성 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleCreateRequest {

    /**
     * 샘플 제목
     */
    @Schema(description = "샘플 제목", example = "샘플 제목입니다", required = true)
    @NotBlank(message = "제목은 필수입니다")
    @Size(min = 1, max = 200, message = "제목은 1자 이상 200자 이하로 입력해주세요")
    private String title;

    /**
     * 샘플 내용
     */
    @Schema(description = "샘플 내용", example = "샘플 내용입니다")
    @Size(max = 5000, message = "내용은 5000자 이하로 입력해주세요")
    private String content;

    /**
     * 활성화 상태
     */
    @Schema(description = "활성화 상태", example = "true")
    @Builder.Default
    private Boolean active = true;

    /**
     * 샘플 상태
     */
    @Schema(description = "샘플 상태", example = "DRAFT", allowableValues = {"DRAFT", "PUBLISHED", "ARCHIVED"})
    @NotNull(message = "상태는 필수입니다")
    @Builder.Default
    private Sample.SampleStatus status = Sample.SampleStatus.DRAFT;

    /**
     * 요청 데이터를 Sample 엔티티로 변환합니다.
     * 
     * @return Sample 엔티티
     */
    public Sample toEntity() {
        return Sample.builder()
                .title(this.title)
                .content(this.content)
                .active(this.active)
                .status(this.status)
                .build();
    }
}
