package com.skax.aiplatform.client.sktax.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.Dataset;
import com.skax.aiplatform.client.sktax.data.dto.DatasetTags;
import com.skax.aiplatform.client.sktax.data.dto.DatasetTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DataSet 상세 정보 응답 DTO
 * 
 * <p>데이터셋의 상세 정보를 담는 응답 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSetDetail {

    /**
     * 데이터셋명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 데이터셋 타입 (기본값: unsupervised_finetuning)
     */
    @JsonProperty("type")
    @Builder.Default
    private DatasetTypeEnum type = DatasetTypeEnum.UNSUPERVISED_FINETUNING;

    /**
     * 설명 (기본값: "")
     */
    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    /**
     * 태그
     */
    @JsonProperty("tags")
    private List<DatasetTags> tags;

    /**
     * 상태 (기본값: processing)
     */
    @JsonProperty("status")
    @Builder.Default
    private String status = "processing";

    /**
     * 프로젝트 ID (기본값: "")
     */
    @JsonProperty("project_id")
    @Builder.Default
    private String projectId = "";

    /**
     * 삭제 여부 (기본값: false)
     */
    @JsonProperty("is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;

    /**
     * 파일 경로 (필수)
     */
    @JsonProperty("file_path")
    private String filePath;

    /**
     * 생성한 사용자 (필수)
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 업데이트한 사용자 (필수)
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 생성일시 (필수)
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 업데이트일시 (필수)
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
