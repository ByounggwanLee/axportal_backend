package com.skax.aiportal.dto.data.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 생성 요청 DTO
 * 
 * <p>새로운 데이터셋을 생성할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetCreateRequest {

    /**
     * 데이터셋 이름
     */
    @NotBlank(message = "데이터셋 이름은 필수입니다")
    private String name;

    /**
     * 데이터셋 타입
     * unsupervised_finetuning, supervised_finetuning, model_benchmark, rag_evaluation
     */
    @Pattern(regexp = "^(unsupervised_finetuning|supervised_finetuning|model_benchmark|rag_evaluation)$",
             message = "데이터셋 타입은 지원되는 형식이어야 합니다")
    @Builder.Default
    private String type = "unsupervised_finetuning";

    /**
     * 데이터셋 설명
     */
    private String description;

    /**
     * 데이터셋 태그 목록
     */
    private List<String> tags;

    /**
     * 데이터셋 상태
     * processing, completed, failed
     */
    @Pattern(regexp = "^(processing|completed|failed)$",
             message = "데이터셋 상태는 지원되는 형식이어야 합니다")
    @Builder.Default
    private String status = "processing";

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
     * 추가 페이로드
     */
    private Object payload;

    /**
     * 프로세서 매개변수 목록
     */
    private List<ProcessorParam> processorParams;

    /**
     * 프로세서 매개변수 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProcessorParam {
        
        /**
         * 매개변수 이름
         */
        private String name;
        
        /**
         * 매개변수 값
         */
        private Object value;
        
        /**
         * 매개변수 타입
         */
        private String type;
    }
}
