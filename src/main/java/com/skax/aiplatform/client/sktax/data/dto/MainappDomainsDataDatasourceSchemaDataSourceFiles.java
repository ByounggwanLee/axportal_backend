package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 데이터소스 파일 스키마 DTO (schema 네임스페이스)
 * 
 * <p>데이터소스에 속한 파일의 스키마 정보를 나타내는 모델입니다.
 * mainapp.domains.data.datasource.schema 네임스페이스의 DataSourceFiles 스키마입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainappDomainsDataDatasourceSchemaDataSourceFiles {

    /**
     * 파일 ID
     * 파일의 고유 식별자입니다.
     */
    @JsonProperty("id")
    private String id;

    /**
     * 데이터소스 ID
     * 파일이 속한 데이터소스의 식별자입니다.
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 파일명
     * 업로드된 파일의 이름입니다.
     * 기본값: 빈 문자열
     */
    @JsonProperty("file_name")
    @Builder.Default
    private String fileName = "";

    /**
     * 파일 경로
     * 서버에 저장된 파일의 경로입니다.
     */
    @JsonProperty("file_path")
    private String filePath;

    /**
     * 파일 크기
     * 파일의 크기(바이트)입니다.
     */
    @JsonProperty("file_size")
    private Integer fileSize;

    /**
     * 삭제 여부
     * 파일의 삭제 상태를 나타냅니다.
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    /**
     * 생성일시
     * 파일이 생성된 날짜와 시간입니다.
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     * 파일이 마지막으로 수정된 날짜와 시간입니다.
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성자
     * 파일을 생성한 사용자입니다.
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자
     * 파일을 마지막으로 수정한 사용자입니다.
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * S3 ETag
     * S3 객체의 ETag 값입니다.
     */
    @JsonProperty("s3_etag")
    private String s3Etag;

    /**
     * 파일 메타데이터
     * 파일의 추가 정보를 담은 JSON 객체입니다.
     */
    @JsonProperty("file_metadata")
    private Object fileMetadata;

    /**
     * 지식 구성 정보
     * 지식베이스 관련 설정 정보입니다.
     */
    @JsonProperty("knowledge_config")
    private Object knowledgeConfig;
}
