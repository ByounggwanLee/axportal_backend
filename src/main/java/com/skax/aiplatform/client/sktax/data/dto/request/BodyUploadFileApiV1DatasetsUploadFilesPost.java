package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.web.multipart.MultipartFile;

/**
 * 데이터셋 파일 업로드 요청 DTO
 * 
 * <p>데이터셋 파일을 업로드하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BodyUploadFileApiV1DatasetsUploadFilesPost {

    /**
     * 업로드할 파일 (필수)
     */
    @JsonProperty("file")
    private MultipartFile file;

    /**
     * 데이터셋명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 데이터셋 타입 (필수)
     */
    @JsonProperty("type")
    private String type;

    /**
     * 상태 (기본값: processing)
     */
    @JsonProperty("status")
    @Builder.Default
    private String status = "processing";

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 태그
     */
    @JsonProperty("tags")
    private String tags;

    /**
     * 프로젝트 ID (필수)
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 생성한 사용자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 업데이트한 사용자
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 페이로드
     */
    @JsonProperty("payload")
    private String payload;
}
