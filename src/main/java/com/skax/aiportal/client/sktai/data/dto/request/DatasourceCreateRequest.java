package com.skax.aiportal.client.sktai.data.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
// TODO: DataSourceTempFile 클래스가 존재하지 않으므로 임시로 주석 처리 또는 클래스 생성 필요
// import com.skax.aiportal.client.sktai.data.dto.DataSourceTempFile;
import com.skax.aiportal.client.sktai.data.dto.S3Config;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터소스 생성 요청 DTO
 * 
 * <p>SKT AI 플랫폼에서 새로운 데이터소스를 생성할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasourceCreateRequest {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 데이터소스 이름
     */
    @NotBlank(message = "데이터소스 이름은 필수입니다")
    private String name;

    /**
     * 데이터소스 타입 (file, database, s3)
     */
    @Builder.Default
    private String type = "file";

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 데이터소스 설명
     */
    @Builder.Default
    private String description = "";

    /**
     * S3 설정
     */
    @JsonProperty("s3_config")
    private S3Config s3Config;

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;

    /**
     * 데이터소스 범위 (public, private)
     */
    @Builder.Default
    private String scope = "public";
    /**
     * 임시 파일 목록
     * TODO: DataSourceTempFile 클래스가 존재하지 않으므로 Object로 임시 처리 (클래스 생성 필요)
     */
    /**
     * 임시 파일 목록
     * TODO: DataSourceTempFile 클래스가 존재하지 않으므로 Object로 임시 처리 (클래스 생성 필요)
     */
    @JsonProperty("temp_files")
    private List<Object> tempFiles;

    /**
     * 정책 페이로드
     */
    private Object policy;

}
