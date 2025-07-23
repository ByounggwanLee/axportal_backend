package com.skax.aiportal.dto.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 파일 업로드 데이터셋 생성 요청 DTO
 * 
 * <p>파일을 직접 업로드하여 데이터셋을 생성하기 위한 요청 정보를 담는 DTO입니다.
 * 업로드할 파일과 함께 데이터셋 메타데이터 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "파일 업로드 데이터셋 생성 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetUploadFileReq {

    /**
     * 업로드할 파일
     */
    @Schema(
        description = "업로드할 데이터 파일", 
        requiredMode = Schema.RequiredMode.REQUIRED,
        type = "string",
        format = "binary"
    )
    @NotNull(message = "업로드할 파일은 필수입니다")
    private Object file;

    /**
     * 데이터셋 이름
     */
    @Schema(
        description = "생성할 데이터셋 이름", 
        example = "고객 데이터 파일",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 이름은 필수입니다")
    @Size(max = 100, message = "데이터셋 이름은 100자 이하여야 합니다")
    private String name;

    /**
     * 데이터셋 타입
     */
    @Schema(
        description = "데이터셋 타입 (예: image, text, audio, video, tabular)", 
        example = "tabular",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 타입은 필수입니다")
    @Size(max = 50, message = "데이터셋 타입은 50자 이하여야 합니다")
    private String type;

    /**
     * 데이터셋 상태
     */
    @Schema(
        description = "데이터셋 상태 (예: active, processing, inactive)", 
        example = "processing",
        defaultValue = "processing"
    )
    @Size(max = 20, message = "데이터셋 상태는 20자 이하여야 합니다")
    @Builder.Default
    private String status = "processing";

    /**
     * 데이터셋 설명
     */
    @Schema(
        description = "데이터셋에 대한 상세 설명", 
        example = "CSV 파일로 업로드된 고객 정보 데이터셋입니다."
    )
    @Size(max = 1000, message = "데이터셋 설명은 1000자 이하여야 합니다")
    private String description;

    /**
     * 데이터셋 태그
     */
    @Schema(
        description = "데이터셋 태그 (쉼표로 구분)", 
        example = "고객정보,CSV,업로드"
    )
    @Size(max = 500, message = "데이터셋 태그는 500자 이하여야 합니다")
    private String tags;

    /**
     * 프로젝트 ID
     */
    @Schema(
        description = "데이터셋이 속할 프로젝트 ID", 
        example = "project-12345",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "프로젝트 ID는 필수입니다")
    @Size(max = 50, message = "프로젝트 ID는 50자 이하여야 합니다")
    private String projectId;

    /**
     * 생성자
     */
    @Schema(
        description = "데이터셋 생성자 정보", 
        example = "user@example.com"
    )
    @Size(max = 100, message = "생성자 정보는 100자 이하여야 합니다")
    private String createdBy;

    /**
     * 수정자
     */
    @Schema(
        description = "데이터셋 수정자 정보", 
        example = "admin@example.com"
    )
    @Size(max = 100, message = "수정자 정보는 100자 이하여야 합니다")
    private String updatedBy;

    /**
     * 추가 페이로드
     */
    @Schema(
        description = "추가 메타데이터나 설정 정보 (JSON 형태)", 
        example = "{\"encoding\": \"utf-8\", \"delimiter\": \",\"}"
    )
    @Size(max = 2000, message = "추가 페이로드는 2000자 이하여야 합니다")
    private String payload;
}
