package com.skax.aiportal.dto.sample.request;

import com.skax.aiportal.entity.sample.Sample;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 샘플 수정 요청 DTO
 * 
 * <p>기존 샘플을 수정할 때 사용되는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "샘플 수정 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleUpdateRequest {

    /**
     * 샘플 제목
     */
    @Schema(description = "샘플 제목", example = "수정된 샘플 제목입니다")
    @Size(min = 1, max = 200, message = "제목은 1자 이상 200자 이하로 입력해주세요")
    private String title;

    /**
     * 샘플 내용
     */
    @Schema(description = "샘플 내용", example = "수정된 샘플 내용입니다")
    @Size(max = 5000, message = "내용은 5000자 이하로 입력해주세요")
    private String content;

    /**
     * 활성화 상태
     */
    @Schema(description = "활성화 상태", example = "true")
    private Boolean active;

    /**
     * 샘플 상태
     */
    @Schema(description = "샘플 상태", example = "PUBLISHED", allowableValues = {"DRAFT", "PUBLISHED", "ARCHIVED"})
    private Sample.SampleStatus status;

    /**
     * 기존 엔티티에 수정사항을 적용합니다.
     * 
     * @param sample 기존 샘플 엔티티
     */
    public void applyToEntity(Sample sample) {
        if (this.title != null) {
            sample.updateTitle(this.title);
        }
        if (this.content != null) {
            sample.updateContent(this.content);
        }
        if (this.active != null) {
            sample.updateActive(this.active);
        }
        if (this.status != null) {
            sample.updateStatus(this.status);
        }
    }
}
