package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DataSource 업데이트 파일 DTO
 * 
 * <p>데이터소스 업데이트 시 파일 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceUpdateFile {

    /**
     * 파일명 (필수)
     */
    @JsonProperty("file_name")
    private String fileName;

    /**
     * 파일 ID
     */
    @JsonProperty("file_id")
    private String fileId;

    /**
     * 임시 파일 경로 (기본값: "")
     */
    @JsonProperty("temp_file_path")
    @Builder.Default
    private String tempFilePath = "";

    /**
     * 파일 메타데이터
     */
    @JsonProperty("file_metadata")
    private Object fileMetadata;

    /**
     * 지식 설정
     */
    @JsonProperty("knowledge_config")
    private Object knowledgeConfig;

    /**
     * 파일 상태 (필수)
     */
    @JsonProperty("status")
    private String status;
}
