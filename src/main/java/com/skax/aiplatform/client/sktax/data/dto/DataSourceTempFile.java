package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DataSource 임시 파일 DTO
 * 
 * <p>데이터소스에 업로드된 임시 파일 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceTempFile {

    /**
     * 파일 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 파일명
     */
    @JsonProperty("file_name")
    private String fileName;

    /**
     * 파일 경로
     */
    @JsonProperty("file_path")
    private String filePath;

    /**
     * 파일 크기
     */
    @JsonProperty("file_size")
    private Long fileSize;

    /**
     * MIME 타입
     */
    @JsonProperty("mime_type")
    private String mimeType;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 만료일시
     */
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;
}
