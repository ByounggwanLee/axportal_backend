package com.skax.aiportal.dto.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 파일 업로드 요청 DTO
 * 
 * <p>파일을 직접 업로드하여 데이터셋을 생성할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetUploadRequest {

    /**
     * 데이터셋 이름
     */
    @NotBlank(message = "데이터셋 이름은 필수입니다")
    private String name;

    /**
     * 데이터셋 타입
     * unsupervised_finetuning, supervised_finetuning, model_benchmark, rag_evaluation
     */
    @NotBlank(message = "데이터셋 타입은 필수입니다")
    @Pattern(regexp = "^(unsupervised_finetuning|supervised_finetuning|model_benchmark|rag_evaluation)$",
             message = "데이터셋 타입은 지원되는 형식이어야 합니다")
    private String type;

    /**
     * 데이터셋 상태
     * processing, completed, failed
     */
    @Pattern(regexp = "^(processing|completed|failed)$",
             message = "데이터셋 상태는 지원되는 형식이어야 합니다")
    @Builder.Default
    private String status = "processing";

    /**
     * 데이터셋 설명
     */
    private String description;

    /**
     * 데이터셋 태그 (콤마로 구분된 문자열)
     */
    private String tags;

    /**
     * 프로젝트 ID
     */
    @NotBlank(message = "프로젝트 ID는 필수입니다")
    private String projectId;

    /**
     * 생성자
     */
    private String createdBy;

    /**
     * 수정자
     */
    private String updatedBy;

    /**
     * 추가 페이로드 (JSON 문자열)
     */
    private String payload;
}
